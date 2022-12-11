package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Global.Locale;
import Service.SMembership;
import ValueObject.VAccount;

public class PMembership extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JLabel sucLabel;
	private JTextField txtName;
	private JTextField txtId;
	private JTextField txtPw;
	private JButton membershipButton;

	private SMembership sMembership;

	public PMembership() {
		setSize(300, 200);
		setResizable(false);
		setTitle(Locale.Membership.MEMBERSHIP_MEMBERSHIP_TEXT);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel line1 = new JPanel();
		nameLabel = new JLabel(Locale.Membership.MEMBERSHIP_NAME);
		txtName = new JTextField(10);
		line1.add(nameLabel);
		line1.add(txtName);

		JPanel line2 = new JPanel();
		idLabel = new JLabel(Locale.Membership.MEMBERSHIP_ID);
		txtId = new JTextField(10);
		line2.add(idLabel);
		line2.add(txtId);

		JPanel line3 = new JPanel();
		pwLabel = new JLabel(Locale.Membership.MEMBERSHIP_PASSWORD);
		txtPw = new JTextField(10);
		line3.add(pwLabel);
		line3.add(txtPw);

		JPanel line4 = new JPanel();
		membershipButton = new JButton(Locale.Membership.MEMBERSHIP_MEMBERSHIP);
		line4.add(membershipButton);

		JPanel line5 = new JPanel();
		sucLabel = new JLabel("");
		line5.add(sucLabel);

		container.add(line1);
		container.add(line2);
		container.add(line3);
		container.add(line4);
		container.add(line5);

		membershipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String id = txtId.getText();
				String password = txtPw.getText();

				sMembership = new SMembership();
				VAccount vAccount = sMembership.createMembership(name, id, password);

				if (vAccount == null) {
					sucLabel.setText(Locale.Membership.MEMBERSHIP_IPRYERK);
				} else {
					dispose();
					JOptionPane.showMessageDialog(null, Locale.Membership.MEMBERSHIP_SUCCESS);
				}

			}

		});

		getRootPane().setDefaultButton(membershipButton);

	}

	public void initialize() {
		setVisible(true);
	}

}

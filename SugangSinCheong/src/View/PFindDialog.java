package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Global.Locale;
import Service.SFind;
import ValueObject.VAccount;

public class PFindDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private SFind sFindDialog;

	private JLabel nameLabel1;
	private JLabel nameLabel2;
	private JLabel idLabel;
	private JTextField txtName1;
	private JTextField txtName2;
	private JTextField txtId;
	private JButton findButton1;
	private JButton findButton2;
	private JButton cancelButton;

	public PFindDialog() {
		setSize(300, 300);
		setResizable(true);
		setTitle(Locale.Membership.MEMBERSHIP_MEMBERSHIP_TEXT);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel line1 = new JPanel();
		nameLabel1 = new JLabel(Locale.Find.FIND_NAME);
		txtName1 = new JTextField(10);
		line1.add(nameLabel1);
		line1.add(txtName1);

		JPanel line2 = new JPanel();
		findButton1 = new JButton(Locale.Find.FIND_ID_BUTTON);
		line2.add(findButton1);

		JPanel line3 = new JPanel();
		nameLabel2 = new JLabel(Locale.Find.FIND_NAME);
		txtName2 = new JTextField(10);
		line3.add(nameLabel2);
		line3.add(txtName2);

		JPanel line4 = new JPanel();
		idLabel = new JLabel(Locale.Find.FIND_ID);
		txtId = new JTextField(10);
		line4.add(idLabel);
		line4.add(txtId);

		JPanel line5 = new JPanel();
		findButton2 = new JButton(Locale.Find.FIND_PASSWORD_BUTTON);
		cancelButton = new JButton(Locale.Find.FIND_CANCEL_BUTTON);
		line5.add(findButton2);
		line5.add(cancelButton);

		sFindDialog = new SFind();
		findButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName1.getText();
				VAccount vAccount = sFindDialog.findId(name);
				if (vAccount == null) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 사용자 정보입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "아이디 : " + vAccount.getId());
				}
			}
		});
		findButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName2.getText();
				String id = txtId.getText();
				VAccount vAccount = sFindDialog.findPw(name, id);
				if (vAccount == null) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 사용자 정보입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호 : " + vAccount.getId());
				}
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		container.add(line1);
		container.add(line2);
		container.add(line3);
		container.add(line4);
		container.add(line5);

	}

	public void initialize() {
		setVisible(true);
	}
}

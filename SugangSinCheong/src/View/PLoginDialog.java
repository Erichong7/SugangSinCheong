package View;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Service.SLogin;
import ValueObject.VAccount;

public class PLoginDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SLogin sLogin;

	private JLabel idLabel;
	private JLabel pwLabel;
	private JTextField txtId;
	private JTextField txtPw;
	private JButton loginButton;

	public PLoginDialog(Frame parent) {
		super(parent);

		setSize(230, 140);
		setResizable(false);
		setTitle("로그인");
		setLocationRelativeTo(parent);
		setModal(true);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel line1 = new JPanel();
		idLabel = new JLabel("  아이디 : ");
		txtId = new JTextField(10);
		line1.add(idLabel);
		line1.add(txtId);

		JPanel line2 = new JPanel();
		pwLabel = new JLabel("비밀번호 : ");
		txtPw = new JPasswordField(10);
		line2.add(pwLabel);
		line2.add(txtPw);

		JPanel line3 = new JPanel();
		loginButton = new JButton("로그인");
		line3.add(loginButton);

		container.add(line1);
		container.add(line2);
		container.add(line3);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String password = txtPw.getText();

				sLogin = new SLogin();
				VAccount vAccount = sLogin.getLogin(id, password);

				if (vAccount.getId().equals(id) && vAccount.getPassword().equals(password)) {
					String message = "환영합니다, " + vAccount.getName() + "님.";
					JOptionPane.showMessageDialog(null, message);

					PMainFrame pMainFrame = (PMainFrame) getParent();
					pMainFrame.setVAccout(vAccount);

					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}

			}

		});

		setVisible(true);

	}

}
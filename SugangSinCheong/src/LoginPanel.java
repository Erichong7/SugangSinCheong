import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

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

	public LoginPanel() {
		idLabel = new JLabel("  아이디 : ");
		pwLabel = new JLabel("비밀번호 : ");
		txtId = new JTextField(10);
		txtPw = new JPasswordField(10);
		loginButton = new JButton("로그인");

		add(idLabel);
		add(txtId);
		add(pwLabel);
		add(txtPw);
		add(loginButton);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String password = txtPw.getText();

				sLogin = new SLogin();
				VLogin vLogin = sLogin.login(id, password);

				if (id.equals(vLogin.getId()) && password.equals(vLogin.getPassword())) {
					String message = "환영합니다, " + vLogin.getName() + "님.";
					JOptionPane.showMessageDialog(null, message);
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}

			}

		});

	}

}

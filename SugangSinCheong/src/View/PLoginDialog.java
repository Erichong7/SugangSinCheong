package View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Global.Locale;
import Service.SLogin;
import ValueObject.VAccount;
import View.Main.ActionHandler;

public class PLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private SLogin sLogin;
	private PMembership membership;
	private PFindDialog findDialog;

	private JLabel idLabel;
	private JLabel pwLabel;
	private JTextField txtId;
	private JTextField txtPw;
	private JButton loginButton;
	private JButton cancelButton;
	private JButton membershipButton;
	private JButton findButton;

	public PLoginDialog(ActionHandler actionHandler) {

		setSize(300, 200);
		setResizable(false);
		setTitle("로그인");
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		JPanel line1 = new JPanel();
		idLabel = new JLabel(Locale.LoginDialog.LOGIN);
		txtId = new JTextField(10);
		line1.add(idLabel);
		line1.add(txtId);

		JPanel line2 = new JPanel();
		pwLabel = new JLabel(Locale.LoginDialog.PASSWORD);
		txtPw = new JPasswordField(10);
		line2.add(pwLabel);
		line2.add(txtPw);

		JPanel line3 = new JPanel();
		membershipButton = new JButton(Locale.LoginDialog.HWAEWONGAIM_BUTTONTEXT);
		findButton = new JButton(Locale.LoginDialog.CHATGI_BUTTONTEXT);
		line3.add(membershipButton);
		line3.add(findButton);

		JPanel line4 = new JPanel();
		loginButton = new JButton(Locale.LoginDialog.LOGIN_BUTTONTEXT);
		cancelButton = new JButton(Locale.LoginDialog.CANCEL_BUTTONTEXT);
		line4.add(loginButton);
		line4.add(cancelButton);

		container.add(line1);
		container.add(line2);
		container.add(line3);
		container.add(line4);

		loginButton.addActionListener(actionHandler);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		membershipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				membership = new PMembership();
				membership.initialize();
			}
		});
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findDialog = new PFindDialog();
				findDialog.initialize();
			}
		});

		this.addWindowListener(new WindowAdapter() { // "x" on Close
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		getRootPane().setDefaultButton(loginButton);

	}

	VAccount login() {
		String id = txtId.getText();
		String password = txtPw.getText();

		sLogin = new SLogin();
		VAccount vAccount = sLogin.getLogin(id, password);

		if (vAccount.getId().equals(id) && vAccount.getPassword().equals(password)) {
			dispose();
			String message = Locale.LoginDialog.HWANYOUNG + vAccount.getName() + Locale.LoginDialog.NIM;
			JOptionPane.showMessageDialog(null, message);

			return vAccount;
		} else {
			dispose();
			JOptionPane.showMessageDialog(null, Locale.LoginDialog.SHILPAE);
			return null;
		}
	}

	public void initialize() {
		setVisible(true);
	}

}

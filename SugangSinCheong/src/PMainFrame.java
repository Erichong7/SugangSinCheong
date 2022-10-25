import javax.swing.JFrame;

public class PMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PLogin pLogin;

	public PMainFrame() {
		this.pLogin = new PLogin();

		// attributes
		setVisible(true);
		setSize(230, 130);
		setResizable(false);
		setTitle("로그인 시스템");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// components
		LoginPanel loginPanel = new LoginPanel();
		add(loginPanel);

	}

}

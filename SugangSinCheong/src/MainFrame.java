import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {

		// attributes
		setVisible(true);
		setSize(400, 330);
		setResizable(false);
		setTitle("수강 신청");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// components
		LayoutManager layoutManager = new BorderLayout();
		setLayout(layoutManager);

		SugangsincheongPanel sugangsincheongPanel = new SugangsincheongPanel();
		add(sugangsincheongPanel, BorderLayout.CENTER);

		LoginDialog loginDialong = new LoginDialog(this);

	}

}

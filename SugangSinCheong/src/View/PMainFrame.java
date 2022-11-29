package View;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import Global.Constants;
import ValueObject.VAccount;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PAccountPanel accountPanel;
	private PSugangsincheongPanel sugangsincheongPanel;

	private VAccount vAccount;

	public void setVAccount(VAccount vAccount) {
		this.vAccount = vAccount;
	}

	public PMainFrame(VAccount vAccount) {

		setVAccount(vAccount);

		// attributes
		setSize(Constants.CMainFrame.WIDTH, Constants.CMainFrame.HIGHT);
		setResizable(true);
		setTitle("수강 신청");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// components
		LayoutManager layoutManager = new BorderLayout();
		setLayout(layoutManager);

		accountPanel = new PAccountPanel(this.vAccount);
		add(accountPanel, BorderLayout.NORTH);

		sugangsincheongPanel = new PSugangsincheongPanel();
		add(sugangsincheongPanel, BorderLayout.CENTER);

	}

	public void initialize() {
		setVisible(true);
	}

}

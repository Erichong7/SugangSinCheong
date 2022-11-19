package View;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import ValueObject.VAccount;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PAccountPanel accountPanel;
	private PSugangsincheongPanel sugangsincheongPanel;

	private VAccount vAccount;

	public void setVAccout(VAccount vAccount) {
		this.vAccount = vAccount;
	}

	public PMainFrame() {

		// attributes
		setSize(1000, 600);
		setResizable(true);
		setTitle("수강 신청");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// components
		// vAccount setting
		new PLoginDialog(this);

		LayoutManager layoutManager = new BorderLayout();
		setLayout(layoutManager);

		accountPanel = new PAccountPanel(this.vAccount);
		add(accountPanel, BorderLayout.NORTH);

		sugangsincheongPanel = new PSugangsincheongPanel();
		add(sugangsincheongPanel, BorderLayout.CENTER);

		setVisible(true);

	}

}

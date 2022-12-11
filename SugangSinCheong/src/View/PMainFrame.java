package View;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

import Global.Constants;
import Global.Locale;
import ValueObject.VAccount;
import View.Main.ActionHandler;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PAccountPanel accountPanel;
	private PSugangsincheongPanel sugangsincheongPanel;

	public PMainFrame(VAccount vAccount, ActionHandler actionHandler) {

		// attributes
		setSize(Constants.CMainFrame.WIDTH, Constants.CMainFrame.HIGHT);
		setResizable(true);
		setTitle(Locale.MainFrame.SUGANGSINCHEONG);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// components
		LayoutManager layoutManager = new BorderLayout();
		setLayout(layoutManager);

		accountPanel = new PAccountPanel(vAccount, actionHandler);
		add(accountPanel, BorderLayout.NORTH);

		sugangsincheongPanel = new PSugangsincheongPanel();
		add(sugangsincheongPanel, BorderLayout.CENTER);

	}

	public void initialize() {
		setVisible(true);
	}

}

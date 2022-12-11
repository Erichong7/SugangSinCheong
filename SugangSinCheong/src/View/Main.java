package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ValueObject.VAccount;

public class Main {

	private PLoginDialog loginDialog;
	private PMainFrame mainFrame;
	private ActionHandler actionHandler;

	private VAccount vAccount;

	public Main() {
	}

	private void initialize() {
		actionHandler = new ActionHandler();
		loginDialog = new PLoginDialog(actionHandler);
		loginDialog.initialize();
	}

	private void run() {
		vAccount = loginDialog.login();
		if (vAccount != null) {
			mainFrame = new PMainFrame(vAccount, actionHandler);
			mainFrame.initialize();
		} else {
			initialize();
		}

	}

	private void finish() {
	}

	class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (vAccount == null) {
				run();
			} else {
				mainFrame.dispose();
				vAccount = null;
				initialize();
			}

		}

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
		main.finish();
	}
}

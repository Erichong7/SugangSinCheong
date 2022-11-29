package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ValueObject.VAccount;

public class Main {

	private PLoginDialog loginDialog;

	public Main() {
	}

	private void initialize() {
		ActionHandler actionHandler = new ActionHandler();

		loginDialog = new PLoginDialog(actionHandler);
		loginDialog.setVisible(true);
	}

	private void run() {
		VAccount vAccount = loginDialog.login();
		if (vAccount != null) {
			PMainFrame mainFrame = new PMainFrame(vAccount);
			mainFrame.initialize();
		} else {
			initialize();
		}

	}

	private void finish() {
	}

	class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			run();
		}

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
		main.finish();
	}
}

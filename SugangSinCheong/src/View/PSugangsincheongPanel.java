package View;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PSugangsincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectoryPanel directoryPanel;

	public PSugangsincheongPanel() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layoutManager);

		directoryPanel = new PDirectoryPanel();
		add(directoryPanel);
	}

}

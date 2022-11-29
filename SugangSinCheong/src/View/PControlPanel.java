package View;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import View.PSugangsincheongPanel.ActionHandler;

public class PControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton buttonRight;
	private JButton buttonLeft;

	public PControlPanel(String panelId, ActionHandler actionHandler) {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layoutManager);

		buttonRight = new JButton(">>");
		buttonRight.addActionListener(actionHandler);
		buttonRight.setActionCommand(panelId + buttonRight.getText());
		add(buttonRight);

		buttonLeft = new JButton("<<");
		buttonLeft.addActionListener(actionHandler);
		buttonLeft.setActionCommand(panelId + buttonLeft.getText());
		add(buttonLeft);
	}

}

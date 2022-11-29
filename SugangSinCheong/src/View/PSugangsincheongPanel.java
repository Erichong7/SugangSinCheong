package View;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ValueObject.VLecture;

public class PSugangsincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectoryPanel directoryPanel;
	private PControlPanel controlPanel1;
	private PMiridamgiPanel miridamgiPanel;
	private PControlPanel controlPanel2;
	private PSincheongPanel sincheongPanel;

	public PSugangsincheongPanel() {

		ActionHandler actionHandler = new ActionHandler();

		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(layoutManager);

		directoryPanel = new PDirectoryPanel();
		add(directoryPanel);

		controlPanel1 = new PControlPanel("1", actionHandler);
		add(controlPanel1);

		JScrollPane scrollPane = new JScrollPane();
		miridamgiPanel = new PMiridamgiPanel();
		scrollPane.setViewportView(miridamgiPanel);
		add(scrollPane);

		controlPanel2 = new PControlPanel("2", actionHandler);
		add(controlPanel2);

		scrollPane = new JScrollPane();
		sincheongPanel = new PSincheongPanel();
		scrollPane.setViewportView(sincheongPanel);
		add(scrollPane);
	}

	private void moveFromSincheongToMiridamgi() {
		VLecture lecture = sincheongPanel.getSelectedLectures();
		miridamgiPanel.addLectures(lecture);
	}

	private void moveFromMiridamgiToSincheong() {
		VLecture lecture = miridamgiPanel.getSelectedLectures();
		sincheongPanel.addLectures(lecture);
	}

	private void moveFromMiridamgiToLectures() {
		VLecture lecture = miridamgiPanel.getSelectedLectures();
		directoryPanel.addLectures(lecture);
	}

	private void moveFromLecturesToMiridamgi() {
		VLecture lecture = directoryPanel.getSelectedLectures();
		miridamgiPanel.addLectures(lecture);
	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().compareTo("1>>") == 0) {
				moveFromLecturesToMiridamgi();
			} else if (event.getActionCommand().compareTo("1<<") == 0) {
				moveFromMiridamgiToLectures();
			} else if (event.getActionCommand().compareTo("2>>") == 0) {
				moveFromMiridamgiToSincheong();
			} else if (event.getActionCommand().compareTo("2<<") == 0) {
				moveFromSincheongToMiridamgi();
			}

		}

	}

}

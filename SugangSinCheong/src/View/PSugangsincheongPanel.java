package View;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import ValueObject.VLecture;

public class PSugangsincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PDirectoryPanel directoryPanel;
	private PDetailDialog detailDialog = new PDetailDialog();;

	private JButton miridamgiButton;
	private JButton sincheongButton;
	private JButton detailButton;

	public PSugangsincheongPanel() {

		ActionHandler actionHandler = new ActionHandler();

		LayoutManager layoutManager = new BorderLayout();
		setLayout(layoutManager);

		directoryPanel = new PDirectoryPanel();
		add(directoryPanel);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		detailButton = new JButton("책가방 / 신청내역");
		miridamgiButton = new JButton("미리 담기");
		sincheongButton = new JButton("신청");

		controlPanel.add(detailButton);
		controlPanel.add(miridamgiButton);
		controlPanel.add(sincheongButton);

		detailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailDialog.initialize();
			}
		});
		miridamgiButton.addActionListener(actionHandler);
		sincheongButton.addActionListener(actionHandler);

		add(controlPanel, BorderLayout.EAST);

	}

	private void moveFromLecturesToMiridamgi() {
		VLecture lecture = directoryPanel.getSelectedLecture();
		detailDialog.miridamgiPanel.addLecture(lecture);
	}

	private void moveFromLecturesToSincheong() {
		VLecture lecture = directoryPanel.getSelectedLecture();
		detailDialog.sincheongPanel.addLecture(lecture);
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().compareTo("미리 담기") == 0) {
				moveFromLecturesToMiridamgi();
			} else if (event.getActionCommand().compareTo("신청") == 0) {
				moveFromLecturesToSincheong();
				detailDialog.totalCredit.setText("  총 학점 :" + detailDialog.sincheongPanel.getTotalCredit());
			}
		}

	}

}

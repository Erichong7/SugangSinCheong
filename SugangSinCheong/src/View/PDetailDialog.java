package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Global.Locale;
import ValueObject.VLecture;

public class PDetailDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JButton sincheongButton;
	private JButton deleteButton1;
	private JButton deleteButton2;
	private JLabel miridamgiLabel;
	private JLabel sincheongLabel;
	public JLabel totalCredit;

	public PMiridamgiPanel miridamgiPanel;
	public PSincheongPanel sincheongPanel;

	public PDetailDialog() {
		ActionHandler actionHandler = new ActionHandler();

		setSize(550, 600);
		setResizable(true);
		setTitle("책가방 / 수강신청");
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		Container container1 = new Container();
		container1.setLayout(new BoxLayout(container1, BoxLayout.X_AXIS));

		JPanel tablePanel1 = new JPanel();
		tablePanel1.setLayout(new BoxLayout(tablePanel1, BoxLayout.X_AXIS));
		JScrollPane scrollPane = new JScrollPane();
		miridamgiPanel = new PMiridamgiPanel();
		scrollPane.setViewportView(miridamgiPanel);
		tablePanel1.add(scrollPane);

		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.Y_AXIS));
		sincheongButton = new JButton(Locale.PDetailDialog.APPLY_TEXT);
		deleteButton1 = new JButton(Locale.PDetailDialog.DELETE_TXT);
		deleteButton1.addActionListener(actionHandler);
		buttonPanel1.add(sincheongButton);
		buttonPanel1.add(deleteButton1);

		container1.add(tablePanel1);
		container1.add(buttonPanel1);

		Container container2 = new Container();
		container2.setLayout(new BoxLayout(container2, BoxLayout.X_AXIS));

		JPanel tablePanel2 = new JPanel();
		tablePanel2.setLayout(new BoxLayout(tablePanel2, BoxLayout.X_AXIS));
		scrollPane = new JScrollPane();
		sincheongPanel = new PSincheongPanel();
		scrollPane.setViewportView(sincheongPanel);
		tablePanel2.add(scrollPane);

		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.Y_AXIS));
		deleteButton2 = new JButton(Locale.PDetailDialog.CANCEL_TEXT);
		totalCredit = new JLabel(Locale.PDetailDialog.TOTALCREDIT + sincheongPanel.getTotalCredit());
		deleteButton2.addActionListener(actionHandler);
		buttonPanel2.add(deleteButton2);
		buttonPanel2.add(totalCredit);

		container2.add(tablePanel2);
		container2.add(buttonPanel2);

		sincheongButton.addActionListener(actionHandler);

		JPanel miridamgiTitlePanel = new JPanel();
		miridamgiLabel = new JLabel(Locale.PDetailDialog.BOOKBAG);
		miridamgiTitlePanel.add(miridamgiLabel);
		miridamgiTitlePanel.setBackground(Color.LIGHT_GRAY);

		JPanel sincheongTitlePanel = new JPanel();
		sincheongLabel = new JLabel(Locale.PDetailDialog.SINCHEONGNAEYERK);
		sincheongTitlePanel.add(sincheongLabel);
		sincheongTitlePanel.setBackground(Color.LIGHT_GRAY);

		add(miridamgiTitlePanel);
		add(container1);
		add(sincheongTitlePanel);
		add(container2);

	}

	public void initialize() {
		setVisible(true);
	}

	private void moveFromMiridamgiToSincheong() {
		VLecture lecture = miridamgiPanel.getSelectedLecture();
		sincheongPanel.addLecture(lecture);
	}

	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				if (event.getActionCommand().compareTo("신청") == 0) {
					moveFromMiridamgiToSincheong();
					totalCredit.setText(Locale.PDetailDialog.TOTALCREDIT + sincheongPanel.getTotalCredit());
				} else if (event.getActionCommand().compareTo("삭제") == 0) {
					miridamgiPanel.removeLecture();
				} else if (event.getActionCommand().compareTo("철회") == 0) {
					sincheongPanel.removeLecture();
					totalCredit.setText(Locale.PDetailDialog.TOTALCREDIT + sincheongPanel.getTotalCredit());
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, Locale.PDetailDialog.NoLectureMessage);
			}
		}

	}

}

package View;

import java.util.Vector;

import javax.swing.JOptionPane;

import ValueObject.VLecture;

public class PSincheongPanel extends PLectureTable {
	private static final long serialVersionUID = 1L;

	private Vector<VLecture> lectures;
	private static int totalCredit;
	private int credit;

	public PSincheongPanel() {
		lectures = new Vector<VLecture>();
	}

	public void addLecture(VLecture vLecture) {
		for (VLecture lecture : lectures) { // 동일한 과목을 여러 개 넣을 수 없도록 함.
			if (lecture.equals(vLecture)) {
				JOptionPane.showMessageDialog(null, "이미 신청한 과목입니다.");
				return;
			}
		}
		lectures.add(vLecture);

		totalCredit = 0;
		for (VLecture lecture : lectures) {
			credit = Integer.parseInt(lecture.getCredit());
			totalCredit += credit;
		}

		if (totalCredit > 18) {
			JOptionPane.showMessageDialog(null, "학기 지정 학점 초과입니다.");
			totalCredit -= credit;
		} else {

			JOptionPane.showMessageDialog(null, "강좌 신청 성공");

			Vector<String> row = new Vector<String>();

			row.add(vLecture.getId());
			row.add(vLecture.getName());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getCredit());
			row.add(vLecture.getTime());

			tableModel.addRow(row);
			setRowSelectionInterval(0, 0);
		}
	}

	public void removeLecture() {
		int credit = Integer.parseInt(lectures.get(getSelectedRow()).getCredit());
		totalCredit -= credit;

		lectures.remove(getSelectedRow());
		tableModel.removeRow(getSelectedRow());

		if (getRowCount() != 0) {
			setRowSelectionInterval(0, 0);
		}

	}

	public VLecture getSelectedLecture() {
		VLecture selectedLecture = lectures.get(getSelectedRow());
		return selectedLecture;
	}

	public int getTotalCredit() {
		updateUI();
		return totalCredit;
	}

}

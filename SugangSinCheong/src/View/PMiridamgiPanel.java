package View;

import java.util.Vector;

import javax.swing.JOptionPane;

import ValueObject.VLecture;

public class PMiridamgiPanel extends PLectureTable {
	private static final long serialVersionUID = 1L;

	private Vector<VLecture> lectures;

	public PMiridamgiPanel() {
		lectures = new Vector<VLecture>();
	}

	public void addLecture(VLecture vLecture) {

		for (VLecture lecture : lectures) { // 동일한 과목을 여러 개 넣을 수 없도록 함.
			if (lecture.equals(vLecture)) {
				JOptionPane.showMessageDialog(null, "이미 담은 과목입니다.");
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "책가방에 강좌를 담았습니다.");

		lectures.add(vLecture);

		Vector<String> row = new Vector<String>();

		row.add(vLecture.getId());
		row.add(vLecture.getName());
		row.add(vLecture.getProfessor());
		row.add(vLecture.getCredit());
		row.add(vLecture.getTime());

		tableModel.addRow(row);

		setRowSelectionInterval(0, 0);
	}

	public void removeLecture() {
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

}

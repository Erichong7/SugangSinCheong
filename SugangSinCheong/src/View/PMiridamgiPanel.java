package View;

import java.util.Vector;

import javax.swing.JScrollPane;

import ValueObject.VLecture;

public class PMiridamgiPanel extends PLectureTable {
	private static final long serialVersionUID = 1L;

	private PLectureTable lectureTable;
	private VLecture vLecture;
	private Vector<VLecture> lectures;

	public PMiridamgiPanel() {
		lectures = new Vector<VLecture>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		lectureTable = new PLectureTable();
		scrollPane.setViewportView(lectureTable);
		add(scrollPane);
	}

	public void addLectures(VLecture vLecture) {
		this.vLecture = vLecture;
		lectures.add(vLecture);

		if (vLecture != null) {
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

	public VLecture getSelectedLectures() {
		System.out.print(lectureTable.getSelectedRow());
		return vLecture;
	}

}

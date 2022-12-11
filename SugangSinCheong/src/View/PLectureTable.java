package View;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Global.Locale;
import Service.SLecture;
import ValueObject.VLecture;

public class PLectureTable extends JTable {
	private static final long serialVersionUID = 1L;

	public DefaultTableModel tableModel;
	private Vector<VLecture> vLectures;

	public PLectureTable() {

		Vector<String> header = new Vector<String>();
		header.add(Locale.LectureTable.LECTURE_ID);
		header.add(Locale.LectureTable.LECTURE_NAME);
		header.add(Locale.LectureTable.LECTURE_PROFESSOR);
		header.add(Locale.LectureTable.LECTURE_CREDIT);
		header.add(Locale.LectureTable.LECTURE_TIME);
		tableModel = new DefaultTableModel(header, 0);
		setModel(tableModel);

	}

	public Vector<VLecture> getVLectures() {
		return this.vLectures;
	}

	public void setData(String fileName) {
		SLecture sLecture = new SLecture();
		vLectures = sLecture.getLectures(fileName);

		tableModel.setNumRows(0);
		for (VLecture vLecture : vLectures) {
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

}

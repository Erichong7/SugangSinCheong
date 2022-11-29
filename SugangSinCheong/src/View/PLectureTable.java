package View;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Service.SLecture;
import ValueObject.VLecture;

public class PLectureTable extends JTable {
	private static final long serialVersionUID = 1L;

	public DefaultTableModel tableModel;
	public Vector<VLecture> vLectures;

	public PLectureTable() {

		Vector<String> header = new Vector<String>();
		header.add("강좌 번호");
		header.add("과목");
		header.add("교수");
		header.add("학점");
		header.add("시간");
		tableModel = new DefaultTableModel(header, 0);
		setModel(tableModel);

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

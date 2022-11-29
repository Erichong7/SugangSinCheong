package View;

import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Service.SDirectory;
import ValueObject.VDirectory;
import ValueObject.VLecture;

public class PDirectoryPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ListSelectionHandler listSelectionHandler;
	private PDirectory campusTable;
	private PDirectory collegeTable;
	private PDirectory departmentTable;
	private PLectureTable lectureTable;

	private String fileName;

	public PDirectoryPanel() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layoutManager);

		listSelectionHandler = new ListSelectionHandler();

		JPanel subPanel1 = new JPanel();
		layoutManager = new BoxLayout(subPanel1, BoxLayout.X_AXIS);
		subPanel1.setLayout(layoutManager);

		campusTable = new PDirectory(); // campusTable
		campusTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
		JScrollPane scrollPane = new JScrollPane(campusTable);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(campusTable);
		subPanel1.add(scrollPane);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		collegeTable = new PDirectory(); // collegeTable
		collegeTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
		scrollPane.setViewportView(collegeTable);
		subPanel1.add(scrollPane);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		departmentTable = new PDirectory(); // departmentTable
		departmentTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
		scrollPane.setViewportView(departmentTable);
		subPanel1.add(scrollPane);

		add(subPanel1);

		JPanel subPanel2 = new JPanel();
		layoutManager = new BoxLayout(subPanel2, BoxLayout.X_AXIS);
		subPanel2.setLayout(layoutManager);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		lectureTable = new PLectureTable();
		scrollPane.setViewportView(lectureTable);
		subPanel2.add(scrollPane);

		add(subPanel2);

		upDataTable(null);
	}

	private void upDataTable(Object source) {
		if (source == null) {
			fileName = "root";
			fileName = campusTable.setData(fileName);
			fileName = collegeTable.setData(fileName);
			fileName = departmentTable.setData(fileName);
			lectureTable.setData(fileName);
		} else if (source == campusTable.getSelectionModel()) {
			fileName = campusTable.getVDirectories().get(campusTable.getSelectedRow()).getFileName();
			fileName = collegeTable.setData(fileName);
			fileName = departmentTable.setData(fileName);
			lectureTable.setData(fileName);
		} else if (source == collegeTable.getSelectionModel()) {
			fileName = collegeTable.getVDirectories().get(collegeTable.getSelectedRow()).getFileName();
			fileName = departmentTable.setData(fileName);
			lectureTable.setData(fileName);
		} else if (source == departmentTable.getSelectionModel()) {
			fileName = departmentTable.getVDirectories().get(departmentTable.getSelectedRow()).getFileName();
			lectureTable.setData(fileName);
		}

	}

	private class ListSelectionHandler implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting()) { // 뭐가 진행되고 있으면 True
				upDataTable(event.getSource());
			} else {
			}
		}

	}

	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;
		private Vector<VDirectory> vDirectories;

		public PDirectory() {
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			Vector<String> header = new Vector<String>();
			header.add("");
			tableModel = new DefaultTableModel(header, 0);
			setModel(tableModel);

		}

		public Vector<VDirectory> getVDirectories() {
			return vDirectories;
		}

		public String setData(String fileName) {
			SDirectory sDirectory = new SDirectory();
			vDirectories = sDirectory.getDirectories(fileName);

			tableModel.setNumRows(0);
			for (VDirectory vDirectory : vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());

				tableModel.addRow(row);
			}
			setRowSelectionInterval(0, 0);
			return vDirectories.get(0).getFileName();
		}

	}

	public VLecture getSelectedLectures() {

		if (lectureTable.getRowCount() == 0) {
			return null;
		}

		Vector<VLecture> lectures = lectureTable.vLectures;
		int selectedLectureRow = lectureTable.getSelectedRow();
		VLecture selectedLecture = lectures.get(selectedLectureRow);
		lectures.remove(selectedLectureRow);
		((DefaultTableModel) lectureTable.getModel()).removeRow(selectedLectureRow);

		if (lectureTable.getRowCount() != 0) {
			lectureTable.setRowSelectionInterval(0, 0);
		}

		return selectedLecture;
	}

	public void addLectures(VLecture lectures) {

	}

}

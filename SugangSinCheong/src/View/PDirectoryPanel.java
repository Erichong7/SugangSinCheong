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
import Service.SLecture;
import ValueObject.VDirectory;
import ValueObject.VLecture;

public class PDirectoryPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ListSelectionHandler listSelectionHandler;
	private PDirectory campusTable;
	private PDirectory collegeTable;
	private PDirectory departmentTable;
	private PLecture lectureTable;

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

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(campusTable);
		subPanel1.add(scrollPane);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		collegeTable = new PDirectory(); // collegeTable
		collegeTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
		scrollPane.setViewportView(collegeTable);
		subPanel1.add(scrollPane);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		departmentTable = new PDirectory(); // departmentTable
		departmentTable.getSelectionModel().addListSelectionListener(listSelectionHandler);
		scrollPane.setViewportView(departmentTable);
		subPanel1.add(scrollPane);

		add(subPanel1);

		JPanel subPanel2 = new JPanel();
		layoutManager = new BoxLayout(subPanel2, BoxLayout.X_AXIS);
		subPanel2.setLayout(layoutManager);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		lectureTable = new PLecture();
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

	private class PLecture extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;

		public PLecture() {

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
			Vector<VLecture> vLectures = sLecture.getLectures(fileName);

			tableModel.setNumRows(0);
			for (VLecture vLecture : vLectures) {
				Vector<String> row = new Vector<String>();
				row.add(vLecture.getId());
				row.add(vLecture.getName());
				row.add(vLecture.getProfessor());
				row.add(vLecture.getCredit());
				row.add(vLecture.getTime());

				tableModel.addRow(row);
			}
		}

	}
}

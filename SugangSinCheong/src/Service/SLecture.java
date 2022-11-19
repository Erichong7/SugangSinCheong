package Service;
import java.util.Vector;

import Entity.ELecture;
import ValueObject.VLecture;

public class SLecture {

	private ELecture eLecture;

	public SLecture() {
		eLecture = new ELecture();
	}

	public Vector<VLecture> getLectures(String fileName) {
		return eLecture.getLectures(fileName);
	}

}

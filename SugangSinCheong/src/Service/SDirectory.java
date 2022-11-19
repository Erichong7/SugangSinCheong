package Service;
import java.util.Vector;

import Entity.EDirectory;
import ValueObject.VDirectory;

public class SDirectory {

	private EDirectory eDirectory;

	public SDirectory() {
		eDirectory = new EDirectory();
	}

	public Vector<VDirectory> getDirectories(String fileName) {
		return eDirectory.getDirectories(fileName);
	}

}

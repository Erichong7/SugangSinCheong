package Service;

import Entity.EFind;
import ValueObject.VAccount;

public class SFind {

	private EFind eFind;

	public SFind() {
		eFind = new EFind();
	}

	public VAccount findId(String name) {
		VAccount vAccount = eFind.getAccount(name);
		return vAccount;
	}

	public VAccount findPw(String name, String id) {
		VAccount vAccount = eFind.getAccount(name, id);
		return vAccount;
	}

}

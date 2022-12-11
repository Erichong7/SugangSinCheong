package Service;

import Entity.EMembership;
import ValueObject.VAccount;

public class SMembership {

	private EMembership eMembership;

	public SMembership() {
		eMembership = new EMembership();
	}

	public VAccount createMembership(String name, String id, String password) {
		VAccount vAccount = eMembership.memberShip(name, id, password);
		return vAccount;
	}

}

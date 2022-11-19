package Service;
import Entity.EAccount;
import ValueObject.VAccount;

public class SLogin {

	private EAccount eAccount;
	private VAccount vLogin;

	public SLogin() {
		this.eAccount = new EAccount();
	}

	public VAccount getLogin(String id, String password) {
		vLogin = this.eAccount.getLogin(id, password);

		return vLogin;
	}

}

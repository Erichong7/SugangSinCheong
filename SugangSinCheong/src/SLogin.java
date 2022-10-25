
public class SLogin {

	private EAccount eAccount;

	public SLogin() {
		this.eAccount = new EAccount();
	}

	public VLogin login(String id, String password) {
		VLogin vLogin = this.eAccount.getLogin(id, password);

		return vLogin;
	}
}

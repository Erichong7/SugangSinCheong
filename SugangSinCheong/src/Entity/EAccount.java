package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ValueObject.VAccount;

public class EAccount {

	private VAccount vLogin = new VAccount();
	private String id;
	private String password;
	private String name;
	// ...

	public EAccount() {
	}

	public VAccount getLogin(String id, String password) {
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			// file read
			boolean found = false;
			while (scanner.hasNext() && !found) {
				this.id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();

				if (this.id.equals(id)) {
					if (this.password.equals(password)) {
						found = true;
					}
				}
			}
			scanner.close();

			vLogin.setId(this.id);
			vLogin.setPassword(this.password);
			vLogin.setName(this.name);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vLogin;
	}

}

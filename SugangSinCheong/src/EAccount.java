import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EAccount {

	private VLogin vLogin = new VLogin();
	private String id;
	private String password;
	private String name;
	// ...

	public EAccount() {
	}

	public VLogin getLogin(String id, String password) {
		try {
			File file = new File("data/account");
			Scanner scanner = new Scanner(file);
			// file read
			boolean found = true;
			while (scanner.hasNext() && found) {
				this.id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();

				if (this.id.equals(id)) {
					if (this.password.equals(password)) {
						found = false;
					}
				}
			}
			scanner.close();

			if (!found) {
				vLogin.setId(this.id);
				vLogin.setPassword(this.password);
				vLogin.setName(this.name);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vLogin;
	}

}

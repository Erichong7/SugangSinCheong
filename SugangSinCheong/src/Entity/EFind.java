package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ValueObject.VAccount;

public class EFind {
	String id;
	String name;
	String password;

	private VAccount vAccount;

	public EFind() {
		vAccount = new VAccount();
	}

	public VAccount getAccount(String name) {
		this.name = name;
		VAccount vAccount = checkFile();
		return vAccount;
	}

	public VAccount getAccount(String name, String id) {
		this.name = name;
		this.id = id;
		VAccount vAccount = checkFile();
		return vAccount;
	}

	public VAccount checkFile() {
		File file = new File("account/account");
		try {
			Scanner scanner = new Scanner(file);
			boolean found = false;
			while (scanner.hasNext() && !found) {
				String id = scanner.next();
				String password = scanner.next();
				String name = scanner.next();

				if (this.name.equals(name)) {
					found = true;
					vAccount.setId(id);
					vAccount.setPassword(password);
					vAccount.setName(name);
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vAccount;
	}

}

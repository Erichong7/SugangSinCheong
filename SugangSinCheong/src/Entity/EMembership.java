package Entity;

import java.io.FileWriter;
import java.io.IOException;

import ValueObject.VAccount;

public class EMembership {

	private VAccount vAccount = new VAccount();

	public EMembership() {

	}

	public VAccount memberShip(String name, String id, String password) {

		if (name.equals("") || id.equals("") || password.equals("")) {
			vAccount = null;
		} else {
			String filePath = "account/account";
			try {
				FileWriter fw = new FileWriter(filePath, true);
				fw.write("\n");
				fw.write(id + " ");
				fw.write(password + " ");
				fw.write(name);

				fw.close();

				vAccount.setName(name);
				vAccount.setId(id);
				vAccount.setPassword(password);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return vAccount;
	}

}

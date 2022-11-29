package View;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Global.Locale;
import ValueObject.VAccount;

public class PAccountPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public PAccountPanel(VAccount vLogin) {
		JLabel lName = new JLabel(vLogin.getName());
		this.add(lName);

		JLabel lInsa = new JLabel(Locale.AccountPanel.INSA_POSTFIX);
		this.add(lInsa);

		JLabel lLogin = new JLabel(Locale.AccountPanel.LOGINTIME_POSTFIX);
		this.add(lLogin);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Locale.TIME_FORMAT);
		JLabel lTime = new JLabel(simpleDateFormat.format(new Date()));
		this.add(lTime);

		JLabel lText = new JLabel(Locale.IMNIDA);
		this.add(lText);
	}
}

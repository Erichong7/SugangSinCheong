package View;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ValueObject.VAccount;

public class PAccountPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public PAccountPanel(VAccount vLogin) {
		JLabel lName = new JLabel(vLogin.getName() + "님");
		this.add(lName);

		JLabel lInsa = new JLabel("안녕하세요!");
		this.add(lInsa);

		JLabel lLogin = new JLabel("로그인 시간은");
		this.add(lLogin);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy년 MM월 dd일 hh시 mm분");
		JLabel lTime = new JLabel(simpleDateFormat.format(new Date()));
		this.add(lTime);

		JLabel lText = new JLabel("입니다.");
		this.add(lText);
	}
}

package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Global.Locale;
import ValueObject.VAccount;
import View.Main.ActionHandler;

public class PAccountPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lName;
	private JLabel lInsa;
	private JLabel lLogin;
	private JLabel lTime;
	private JLabel lText;
	private JButton logoutButton;
	private JLabel leftTime;
	private JLabel countMin;
	private JLabel display;
	private JLabel countSec;

	private static int countM = 30;
	private static int countS = 0;
	private boolean run = true;

	public PAccountPanel(VAccount vAccount, ActionHandler actionHandler) {
		setLayout(new BorderLayout());

		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.LIGHT_GRAY);
		lName = new JLabel(vAccount.getName());
		add(lName);
		lInsa = new JLabel(Locale.AccountPanel.INSA_POSTFIX);
		add(lInsa);
		lLogin = new JLabel(Locale.AccountPanel.LOGINTIME_POSTFIX);
		add(lLogin);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Locale.TIME_FORMAT);
		lTime = new JLabel(simpleDateFormat.format(new Date()));
		add(lTime);
		lText = new JLabel(Locale.IMNIDA);
		add(lText);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		logoutButton = new JButton(Locale.PAccount.LogoutTXT);
		logoutButton.addActionListener(actionHandler);
		buttonPanel.add(logoutButton);

		JPanel countPanel = new JPanel();
		countPanel.setBackground(Color.LIGHT_GRAY);

		leftTime = new JLabel(Locale.PAccount.LeftTime);
		countMin = new JLabel(Locale.PAccount.SetMinTXT);
		display = new JLabel(Locale.PAccount.DisplayTXT);
		countSec = new JLabel(Locale.PAccount.SetSecTXT);

		countPanel.add(leftTime);
		countPanel.add(countMin);
		countPanel.add(display);
		countPanel.add(countSec);

		welcomePanel.add(lName);
		welcomePanel.add(lInsa);
		welcomePanel.add(lLogin);
		welcomePanel.add(lTime);
		welcomePanel.add(lText);

		add(welcomePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.EAST);
		add(countPanel, BorderLayout.WEST);

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				countM = Integer.parseInt(countMin.getText());
				countS = Integer.parseInt(countSec.getText());
				int totalTime = countM * 60 + countS;
				if (totalTime > 0) {
					totalTime--;
					countM = totalTime / 60;
					countS = totalTime % 60;
					String textM = Integer.toString(countM);
					String textS = Integer.toString(countS);
					countMin.setText(textM);

					if (countM < 1 && run) {
						int result = JOptionPane.showConfirmDialog(null, Locale.PAccount.ConfirmMessage,
								Locale.PAccount.Confirm, JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							countMin.setText(Locale.PAccount.SetMinTXT);
						} else {
							run = false;
						}
					}

					if (countS < 10) {
						countSec.setText(0 + textS);
					} else {
						countSec.setText(textS);
					}

					updateUI();
				} else {
					timer.cancel(); // 타이머 종료
					logoutButton.doClick();
				}
			}
		};
		timer.schedule(task, 1000, 1000); // 1초뒤 실행, 1초마다 반복

	}
}

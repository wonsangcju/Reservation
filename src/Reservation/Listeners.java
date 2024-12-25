package Reservation;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Listeners {
	/**
	 * 리스너를 모아놓은 클래스
	 * 
	 * @changelog
	 *            <ul>
	 *            <li>2024.12.23 23:00 최초 생성</li>
	 *            </ul>
	 */
	private Main mainApp;

	public Listeners(Main mainApp) {
		this.mainApp = mainApp;
	}

	// 좌석 버튼 리스너
	public class SeatButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton clickedSeat = (JButton) e.getSource();
			mainApp.selectedSeat = clickedSeat.getText();
			mainApp.sentence.setText(mainApp.selectedSeat + " 좌석이 선택되었습니다.");
		}
	}

	// 예약확인 버튼 리스너
	public class CheckButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!mainApp.selectedSeat.isEmpty()) {
				mainApp.saveReservation(mainApp.selectedSeat);
				mainApp.cardLayout.show(mainApp.getContentPane(), "Confirm");
			} else {
				mainApp.sentence.setText("좌석을 먼저 선택해주세요.");
			}
		}
	}

	// 예약취소 버튼 리스너
	public class CancelButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!mainApp.selectedSeat.isEmpty()) {
				mainApp.cancelReservationInCSV(mainApp.selectedSeat);
				mainApp.selectedSeat = "";
				mainApp.sentence.setText("예약이 취소되었습니다.");
				mainApp.cardLayout.show(mainApp.getContentPane(), "Main");
			}
		}
	}

	// 홈 버튼 리스너
	public class HomeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mainApp.cardLayout.show(mainApp.getContentPane(), "Main");
		}
	}

	// 로그인 버튼 리스너
	public class LoginButtonListener implements ActionListener {
	    private JTextField inputId;
	    private JPasswordField inputPassword;
	    private JPanel loginPanel, mainPanel;
	    private CardLayout cardLayout;

	    public LoginButtonListener(JTextField inputId, JPasswordField inputPassword, JPanel loginPanel,
	                               CardLayout cardLayout, JPanel mainPanel) {
	        this.inputId = inputId;
	        this.inputPassword = inputPassword;
	        this.loginPanel = loginPanel;
	        this.cardLayout = cardLayout;
	        this.mainPanel = mainPanel;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String id = inputId.getText().trim();
	        String password = new String(inputPassword.getPassword()).trim();

	        if (id.isEmpty() || password.isEmpty()) {
	            JOptionPane.showMessageDialog(loginPanel, "아이디와 비밀번호를 모두 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        if (isLoginValid(id, password)) {
	            JOptionPane.showMessageDialog(loginPanel, "로그인에 성공했습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
	            cardLayout.show(mainPanel, "Main");
	        } else {
	            JOptionPane.showMessageDialog(loginPanel, "아이디 또는 비밀번호가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	
	// 아이디, 비밀번호 확인 메소드
	private boolean isLoginValid(String id, String password) {
	    String filePath = "account/account.csv";
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] userData = line.split(",");
	            if (userData.length == 2 && userData[0].equals(id) && userData[1].equals(password)) {
	                return true;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	// 회원가입 버튼 리스너
	public class RegisterButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mainApp.cardLayout.show(mainApp.getContentPane(), "Register");
		}
	}

	// 중복 확인 리스너
	public class CheckDuplicateListener implements ActionListener {
		private JTextField idField;
		private JPanel registerPanel;

		public CheckDuplicateListener(JTextField idField, JPanel registerPanel) {
			this.idField = idField;
			this.registerPanel = registerPanel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText().trim();
			if (id.isEmpty()) {
				JOptionPane.showMessageDialog(registerPanel, "아이디를 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (isDuplicateId(id)) {
				JOptionPane.showMessageDialog(registerPanel, "이미 존재하는 아이디입니다.", "중복 확인", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(registerPanel, "사용 가능한 아이디입니다.", "중복 확인",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// 회원가입 리스너
	public class ConfirmRegisterListener implements ActionListener {
		private JTextField idField;
		private JPasswordField passwordField;
		private JPanel registerPanel;
		private CardLayout cardLayout;
		private Container mainContentPanel;

		public ConfirmRegisterListener(JTextField idField, JPasswordField passwordField, JPanel registerPanel,
				CardLayout cardLayout, Container mainContentPanel) {
			this.idField = idField;
			this.passwordField = passwordField;
			this.registerPanel = registerPanel;
			this.cardLayout = cardLayout;
			this.mainContentPanel = mainContentPanel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText().trim();
			String password = new String(passwordField.getPassword()).trim();

			if (id.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(registerPanel, "아이디와 비밀번호를 모두 입력해주세요.", "경고",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (isDuplicateId(id)) {
				JOptionPane.showMessageDialog(registerPanel, "아이디가 중복되었습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				saveUser(id, password);
				JOptionPane.showMessageDialog(registerPanel, "회원가입이 완료되었습니다.", "완료", JOptionPane.INFORMATION_MESSAGE);
				cardLayout.show(mainContentPanel, "Login");
			}
		}
	}

	// 회원가입 시 아이디 중복 여부 확인 메소드
	private boolean isDuplicateId(String id) {
		String filePath = "account/account.csv";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.split(",")[0].equals(id)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 사용자 정보 저장 메소드
	private void saveUser(String id, String password) {
		String filePath = "account/account.csv";
		String data = id + "," + password + "\n";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
			writer.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
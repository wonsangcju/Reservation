package Reservation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 학생식당 자리 예약 및 식단 확인 프로그램
 * 
 * @author 2021011865 전원상
 * @version 1.0
 * 
 * @created 2024.12.19
 * @lastModified 2024.12.22
 * 
 *
 * @changelog
 *            <ul>
 *            <li>2024.12.19 12:00 최초 생성</li>
 *            <li>2024.12.22 07:00 패널 별도의 메소드로 분리</li>
 *            <li>2024.12.22 08:00 메인패널을 메소드로 분리하고 다른 메소드들을 메인패널에 통합</li>
 *            <li>2024.12.23 23:00 리스너들을 별도의 클래스로 분리</li>
 *            </ul>
 */
public class Main extends JFrame {
	public CardLayout cardLayout;
	public JPanel mainPanel, reservationPanel, reservationCheckPanel, loginPanel, registerPanel;
	public JLabel sentence;
	public JButton seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9;
	public JButton menuButton, checkButton, homeButton, cancelButton;
	public JTextField inputId;
	public JPasswordField inputPassword;
	public String selectedSeat = "";

	Listeners listeners;

	public Main() {
		listeners = new Listeners(this);

		this.setTitle("학생식당");
		this.setSize(400, 465);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.green);

		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		
		mainPanel();
		loginPanel();
		registerPanel();
		reservationCheckPanel();
		
		cardLayout.show(this.getContentPane(), "Login");

		this.setVisible(true);
	}	
	
	public void loginPanel() {
		/**
		 * 로그인 패널
		 * 
		 * @changelog
		 *            <ul>
		 *            <li>2024.12.24 15:00 최초 생성</li>
		 *            <ul>
		 */
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.white);
		loginPanel.setLayout(new BorderLayout());

		JPanel labelPanel = new JPanel(new GridLayout(2, 1));
		JLabel idLabel = new JLabel("아이디");
		labelPanel.add(idLabel);
		JLabel pwLabel = new JLabel("비밀번호 ");
		labelPanel.add(pwLabel);

		JPanel inputPanel = new JPanel(new GridLayout(2, 1));
		inputId = new JTextField(10);
		inputPanel.add(inputId);
		inputPassword = new JPasswordField(10);
		inputPanel.add(inputPassword);
		
		JPanel loginRegisterPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		JButton loginButton = new JButton();
		new decorateButton(loginButton, loginRegisterPanel, "로그인", 80, 80, 80,
				listeners.new LoginButtonListener(inputId, inputPassword, cardLayout, this.getContentPane()));
		JButton registerButton = new JButton();
		new decorateButton(registerButton, loginRegisterPanel, "회원가입", 80, 80, 80,
				listeners.new RegisterButtonListener());

		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(labelPanel, BorderLayout.WEST);
		centerPanel.add(inputPanel, BorderLayout.CENTER);
		centerPanel.add(loginRegisterPanel, BorderLayout.EAST);
		centerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(100, 50, 100, 50));

		loginPanel.add(centerPanel, BorderLayout.CENTER);

		this.add(loginPanel, "Login");
	}


	public void mainPanel() {
		/**
		 * 예약을 할 수 있고 메인이 되는 패널
		 * 
		 * @changelog
		 *            <ul>
		 *            <li>2024.12.24 07:00 별도의 메소드로 분리</li>
		 *            <li>2024.12.22 08:00 다른 메소드들을 메인패널에 통합</li>
		 *            <li>2024.12.24 15:00 로그인 패널 생성</li>
		 *            <li>2024.12.24 22:00 회원가입 패널 생성</li>
		 *            <ul>
		 */
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.black);

		reservationPanel = new JPanel(new BorderLayout());
		reservationPanel.setBackground(Color.gray);

		mainPanel.add(reservationPanel);

		this.add(mainPanel, "Main");

		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.gray);

		// 메뉴 버튼
		ImageIcon listIcon = new ImageIcon("img/menuButton.png");
		menuButton = new JButton(listIcon);
		menuButton.setPreferredSize(new Dimension(40, 40));
		menuButton.setBorder(null);
		topPanel.add(menuButton);

		sentence = new JLabel("예약을 원하는 좌석을 선택해주세요.");
		sentence.setFont(new Font("굴림 보통", Font.BOLD, 15));
		sentence.setForeground(Color.white);
		topPanel.add(sentence);

		reservationPanel.add(topPanel, BorderLayout.NORTH);

		// 좌석 버튼들이 배치될 패널
		JPanel seatPanel = new JPanel(new GridLayout(3, 3));
		seatPanel.setBackground(Color.gray);

		// 좌석 버튼
		seat1 = new JButton();
		new decorateButton(seat1, seatPanel, "1번", 80, 80, 80, listeners.new SeatButtonListener());
		seat2 = new JButton();
		new decorateButton(seat2, seatPanel, "2번", 80, 80, 80, listeners.new SeatButtonListener());
		seat3 = new JButton();
		new decorateButton(seat3, seatPanel, "3번", 80, 80, 80, listeners.new SeatButtonListener());
		seat4 = new JButton();
		new decorateButton(seat4, seatPanel, "4번", 80, 80, 80, listeners.new SeatButtonListener());
		seat5 = new JButton();
		new decorateButton(seat5, seatPanel, "5번", 80, 80, 80, listeners.new SeatButtonListener());
		seat6 = new JButton();
		new decorateButton(seat6, seatPanel, "6번", 80, 80, 80, listeners.new SeatButtonListener());
		seat7 = new JButton();
		new decorateButton(seat7, seatPanel, "7번", 80, 80, 80, listeners.new SeatButtonListener());
		seat8 = new JButton();
		new decorateButton(seat8, seatPanel, "8번", 80, 80, 80, listeners.new SeatButtonListener());
		seat9 = new JButton();
		new decorateButton(seat9, seatPanel, "9번", 80, 80, 80, listeners.new SeatButtonListener());

		reservationPanel.add(seatPanel, BorderLayout.CENTER);

		// 예약확인, 취소 버튼이 있는 패널
		JPanel checkPanel = new JPanel();
		checkPanel.setBackground(Color.gray);

		// 예약확인 버튼
		checkButton = new JButton();
		new decorateButton(checkButton, checkPanel, "예약", 80, 80, 80, listeners.new CheckButtonListener());
		checkButton.setPreferredSize(new Dimension(100, 50));
		reservationPanel.add(checkPanel, BorderLayout.SOUTH);

		// 예약취소 버튼
		cancelButton = new JButton();
		new decorateButton(cancelButton, checkPanel, "예약 취소", 80, 80, 80, listeners.new CancelButtonListener());
		cancelButton.setPreferredSize(new Dimension(100, 50));

	}

	public void reservationCheckPanel() {
		/**
		 * 예약 완료 패널
		 * 
		 * @changelog
		 *            <ul>
		 *            <li>2024.12.22 16:00 최초 생성</li>
		 *            <li>2024.12.22 18:00 홈 버튼 추가</li>
		 *            <ul>
		 */
		reservationCheckPanel = new JPanel();
		reservationCheckPanel.setBackground(Color.LIGHT_GRAY);

		// 예약 완료 문구
		JLabel confirmLabel = new JLabel("예약이 완료되었습니다.");
		confirmLabel.setFont(new Font("굴림 보통", Font.BOLD, 20));
		confirmLabel.setHorizontalAlignment(JLabel.CENTER);
		reservationCheckPanel.add(confirmLabel, BorderLayout.NORTH);

		// 홈 버튼
		JPanel homePanel = new JPanel();
		homeButton = new JButton("");
		new decorateButton(homeButton, homePanel, "홈으로", 80, 80, 80, listeners.new HomeButtonListener());
		reservationCheckPanel.add(homePanel, BorderLayout.SOUTH);

		this.add(reservationCheckPanel, "Confirm");
	}


	public void registerPanel() {
		/**
		 * 회원가입 패널
		 * 
		 * @changelog
		 *            <ul>
		 *            <li>2024.12.24 22:00 최초 생성</li>
		 *            <ul>
		 */
		registerPanel = new JPanel(new BorderLayout());
		registerPanel.setBackground(Color.white);

		JLabel statusLabel = new JLabel("회원가입 정보를 입력해주세요.", JLabel.CENTER);
		statusLabel.setFont(new Font("굴림", Font.BOLD, 16));
		registerPanel.add(statusLabel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

		JLabel idLabel = new JLabel("아이디:");
		JTextField txtId = new JTextField(20);

		JLabel pwLabel = new JLabel("비밀번호:");
		JPasswordField txtPassword = new JPasswordField(20);

		// 아이디 중복 검사 버튼
		JButton checkDuplicateButton = new JButton();
		new decorateButton(checkDuplicateButton, centerPanel, "중복 검사", 80, 80, 80,
				listeners.new CheckDuplicateListener(txtId, registerPanel));
		checkDuplicateButton.setFont(new Font("Seoge UI", Font.PLAIN, 13));
		
		// 회원가입 완료 버튼
		JButton confirmButton = new JButton();
		new decorateButton(confirmButton, buttonPanel, "<html><div style='text-align: center;'>회원가입<br>완료</div></html>",
				80, 80, 80, listeners.new ConfirmRegisterListener(txtId, txtPassword, registerPanel, cardLayout,
						this.getContentPane()));
		
		// 회원가입 취소 버튼
		JButton cancelButton = new JButton();
		new decorateButton(cancelButton, buttonPanel, "취소", 80, 80, 80,
				e -> cardLayout.show(this.getContentPane(), "Login"));

		JLabel gapLabel = new JLabel("");

		Dimension textFieldSize = new Dimension(50, 20);
		txtId.setPreferredSize(textFieldSize);
		txtPassword.setPreferredSize(textFieldSize);

		// 회원가입 패널 배치
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		centerPanel.add(idLabel, gbc);

		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		centerPanel.add(txtId, gbc);

		gbc.gridx = 2;
		gbc.weightx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		centerPanel.add(checkDuplicateButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		centerPanel.add(pwLabel, gbc);

		gbc.gridx = 1;
		centerPanel.add(txtPassword, gbc);

		gbc.gridx = 2;
		centerPanel.add(gapLabel, gbc);

		registerPanel.add(centerPanel, BorderLayout.CENTER);
		registerPanel.add(buttonPanel, BorderLayout.SOUTH);

		this.add(registerPanel, "Register");
	}

	public void saveReservation(String seat) {
		/**
		 * 예약 시 예약시간과 예약한 좌석이 csv에 작성되게 하는 메소드
		 * 
		 * @changelog
		 *            <ul>
		 *            <li>2024.12.23 22:00 최초 생성</li>
		 *            <ul>
		 */
		String filePath = "seat/reservations.csv";
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String timestamp = now.format(formatter);

		String data = timestamp + "," + seat + "\n";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
			writer.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cancelReservationInCSV(String seat) {
		/**
		 * 예약을 취소할 경우 예약 시 작성됐던 내용이 csv에서 삭제되는 메소드
		 * 
		 * @changelog
		 *            <ul>
		 *            <li>2024.12.23 22:00 최초 생성</li>
		 *            <ul>
		 */
		String filePath = "seat/reservations.csv";
		StringBuilder updatedData = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.contains("," + seat)) { // 선택된 좌석이 아닌 경우만 추가
					updatedData.append(line).append("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
			writer.write(updatedData.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}

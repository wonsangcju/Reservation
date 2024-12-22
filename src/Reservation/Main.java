package Reservation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
 *            </ul>
 */
public class Main extends JFrame {
	public JPanel mainPanel, reservationPanel, reservationCheckPanel;
	public JLabel sentence;
	public JButton menuButton, checkButton, seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9;
	
	public Main() {
		this.setTitle("학생식당");
		this.setSize(335, 460);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.green);
		
		this.setLayout(new CardLayout());

		mainPanel();
		reservationCheckPanel();
		
		this.setVisible(true);
	}
	
	public void mainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.black);
		
		reservationPanel = new JPanel(new BorderLayout());
		reservationPanel.setBackground(Color.gray);
		
		mainPanel.add(reservationPanel);
		
		this.add(mainPanel);

		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.gray);
		
		//메뉴버튼
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
		
		//좌석 버튼들이 배치될 패널
		JPanel seatPanel = new JPanel(new GridLayout(3, 3));
		seatPanel.setBackground(Color.gray);
		
		seatButtonListener seatListener = new seatButtonListener();
		checkButtonListener checkListener = new checkButtonListener();
		
		//좌석 버튼
		seat1 = new JButton();
		new decorateButton(seat1, seatPanel, "1번", 80, 80, 80, seatListener);
		seat2 = new JButton();
		new decorateButton(seat2, seatPanel, "2번", 80, 80, 80, seatListener);
		seat3 = new JButton();
		new decorateButton(seat3, seatPanel, "3번", 80, 80, 80, seatListener);
		seat4 = new JButton();
		new decorateButton(seat4, seatPanel, "4번", 80, 80, 80, seatListener);
		seat5 = new JButton();
		new decorateButton(seat5, seatPanel, "5번", 80, 80, 80, seatListener);
		seat6 = new JButton();
		new decorateButton(seat6, seatPanel, "6번", 80, 80, 80, seatListener);
		seat7 = new JButton();
		new decorateButton(seat7, seatPanel, "7번", 80, 80, 80, seatListener);
		seat8 = new JButton();
		new decorateButton(seat8, seatPanel, "8번", 80, 80, 80, seatListener);
		seat9 = new JButton();
		new decorateButton(seat9, seatPanel, "9번", 80, 80, 80, seatListener);
		
		reservationPanel.add(seatPanel, BorderLayout.CENTER);
		
		JPanel checkPanel = new JPanel();
		checkPanel.setBackground(Color.gray);
		
		checkButton = new JButton();
		new decorateButton(checkButton, checkPanel, "예약", 80, 80, 80, checkListener);
		checkButton.setPreferredSize(new Dimension(100, 50));
		
		reservationPanel.add(checkPanel, BorderLayout.SOUTH);
	}
	
	public void reservationCheckPanel() {
		reservationCheckPanel = new JPanel();
		reservationCheckPanel.setBackground(Color.LIGHT_GRAY);
		
		this.add(reservationCheckPanel);
	}
	
	public class seatButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton clickSeat = (JButton) e.getSource();
			sentence.setText(clickSeat.getText() + " 좌석이 선택되었습니다.");
		}
	}
	
	public class checkButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}

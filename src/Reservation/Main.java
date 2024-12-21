package Reservation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
 *            <li>2024.12.22 07:00 패널 별도의 메소드로 분리 분리</li>
 *            </ul>
 */
public class Main extends JFrame {
	public JPanel mainPanel, reservationPanel;
	
	public JButton menuButton, seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9;
	
	public Main() {
		this.setTitle("학생식당");
		this.setSize(335, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.green);
		
		this.setLayout(new CardLayout());

		//자리 예약을 할 수 있는 패널
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.black);
		
		reservationPanel = new JPanel(new BorderLayout());
		reservationPanel.setBackground(Color.gray);
		
		mainPanel.add(reservationPanel);
		
		this.add(mainPanel);

		this.setVisible(true);
	}
	
	public void topPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.gray);
		
		//메뉴버튼
		ImageIcon listIcon = new ImageIcon("img/menuButton.png");
		menuButton = new JButton(listIcon);
		menuButton.setPreferredSize(new Dimension(40, 40));
		menuButton.setBorder(null);
		topPanel.add(menuButton);
		
		reservationPanel.add(topPanel, BorderLayout.NORTH);
	}
	
	public void centerPanel() {
		JPanel seatPanel = new JPanel(new GridLayout(3, 3));
		seatPanel.setBackground(Color.gray);
		
		seat1 = new JButton();
		new decorateButton(seat1, seatPanel, "1번", 80, 80, 80);
		seat2 = new JButton();
		new decorateButton(seat2, seatPanel, "2번", 80, 80, 80);
		seat3 = new JButton();
		new decorateButton(seat3, seatPanel, "3번", 80, 80, 80);
		seat4 = new JButton();
		new decorateButton(seat4, seatPanel, "4번", 80, 80, 80);
		seat5 = new JButton();
		new decorateButton(seat5, seatPanel, "5번", 80, 80, 80);
		seat6 = new JButton();
		new decorateButton(seat6, seatPanel, "6번", 80, 80, 80);
		seat7 = new JButton();
		new decorateButton(seat7, seatPanel, "7번", 80, 80, 80);
		seat8 = new JButton();
		new decorateButton(seat8, seatPanel, "8번", 80, 80, 80);
		seat9 = new JButton();
		new decorateButton(seat9, seatPanel, "9번", 80, 80, 80);
		
		reservationPanel.add(seatPanel, BorderLayout.CENTER);
	}
	
	public void bottomPanel() {
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}

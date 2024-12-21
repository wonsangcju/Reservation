package Reservation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class decorateButton {
	
	/**
	 * 버튼의 배경색, 글자색, 크기를 변경, 테두리를 제거, 액션리스너를 추가하는 클래스
	 * 
	 * @param panel 추가하고 싶은 패널
	 * @param button 변경하고 싶은 버튼
	 * @param text 변경될 버튼의 문구
	 * @param r, g, b 버튼의 배경색 rgb값
	 * @param listener 버튼에 사용될 액션리스너
	 * 
	 * @changelog
	 * <ul>
	 * 	<li>2024.12.22 06:00 최초 생성</li>
	 * </ul>
	 */
	public decorateButton(JButton button, JPanel panel, String text, int r, int g, int b/*, ActionListener listener*/) {
		button.setText(text);
		button.setPreferredSize(new Dimension(100, 100));
		button.setFont(new Font("Seoge UI", Font.PLAIN, 17));
        button.setForeground(Color.white); // 글자색 설정
        button.setBackground(new Color(r, g, b)); // 배경색 설정
        button.setBorder(null); // 테두리 제거
        //button.addActionListener(listener); // 리스너 추가
        panel.add(button);
	}
}
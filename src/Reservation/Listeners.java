package Reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Listeners {
	/**
	 * 리스너를 모아놓은 클래스
	 * 
	 * @changelog
	 * <ul>
	 * 	<li>2024.12.23 23:00 최초 생성</li>
	 * </ul>
	 */
    private Main mainApp;

    public Listeners(Main mainApp) {
        this.mainApp = mainApp;
    }

    //좌석 버튼 리스너
    public class SeatButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton clickedSeat = (JButton) e.getSource();
            mainApp.selectedSeat = clickedSeat.getText();
            mainApp.sentence.setText(mainApp.selectedSeat + " 좌석이 선택되었습니다.");
        }
    }

    //예약확인 버튼 리스너
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

    //예약취소 버튼 리스너
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

    //홈 버튼 리스너
    public class HomeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainApp.cardLayout.show(mainApp.getContentPane(), "Main");
        }
    }
}

package db.member;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* 자바에서는 이벤트 리스너의 메소드가 3개 이상 일 시, 
 * 개발자 대신 메소드 재정의 의무를 짊어진 어뎁터 클래스를 지원.
 * 예) KeyListener-> KeyAdapter
 * 		WindowListener-> WindowAdapter
 * 		MouseListener-> MouseAdapter*/
public class MyWindowAdapter extends WindowAdapter{
	// 이미 adapter가 재정의 의무를 다 했기 때문에 필요한 메소드만 오버라이드 하면 된다.
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}
}

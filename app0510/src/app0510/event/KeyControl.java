package app0510.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// JVM이 KeyEvent 객체를 생성하면 아래의 리스너에게 이벤트 객체를 전달하므로, 키보드와 관련된 작업을 할 수 있음
public class KeyControl implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Keytyped 호출");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KeyPressed 호출");	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("KeyReleased 호출");	
		
	}
	
}

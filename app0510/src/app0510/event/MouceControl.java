package app0510.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouceControl implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked 호출");	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed 호출");	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased 호출");	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered 호출");	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited 호출");	
	}
	
}

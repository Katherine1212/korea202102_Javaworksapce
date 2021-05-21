package app0513.paint;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// 그림 그릴 곳
public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener{
	boolean flag= false;
	public MyCanvas() {
		// 리스너 연결
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	@Override
	public void paint(Graphics g) {
		if(flag) {
			g.fillOval(100, 100, 2, 2); // 채워진 원. 즉 점을 표현.(그림판은 결국 픽셀이 모여진 것이니까)			
		}
	}
	
	public void mouseDragged(MouseEvent e) { // 마우스모션리스너
		// System.out.println("mouseDragged");
		flag= true;
		repaint(); // 간접적으로 paint등장	
	}
	public void mouseMoved(MouseEvent e) {}
	// 마우스 누른 것을 때면 그림 그리기 불가
	public void mouseReleased(MouseEvent e) {
		// System.out.println("그림끝");
		flag= false;
	}


	
	public void mousePressed(MouseEvent e) {} // 마우스 누를 시 그림 그리기
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}


	
}

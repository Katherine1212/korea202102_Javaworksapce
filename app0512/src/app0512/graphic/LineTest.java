package app0512.graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

// 자바의 모든 컴포넌트는 스스로 그림의 주체(화가)이자 그림의 대상(도화지)임.
public class LineTest extends JFrame{
	/*자바의 모든 컴포넌트는 부모 GUI 객체로부터 paint메소드를 물려받아, 자기 자신에게 알맞는 그림을 스스로 그린 것이다. 
	 * 특히 그림 그리는 메소드인 Paint메소드에는 붓만으로는 그림을 그릴 수 없기 때문에
	 * 팔레트 역할을 수행하는 Graphics객체가 인수로 넘어옴
	 * 특히, 시스템 즉 컴포넌트에 의한 그림이 아닌 개발자가 주도하여 그림을 그리려면
	 * pain메소드를 재정의 즉 오버라이드 하면 된다.*/
	public void paint(Graphics g) {
		// System.out.println("Print메소드 호출");
		g.drawLine(100, 50, 250, 380); // 선
		g.drawOval(100, 200, 100, 100); // 원
		g.drawRect(10, 250, 80, 80); // 사각형
		g.fillOval(30, 300, 90, 90); // 채워진 원
		// 색상처리
		g.setColor(Color.BLUE);
		g.fillRect(300, 200, 50, 100);
		// 텍스트
		g.drawString("Apple", 20, 400);
	}
	public LineTest() {
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new LineTest();
	}
}

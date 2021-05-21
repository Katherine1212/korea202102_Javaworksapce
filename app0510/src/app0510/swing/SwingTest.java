package app0510.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/* 
 * 
 * */
public class SwingTest extends JFrame {
	JButton bt; // has a 관계
	public SwingTest() {
		/* 특히 has a 관계를 다른 객체를 보유할 경우, 개발자는 생성자를 적극활용
		 * WHy? has a 란 부품을 보유한 관계이므로 해당 본체가 태어날 때 생성되야함 */
		bt= new JButton("Button");
		this.setSize(new Dimension(300,400));
		this.add(bt);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		/* Swing은 윈도우 창 닫기 버튼을 setVisible(false)로만 바꾸는 것일뿐 콘솔에는 살아있음
		 * 해결책 1. 이벤트를 구현 2. 알맞는 메소드 호출*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SwingTest();
	}
}

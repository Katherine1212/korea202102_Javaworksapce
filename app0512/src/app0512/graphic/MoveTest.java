package app0512.graphic;
// 캔버스에 채워진 원을 하나 그리고, 버튼에 의해 원이 x축 방향으로 이동.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveTest extends JFrame implements ActionListener{
	JPanel p_north;
	MyButton bt;
	MyCanvas can;
	int x=0; // 원의 x좌표
	public MoveTest() {
		p_north= new JPanel();
		bt= new MyButton("Move");
		can= new MyCanvas(this);
		// 스타일, 레이아웃
		can.setBackground(Color.red);
		// 조립
		p_north.add(bt);
		
		add(p_north,BorderLayout.NORTH);
		add(can);
		
		//버튼과 리스너의 연결
		bt.addActionListener(this);
		// 보여주기
		setBounds(1000, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// 물리량 변화
	public void tick() {
		x=x+10;
		System.out.println(x);
	}
	public void render() {
		can.repaint(); // update()->paint()
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		tick();		
		render();
	}
	public static void main(String[] args) {
		new MoveTest();
	}
}

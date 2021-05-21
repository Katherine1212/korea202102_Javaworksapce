package app0513.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Photoshop extends JFrame {
	JPanel p_north;
	JButton bt_eraser;
	Color[] colorArray= {Color.RED, Color.ORANGE, Color.YELLOW, Color.GRAY, 
			Color.BLUE, Color.CYAN,Color.PINK};
	MyCanvas can;
	public Photoshop() {
		// 생성
		p_north= new JPanel();
		bt_eraser= new JButton("지우기");
		// 7가지 색상
		for(int i=0; i<7; i++) {
			ColorPicker colorbox= new ColorPicker(colorArray[i]);
			p_north.add(colorbox);
		}
		can= new MyCanvas(); // 그림판
		// 스타일, 레이아웃
		p_north.setPreferredSize(new Dimension(700, 50));
		can.setBackground(Color.WHITE);
		// 조립
		p_north.add(bt_eraser);
		add(p_north,BorderLayout.NORTH);
		add(can);
		// 기본
		setBounds(300, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Photoshop();
	}
}

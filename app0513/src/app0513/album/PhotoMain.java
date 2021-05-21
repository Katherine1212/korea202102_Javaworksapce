package app0513.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoMain extends JFrame {
	JPanel p_north; // 상단 썸네일 붙일 패널
	XCanvas canvas; // 하단에 큰 이미지를 나타 낼 캔버스
	// 상단 썸네일
	String dir= "D:\\Workspace\\korea202102_Javaworksapce\\app0513\\res\\image\\";
	String [] pathArray= {"a1.png","a2.png","a3.png","a4.png","a5.jpeg","a6.png","a7.jpeg","a8.png","a9.jpg","a10.png"};
	ThumbPanel [] thumbnail= new ThumbPanel[pathArray.length];
	public PhotoMain() {
		// 생성
		p_north= new JPanel();
		canvas= new XCanvas();
		// 썸네일 생성
		for(int i=0; i<pathArray.length; i++) {
			thumbnail[i]= new ThumbPanel(dir+pathArray[i], canvas); 				
		}
		// 스타일, 레이아웃
		p_north.setBackground(Color.PINK);
		p_north.setPreferredSize(new Dimension(600,70));
		canvas.setBackground(Color.DARK_GRAY);
		// 조립
		for(int i=0; i<pathArray.length; i++) {
			p_north.add(thumbnail[i]);			
		}
		add(p_north,BorderLayout.NORTH);
		add(canvas);
		
		// 기본
		canvas.createImage(dir+pathArray[0]);
		setBounds(600, 100, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new PhotoMain();
	}
}

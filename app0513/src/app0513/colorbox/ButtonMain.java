package app0513.colorbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonMain extends JFrame implements ActionListener{
	JPanel p_north;
	JTextField t_ea;
	JButton bt_create;
	JButton bt_make;
	JButton bt_bg;
	JPanel p_center;
	JButton [] btArray; // ea는 멤버변수라 아직 생성 전. new불가
	int count=0; // 버튼 수 세기 위해
	
	/* 배열이 나쁜 것은 아니지만, 선언 시 크기를 정한다는 것은 프로그램 개발 시 유연성에 있어 불편함. 
	 * js처럼 배열 크기가 동적으로 늘어날 수 있는 객체가 있는가? o */
//	JButton[] btArray2;
	// 배열과 거의 같지만 크기가 동적으로 변할 수 있는 컬렉션프레임웍 중 List로 간다.
	ArrayList<JButton> list= new ArrayList<JButton>(); // 현재는 0이지만 늘어날 수 있음.
	public ButtonMain() {
		// 생성
		p_north= new JPanel();
		t_ea= new JTextField(10);
		bt_create= new JButton("일괄 생성하기");
		bt_make= new JButton("낱개 생성하기");
		bt_bg= new JButton("배경색");
		p_center= new JPanel();
		// 스타일, 레이아웃
		p_center.setPreferredSize(new Dimension(500,50));
		p_center.setBackground(Color.PINK);
		// 조립
		p_north.add(t_ea);
		p_north.add(bt_create);
		p_north.add(bt_make);
		p_north.add(bt_bg);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		// 리스너 연결
		bt_create.addActionListener(this);
		bt_make.addActionListener(this);
		bt_bg.addActionListener(this);
		// 기본설정
		setBounds(300, 100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void create() {
		// 1. 텍스트필의 값 구하기
		int ea= Integer.parseInt(t_ea.getText()); // ""벗겨내기
		btArray= new JButton[ea]; // 배열 크기 결정짓기
		// 2. 개수만큼 버튼 생성하여 p_center에 붙이기
		for(int i=0; i<ea; i++) {
			JButton bt= new JButton("버튼"+i);
			p_center.add(bt);
			btArray[i]=bt;
		}
		p_center.updateUI(); // 다시 그리기
		
	}
	public void makeBt(){
		// 누를 때 마다 누적 처리
		JButton bt= new JButton("버튼"+count);
		p_center.add(bt);
		p_center.updateUI();
		// 추후 배경색 버튼 눌렀을 때 모든 버튼 색을 변경하기 위해 배열화 후 for문
		list.add(bt);
		count++;
	}
	public void setBg() {
		/* 배열 사용 시
		//배열에 들어있는 버튼 수 만큼 배경색 적용 
			for(int i=0;i<btArray.length;i++) {
				btArray[i].setBackground(Color.RED);
			}
		*/
		// List사용 시
		for(JButton btn:list) {
			btn.setBackground(Color.RED);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== bt_create) {
			create();
		}else if(e.getSource()==bt_make) {
			makeBt();
		}else if(e.getSource()== bt_bg) {
			setBg();
		}
	}
	
	public static void main(String[] args) {
		new ButtonMain();
	}
}

package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientB extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	
	private JTextArea area2; // ChatClientA 가 보유한 area 값
	
	//생성자도 메서드이다!!!따라서 매개변수 전달이 가능함!!
		public ChatClientB(ChatClientA chatA) {
			//this.area2=area2;
			this.area2=chatA.area;
		// 생성
		area= new JTextArea();
		scroll= new JScrollPane(area);
		t_input= new JTextField(24);
		
		// 레이아웃, 스타일
		setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(Color.CYAN);
		
		// 조립
		add(scroll);
		add(t_input);
		
		// 이벤트 연결
		t_input.addKeyListener(this);
		//  보여주기
		setBounds(600, 100, 300, 400);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			showText();
		}
	}
	//setter
	public void setArea2(JTextArea area) {
		area2=area;
	}
	public void showText() {
		String msg= t_input.getText(); // 1) 나의 텍스트 필드 값 구하기
		area.append(msg+"\n"); // 2) 나의 TextArea에 누적
		// 3) ChatClietnA의 TextArea에 누적
		area2.append(msg+"\n");
		t_input.setText("");// 4) 입력값 초기회
	}
}

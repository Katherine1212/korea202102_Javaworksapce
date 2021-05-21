package app0511.chat.copy.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt, bt_open;
	ChatClientB cb; // 내가 제어하고 싶은 상대방창에 대한 레퍼런스 변수
	public ChatClientA() {
		// 생성
		bt_open= new JButton("open");
		area= new JTextArea();
		scroll= new JScrollPane(area);
		t_input= new JTextField(18);
		bt= new JButton("send");
		// 스타일, 레이아웃
		this.setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(new Color(250,225,0));
		// 조립
		add(bt_open);
		add(scroll);
		add(t_input);
		add(bt);
		// 이벤트 리스너와 연결
		bt.addActionListener(this);
		bt_open.addActionListener(this);		
		t_input.addKeyListener(this);

		// 보여주기
		setBounds(300, 100, 300, 400); //x,y, width, height
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		int key= e.getKeyCode();
		if(key== KeyEvent.VK_ENTER) {
			showText();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 열기 버튼 누를 시
		if(e.getSource()==bt_open) {
//			System.out.println("파일을 열겠습니까?");
			// chatclientB 가 태어나도록
			cb =new ChatClientB(this);
			// cb.setArea2(area);
		}else if(e.getSource()==bt) { // 전송 버튼 누를 시
//			System.out.println("전송하시겠습니까?");
			showText();
		}
	}
	// 전송처리
	public void showText(){	
		String msg= t_input.getText(); // 1) TextField 값 가져오기
		area.append(msg+"\n"); // 2) TextArea에 누적		
		t_input.setText(""); // 3) 기존 입력값 초기화
		cb.area.append(msg+"\n");// 4) 상대방 채팅창의 area.append();
	}
	public static void main(String[] args) {
		new ChatClientA();
	}
}

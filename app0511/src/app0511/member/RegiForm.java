package app0511.member;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegiForm extends JFrame implements ActionListener {
	JPanel p_title;
	JLabel la_title;
	
	JLabel la_id;
	JTextField t_id;
	
	JLabel la_pass;
	JPasswordField t_pass;
	
	JLabel la_hobby;
	JPanel p_hobby;
	JCheckBox[] ch_hobby;
	
	JPanel p_mail;
	JLabel la_mail;
	JTextField t_mailID;
	JLabel la_at;
	Choice ch_server;
	
	JPanel p_receive;
	JLabel la_receive;
	CheckboxGroup g;
	JButton bt_regist;
	
	
	public RegiForm() {
		//[생성]
		// 타이틀
		p_title= new JPanel();
		la_title= new JLabel("회원가입");
		// ID
		la_id= new JLabel("ID");
		t_id= new JTextField();
		// Password
		la_pass= new JLabel("Password");
		t_pass= new JPasswordField();
		// 취미
		la_hobby= new JLabel("취미 선택");
		p_hobby= new JPanel(); // 취미 checkbox 담을 패널
		ch_hobby= new JCheckBox[5]; // 빈공간만 생성
		ch_hobby[0]= new JCheckBox("운동");
		ch_hobby[1]= new JCheckBox("독서");
		ch_hobby[2]= new JCheckBox("여행");
		ch_hobby[3]= new JCheckBox("프로그래밍");
		ch_hobby[4]= new JCheckBox("명상");
		// 메일
		la_mail= new JLabel("이메일");
		p_mail= new JPanel();
		t_mailID= new JTextField();
		la_at= new JLabel("@");
		ch_server= new Choice();
		ch_server.add("gmail.com");
		ch_server.add("naver.com");
		ch_server.add("daum.net");
		ch_server.add("Direct Insert");
		// 메일 수신 여부
		p_receive= new JPanel();
		la_receive= new JLabel("메일 수신");
		g= new CheckboxGroup(); // 체크박스를 그룹으로 묶기 위한 객체
		// 버튼
		bt_regist= new JButton("회원가입");
		
		
		// [스타일, 레이아웃]
		Dimension d= new Dimension(100,30);
		setLayout(new FlowLayout());
		// Title
		la_title.setFont(new Font("돋움", Font.BOLD,28));
		p_title.setPreferredSize(new Dimension(400,50));
		// ID
		la_id.setPreferredSize(d);
		t_id.setPreferredSize(new Dimension(350,30));
		// Password
		la_pass.setPreferredSize(d);
		t_pass.setPreferredSize(new Dimension(350,30));
		// 취미
		p_hobby.setPreferredSize(new Dimension(400,50));
		// 메일
		la_mail.setPreferredSize(d);
		t_mailID.setPreferredSize(new Dimension(120,30));
		la_at.setPreferredSize(new Dimension(30,30));
		ch_server.setPreferredSize(new Dimension(150,30));
		// 메일 수신
		la_receive.setPreferredSize(d);
		p_receive.setPreferredSize(new Dimension(350,30));
		
		// [조립]
		// Title
		p_title.add(la_title);
		add(p_title);
		// ID
		add(la_id);
		add(t_id);
		// Password
		add(la_pass);
		add(t_pass);
		// 취미
		add(la_hobby);
		for(int i=0; i<ch_hobby.length; i++) {
			p_hobby.add(ch_hobby[i]);			
		}
		add(p_hobby);
		// 메일
		add(la_mail);
		p_mail.add(t_mailID);
		p_mail.add(la_at);
		p_mail.add(ch_server);
		add(p_mail);
		// 메일 수신
		add(la_receive);
		p_receive.add(new Checkbox("Yes",g,true));
		p_receive.add(new Checkbox("No",g,false));
		add(p_receive);
		// 버튼
		add(bt_regist);
		
		// [이벤트소스와 리스너 연결]
		bt_regist.addActionListener(this);
		
		// [보여주기(화면 중앙으로)]
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void checkValue() {
		// JOptionPane.showMessageDialog(this, "유효성체크 시작");
		/* [비밀번호]
		String str= t_pass.getText(); // 차후버전에서는 지원x
		System.out.println("당신이 입력한 비밀번호는 "+str);  // 비밀번호가 뜨지만, 사용x 
		[해결책]
		char[] pass= t_pass.getPassword(); // char 배열로 받은 후 string으로 변환
		String data= new String(pass); 
		System.out.println("당신이 입력한 비밀번호는 "+data); 
		더 간략하게는 하단처럼 작성*/
		String data= new String(t_pass.getPassword()); 
		// 5개 체크박스를 대상으로 조사
		//System.out.println("0번째 체크박스의 상태는 "+ch_hobby[0].isSelected());
		int count= 0;
		for(int i=0; i<ch_hobby.length; i++) {
			if(ch_hobby[i].isSelected()) {
				count++;
			}
		}
		
		// [유효성 체크]
		// System.out.println("입력한 값은= "+t_id.getText().length());
		if(t_id.getText().length()==0) {
			JOptionPane.showMessageDialog(this, "ID를 입력하십시오.");
			t_id.requestFocus(); // 커서올리기
		}else if(data.length()<8) {
			JOptionPane.showMessageDialog(this, "비밀번호는 8자 이상 입력하십시오.");
			t_pass.requestFocus(); // 커서올리기
		}else if(count<1){
			JOptionPane.showMessageDialog(this, "1개 이상의 취미를 선택 해 주세요.");
		}else{
			// 오라클 DB입력
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		checkValue();
		
	}
	public static void main(String[] args) {
		new RegiForm();

	}

}

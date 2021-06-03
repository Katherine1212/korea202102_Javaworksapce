package com.minssam.shoppingapp.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.minssam.shoppingapp.configure.ConfigureMain;
import com.minssam.shoppingapp.cs.CustomerMain;
import com.minssam.shoppingapp.member.JoinForm;
import com.minssam.shoppingapp.member.LoginForm;
import com.minssam.shoppingapp.member.MemberMain;
import com.minssam.shoppingapp.order.OrderMain;
import com.minssam.shoppingapp.product.ProductMain;

public class AppMain extends JFrame implements ActionListener {
	JPanel p_north;
	String[] menu_title= {"상품관리","회원관리","주문관리","고객센터","Login","환경설정"};
	CustomButton[] bt_menu=new CustomButton[menu_title.length]; // 배열생성
	
	// 페이지를 교체하기 위한 패널
	JPanel p_center;
	// 페이지 선언
	Page[] pages= new Page[7];

	// DB관련
	String driver= "com.mysql.jdbc.Driver";
	String url= "jdbc:mysql://localhost:3306/shoppingapp?characterEncoding=UTF-8";
	String user= "root";
	String password= "1234";
	private Connection con;
	private boolean session; // 세션이 t일 때 인증 받은 것, f는 미인증
	
	public AppMain() {
		connect(); // DB 연결
		// -----------------------------------------------[생성]
		p_north= new JPanel();
		for(int i=0; i<menu_title.length; i++) {
			bt_menu[i]= new CustomButton(menu_title[i]);
			bt_menu[i].setId(i);
		}
		// 센터
		p_center= new JPanel();
		pages[0]= new ProductMain(this); // 상품관리 페이지
		pages[1]= new MemberMain(this); // 회원관리 페이지
		pages[2]= new OrderMain(this); // 주문관리 페이지
		pages[3]= new CustomerMain(this); // 고객센터
		pages[4]= new LoginForm(this); // 로그인
		pages[5]= new ConfigureMain(this); // 환경설정
		pages[6]= new JoinForm(this); // 회원가입
		
		// -----------------------------------------------[조립]
		// improved for loop: 주로 집합된 데이터형식을 대상으로 한 개선된 for문
		for(JButton bt:bt_menu) {
			p_north.add(bt);
		}
		add(p_north,BorderLayout.NORTH);
		// 센터
		for(Page p: pages) {
			p_center.add(p);
		}
		add(p_center);
		
		// -----------------------------------------------[리스너]
		// 윈도우 리스너(창닫기용)
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disconnect(); // DB접속 해제
				System.exit(0); // kill process
			}
		});
		// 액션리스너(버튼)
		for(int i=0; i<bt_menu.length; i++) {
			bt_menu[i].addActionListener(this);
		}
		
		// -----------------------------------------------[화면]
		// 인증여부에 따라 알맞는 페이지 띄우기
		if(session== false) { // 인증받지 않은 상태
			showHide(4); // 첫화면에 띄울 페이지 설정			
		}else { // 인증 받은 상태
			showHide(0);
		}
		setBounds(700, 100, 1200, 700);
		setVisible(true);
		
		
	}
	// -----------------------------------------------[액션리스너]
	public void actionPerformed(ActionEvent e) {
		Object obj= e.getSource();
		/*obj는 오브젝트 자료형이기때문에 버튼을 가리킬 수 있지만 버튼보단 보편적 기능만 보유
		 * 즉, 가진게 별로 없기에 버튼특징을 이용하기 위해서는 버튼형으로 변환*/
		CustomButton bt=(CustomButton)obj; // down casting
		if(session) {
			showHide(bt.getId());			
		}else {
			JOptionPane.showMessageDialog(this, "로그인이 필요한 서비스입니다.");
		}
		
	}
	// -----------------------------------------------[MYSQL]
	// DB연결
	public void connect() {
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url, user, password);
			if(con!=null) {
				this.setTitle("접속 성공");
			}else {
				this.setTitle("접속 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// DB 연결 해제
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 쿼리문이 DML인 경우
	public void release(PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// select문인 경우
	public void release(PreparedStatement pstmt, ResultSet rs) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Connect 넘기기 위해 (getter)
	public Connection getCon() {
		return con;
	}
	public void showHide(int n) { // 보여주고 싶은 페이지 번호 넘기기
		// 누른 버튼에 맞는 화면 출력
				for(int i=0; i<pages.length; i++) {
					if(n== i) {
						pages[i].setVisible(true);				
					}else {
						pages[i].setVisible(false);				
					}
				}		
	}
	// -----------------------------------------------[세션의 게터세터]
	// 논리값은 is로 사용(get아님)
	public boolean isSession() {
		return session;
	}
	public void setSession(boolean session) {
		this.session = session;
	}
	// -----------------------------------------------[메인]
	public static void main(String[] args) {
		new AppMain();
	}

}

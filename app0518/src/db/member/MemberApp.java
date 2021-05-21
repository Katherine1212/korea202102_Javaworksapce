package db.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberApp extends JFrame{
	JPanel p_north, p_west, p_center;
	// 북쪽
	JTextField t_url, t_port;
	JButton bt_connect;
	// 서쪽
	JTextField t_user_id;
	JPasswordField t_pass;
	JTextField t_name;
	JButton bt_regist, bt_list;
	// 센터
	JTextArea area;
	JScrollPane scroll;
	Connection con;
	public MemberApp() {
		// [생성]
		p_north= new JPanel();
		p_west= new JPanel();
		p_center= new JPanel();
			// 북쪽
		t_url= new JTextField();
		t_port= new JTextField();
		bt_connect= new JButton("접속");
			// 서쪽
		t_user_id= new JTextField(15);
		t_pass= new JPasswordField(15);
		t_name= new JTextField(15);
		bt_regist= new JButton("등록");
		bt_list= new JButton("목록");
			// 센터
		area= new JTextArea();
		scroll= new JScrollPane(area);
		
		// [스타일&레이아웃]
		t_url.setPreferredSize(new Dimension(470,25));
		t_port.setPreferredSize(new Dimension(120,25));
		
		p_west.setPreferredSize(new Dimension(200,550));
		p_west.setBackground(Color.LIGHT_GRAY);
		
		// [조립]
		p_north.add(t_url);
		p_north.add(t_port);
		p_north.add(bt_connect);
		add(p_north,BorderLayout.NORTH);
		
		p_west.add(t_user_id);
		p_west.add(t_pass);
		p_west.add(t_name);
		p_west.add(bt_regist);
		p_west.add(bt_list);
		add(p_west,BorderLayout.WEST);
		
		add(scroll);
		
		// -------------- [액션리스너 연결]
		
		// 접속
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		// 등록
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
				area.setText("");
				getList();
			}
		});
		// 목록
		bt_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getList();
			}
		});
		
		// -------------- [윈도우 리스너연결]
		// 어뎁터의 존재+익명클래스를 이용하면 많은 메소드를 거느린인터페이스 코드를 줄일 수 있다.
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.print("나 닫아유");
				disConnect();
				System.exit(0);
			}
		});
		
		//보여주기
		setSize(700,600);
		setVisible(true);
		/*아래의 메소드는 윈도우 창 닫을 때 무언가를 반환 할 것이 있을 시 반환이 안 됨.
		 * 이때는 WindowListener의 windowClosing()메소드에서 반납할 자원등을 처리 해야함.
		setDefaultCloseOperation(EXIT_ON_CLOSE); */
	}
	// 등록
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			area.append("드라이버 로드 성공\n");
			String url="jdbc:mysql://"+t_url.getText()+":"+t_port.getText()+"/javase?characterEncoding=UTF-8";
			con= DriverManager.getConnection(url, "root", "1234");
			if(con!=null) {
				area.append("접속 성공\n");
			}else {
				area.append("접속 실패\n");
			}
		} catch (ClassNotFoundException e) {
			area.append("드라이버 로드 실패\n");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//---------- 리스너 내 함수
	// sql실행
	public void regist() {
		PreparedStatement pstmt= null;
		String sql= "insert into member(user_id, password, name) values(?,?,?)";
		try {
			pstmt= con.prepareStatement(sql);
			
			// 바인드 변수값 설정
			pstmt.setString(1, t_user_id.getText());
			// password는 char배열로 생성 후 다시 String으로 변환
			String pass= new String(t_pass.getPassword());
			pstmt.setString(2, pass);
			pstmt.setString(3, t_name.getText());
			
			int result= pstmt.executeUpdate();
			if(result==1) {
				area.append("회원 등록 성공\n");
			}else {
				area.append("회원 등록 실패\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// 목록 출력
	public void getList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from member";
		
		try {
			pstmt=con.prepareStatement(sql);//쿼리 수행 객체 생성
			rs=pstmt.executeQuery();//수행할 쿼리가 select문 인경우 ResultSet 반환됨
			
			//rs의 커서를 움직여가면서, 모든 레코드에 접근하여 area에 출력해보자!!
			while(rs.next()){//커서 한칸 전진!!
				//현재 커서가 가리키는 레코드를 컬럼명으로 접근해보자!!
				int member_id = rs.getInt("member_id");
				String user_id = rs.getString("user_id");
				String password = rs.getString("password");
				String name =rs.getString("name");
				String regdate = rs.getString("regdate");
				
				area.append(member_id+"\t"+user_id+"\t"+password+"\t"+name+"\t"+regdate+"\n");
				area.append("-------------------------------------------------------------------------------------------------------------------------- \n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}
		}
	}
	// 접속해제
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new MemberApp();
	}
}

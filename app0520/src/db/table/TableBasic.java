package db.table;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

// DBMS등의 표형식(2차원 구조)의 데이터를 표현하는데 최적화 된 JTable이용
public class TableBasic extends JFrame{
	// JTable 생성자 중, 레코드는 2차원 배열로, 컬럼의 제목은 1차원 배열로 지원하는 3번째 생성자를 이용.
	String[] colums= {"member_id","user_id","password","name","regdate"};
	String [][] rows= {}; // db서 받아옴
	JTable table;
	JScrollPane scroll;
	
	// MYSQL
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user= "root";
	String password= "1234";
	Connection con;
	
	public TableBasic() {
		// MYSQL
		// JTable이 사용할 이차원 배열 먼저 구해야 하므로
		connect(); // MYSQL연결
		// 생성
		table= new JTable(rows,colums);
		scroll= new JScrollPane(table);
		// 리스너
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		// 조립
		add(scroll);
		// 보여주기
		setBounds(900, 100, 500, 250);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);// DB 연동시 주석처리
		
	}
	// DB 가져오기
	public void connect() {
		/* 1. 드라이버로드
		 * 2. 접속
		 * 3. 쿼리수행
		 * 4. 자원 해제*/
		try {
			// DB로드
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(this, "드라이버 로드 성공.");
			// 접속
			con= DriverManager.getConnection(url,user,password);
			if(con!=null) {
				select(); // select문 수행
				JOptionPane.showMessageDialog(this, "접속 성공.");
			}else {
				JOptionPane.showMessageDialog(this, "접속 실패.");
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "드라이버 로드 실패\n 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void select() {
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		String sql= "select * from member";
		
		try {
			// 쿼리 수행 객체 생성
			// 스크롤 가능하면서 읽기전용의 ResultSet을 생성
			pstmt= con.prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY); 
			
			rs= pstmt.executeQuery(); // 쿼리 실행 및 레코드 반환
			
			/* rs의 데이터를 2차원 배열로 변환해 JTable에 적용
			   rs에는 총 레코드수를 반환해 주는 메소드가 없음. 하단의 절차를 거쳐 구해야함.
			1. 커서를 레코드의 제일 마지막으로 이동. last();
			2. 마지막으로 이동 된 커서의 row넘버 구하기.(num은 몇번째 레코드인지에 대한 순번)
			만일 rowNum 이 3 이라면 3번째 데이터라는 것
			*/
			rs.last();
			int num= rs.getRow();
//			System.out.println("제 위치는 "+num);
			String[][] data= new String[num][colums.length];
			
			// rs의 레코드에 접근해서 빈 상태의 2차원 배열에 데이터 넣기
			rs.beforeFirst(); // 커서를 원상복귀
			
			int index=0;
			while(rs.next()) {// 한칸 내림
				data[index][0]= Integer.toString(rs.getInt("member_id"));
				data[index][1]= rs.getString("user_id");
				data[index][2]= rs.getString("password");
				data[index][3]= rs.getString("name");
				data[index][4]= rs.getString("regdate");
				index++;
			} 
			rows= data; // JTable이 참조할 예정인 rows의 주소값을 data이차원 배열로 대체
			
//			System.out.println(data[0][1]);
//			table.setValueAt(Integer.toString(rs.getInt("member_id")),0,0);
//			table.setValueAt(rs.getString("user_id"),0,1);
//			table.setValueAt(rs.getString("password"),0,2);
//			table.setValueAt(rs.getString("name"),0,3);
//			table.setValueAt(rs.getString("regdate"),0,3);
//			table.updateUI(); // 갱신된 데이터를 이용해 JTable도 업데이트
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TableBasic();
	}

}

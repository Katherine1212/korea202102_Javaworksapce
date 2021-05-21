package app0517.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBSelect {
	String driver="com.mysql.jdbc.Driver"; // MySQL용 드라이버 pkg
	String url="jdbc:mysql://localhost/javase?characterEncoding=UTF-8";
	String id="root";
	String pass="1234";
	Connection con; /* 접속 정보 객체. 주의, 다른 프로그래밍 언어에서는 주로 Connection객체가 접속 시도 하는 객체이지만,
	 jdbc에서는 접속 시도하는 객체가 아니라 접속 성공 후 그 접속 정보를 가진 객체이다. 
	 즉, 접속 시도는 DriveManager객체가 담당한다. 따라서, 이 객체가 null이면 접속 된 적이 없다는 것이다. */
	PreparedStatement ptstmt; // 쿼리문 객체 수행
	ResultSet rs; // select 문 수행 수 결과집합은 표 구조. 결국, 이차원 구조의 데이터 집합.
	
	public DBSelect() {
		/* 1. 드라이버 로드(jar)
		 * 2. 접속
		 * 3. 원하는 쿼리문 수행
		 * 4. DB접속 해제*/
		
		// [1] 드라이버 로드
		try { 
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			// [2] 접속
			con=DriverManager.getConnection(url, id, pass);
			if(con==null) {
				System.out.println("접속 실패");
			}else {
				System.out.println("접속 성공");
				// [3] 원하는 쿼리문 수행
				String sql= "select * from member order by member_id desc";
				ptstmt= con.prepareStatement(sql); // 쿼리문 수행 객체 생성
				/* select 문- executeQuery()메소드
				 * DML(insert, update, delete) executeUpdate()*/
				rs= ptstmt.executeQuery();
				System.out.println("반환된 객체는 "+rs);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // [4] 접속 해제
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ptstmt!=null) {
				try {
					ptstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}
	 public static void main(String[] args) {
		new DBSelect();
	}
}

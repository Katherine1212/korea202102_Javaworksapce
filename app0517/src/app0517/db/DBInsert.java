package app0517.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// MySQL DB에 레코드 넣기.
// 참고: 자바언어로 DB를 연동하는 기술을 가리켜 JDBC(Java DataBase Connectivity)
// java.sql pkg에서 대부분의 api를 제공
public class DBInsert {
	public static void main(String[] args) {
		// 0. 해당 DB에 맞는 드라이버 클래스를 로드
		/*드라이버는 각 DB벤더사의 홈페이지 또는 저장소로 부터 다운 가능.
		 * 드라이버는 jar파일 형태로 되어 있다.
		 * jar(Java Archive)*/
		try {
			/*Class.forName이란? 클래스를 static영역으로 로드하는 메소드*/
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 클래스 로드
			System.out.println("로드 성공");
		} catch (ClassNotFoundException e1) {
			System.out.println("로드 실패");
			e1.printStackTrace();
		} 
		// 1. DB접속
		// url="jdbc:sql기종://localhost:포트번호(3306이면 생략가능. 디폴트라)/선택 테이블?characterEncoding=UTF-8";
		
		String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
		String user="root";
		String pass= "1234";
		Connection con = null;
		PreparedStatement pstmt= null; // 쿼리문 수행 객체
		try {
			// 아래 코드처럼 driver매니저에 의해 접속 성공한 경우에만 conn객체 반환
			// 실패일 경우 conn객체가 반환되지 않으므로 null로 초기화.
			con =DriverManager.getConnection(url, user, pass);
			if(con== null) {
				System.out.println("접속 실패");
			}else {
				System.out.println("접속 성공");
				
				String sql="insert into member(user_id,password,name) values('jin','7897','김진아')";

				// 2. 쿼리 수행
				pstmt= con.prepareStatement(sql);
				int result= pstmt.executeUpdate(); // DML(insert, update, delete) 실행
				if(result==0) {
					System.out.println("입력 실패");
				}else {
					System.out.println("입력 성공");					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // 3. 접속 끊기
			if(pstmt!=null) {
				try {
					pstmt.close();
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
}

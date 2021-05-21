package db.table.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

// JTable이 사용 할 데이터를 TableModel이용하여 유지보수성을 개선
/*TableModel이란? JTable과 같은 디자인 영역에서 실제 데이터를 직접 접근하지 않고,
 * 중간에 계층을 두고 데이터의 조회, 입력, 수정 등를 이 중간층을 통해 작업을 하면,
 * 추후 JTable이 변경 될 때 데이터 처리하는 로직은 영향받지 않게되므로 app의 유지보수성을 높일 수 있다.
 * TableMode은 JTable이 사용하려는 데이터를 간접적으로 사용할 수 있게 되는 컨트롤러를 의미*/
public class UseModelApp extends JFrame {
	JTable table;
	JScrollPane scroll;
	JTextArea area; // 선택한 회원 나오는 창
	// 왼쪽 등록 창
	JPanel p_west;
	JTextField t_user_id;
	JPasswordField t_password;
	JTextField t_name;
	JButton bt_regist, bt_delete;
	
	
	String[] columnName= {"member_id","user_id","password","name","regdate"};
	String [][] rows= {};
	
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user= "root";
	String password= "1234";
	Connection con;
	String value; // 현재는 null, 레코드 미선택시 null
	int row; // 현재 사용자가 JTable에서 선택한 레코드의 row
	
	public UseModelApp() {
		// --------------------------------------------------- [생성]
		table= new JTable(new AbstractTableModel() { // tablemodel객체 이용가능
			// 총 레코드 수를 반환하는 메소드.(JTable이 호출)
			public int getRowCount() {
				return rows.length;
			}
			// 총 컬럼수를 반환하는 메소드.(JTable이 호출)
			public int getColumnCount() {
				return columnName.length;
			}
			public String getColumnName(int col) { // col변수에 호출 시 마다 1씩 증가
				return columnName[col];
			}
			// row, col좌표에 어떤 데이터가 있는지 반환하는 메소드.(JTable이 호출)
			public Object getValueAt(int row, int col) {
				return rows[row][col];
			}
			// 즉, JTableModel이 호출하는 모든 메소드가 다 JTable을 위한 메소드이다.
		}); 
		scroll= new JScrollPane(table);
		area= new JTextArea();
		
		// 왼쪽 등록 폼
		p_west= new JPanel();
		t_user_id= new JTextField(15);
		t_password= new JPasswordField(15);
		t_name= new JTextField(15);
		bt_regist= new JButton("등록");
		bt_delete= new JButton("삭제");
		
		// --------------------------------------------------- [스타일, 레이아웃]
		scroll.setPreferredSize(new Dimension(600,400));
		area.setPreferredSize(new Dimension(600,150));
		p_west.setPreferredSize(new Dimension(200, 400));
		// --------------------------------------------------- [조립]
		add(scroll);
		add(area,BorderLayout.SOUTH);
		// 왼쪽 등록 영역
		p_west.add(t_user_id);
		p_west.add(t_password);
		p_west.add(t_name);
		p_west.add(bt_regist);
		p_west.add(bt_delete);
		add(p_west,BorderLayout.WEST);
		// --------------------------------------------------- [리스너]
		// 마우스 리스너
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				row= table.getSelectedRow();
				int col= table.getSelectedColumn();
				value= (String)table.getValueAt(row, col);
//				area.setText("당신이 선택 한 위치는 " +row+","+col+"그 과표에 들어있는 데이터 값은 "+value);
				area.setText("");
				area.append("member_id: "+table.getValueAt(row, 0)+"\n");
				area.append("user_id: "+table.getValueAt(row, 1)+"\n");
				area.append("password: "+table.getValueAt(row, 2)+"\n");
				area.append("name: "+table.getValueAt(row, 3)+"\n");
				area.append("regdate: "+table.getValueAt(row, 4)+"\n");
				
			}
		});
		
		// 액션리스너
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});
		
		bt_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 방법1) UseModelApp을 인스턴스 변수로 선언해 사용
//				JOptionPane.showConfirmDialog(uma, "해당 회원을 삭제 하시겠습니까?");
				if(value!=null) {
					// 방법2) class명.this
					int res= JOptionPane.showConfirmDialog(UseModelApp.this, "해당 회원을 삭제 하시겠습니까?");		
					if(res==JOptionPane.OK_OPTION) {
						delete();						
					}
				}else {
					JOptionPane.showMessageDialog(UseModelApp.this, "삭제하실 회원을 선택하십시오.");
				}
			}
		});
		
		// 윈도우리스너
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(0); // 프로세스 종료
			}
		});
		// 보여주기
		setBounds(700, 100, 800, 400);
		setVisible(true);
		connect();
	}
	// --------------------------------------------------- [MYSQL]
	// DB연동
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(url, user, password);
			if(con==null) {
				JOptionPane.showMessageDialog(this, "접속실패");
			}else {
				getList();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// select문
	public void getList() {
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		String sql= "select * from member";
		
		try {
			pstmt= con.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs= pstmt.executeQuery();
			// 2차원 배열로 바꾸기
			rs.last();
			int num= rs.getRow();
			String[][] data= new String[num][columnName.length];
			rs.beforeFirst();
			int index=0;
			while(rs.next()){
				data[index][0]= Integer.toString(rs.getInt("member_id"));
				data[index][1]= rs.getString("user_id");
				data[index][2]= rs.getString("password");
				data[index][3]= rs.getString("name");
				data[index][4]= rs.getString("regdate");
				index++;
			}
			rows= data;
			table.updateUI(); // 디자인 갱신

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// --------------------------------------------------- [왼쪽 등록 영역]
	public void regist() {
		PreparedStatement pstmt= null;
		String sql= "insert into member(user_id,password,name) values(?,?,?) ";
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, t_user_id.getText());
			String pass= new String(t_password.getPassword());
			pstmt.setString(2, pass);
			pstmt.setString(3, t_name.getText());
			int result= pstmt.executeUpdate(); // DML실행에 의해 영향을 받은 레코드 수 반환(그래서 int)
			if(result==1) {
				JOptionPane.showMessageDialog(this, "회원 등록 성공");
				getList();
			}else {
				JOptionPane.showMessageDialog(this, "회원 등록 실패");
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
	public void delete() {
		PreparedStatement pstmt= null;
		int mem_id=Integer.parseInt((String)table.getValueAt(row, 0)); // 삭제할 레코드의 pk받을 변수
		String sql= "delete from member where member_id="+mem_id;
//		System.out.println(sql);
			try {
				pstmt= con.prepareStatement(sql);
				int result= pstmt.executeUpdate(); // 삭제 실행
				if(result>0) {
					JOptionPane.showMessageDialog(this, "삭제 완료");
					getList();
				}else {
					JOptionPane.showMessageDialog(this, "삭제 실패");
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
	// --------------------------------------------------- [메인]
	public static void main(String[] args) {
		new UseModelApp();
	}

}

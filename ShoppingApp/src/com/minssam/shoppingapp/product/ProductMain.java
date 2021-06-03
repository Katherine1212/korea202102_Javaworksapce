package com.minssam.shoppingapp.product;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.minssam.shoppingapp.main.AppMain;
import com.minssam.shoppingapp.main.Page;
import com.minssam.shoppingapp.model.domain.Subcategory;
import com.minssam.shoppingapp.model.domain.Topcategory;
import com.minssam.shoppingapp.util.FileManager;



public class ProductMain extends Page{
	
	// 서쪽 관련
	JPanel p_west;
	Choice ch_top;
	Choice ch_sub;
	JTextField t_product_name;
	JTextField t_price;
	JTextField t_brand;
	JTextArea t_detail;
	JScrollPane scroll;
	JButton bt_web;
	JButton bt_file;
	Canvas can;
	JButton bt_regist;
	// 센터
	JPanel p_center;
	JPanel p_search; // 검색 컴포넌트 올려두는 패널
	Choice ch_category; // 검색 카테고리
	JTextField t_keyword; // 검색어입력
	JButton bt_search; 
	JButton bt_excel;
	
	JTable table;
	JScrollPane scroll_table;
	// 동쪽 관련
	JPanel p_east;
	JTextField t_top;
	JTextField t_sub;
	JTextField t_product_name2;
	JTextField t_price2;
	JTextField t_brand2;
	JTextArea t_detail2;
	JScrollPane scroll2;
	JButton bt_web2;
	JButton bt_file2;
	Canvas can2;
	JButton bt_del;
	
	// 캔버스의 사진
	Toolkit kit= Toolkit.getDefaultToolkit();
	Image image;
	Image image2;
	JFileChooser chooser;
	String filename; // 유저의 복사에 의해 생성된 파일명
	
	// 테이블
	String[] columns= {"product_id", "subcategory_id", "product_name", "price", "brand","detail", "filename"}; // 컬럼배열
	String[][] records= {};// 레코드 배열
	
	int product_id; // 현재 상세보기중인 product_id의 pk
	String del_file;
	
	// Choice 컴포넌트는 html의 option과 달리 txt,value값을 동시에 가질 수 없음.
	// 개발자가 복합데이터 형대로 직접 만들어야함.
	ArrayList<Topcategory> topList= new ArrayList<Topcategory>(); // size 0
	ArrayList<Subcategory> subList= new ArrayList<Subcategory>(); // size 0
	
	
	
	public ProductMain(AppMain appMain) {
		super(appMain);
		// -----------------------------------------------[생성]
		// 서쪽 관련
		p_west= new JPanel();
		ch_top= new Choice();
		ch_sub= new Choice();
		t_product_name= new JTextField();
		t_price= new JTextField();
		t_brand= new JTextField();
		t_detail= new JTextArea();
		scroll= new  JScrollPane(t_detail);
		bt_web= new JButton("웹에서 파일 찾기");
		bt_file= new JButton("내 컴퓨터에서 파일 찾기");
		
		// 내부익명 클래스는 외부클래스의 멤버변수, 메소드를 접근가능.
		can= new Canvas() { // {}붙으며 extends효과
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, 180, 180, can);
			}
		};
		
		bt_regist= new JButton("상품등록");
		
		
		// 센터
		p_center= new JPanel();
		p_search= new JPanel();
		
		ch_category= new Choice();
		// 검색 카테고리 등록
		ch_category.add("Choose Category");
		ch_category.add("product_name");
		ch_category.add("price");
		ch_category.add("brand");
		
		t_keyword= new JTextField();
		bt_search= new JButton("검색");
		bt_excel= new JButton("일괄 등록");
		
		table= new JTable(new AbstractTableModel() {
			public int getRowCount() {
				return records.length;
			}
			public int getColumnCount() {
				return columns.length;
			}
			// 컬럼 제목
			public String getColumnName(int col) {
				return columns[col];
			}
			// 각 셀에 들어갈 데이터를 이차원 배열로부터 구함
			public Object getValueAt(int row, int col) {
				return records[row][col];
			}
			// JTable의 각 셀의 값을 지정
			// 셀을 편집한 후 엔터치는 순간 아래의 메소드 호출
			public void setValueAt(Object val, int row, int col) {
				records[row][col]=(String)val; 
				updateProduct();
//				System.out.println(row+","+col+"번째 셀의 데이터는 "+val+"로 바꿀게요~");
			}
			// 다른 메소드와 마친가지로, 아래의 isCe;;Editable메서드도 호출자가 JTable
			public boolean isCellEditable(int row, int col) {
				if(col==0) { // 첫번쩨 열인 product_id만 읽기전용으로 셋팅
					return false;
				}else {
					return true;
				}
			}
		});
		
		scroll_table= new JScrollPane(table);
		
		// 동쪽 관련
		p_east= new JPanel();
		t_top= new JTextField();
		t_sub= new JTextField();
		t_product_name2= new JTextField();
		t_price2= new JTextField();
		t_brand2= new JTextField();
		t_detail2= new JTextArea();
		scroll2= new  JScrollPane(t_detail2);
		bt_web2= new JButton("웹에서 파일 찾기");
		bt_file2= new JButton("내 컴퓨터에서 파일 찾기");
		can2= new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(image2, 0, 0, 180, 180, can2);
			}
		};
		bt_del= new JButton("상품삭제");
		
		// 사진 등록
		chooser= new JFileChooser("D:\\Workspace\\korea202102_jsworkspace\\class work\\Images");
		
		// -----------------------------------------------[스타일, 레이아웃]
		Dimension d= new Dimension(180, 30); // 공통크기
		setLayout(new BorderLayout());
		// 서쪽 관련
		p_west.setPreferredSize(new Dimension(200, 700));
		scroll.setPreferredSize(new Dimension(180, 180));
		can.setPreferredSize(new Dimension(180, 180));
		can.setBackground(Color.PINK);
		
		ch_top.setPreferredSize(d);
		ch_sub.setPreferredSize(d);
		t_product_name.setPreferredSize(d);
		t_price.setPreferredSize(d);
		t_brand.setPreferredSize(d);
		
		// 센터
		p_center.setLayout(new BorderLayout());
		ch_category.setPreferredSize(d);
		t_keyword.setPreferredSize(new Dimension(450, 30));
		
		// 동쪽 관련
		p_east.setPreferredSize(new Dimension(200, 700));
		scroll2.setPreferredSize(new Dimension(180, 180));
		can2.setPreferredSize(new Dimension(180, 180));
		can2.setBackground(Color.PINK);
		
		t_top.setPreferredSize(d);
		t_sub.setPreferredSize(d);
		t_product_name2.setPreferredSize(d);
		t_price2.setPreferredSize(d);
		t_brand2.setPreferredSize(d);
		
		// -----------------------------------------------[조립]
		// 서쪽 관련
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_product_name);
		p_west.add(t_price);
		p_west.add(t_brand);
		p_west.add(scroll);
		p_west.add(bt_web);
		p_west.add(bt_file);
		p_west.add(can);
		p_west.add(bt_regist);
		add(p_west,BorderLayout.WEST);
		
		// 센터
		p_search.add(ch_category);
		p_search.add(t_keyword);
		p_search.add(bt_search);
		p_search.add(bt_excel);
		p_center.add(p_search,BorderLayout.NORTH);
		p_center.add(scroll_table);
		add(p_center);
		
		// 동쪽 관련
		p_east.add(t_top);
		p_east.add(t_sub);
		p_east.add(t_product_name2);
		p_east.add(t_price2);
		p_east.add(t_brand2);
		p_east.add(scroll2);
		p_east.add(bt_web2);
		p_east.add(bt_file2);
		p_east.add(can2);
		p_east.add(bt_del);
		add(p_east,BorderLayout.EAST);
		
		// -----------------------------------------------[리스너]
		ch_top.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// 선택한 상위 카테고리의 pk값을 맞추기
				Choice ch= (Choice)e.getSource();
//				System.out.println("당신이 선택한 아이템은 "+ch.getSelectedIndex());
				// 선택한 Choice에서 아이템을 사용해 ArrayList의 객체를 꺼내자
				int index= ch.getSelectedIndex()-1;
				Topcategory topcategory= topList.get(index); // VO 1개 꺼내기
//				System.out.println("Topcategory_id  "+topcategory.getTopcategory_id());
//				System.out.println("Top_name  "+topcategory.getTop_name());
				getSubList(topcategory.getTopcategory_id());
			}
		});
		// 웹에서 파일 찾기
		bt_web.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findWeb();
			}
		});
		// 로컬에서 파일 찾기
		bt_file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findLocal();
			}
		});
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*유효성 체크통과되면 아래 메소드 호출
				 * 숫자값을 문자로 입력시 문제가 생기기때문에 이 부분만 체크
				 * 예외는 에러가 발생할 가능성이 있는, 에러가 우려가 되는 코드에 대한 안정장치.
				 * 지금까지는 컴파일 타임에(컴파일러에 의해)무조건 처리되는 예외만 사용했으나
				 * 이제부터는 실행시(런타임)관여하는 예외를 사용.
				 * 이러한 예외를 RuntimeException(런타임 예외)으로부터 상속받은 자식들이다.
				 * 강요하지않는 예외는 개발자의 선택에 의해 처리여부를 결정.
				 * 대표적인 RuntimeExeception ArrayOutofBoundException
				 */
				try {
					Integer.parseInt(t_price.getText());					
					regist();
					getProductList();
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(ProductMain.this.getAppMain(), "가격은 숫자만 입력 가능합니다.");
					t_price.setText("");
					t_price.requestFocus();
				}
				
			}
		});
		// 엑셀 버튼
		bt_excel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				registByExcel();
			}
		});
		// 검색 버튼
		bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 검색 안 하면 모든 데이터가 나오게
				if(ch_category.getSelectedIndex()==0 && t_keyword.getText().length()==0) {
					getProductList();
				}else {
					// 검색 하면 해당 검색 결과만 나오게
					getListBySearch();									
				}
			}
		});
		// 테이블 연결
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				getDetail();
			}
		});
		// 삭제 버튼
		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(ProductMain.this.getAppMain(), "선택한 상품을 삭제 하시겠습니까?")==JOptionPane.OK_OPTION) {
					deleteProduct();
				}
				
			}
		});
		
		// 생성자 호출
		getTopList();
		getProductList(); // 상품목록
		// -----------------------------------------------[화면]
		setBackground(Color.PINK);
	}
	// -----------------------------------------------[왼쪽영역 정보 가져오기]
	public void getTopList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from topcategory";
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			rs=pstmt.executeQuery(); // select 실행 후 레코드 반환
			
			ch_top.add("Choose Category");
			while(rs.next()){ // 커서 한 칸씩 이동
				ch_top.add(rs.getString("top_name"));
//				System.out.println(rs.getString("top_name"));
				// Empty상태의 인스턴스 1개 생성
				Topcategory topcategory= new Topcategory();
				topcategory.setTopcategory_id(rs.getInt("topcategory_id"));
				topcategory.setTop_name(rs.getString("top_name"));
				topList.add(topcategory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt, rs);
		}
		
//		// 확인용 로그
//		for(int i=0; i<topList.size(); i++) {
//			String item= (String)topList.get(i);
//			System.out.print(item);
//		}
	}
	public void getSubList(int topcategory_id) {
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		String sql= "select * from subcategory where topcategory_id="+ topcategory_id;
//		System.out.println(sql);
		try {
			pstmt= this.getAppMain().getCon().prepareStatement(sql);
			rs= pstmt.executeQuery();
			ch_sub.removeAll(); // 아이템 싹 제거
			subList.removeAll(subList); // ArrayList의 모든 요소 제거
			// 채워넣기
			ch_sub.add("Choose Subcategory");
			while(rs.next()) {
				Subcategory subcategory= new Subcategory();
				subcategory.setSubcategory_id(rs.getInt("subcategory_id")); // pk
				subcategory.setTopcategory_id(rs.getInt("topcategory_id")); // fk
				subcategory.setSub_name(rs.getString("sub_name"));
				subList.add(subcategory);
				ch_sub.add(rs.getString("sub_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt, rs);
		}
		
	}
	// 웹에서 파일 찾아서 이미지 미리보기 구현
		public void findWeb() {
			String path=JOptionPane.showInputDialog(this.getAppMain(),"경로 입력");
			
			//위의 경로를 이용하여, 웹서버에 요청을 시도해본다!! 
			//HttpURLConnection !!!!
			URL url=null;
			HttpURLConnection httpCon=null;
			InputStream is=null; //입력스트림 계열의 최상위 객체
			FileOutputStream fos=null; //파일을 대상으로 한 출력스트림
			
			try {
				url=new URL(path);
				httpCon=(HttpURLConnection)url.openConnection();
				httpCon.setRequestMethod("GET");
				
				is=httpCon.getInputStream();//웹서버로의 요청에 연결된 스트림 얻기!!
				long time=System.currentTimeMillis();
				filename=time+"."+FileManager.getExtend(path, "/");
				fos = new FileOutputStream("D:\\Workspace\\korea202102_Javaworksapce\\ShoppingApp\\data\\"+filename);
				
				int data=-1;
				while(true) {
					data=is.read();
					if(data==-1)break;
					fos.write(data);
				}
				
				JOptionPane.showMessageDialog(this.getAppMain(), "복사완료");
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fos!=null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(is!=null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
		
	// local 시스템에서 파일 찾아서 이미지 미리보기 구현
	public void findLocal() {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		if(chooser.showOpenDialog(this.getAppMain())==JFileChooser.APPROVE_OPTION) {
			File file=chooser.getSelectedFile();
			
			image = kit.getImage(file.getAbsolutePath()); //파일의 물리적 풀 경로
			can.repaint();
			
			// 유저가 선택한 파일을 data 디렉토리에 복사
			try {
				fis = new FileInputStream(file);
				long time = System.currentTimeMillis();
				filename = time+"."+FileManager.getExtend(file.getAbsolutePath(),"\\");
				fos = new FileOutputStream("D:\\Workspace\\korea202102_Javaworksapce\\ShoppingApp\\data\\"+filename); //복사될 경로
				
				// 입출력 스트림 준비 되었으므로 복사 시작.
				int data=-1; 
				byte[] buff = new byte[1024]; //1kbyte 의 버퍼확보
				while(true) {
					data=fis.read(buff); //버퍼로 읽음
					if(data==-1)break;
					fos.write(buff);//버퍼로 내려씀
				}
				JOptionPane.showMessageDialog(this.getAppMain(), "복사완료");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fos!=null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}			
			}
			
		};
	}
	// 상품 등록
	public void regist() {
		
		PreparedStatement pstmt=null;
		
		String sql="insert into product(subcategory_id, product_name, price, brand, detail, filename)";
		sql+=" values(?,?,?,?,?,?)";
		int index= ch_sub.getSelectedIndex()-1;
		
		//얻어진 초이스 컴포넌트의 index를 이용하여, VO가 들어있는 ArrayList의 접근해보자!!
		Subcategory subcategory=subList.get(index);
		System.out.println("당신이 등록하려는 상품의 subcategory_id 는 "+ subcategory.getSubcategory_id());
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			// 바인드 변수값 처리 
			pstmt.setInt(1, subcategory.getSubcategory_id()); //서브 카테고리
			pstmt.setString(2, t_product_name.getText());//상품명
			pstmt.setInt(3, Integer.parseInt(t_price.getText()));//가격
			pstmt.setString(4, t_brand.getText());//브랜드
			pstmt.setString(5, t_detail.getText());//상세설명
			pstmt.setString(6, filename);//이미지명
			
			// 쿼리실행(DML)
			int result = pstmt.executeUpdate();
			if(result==1) {
				JOptionPane.showMessageDialog(this.getAppMain(), "상품 등록성공");
			}else {
				JOptionPane.showMessageDialog(this.getAppMain(), "상품 등록실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt);
		}
		
	}
	// -----------------------------------------------[센터영역]
	// 엑셀 등록
	public void registByExcel(){
		// 1. 엑셀파일 선택필수
		String path= null;
		if(chooser.showOpenDialog(this.getAppMain())== JFileChooser.APPROVE_OPTION) {
			File file= chooser.getSelectedFile();
			path= file.getAbsolutePath();
		}else {
			JOptionPane.showMessageDialog(this.getAppMain(), "엑셀 파일을 선택하시오.");
			return; // 아래로 수행하지 못하도록 함수 호출부로 돌려보냄
		}
		// 2. 엑셀파일에 접근
		FileInputStream fis= null;
		XSSFWorkbook workbook= null;
		PreparedStatement pstmt= null;
		Connection con= this.getAppMain().getCon();
		try {
			fis= new FileInputStream(path);
			con.setAutoCommit(false);
			// 엑셀파일 처리 위한 객체 XSSFWorkbook
			workbook= new XSSFWorkbook(fis);
			XSSFSheet sheet= workbook.getSheetAt(0); // 내가 부여한 sheet명을 통해 접근
			// sheet 객체를 이용해 원하는 레코드에 접근
			for(int i=1; i<sheet.getLastRowNum(); i++) {
				XSSFRow row= sheet.getRow(i);
				int subcategory_id=0;
				String product_name= null;
				int price= 0;
				String brand= null;
				String detail= null;
				String filename= null;
				// 컬럼 수 만큼 반복
				for(int a=0; a<row.getLastCellNum(); a++) {
					XSSFCell cell= row.getCell(a);
					// 숫자와 문자일 경우 메소드가 다르기때문에 자료형에 따라 조건에 알맞는 메소드 호출해야함.
					if(a==0) { // sub_id
					// System.out.print(cell.getNumericCellValue());	
					subcategory_id= (int)cell.getNumericCellValue();
					}else if(a==1) { // product_name
						// System.out.print(cell.getStringCellValue());
						product_name= cell.getStringCellValue();
					}else if(a==2) {
						// System.out.print(cell.getNumericCellValue());
						price= (int)cell.getNumericCellValue();
					}else if(a==3) {
						// System.out.print(cell.getStringCellValue());
						brand= cell.getStringCellValue();
					}else if(a==4) {
						// System.out.print(cell.getStringCellValue());
						detail= cell.getStringCellValue();
					}else if(a==5) {
						// System.out.print(cell.getStringCellValue());
						detail= cell.getStringCellValue();
					}
				}
				System.out.println(""); // 줄바꿈
				String sql= "insert into product(subcategory_id, product_name, price, brand, detail, filename)";
				sql+= " values(?, ?, ?, ?, ?, ?)";

				pstmt= this.getAppMain().getCon().prepareStatement(sql);
				// 바인드 변수
				pstmt.setInt(1, subcategory_id);
				pstmt.setString(2, product_name);
				pstmt.setInt(3, price);
				pstmt.setString(4, brand);
				pstmt.setString(5, detail);
				pstmt.setString(6, filename);
				// 쿼리 실행
				pstmt.executeUpdate(); 
			}
			con.commit(); // 트랜젝션 확정
			JOptionPane.showMessageDialog(this.getAppMain(), "엑셀 업로드 완료");
			getProductList();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// DML 실패에 의해 에러를 만난 이유로 실행된다면 롤백
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			this.getAppMain().release(pstmt);
		}
	}
	// 상품 목록 가져오기 
	public void getProductList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select product_id, sub_name, product_name, price, brand, detail,filename";
		sql+=" from subcategory s, product p";
		sql+=" where s.subcategory_id=p.subcategory_id";
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql
					, ResultSet.TYPE_SCROLL_INSENSITIVE
					, ResultSet.CONCUR_READ_ONLY);
			
			rs=pstmt.executeQuery();
			rs.last(); // 커서를 마지막레코드로 보냄 
			int total = rs.getRow(); // 레코드 번호 구하기
			
			// JTable이 참조하고 있는 records라는 이차원배열의 값을, rs를 이용하여 갱신
			records=new String[total][columns.length];
			
			rs.beforeFirst(); // 커서 위치 제자리로 
			int index=0;
			while(rs.next()) {
				records[index][0]=Integer.toString(rs.getInt("product_id"));
				records[index][1]=rs.getString("sub_name");
				records[index][2]=rs.getString("product_name");
				records[index][3]=Integer.toString(rs.getInt("price"));
				records[index][4]=rs.getString("brand");
				records[index][5]=rs.getString("detail");
				records[index][6]=rs.getString("filename");
				index++;
			}
			table.updateUI(); // JTable 갱신 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt, rs);
		}
	}
	// 검색 결과 가져오기
	public void getListBySearch() {
		String category= ch_category.getSelectedItem();
		String keyword= t_keyword.getText();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String sql="select product_id, sub_name, product_name, price, brand, detail,filename";
		sql+=" from subcategory s, product p";
		sql+=" where s.subcategory_id=p.subcategory_id and "+category+" like '%"+keyword+"%' ";
//		System.out.println(sql);
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql
					, ResultSet.TYPE_SCROLL_INSENSITIVE
					, ResultSet.CONCUR_READ_ONLY);
			
			rs=pstmt.executeQuery();
			rs.last(); // 커서를 마지막레코드로 보냄 
			int total = rs.getRow(); // 레코드 번호 구하기
			
			// JTable이 참조하고 있는 records라는 이차원배열의 값을, rs를 이용하여 갱신
			records=new String[total][columns.length];
			
			rs.beforeFirst(); // 커서 위치 제자리로 
			int index=0;
			while(rs.next()) {
				records[index][0]=Integer.toString(rs.getInt("product_id"));
				records[index][1]=rs.getString("sub_name");
				records[index][2]=rs.getString("product_name");
				records[index][3]=Integer.toString(rs.getInt("price"));
				records[index][4]=rs.getString("brand");
				records[index][5]=rs.getString("detail");
				records[index][6]=rs.getString("filename");
				index++;
			}
			table.updateUI(); // JTable 갱신 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt, rs);
		}
		
	}
	// 상세보기 구현
	public void getDetail() {
		// 선택한 레코드의 product_id
		product_id=Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0)); // 그냥 쓰면 오브젝트라 에러. 인티저로 언박싱처리
		// String은 Immuable특징이 있기때문에 아래와 같이 sql문 처리 시 문자열 상수가 5개나 생성됨.
		StringBuffer sb= new StringBuffer();
		sb.append("select product_id,top_name, sub_name, product_name, price, brand, detail,filename");
		sb.append(" from topcategory t, subcategory s, product p");
		sb.append(" where t.topcategory_id=s.topcategory_id and");
		sb.append(" s.subcategory_id = p.subcategory_id and");
		sb.append(" product_id="+product_id);
//		System.out.println(sb.toString());
		
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			pstmt= this.getAppMain().getCon().prepareStatement(sb.toString());
			rs= pstmt.executeQuery();
			if(rs.next()) {
				// 레코드가 있다면,
				t_top.setText(rs.getString("top_name"));
				t_sub.setText(rs.getString("sub_name"));
				t_product_name2.setText(rs.getString("product_name"));
				t_price2.setText(Integer.toString(rs.getInt("price")));
				t_brand2.setText(rs.getString("brand"));
				t_detail2.setText(rs.getString("detail"));
				del_file= rs.getString("filename");
				// 우측 캔버스에 이미지 나오게
				image2= kit.getImage("D:\\Workspace\\korea202102_Javaworksapce\\ShoppingApp\\data\\"+rs.getString("filename"));
				can2.repaint();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt,rs);
		}
	}
	// 상품 삭제
	public void deleteProduct() {
		String sql= "delete from product where product_id="+product_id;
//		System.out.println(sql);
		PreparedStatement pstmt= null;
		
		try {
			pstmt= this.getAppMain().getCon().prepareStatement(sql);
			int result= pstmt.executeUpdate();
			if(result>0) {
				// 0보다 클때 파일 삭제
				File file= new File("D:\\Workspace\\korea202102_Javaworksapce\\ShoppingApp\\data\\"+del_file);
				file.delete();
				getProductList(); // 리스트 조회
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt);
		}
	}
	// 상품 수정
	public void updateProduct() {
//		System.out.println("수정할 product_id는 "+product_id);
		String sql= "update product set product_name=?, price=?, brand=?, detail=?, filename=?";
		sql+= " where product_id=?";
		PreparedStatement pstmt= null;
		try {
			pstmt= this.getAppMain().getCon().prepareStatement(sql);
			String product_name= (String)table.getValueAt(table.getSelectedRow(), 2);
			int price= Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 3));
			String brand= (String)table.getValueAt(table.getSelectedRow(), 4);
			String detail= (String)table.getValueAt(table.getSelectedRow(), 5);
			String filename= (String)table.getValueAt(table.getSelectedRow(), 6);
			
			
			pstmt.setString(1, product_name); // product_name
			pstmt.setInt(2, price); // price
			pstmt.setString(3, brand); // brand
			pstmt.setString(4, detail); // detail
			pstmt.setString(5, filename); // filename
			pstmt.setInt(6, product_id); // product_id
			int result= pstmt.executeUpdate();
			if(result>0) {
				JOptionPane.showMessageDialog(this.getAppMain(), "수정완료");
			}else{
				JOptionPane.showMessageDialog(this.getAppMain(), "수정실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt);
		}
	}
}

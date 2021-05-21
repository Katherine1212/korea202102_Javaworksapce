package app0517.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JMenuBar bar;
	JMenu m_file;
	JMenuItem item_new; // 새파일
	JMenuItem item_open; // 열기
	JMenuItem item_save; // 저장
	JMenuItem item_saveas; // 새이름으로 저장
	JMenuItem item_exit; // 끝내기
	JTextArea area;
	JScrollPane scroll;
	JFileChooser chooser; // 탐색기
	public MemoEditor() {
		// 생성
		bar= new JMenuBar();
		m_file= new JMenu("메뉴");
		item_new= new JMenuItem("새파일");
		item_open= new JMenuItem("열기");
		item_save= new JMenuItem("저장");
		item_saveas= new JMenuItem("새이름으로 저장");
		item_exit= new JMenuItem("끝내기");
		
		area= new JTextArea();
		scroll=  new JScrollPane(area);
		chooser = new JFileChooser("D:\\Workspace\\korea202102_Javaworksapce\\app0517\\src\\app0517");
		// 조립
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_save);
		m_file.add(item_saveas);
		m_file.add(item_exit);
		bar.add(m_file);  // 메뉴바에 파일 메뉴부착
		setJMenuBar(bar); // 프레임에 메뉴 부착
		
		add(scroll);
		// 리스너 연결
		// item_open.addActionListener(new ActionHandler(this)); 액션리스너 따로 받아올 때
		// (이름없는 클래스) 내부익명클래스
		// 사용 목적: 코드의 재사용성이 필요없는 일회성일 경우에 사용. 주로 이벤트 구현시 압도적으로 많이 사용.
		item_open.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
//					area.append("Hello"); // 바깥쪽에 있는 멤버변수들을 내것처럼 접근가능.
					openFile();
			}
		});
		item_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 새파일은 area를 깨끗하게 비워두는 것
				area.setText(""); // 공백 문자로 대체
			}
		});
		item_saveas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1. showSaveDailog()호출하여 탐색기 띄움
				// 2. 선택한 파일 경로 얻기
				// 3. 빈파일을 파일출력 스트림으로 생성
				// 4. 생성된 파일 출력 스트림통해 area의 내용을 파일에 넣기(출력)
				
			}
		});
		
		// 보여주기
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 닫을 때, 자원 반납용.
	}
	public void openFile() {
		int res= chooser.showOpenDialog(this);
		if(res== JFileChooser.APPROVE_OPTION) {
			// 선택파일에 대한 입력스트림 생성, 내용읽어와 area에 출력
			File file= chooser.getSelectedFile(); // 선택한 파일 반환 받음
			FileReader reader= null; // close위해 try문 밖에 작성
			BufferedReader buffer= null;
			try {
				reader= new FileReader(file);// 문자(2byte)를 읽을 수 있는 스트림생성
				buffer= new BufferedReader(reader);
//				int data=-1; // 읽혀진 문자의 코드를 담게 될 정수 (reader)
				String data= null;
				while(true) {
					// data= reader.read(); // 한 문자 읽기 (reader)
					data= buffer.readLine(); // 한 줄씩 읽기
					if(data==null) break;
					// if(data==-1)break; (reader)
					// area.append(Character.toString((char)data)); (reader)
					area.append(data+"\n");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} finally {
				if(buffer!=null) {
					try {
						buffer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if(reader!=null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new MemoEditor();
	}
}

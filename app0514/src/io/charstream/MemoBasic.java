package io.charstream;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoBasic extends JFrame implements ActionListener{
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JFileChooser chooser;
	public MemoBasic() {
		// 생성
		bt= new JButton("Load");
		area= new JTextArea();
		scroll= new JScrollPane(area);
		chooser= new JFileChooser();
		// 조립
		add(bt,BorderLayout.NORTH);
		add(scroll);
		// 이벤트 리스너 연결
		bt.addActionListener(this);
		// 보여주기
		setBounds(300, 100, 500, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//	-----------------------------------------------------------------------------------------------
	// 바이트 기반
	public void openFileByte() {
		if(chooser.showOpenDialog(this)== JFileChooser.APPROVE_OPTION) {
			File file= chooser.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			// 스트림생성
			FileInputStream fis= null; // 지역변수는 개발자가 직접 초기화
			try {
				fis= new FileInputStream(file.getAbsoluteFile());
				// 1바이트씩 읽고 area에 출력
				int data= -1; // read() 시 바이트 담아 둘 변수
				while(true) {
					data= fis.read();
					if(data== -1)break;
					// System.out.println((char)data);
					area.append(Character.toString((char)data)); // 파일 복사는 가능하나 문자해석x
					// int를 String으로 변경
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}					
				}
			}
		}
	}
	// 문자기반
	public void openFileChar(){
		int res= chooser.showOpenDialog(this);
		if(res== JFileChooser.APPROVE_OPTION) {
			File file= chooser.getSelectedFile(); // 유저가 선택한 파일
			FileReader reader= null;
			// Stream
			try { // 문자 해석 능력있는 스트링(2byte씩 묶어 해석)
				reader= new FileReader(file.getAbsolutePath());
				int data= -1;
				while(true) {
					data= reader.read();	
					if(data== -1) break;
					area.append(Character.toString((char)data));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(reader!= null) {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
//	-----------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e) {
		// openFileByte();
		 openFileChar();
	}
	public static void main(String[] args) {
		new MemoBasic();
	}
}

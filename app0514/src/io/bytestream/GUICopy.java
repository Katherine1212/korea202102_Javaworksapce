package io.bytestream;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 파일 복사기능을 gui기반으로 처리
public class GUICopy extends JFrame implements WindowListener, ActionListener {
	JButton bt_open; // 복사원본 탐색창 열기
	JTextField t_open;
	JButton bt_target; // 복사될 파일 파일 탐색창 열기
	JTextField t_target;
	JTextArea area;
	JScrollPane scroll;
	JButton bt_copy;
	JFileChooser chooser; // 파일 탐색기창 객체
	
	FileInputStream fis;
	FileOutputStream fos;

	public GUICopy() {
		// 생성
		bt_open = new JButton("원본 선택");
		t_open = new JTextField();

		bt_target = new JButton("복사 경로");
		t_target = new JTextField();

		area = new JTextArea();
		scroll = new JScrollPane(area);

		bt_copy = new JButton("복사 실행");

		chooser = new JFileChooser("D:\\Workspace\\korea202102_Javaworksapce\\app0514\\res");

		// 스타일, 레이아웃
		setLayout(new FlowLayout());

		bt_open.setPreferredSize(new Dimension(100, 25));
		bt_target.setPreferredSize(new Dimension(100, 25));

		t_open.setPreferredSize(new Dimension(370, 25));
		t_target.setPreferredSize(new Dimension(370, 25));

		scroll.setPreferredSize(new Dimension(480, 180));

		// 조립
		add(bt_open);
		add(t_open);

		add(bt_target);
		add(t_target);

		add(scroll);

		add(bt_copy);

		// 이벤트 리스너
		this.addWindowListener(this);

		bt_open.addActionListener(this);
		bt_target.addActionListener(this);
		bt_copy.addActionListener(this);

		// 기본
		setBounds(300, 100, 500, 350);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE); 이번에는 안 씀. 스트림 종료기회가 없어서
	}

	public void openFile() {
		// 파일 열기용 탐색기
		int res= chooser.showOpenDialog(this); // 탐색기창들은 모두 윈도우에 의존적
		// System.out.println(res);
		if(res== JFileChooser.APPROVE_OPTION) { // ok버튼 눌렀다면
			// 선택한 파일의 디스크상의 풀 시스템 경로를 얻어와 JTextField에 출력
			
			// java.io에 들어있는 File클래스는 해당 파일에 대한 정보를 담고 있는 객체
			File file= chooser.getSelectedFile();
			t_open.setText(file.getAbsolutePath()); // 텍스트필드에 파일의 풀 경로 출력
		}
		// else if(res== JFileChooser.CANCEL_OPTION) { // 취소 버튼 눌렀다면}
	}

	public void saveFile() {
		int res= chooser.showSaveDialog(this);
		if(res== JFileChooser.APPROVE_OPTION) {
			// System.out.println("선택완료");
			File file= chooser.getSelectedFile();
			t_target.setText(file.getAbsolutePath());
		}
	}

	public void copyFile() {
		//정해진 두 경로를 이용하여, Stream을 만들어 입출력을 시도해보자!!!!
		try {
			fis = new FileInputStream(t_open.getText());
			fos = new FileOutputStream(t_target.getText());
			area.append("입력&출력 스트림 생성 완료\n");
			
			//복사수행~~
			int data=-1;
			
			while(true) {
				data=fis.read(); //1byte 읽기(입력)
				if(data==-1)break;//더이상 읽을 데이터가 없을 경우 -1이므로..
				fos.write(data); //1byte 쓰기(출력)
				area.append(data+"\n");
			}
			area.append("복사완료\n");
			JOptionPane.showMessageDialog(this, "복사완료");
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
			if(fos !=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_open) {
			openFile();
		} else if (e.getSource() == bt_target) {
			saveFile();
		} else if (e.getSource() == bt_copy) {
			copyFile();
		}

	}

	public static void main(String[] args) {
		new GUICopy();
	}
	public void windowClosing(WindowEvent e) { // db, stream등 닫을 시는 해당 이벤트 사용
		System.out.println("저 닫힙니다.");
	}

	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

}

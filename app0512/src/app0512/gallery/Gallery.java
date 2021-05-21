package app0512.gallery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gallery extends JFrame implements ActionListener {
	GalleryDetail galleryDetail; // 오버라이딩 필요
	JPanel btnArea; // 커스터마이징 할 필요 x
	JButton bt_prev;
	JButton bt_next;
	
	// 갤러리에 사용할 데이터 배열 준비
	String dir= "D:\\Workspace\\korea202102_Javaworksapce\\app0512\\res\\images";
	String[] arr= {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png", "10.png"};
	Image[] image= new Image[arr.length]; // 배열 생성
	Toolkit kit;
	int index=0; // 이미지 배열 접근용
	public Gallery() {
		// 생성
		galleryDetail= new GalleryDetail();
		btnArea= new JPanel();
		bt_prev= new JButton("Prev");
		bt_next= new JButton("Next");
		
		kit= Toolkit.getDefaultToolkit(); // new하지 않고, 자바에서 준비된 메소드로 인스턴스 얻기
		for(int i=0; i<arr.length; i++) {
			image[i]= kit.getImage(dir+"\\"+arr[i]);
		}
		// 이미지 생성 후 첫번째 이미지를 디폴트로 그려지게하기.
		galleryDetail.setImage(image[index]);
		
		// 스타일, 레이아웃
		galleryDetail.setBackground(Color.PINK);
		btnArea.setBackground(Color.LIGHT_GRAY);
		// 조립
		add(galleryDetail); // center에 부착
		btnArea.add(bt_prev);
		btnArea.add(bt_next);
		add(btnArea,BorderLayout.SOUTH);
		// 이벤트리스너 연결
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		// 보여주기
		setBounds(100, 200, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// 이벤트 리스너
	public void actionPerformed(ActionEvent e) {
		// 하나의 actionperformed 메소드에서 여려 이벤트 소스를 구분하자.
		if(e.getSource()== bt_prev) {
//			System.out.println("이전");
			if(index>0) {
				index--; // 이전 이미지 접근 위해 -1씩 감소	
			}else {
				JOptionPane.showMessageDialog(this, "이전 이미지가 없습니다.");
			}
		}else if(e.getSource()== bt_next) {
//			System.out.println("다음");
			if(index<arr.length-1) {
				index++; // 다음 이미지 접근 위해 +1씩 증가				
			}else {
				JOptionPane.showMessageDialog(this, "다음 이미지가 없습니다.");
			}
		}
//		System.out.println("index는 " +index);
		galleryDetail.setImage(image[index]);
		galleryDetail.repaint();
	}
	public static void main(String[] args) {
		new Gallery();
	}
}

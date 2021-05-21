package app0513.album;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

// 썸네일 이미지 그리기 위한 클래스
public class ThumbPanel extends JPanel implements MouseListener{
	Image image;
	Toolkit kit;
	int width= 60;
	int height= 60;
	XCanvas canvas; // 필요하면.. 보유! has a관계로
	
	public ThumbPanel(String filename, XCanvas canvas) {	
		this.setPreferredSize(new Dimension(width,height));
		kit= Toolkit.getDefaultToolkit(); // new 불가능
		image= kit.getImage(filename);
//		image= image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.canvas= canvas; // 넘겨받은 캔버스 주소값을 멤버변수에 보관
		this.addMouseListener(this); // 마우스 리스너 연결
	}

	
	@Override
	public void paint(Graphics g) {	
		g.drawImage(image, 0, 0, width, height, this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {		
//		System.out.println("XCanvas의 파일 경로 전달"+image);
		// XCanvas가 가진 setter호출
		canvas.setImage(image);
		canvas.repaint(); // 다시 그리기
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {	}
}

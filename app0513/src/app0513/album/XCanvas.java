package app0513.album;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

// Canvas의 Paint메소드 재정의 위한 클래스
public class XCanvas extends Canvas{	
	Image image;
	Toolkit kit= Toolkit.getDefaultToolkit();
	public void createImage(String path) {
		image= kit.getImage(path);
	}
	// 썸네일 패널로부텅 이미지 전달 받기 위해 setter이용
	public void setImage(Image image) {
		this.image = image;
//		System.out.println("전달 받은 이미지는 "+image);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, 600, 430, this);
	}
}

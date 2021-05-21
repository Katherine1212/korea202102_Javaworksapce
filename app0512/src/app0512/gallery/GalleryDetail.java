package app0512.gallery;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

// 갤러리에 큰 이미지 나올 곳
public class GalleryDetail extends JPanel {
	private Image image; // 누군가에 의해 이미지를 넘겨 받기위해서는 메소드 준비
	// setter
	public void setImage(Image image) {
		this.image = image.getScaledInstance(700, 525, Image.SCALE_SMOOTH);
	}
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}

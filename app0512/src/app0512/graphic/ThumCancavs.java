package app0512.graphic;

import java.awt.Graphics;
import java.awt.Image;


import javax.swing.JPanel;
// JPanel을 상속받아 paint메소드를 재정의하기 위한 클래스
public class ThumCancavs extends JPanel{
	PhotoAlbum photoAlbum;
	Image image;
	public ThumCancavs(PhotoAlbum photoAlbum) {
		this.photoAlbum = photoAlbum;
	}
	public void setImage(Image image) {
		this.image = image;
		System.out.println("클릭 시 넘어온 이미지는 :"+image);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}

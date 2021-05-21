package app0513.paint;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

// 컬러를 담아두는 곳
public class ColorPicker extends JPanel {
	
	public ColorPicker(Color color) {
		this.setPreferredSize(new Dimension(50,50));
		this.setBackground(color);
	}
}

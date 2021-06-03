package com.minssam.shoppingapp.main;

import javax.swing.JButton;

public class CustomButton extends JButton{
	private int id;
	public CustomButton(String title) {
		super(title); // 부모는 생성자를 물려받지 않으므로 자식이 생성자호출
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id= id;
	}
}

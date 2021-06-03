package com.minssam.shoppingapp.main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel {
	// AppMain에 정보 필요
	private AppMain appMain;
	// 다른 pkg에서 접근 가능하도록
	public AppMain getAppMain() {
		return appMain;
	}
	public Page(AppMain appMain) {
		this.appMain= appMain;
		setPreferredSize(new Dimension(1200, 700));
		setVisible(false);
	}
}

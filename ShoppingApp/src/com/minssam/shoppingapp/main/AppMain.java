package com.minssam.shoppingapp.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.minssam.shoppingapp.configure.ConfigureMain;
import com.minssam.shoppingapp.cs.CustomerMain;
import com.minssam.shoppingapp.member.LoginForm;
import com.minssam.shoppingapp.member.MemberMain;
import com.minssam.shoppingapp.order.OrderMain;
import com.minssam.shoppingapp.product.ProductMain;

public class AppMain extends JFrame implements ActionListener {
	JPanel p_north;
	String[] menu_title= {"상품관리","회원관리","주문관리","고객센터","Login","환경설정"};
	JButton[] bt_menu=new JButton[menu_title.length]; // 배열생성
	
	// 페이지를 교체하기 위한 패널
	JPanel p_center;
	// 페이지 선언
	ProductMain productMain; // 상품관리 페이지
	MemberMain memberMain; // 회원관리 페이지
	OrderMain orderMain; // 주문관리 페이지
	CustomerMain customerMain; // 고객센터
	LoginForm loginForm; // 로그인
	ConfigureMain configureMain; // 환경설정
	
	public AppMain() {
		// -----------------------------------------------[생성]
		p_north= new JPanel();
		for(int i=0; i<menu_title.length; i++) {
			bt_menu[i]= new JButton(menu_title[i]);
		}
		p_center= new JPanel();
		productMain= new ProductMain();
		memberMain= new MemberMain();
		orderMain= new OrderMain();
		customerMain= new CustomerMain();
		loginForm= new LoginForm();
		configureMain= new ConfigureMain();
		// -----------------------------------------------[스타일]
		
		// -----------------------------------------------[조립]
		// improved for loop: 주로 집합된 데이터형식을 대상으로 한 개선된 for문
		for(JButton bt:bt_menu) {
			p_north.add(bt);
		}
		add(p_north,BorderLayout.NORTH);
		
		p_center.add(productMain);
		p_center.add(memberMain);
		p_center.add(orderMain);
		p_center.add(customerMain);
		p_center.add(loginForm);
		p_center.add(configureMain);
		
		add(p_center);
		
		// -----------------------------------------------[리스너]
		// 윈도우 리스너(창닫기용)
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // kill process
			}
		});
		// 액션리스너(버튼)
		for(int i=0; i<bt_menu.length; i++) {
			bt_menu[i].addActionListener(this);
		}
		
		// -----------------------------------------------[화면]
		setBounds(700, 100, 1200, 700);
		setVisible(true);
	}
	// -----------------------------------------------[액션리스너]
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 누름?");
		
	}
	
	
	
	
	
	
	
	// -----------------------------------------------[메인]
	public static void main(String[] args) {
		new AppMain();
	}

}

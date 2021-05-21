package app0510.Layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/* LoginForm 예제에선 메인 메소드 안에 변수를 넣음(즉, 지역변수로 처리)
이번 예제는 oop언어의 is a, has a 관계를 활용하여 객체를 정의 */
public class LoginForm2 extends Frame{
									// is a
	// 로그인폼이 메모리에 생성될 때, 부품들도 같이 생성되어야함. 생성자 메소드를 적극 활용.
	// 멤버변수 has a
	Label la_id, la_pass;
	TextField t_id, t_pass;
	Button bt_login, bt_regist;
	Panel p_center, p_south;
	
	public LoginForm2() {
		// 부모의 생성자 이용
		super("Login Form stye 2");
		// 부품 생성
		la_id= new Label("ID");
		t_id= new TextField(20);
		la_pass= new Label("Password");
		t_pass= new TextField(20);
		bt_login= new Button("Login");
		bt_regist= new Button("Regist");
		p_center= new Panel();
		p_south= new Panel();
		
		// 부착
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		p_south.add(bt_login);
		p_south.add(bt_regist);
		
		// 스타일 설정
		la_id.setPreferredSize(new Dimension(110,35));
		t_id.setPreferredSize(new Dimension(110,35));
		la_pass.setPreferredSize(new Dimension(110,35));
		t_pass.setPreferredSize(new Dimension(110,35));
		
		// 프레임에 패널 부착
		this.add(p_center);
		this.add(p_south, BorderLayout.SOUTH);
		
		// 프레임 설정 this. 없어도 무방(현재 class가 frame을 상속받았으니 내것처럼 사용)
		setVisible(true); // 보이게
		setSize(330, 155); // 사이즈
		
	}
	
}

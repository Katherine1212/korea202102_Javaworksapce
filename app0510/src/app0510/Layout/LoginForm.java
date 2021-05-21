package app0510.Layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class LoginForm {
	public static void main(String[] args) {
		/* 지역변수는 null 조차 자동으로 초기화 되지 않음. 멤버변수만 컴파일러가 관여. 
		 * 결론: 지역변수는 초기화 하는 습관을 기르자.*/
		Frame frame= new Frame("Login Form type1");
		Panel panel= new Panel(); // 패널은 디폴트레이아웃이 FlowLayout
		
		GridLayout grid= new GridLayout(2,2);
		/* 텍스트 필드와 라벨은 같은 위치에 부착 될 수 없음. 
		  즉, Frame의 BorderLayout의 한 방위는 컴포넌트들이 공존 할 수 없으며, 
		  크기 또한 컨테이너까지 늘어남, 마지막에 붙인 것이 최상위로 올라감.
		  공존 시키고 싶다면, panel을 이용 */
		
		// ID
		Label la_id= new Label("ID"); // 라벨도 부착
		TextField t_id= new TextField(); // 텍스트 필드
		la_id.setBackground(Color.cyan);// 라벨의 경계를 보기 위해 배경색 적용
		
		// Password
		Label la_pass= new Label("Password");
		TextField t_pass= new TextField();
		
		// Button
		Panel p_bt= new Panel(); // 버튼을 남쪽에 얹힐 패널
		Button bt_login= new Button("Login");
		Button bt_regist= new Button("Rigist");

		// 조립
		
		// 프레임 사이즈 조정
		frame.setVisible(true);
		frame.setSize(300, 125);
		// 패널 부착
		frame.add(panel); 
		panel.setLayout(grid);
		frame.add(p_bt, BorderLayout.SOUTH);
		// id
		panel.add(la_id); // 센터에 부착		
		panel.add(t_id); // 방위를 명시하지 않으면 center가 디폴트
		// password
		panel.add(la_pass); // 센터에 부착		
		panel.add(t_pass); // 방위를 명시하지 않으면 center가 디폴트
		// button
		p_bt.add(bt_login);
		p_bt.add(bt_regist);
	}
}

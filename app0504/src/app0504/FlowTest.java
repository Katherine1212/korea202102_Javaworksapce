package app0504;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
/* 프레임은 윈도우이기 때문에 다른 컴포넌트를 올려놓을 수 있다.
 이때 어떤방식으로 올려놓을지에 대해서는 배치 관리자라 불리는 클래스로 지원 
 배치관리자의 종류
 1. FlowLayout: 수평 or 수직 방향으로 컴포넌트 배치. 윈도우의 크기에 따라 유동적으로 흘러다님.
 2. BorderLayout
 3. GridLayout
 4. GridBagLayout
 5. CardLayout*/

public class FlowTest {
	public static void main(String[] args) {
		Frame frame= new Frame();
		FlowLayout flow= new FlowLayout();
		
		frame.setLayout(flow); // 플로우 레이아웃 적용
		
		for(int i=0; i<20; i++) {
			Button bt= new Button(i+"번째 버튼");
			// 프레임에 버튼 부착
			frame.add(bt);
		}
		frame.setSize(300,200); // 프레임 사이즈
		frame.setVisible(true); // display:none 해제
	}
}

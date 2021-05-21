/*
GUI 프로그래밍은 무조건 윈도우가 있어야 가능하다.
따라서 자바 언어에서 GUI관련된 패키지는 awt/swing 에서 지원.
javaFX-> 안드로이드와 많이 비슷함.
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Choice;
class MyWin{
	public static void main(String[] args) {
		// 자바에서 윈도우는 Frame이 담당
		Frame frame; // 객체의 인스턴스가 없다. frame에는 초기화 되어있지 않음.
		/*
		Frame이라는 클래스는 사용하라고 제공된 것. 문제는 어떻게 사용할지 모름.
		Why? 내가 정의한 클래스가 아니기때문.
		
		Tip 남에게 제공받은 객체 사용법
		1. 해당 클래스를 파악. 용도가 무엇인지? 사용 목적이 무엇인지?
			https://docs.oracle.com/en/java/javase/11/docs/api/index.html

		2. 사용하려면 메모리에 올려야함. 메모리에 올리려면 객체가 일반, 추상, 인터페이스인지 조사
			- 일반 클래스: new 변수();
			- 추상 클래스&인터페이스: 자식으로 완성 후 자식을 new.

		3.객체의 유형이 파악 되었다면,
			- 일반 클래스: new 다음에 올 생성자 조사.
			- 추상 클래스&인터페이스:
		*/
		frame= new Frame();

		// 윈도우 내 부착할 버튼 생성
		Button bt= new Button("click");
		/*
		버튼이 너무 크게 나오는 이유는?
		모든 GUI프로그래밍에서는 화면 배치 방법을 개발자가 결정해야하기 때문.
		*/
		FlowLayout flow= new FlowLayout(); // 컴포넌트를 선형으로 배치하는 레이아웃 객체(수직or수평 배치)
		frame.setLayout(flow); // 프레임에 부착전 수직 or 수평 결정

		// 입력 텍스트박스 생성하여 부착
		TextField t= new TextField(20); // 숫자를 넣으면 해당 n자 크기의 너비가 확보.

		// 체크박스
		Checkbox ck1= new Checkbox("Movie");
		Checkbox ck2= new Checkbox("Programming");
		Checkbox ck3= new Checkbox("Fitness");
		Checkbox ck4= new Checkbox("Travle");
		
		// 텍스트에리어
		TextArea tx= new TextArea(5,15);

		// html의 select box는 choice라고 함
		Choice choice= new Choice();
		choice.add("select Email");
		choice.add("@naver.com");
		choice.add("daum.net");
		choice.add("@google.com");

		// 프레임에 부착
		frame.add(bt);
		frame.add(t);
		frame.add(ck1);
		frame.add(ck2);
		frame.add(ck3);
		frame.add(ck4);
		frame.add(tx);
		frame.add(choice);

		frame.setVisible(true); // frame 기본 설정은 display:none;
		frame.setSize(300,400);// 크기 명시하지 않으면 원하는 크기로 보이지 않음

	}
}

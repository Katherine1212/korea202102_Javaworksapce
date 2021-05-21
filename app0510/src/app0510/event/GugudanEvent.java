package app0510.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

//버튼을 눌렀을때 해당 이벤트를 청취하는 ActionListener 재정의 
public class GugudanEvent implements ActionListener{
	JTextField t_input;
	
	//생성자 
	public GugudanEvent(JTextField t_input) {
		System.out.println("이벤트 클래스 생성시 넘겨받은 t_input은"+t_input);
		this.t_input=t_input;
	}
	public void callMe(int x) {
		System.out.println("넘겨받은 x는 "+x);
	}
	public void callMe(String y) {
		System.out.println("넘겨받은 y는 "+y);
	}
	public void callMe(JButton bt) {
		System.out.println("bt는 "+bt);
	}
	public void callMe(JTextField t_input) {
		this.t_input= t_input;
	}
	public void actionPerformed(ActionEvent e) {
		//나 아닌 다른 클래스에 존재하는 TextField 값에 무엇이 
		//들어있는지 알아맞추기!!
		//t_input값 가져오기~~;
		
		printDan();
		
	}
	
	public void printDan() {
		// js var= v document.getElementById("t_input").value;
		// 자바에서는 TextField 값 얻기.
		String dan= t_input.getText();
		System.out.println("당신이 입력한 단은 "+dan+"입니다.");
		/* javascript에서는 문자열을 정수로 변환하기 위해 parseInt() 함수 지원.
		 java도 동일한 기능을 지원하나 API가 약간 다르다. 
		 문자열인 String형 즉 객체자료형을 기본자료형으로 변경하는 것 자체가 불가능.
		 ig) Dog(객체자료형)->7(기본자료형) 불가.
		 
		 아래와 같이 String형에 대해서는 (특별) 기본자료형과의 형변환을 허용.
		 이때 사용되는 객체가 바로 Wrapper 클래스
		 String s= "5"; ->5 
		 
		 Wrapper class
		 - 자바의 모든 기본 자료형에 대해서는 1:1 대응하는 Wrapper class가 지원됨.
		 - Why called wrapper? 정수를 객체로 감싸서
		 - 사용목적:
		 	1) 기본 자료형과 객체자료형간의 변환시 사용. "5"->5
		 	2) 기본 자료형과 관련된 다양한 작업을 지원하기 위해 기본 자료형을 객체차원에서 지원하기 위해.
		 		Why? 기본 자료형을 객체형으로 변환시 메소드, 속성을 이용할 수 있기 때문.
	 		[기본 자료형]
	 		문자: char
	 			  Character
	 		숫자: 정수- byte,  short,  int,       long 
 						 Byte   Short  Integer  Long  (Wrapper클래스가 함.)
	 			   실수- float, double
	 			   		 Float  Double
	 		논리값: boolean
	 				 Boolean
	 		*/
//		String x= "8; // 이 x값을 정수로 변환 하고 싶다면"
//		int a= Integer.parseInt(x); // "8"의 ""를 제거하여 정수 8로 변환
		int d= Integer.parseInt(dan);
		for(int i=1;i<=9;i++) {
			System.out.println(d+"*"+i+"="+(d*i));
		}
	}
}

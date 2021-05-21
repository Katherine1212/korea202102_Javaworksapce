package app0512.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

// 현재 클래스는 캔버스를 상속받기 위해 생성
public class MyCanvas extends Canvas{
	// 캔버스에 그려질 그림을 개발자가 주도하여 원하는 그림 그리기
	MoveTest moveTest; 
	// 이 생성자를 호출하는 자는 MoveTest의 주소값을 인수로 넘겨야함.
	// MyCanvas는 태어날 때 부터 MoveTest의 주소값을 보유.
	public MyCanvas(MoveTest moveTest) {
		this.moveTest=moveTest;
	}
	/* pain메소드에 대하여
	 * 특징: 개발자가 paint 메소드를 호출해서는 안 된다.
	 * Why? 자바의 모든 컴포넌트는 스스로를 그린ㄷ나. 즉 paint메소드는 시스템이 그래픽 랜더링 시 필요에 의해 호출됨.
	 * 호출 타이밍은 개발자가 결정하는 것이 아님.
	 * When? 처음 그림과 비교하여 바뀐 부분이 있다면 시스템이 알아서 다시 호출
	 * 동작 원리: 다시 그리는 과정은 내부적으로 아래의 절차를 거침.
	 * 				1. 기존의 그림을 지움(Update 메소드)
	 * 				2. 그림을 그림(Paint 메소드)
	 * 문제점: 사용자가 윈도우 창의 크기를 변화시키거나 하는 그래픽상의 변화를 통해 paint()메소드를 호출 하는 것이 아니라
	 * 			개발자가 원하는 시점에 프로그래밍적으로 paint()를 호출하는 방법은 없을까?
	 * 해결방안: Sun사에서는 그래픽이 화면에 반영되는 처리를 시스템이 하기때문에 paint()메소드 호출을 원칙적으로 막음.
	 * 			  따라서 개발자가 시스템에게 PAINT()가 호출 될 수 있도록 간접적으로 요청하는 방식으로 그래픽을 처리 할 수 있다.
	 * 			  이때 호출할 수 있는 메소드는 repaint(). 
	 * 			  repaint()는 그래픽의 갱신 요청-> 갱신 요청을 받으면 update()호출. 화면 지움-> 깨끗해지면 paint()*/
	
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		// 이 시점부터 노란색으로 그려짐
		g.fillOval(moveTest.x, 100, 100, 100);
	}
}

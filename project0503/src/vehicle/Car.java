package vehicle;
public class Car{
	/*
	Car has a Engine
	특정 클래스가 다른 클래스를 멤버변수로 보유한 경우, 이를 가리켜 has a 관계라고 함.
	자바와 같은 oop언어에서는 객체들간 간계가 크게 2가지가 있다.
	1) is a 관계: 상속관계
	2) has a 관계: 부품관계
	- oop기반으로 개발하다보면 여러 클래스로 개발하게되며, 이 클래스들간에 관계 형성도 가능한데
	이대 관계란 is a, has a 관계로 분류됨.
	*/
	Engine e; // 객체는 최소한의 관여가 불가능하기때문에 null로 초기화. null은 데이터가 없다는 뜻.
	Wheel w;
	int price; // default 기본 0
	String color; // String도 객체이므로 null로 초기화

	/*부품 관계를 선언 했다면 초기화는 더욱 중요. 초기화 담당역역은 생성자이며, 생성자 적극 활용 필요.*/
	public Car(){ // 방법 2 Car에서 미리 호출
		// has a 관계에 명시한 변수들에대해 초기화
		e= new Engine();
		w= new Wheel(); 
		price=5000; 
		color= "black";
	}
}
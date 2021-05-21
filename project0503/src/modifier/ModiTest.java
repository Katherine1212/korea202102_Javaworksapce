package modifier;
public class ModiTest{
	/*
	자바의 수식자(modifier)에서는 static 말고도 여러가지가 있다.
	개발자가 알아야 할 수식자는 아래의 3가지 이다.
	1. static: 정석 변수, 메소드, 클래스 선언 시 사용.
	2. final: 변수, 메소드, 클래스의 값을 고정 시 사용.
				- 변수: 상수처럼 고정.
				- 메소드: 오버라이딩 불가능. 부모의 메소드 업그레이드 불가.
				- 클래스: 더이상 자식을 두지 않음. 외부의 클래스가 해당 클래스를 상속불가.
	3. abstract: 추상 클래스 메소드 선언 시 사용
	*/
	public static void main(String[] args){
		// final 사용
		final int x= 3; // 더이상 x값은 이 시점 이후 변경 불가능.
		x=9;
	}
}
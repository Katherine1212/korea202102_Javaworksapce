package race;

class UseHuman{
	public static void main(String[] args){
		Black b= new Black();
		// b.age=7; - 존재하지 않은 멤버 변수는 새로 선언 시 에러 난다.
		b.IQ= 110; // black에는 IQ가 없어도 부모Human 클래스에 존재하므로 에러안남.

		/*상속 관계에서 주의할 점.
		부모의 코드가 자식의 class에 붙여넣기 되는 것이 아니라 서로 다른 인스턴스 영역을 가진 상태에서
		자식의 인스턴스가 부모의 인스턴스 영역을 자기것 인 것 처럼 접근 가능하도록 확장 된 것일 뿐.
		따라서 부모와 자식은 자신만의 변수를 가질 수 있으며, 변수명이 동일 할 수 있다.*/
		b.speak();
		b.drive();
	}
}
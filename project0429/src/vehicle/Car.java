package vehicle;
class Car{
	/*
	메소드 명은 소중하다. 직관성 부여하기 위해 힘들게 찾아서 작명.
	하지만 큰 차이가 없는 상황에서는 오버로딩(overoading)- 메소드 중첩 이용.
	오버로딩이란? 메소드 명은 같지만 완전히 일치하게 정의하는 것이 아니라,
	매개변수의 자료형과 개수가 틀리면 중복정의로 간주하지 않음.
	즉, 개발자가 비슷한 로직으로 메소드 정의 할 경우 큰 차이가 없을 경우
	메소드 명을 전혀 다르게 줘야하는 불편함을 해소 할 수 있다.
	*/
	public void run(){
		System.out.println("자동차가 달린다.");
	}
	public void run(int vel){
		System.out.println("자동차가 조금 빨리 달린다.");
	}
	public void run(boolean flag){
		System.out.println("자동차가 빨리 달린다.");
	}
}
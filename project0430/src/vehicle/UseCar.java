package vehicle;

class UseCar{
	public static void main(String args[]){
		Car car= new ElectricCar();
		car.turnOnLight();
		car.tick(); // 자식이 오버라이딩했을 경우 부모가 아니라 자식것을 호출-> 다형성을 이용
		/*
		원칙) 상속관계에 있는 인스턴스는 자료형을 기준으로 찾아가 사용.
		ex) Bird b= new Duck();
			  b. 로 접근 할 수 있는 인스턴스는 Bird의 인스턴스를 접근 가능.
		예외) 자식이 부모의 메소드를 오버라이딩 했을 경우 레버펀스 변수가 부모건 자식이건
			   무조건 업그레이드 된 메소드를 최 우선으로 호출.
		*/
	}
}
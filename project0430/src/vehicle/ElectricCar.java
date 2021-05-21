package vehicle;

public class ElectricCar extends Car{
	// 부모의 로직이 적절하지 않은 경우 로직을 재정의 할 수 있음.-> 오버라이딩(overriding)
	// 주의: 오버라이딩은 부모의 메소드랑 완전 동일. 메소드가 다르면 새로운 매소드이므로 오버라이딩 x
	public void tick(){
		System.out.println("전기동력엔진이 동작.");
	}
	public void stop(){
		System.out.println("전기동력엔진이 멈춤.");
	}
}
// 이렇게 같이 짜면 코드의 재사용성이 현저히 낮아짐.
class Car{
	String name= "BMW";
	int price= 9000;
	String color= "Balck";

	public void setPrice(int price){
		this.price=price;
	}
	// 메인부분
	public static void main(String args[]){
		Car c1= new Car();
		Car c2= new Car();
		Car c3= c2; // 속지말기. 실제로는 Car는 2대만 올라옴

		// c1만 값을 변경
		c1.setPrice(8000);
		System.out.println(c1.price);
		System.out.println(c2.price);// 두번째 자동차가 영향을 받앗는지 여부 체크
		// 결론: 메모리에 올라간 인스턴스들은 서로 다른 별개의 객체들이다.

		// c3가 지닌 가격을 바꿀 시 c2의 값은 영향을 받을 것인가?
		c3.setPrice(7000);
		System.out.println(c2.price);
		// 결론: c3는 c2가 가리키고 있는 자동차와 동일한 차를 가리키므로 가격 조정에 영향을 받는다.
	}
}
package vehicle;
/*과제: 자동차의 인스턴스를 생성하고, 그 자동차가 보유한 엔진의 이름 및 바퀴의 가격을
출력하시오!!*/
class UseCar extends Car{
	 public static void main(String args[]){
		Car c= new Car();
		// 엔진을 존재시키기.(방법 1)
		// c.e= new Engine();

		// 방법 2 Car에서 미리 호출
		System.out.println(c.e.name);
		System.out.println(c.w.price); 
	 }
}




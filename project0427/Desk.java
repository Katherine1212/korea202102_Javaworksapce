public class Desk{ 

		int x; 

		static int y; 

		/*
		굳이 반복문을 포함하여 코드를 수행하고 싶다면 {}통해 블럭을 생성.
		이 클래스인 Desk로부터 인스턴스가 생성될 때 마다 아래의 코드가 실행
		
		1. 인스턴스 초기화 블럭({}): 해당 인스턴스가 생성될 때 동작하는 코드 영역.(생성자 역할과 비슷)
		2. static 초기화 블럭(static{}): 실행 직전에 초기화 블럭이 동작.
		*/ 
		{ // A -->

			for(int i=0;i<10;i++){ 

			x++; 

			} 

		} 

		 
		static { // B -->class가 로드 될 때 동작함. 즉, main method 호출 시(실행 시) 동작.

			for(int i=0;i<20;i++){ 

			y++; 

			} 

		} 

			
		public static void main(String[] args){ 

			System.out.println(x); // C
			// --> 접근 불가! 메모리에 올라 온 적도, static영역에서 refernce변수 없이 x 접근 할 수 없음.

			int a=new Desk().x; // D 
			// --> (위의 for문 돌면서) x값이 10까지 누적 생성한 것을 a에 담음

			System.out.println(a); // E 
			// -->

			System.out.println(y); // F 
			// --> (위의 for문 돌면서) y값이 20까지 누적.

			} 

	} 
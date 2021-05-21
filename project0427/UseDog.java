// 이 클래스는 현실의 사물을 표현하기 위함이 아닌 메인을 두기 위한 실행용 클래스
class UseDog{
	public static void main(String args[]){
		// Dog을 메모리에 올리려면 실행 해야하며, Dog의 인스턴스를 생성해야함.
		// String name= new Dog().getName();
		// System.out.println(name);

		/* 강아지 나이를 3세로 바꾼 후 출력
		 java 와 같은 객체지향언어는 개발자가 자료형을 정의 할 수 있음.
		이 정의는 class를 단위로 작성. 개발자가 정의한 자료형을 "사용자정의 자료형"이라고 함.
		ig) 개발자가 Dog라는 클래스 정의를 했다면 그것은 Dog형을 탄생시킨 것.
		이 시점부터는 oop안에서는 자료형이 총 4개라고 할 수 있다. 
		*/

		// 나이 변경
		Dog d2= new Dog(); // Dog형으로 자료형 선언
		System.out.println("강아지의 변경 전 나이는 "+d2.getAge());
		d2.age= 3;
		System.out.println("강아지의 변경 된 나이는 "+d2.getAge());
		// 이름 변경
		System.out.println("강아지의 변경 전 이름 "+d2.getName());
		d2.name= "Louis";
		System.out.println("강아지의 변경 된 이름 "+d2.getName());


	}
}

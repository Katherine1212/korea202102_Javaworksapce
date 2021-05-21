package animal.mydog;
/*
상속에서 놓치지 말아야 할 핵심 주제.
1) 코드의 재사용.
2) 객체간 형변환(시험 단골)
*/
class UseDog{
	public static void main(String args[]){
		// [기본 자료형의 형변환의 예]
		int x= 7; // 4 byte큰 자료형
		byte b= 3; // 1byte 작은 자료형
		x= b; // 가능

		// [객체 자료형의 형 변환의 예]
		Bird bird= new Bird("White");
		Duck duck= new Duck("Yellow");

		//-----------------------------------------위에까지 총 3개(Bird, Duck, Bird내 Duck)

		bird=duck; // 기본자료형에 비추어 용량문제로 접근 x. 객체간 형변환은 상위자료형이 더 큰 자료형
		// bird.swim();  bird변수의 자료형은 Bird이기때문에 Bird내 swim 메소드가 없으니 에러.
		Duck duck=(Duck)bird; // 객체간 형변환 가능. 자식 자료형으로 형변환 시 손실 생기나 가능
										   // 이것을 downCasting이라고 함
		duck.swim();
	} 
}
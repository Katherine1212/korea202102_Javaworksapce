// 현실의 강아지를 정의하자
class Dog{
	// 강아지가 가질 수 있는 속성들을 변수로 선언
	// 하나의 class가 보유한 변수들은 현실의 객체를 반영한 상태, 속성을 표현했다고 하여 property(속성)이라고 함.
	int age=5;
	String color="White"; // char는 문자 1개 담으나 String은 문자열을 객체로 담음
	String name="뽀미";

	// 함수 즉 메소드 정의.(JS와 살짝 다름. 그러나 전체적인 틀은 동일)
	public void run(){ // public- 접근 제한자, void- 해당 메소드가 반환값이 없다.
		System.out.println(name+"가 뛰어요");
	}
	public String getName(){ // String을 반환하는 메소드
		return name;
	}
	public int getAge(){ // int를 반환하는 메소드
		return age;
	}
}
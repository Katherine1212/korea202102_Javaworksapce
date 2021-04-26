/* 이 클래스는 객체 표현을 위함이 아니라 실행하기 위한 클래스*/
class UseDog{
	// 자바의 실행부 작성(js로 굳이 말하면 script영역)
	// main method는 특별하기에 개발자가 직접 호출은 불가.
	// java.exe파일에 의해 호출
	public static void main(String[] args){
		Dog d= new Dog(); // 내가 만든 자료형이기에 사용자 정의 자료형이라고함.
		System.out.print(d.name);
	}
}
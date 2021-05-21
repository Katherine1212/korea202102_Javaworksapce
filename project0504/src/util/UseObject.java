package util;
class UseObject{
	public static void main(String[] args){
		ObjectTest ot= new ObjectTest();
		String str= "Korea";
		boolean result= ot.equals(str);
		System.out.println(result);
		/*
		위의 코드에서 equals()는 objTest내에서 직접 정의 한 적이 없음.
		근데 왜 에러가 발생하지 않는가? -> 시스템에 의해 이미 존재하고있다는 증명.
		원인: 개발자가 명시하지 않더라도 자바언어에서 최상위 어버이 클래스인 Object 클래스로부터
		상속받은 상태이기에 에러가 안 남.
		*/
		System.out.println(ot);
		/*
		ot는 객체이므로 문자열이 아니다.
		하지만 System.out.println()으로 출력을 시도할 때 문자열 화 되어 그 주소값등이 반환.
		우리는 toString()호출 한 적이 없지만, 문자열 화 될 때 obj 클래스로부터 상속받은
		toString()메소드가 자동으로 호출 된 것
		*/
	}
}
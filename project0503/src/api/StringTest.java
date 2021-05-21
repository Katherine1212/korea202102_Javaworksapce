/*
현재까지는 내가 정의한 클래스 위주로 공부.
실제 개발 시에는 Sun에서 지원하는 유용한 클래스들을 주로 사용.
Sun에서 제공하는 여러 클래스 중 문자열 처리시 중요한 기능을 감당하는
String class에 대해 학습
*/
package api;
class StringTest{
	public static void main(String[] args){
		/*String도 import 한 적이 없어 에러가 나야하지만, 많이 사용되는 유용한 class들은
		개발자가 명시하지 않아도 이미 기본적으로 import되어 있음.
		java.lang 패키지가 그것임.*/ 
		String s= new String("apple"); 
		/*
		String 클래스의 api document를 이용하여 개발자는 여러 기능들을 참조가능.
		*/
		// 문자열의 길이
		System.out.println("문자열의 길이는 "+s.length());
		// 대문자로 변경
		System.out.println(s.toUpperCase());
		// 두번째 p의 index를 반환
		System.out.println("마지막 p의 index of는 "+s.lastIndexOf("p"));
		// 원하는 번째에 있는 문자 1개를 추출
		System.out.println("원하는 순번째 알파벳은 "+s.charAt(3));
	}
}
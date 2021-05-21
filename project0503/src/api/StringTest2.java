package api;
public class StringTest2{
	public static void main(String[] args){
		/*String은 객체지만 기본자료혀어럼 객체를 생성하는 방법을 지원.
		implicit(암시적/묵시적)생성법이라고 함.*/
		String str1= "apple"; // 객체
		String str2= "apple"; // 객체
		System.out.println(str1==str2);
		/* 한번 만들어진 인스턴스랑 같은 것이 생성이 되려고 하면 
		콘스턴트에서 중복을 방지하기 위해 동일한 것을 지칭.
		주소값 비교지만, 같은 주소를 가리키므로 true.*/

		/* String 도 class이므로 생성자 이용
		explicit(명시적)생성법*/
		String s1= new String("korea");
		String s2= new String("korea");
		System.out.println(s1==s2);
		/*
		명시적 생성법으로 String객체를 생성하면 효율성 여부와 관계없이 
		constant pool에 만들어짐.
		따라서 s1과s2가 가리키고 있는 개체의 인스턴스/주소값가 다르므로 false.
		*/
	}
}

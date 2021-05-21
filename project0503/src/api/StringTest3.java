package api;
public class StringTest3{
	public static void main(String[] args){
		
		String s1= "apple"; 
		String s2= "apple"; 
		// s1,s2는 레퍼런스 변수이기에 비교연산자는 서로의 주소값을 비교
		System.out.println(s1==s2);

		// 내용 비교(명시적인 경우에는 꼭 필요!)
		boolean result= s1.equals(s2);
		System.out.println("두 문자열의 내용 비교 결과는 "+result);
		
	}
}

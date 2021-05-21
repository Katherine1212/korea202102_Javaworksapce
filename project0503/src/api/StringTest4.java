package api;
public class StringTest4{
	public static void main(String[] args){
		/*
		String class를 가리켜 immutable(불변)의 속성이 있다.
		*/
		String s1= "Korea";
		s1= s1+" vs USA"; 
		System.out.println(s1);

		// 무서운 코드
		/*아래의 코드는 result가 변경되는 것이 아니라 result와 같은 값에
		계속 새오룬 문자열이 생성. for문 만큼 문자열 상수가 메모리에 올라옴.*/
		//String result="";
		//for(int i=0; i<10; i++){
		//	result+=:"apple"+i;
		// }
		/*문제 해결하는 법은 수정 가능한 문자열 처리 관련 api를 지원
		StringBuffer, StringBuilde 객체 이용*/
		StringBuffer sb= new StringBuffer(); // 스트링버퍼클래스임. 스트링 아님
		sb.append("야호");
		sb.append("나는");
		sb.append("자바가");
		sb.append("좋아");
		System.out.println(sb.toString());
	}
}

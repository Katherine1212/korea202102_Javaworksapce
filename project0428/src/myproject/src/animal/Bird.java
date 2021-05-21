package animal; // 컴파일 시 해당 class의 .class를 animal이란 pkg를 자동 생성하여 넣음.(javac -d)
// pkg에 넣어둔 클래스는 공개로 해야 접근 가능. 공개 결정 짓는 키워드- public(접근제어자)
public class Bird{
	String name="제비";
	public void fly(){
		System.out.println(name+"가 날아가유");
	}
}
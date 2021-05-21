package animal.birds;
/*
아래의 코드의 상속관계가 같은 종류가 될 수 있다는 근거.
1) 자바에서는 기본 자료형들의 유형은 크게 3가지로 분류
	문자, 숫자, 논리값
	특히 숫자(byte, short, int, long, float, double)와(과) char(0포함 양수)들간에는
	서로 같은 종류의 자료형으로 보고 형변환이 가능하다.
2) 자바의 자요형은 총 4가지로서 객체자료형도 자료형이다.
3) 결론: 2번과 같이 객체자료형도 자료형이라면 기본자료형들간에 적용되었던 객체간
		   형변환이 객체자요형에도 적용이 되어야한다. -> 자료형에 속하니까.
4) 문제: 	사용자가 만든 자료형인 클래스간에도 같은 종류의 자료형이 있을 수 있다. 
			상속을 이용하면 부모, 자식간의 관계가 형성되고, 부모,자식 간의 관계를 우리는
			같은 종류의 자료형으로 볼 수 있다.
*/
public class Duck extends Bird{
	String name="오리";
	String color;

	public Duck(String color){
		super(color);
		this.color= color; 
	}
	 public void swim(){
		System.out.println("수영도 잘 하지");
	 }
}
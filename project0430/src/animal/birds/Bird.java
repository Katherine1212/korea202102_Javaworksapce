package animal.birds;
/* 조류의 최상위 객체를 정의. 새로서 가질 수 있는 보편적인 특징을 정의함.*/
public class Bird{
	String name= "그냥 새";
	boolean wing= true;
	String color;

	public Bird(String color){
		this.color= color;
	}

	public void fly(){
		System.out.print(name+"날다");
	}
}
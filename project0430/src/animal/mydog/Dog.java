package animal.mydog;

public class Dog{
	String name="멈머";
	int age;
	boolean tail= true;

	public Dog(int age){
		this.age= age;
	}

	public void barking(){
		System.out.println(name+"짖고있다.");
	}
	public void walk(){
		System.out.println(name+"산책갈까? 산책?!");
	}
}
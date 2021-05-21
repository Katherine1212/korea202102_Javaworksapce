package race;
public class Human{
	int IQ= 90;
	boolean hasName= true;

	public Human(int IQ){
		this.IQ= IQ;
		System.out.println("초기화");
	}
	public void speak(){
		System.out.println("언어 있지");
	}
	public void drive(){
		System.out.println("운전 가능");
	}
}
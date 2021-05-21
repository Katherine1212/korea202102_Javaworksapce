package use;
import traffic.Bike; // traffic 이전 디렉토리는 classpath 에서 참조
class UseBike{
	public static void main(String[] args){
		Bike b= new Bike();
		b.run();
	}
}
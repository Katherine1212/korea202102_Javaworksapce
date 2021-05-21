package PocketBall; // 이 class가 포켓볼 디렉토리에 있음을 선언.(Java는 디렉토리를 패키지라고함)
// 패키지에 넣은 클래스는 아무도 접근 할 수 없기 때문에 공개로!
public class PocketMon{
	String name= "Pika";
	int level= 19; // 전투력

	public void sound(){
		System.out.println("삐까삐까");
	}
}
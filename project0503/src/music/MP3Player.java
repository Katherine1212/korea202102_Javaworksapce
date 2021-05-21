package music;
import riding.Roller;
import aircraft.Zetwing;
/*
추상클래스를 상속받게되는 자식은 부모가 불완전하게 남겨놓은 불완전 메소드를 완성할 의무가 있음.
불환전한 메소드를 구현강제를 강요당함.(부모가 완성 못하면 자식이 상속받아 완성 해야함)
결론: 추상 클래스를 상속받은 자식은 부모가 완성하지 못한 추상메소드를 오버라이딩해야 함.

java에서는 다중 상속을 금지. 즉 자식 클래스가 .class를 부모로 둔다면 더이상 다른 클래스를 추가해
부모로 지정 할 수 없음.
*/
public class MP3Player extends MusicPlayer implements Roller, ZetWing{
	public void setVolume(){
		System.out.println("MP3플레이어의 볼륨을 조절합니다.");
	}
	public void openMP3(){
		System.out.println("MP3파일을 지원합니다.");
	}
	public void roll(){
		System.out.println("롤러블레이드를 지원합니다.");
	}
	public void fly(){
		System.out.println("하늘을 날 수 있습니다.");
	}
}
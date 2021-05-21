/* 현재 패키지와는 다른 패키지에 있는 클래스 사용하기*/
package use;
/*
이 클래스에서 사용하고 싶은 외부에 존재하는 클래스는 import명령어로 명시.
주의, 사용하고자하는 클래스의 형태는 원본이 아니라 사용가능한 .class
따라서 bin 디렉토리 밑에 있는 클래스의 위치를 지정.

자바는 디켁토리라는 말도 쓰지 않고 패키지라고 하며 패키지는 . 으로 구분
*/
import PocketBall.PocketMon;
class UseMon{
	public static void main(String[] args){
		PocketMon mon= new PocketMon();
	}
}
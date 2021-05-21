package douse;
// class path 참조 경로 밑에서부터 작성
import animal.Bird;
// 쓰임을 당하는 class만 public명시. 쓰는 class는 그대로 쓰기
class UseBird{
	public static void main(String[] args){
		// 나와 다른 경로에 있는 class 인 Bird를 사용
		 Bird b= new Bird();
		 b.fly();
	}
}
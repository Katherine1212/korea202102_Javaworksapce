package animal.birds;
class UseDuck{
	public static void main(String args[]){
		Duck d= new Duck("yellow"); // 얘는 초기화 시 컬러를 받음
		d.swim();

		/* 
			byte short int long 숫자형은 서로 같은 종류의 자료형이다.
			같은 종류의 자료형이기에 서로 형 변환이 가능.
			
			객체형도 자료형이다.
		*/
		byte b= 5;
		int k= b;
	}
}
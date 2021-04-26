/*
실수 자료형에 대해 학습하자.
실수 자료형은 소수점을 표현할 수 있는 숫자형 자료형.
float: 4byte
double: 8byte
*/
class Numtype2{
	public static void main(String[] args){
	/* 왜 float x= 27496.345;는 에러가 뜰까?
	실수는 더블이 디폴트이기에 개발자가 디폴트를 무시하려면 f를 붙인다.
	시스템에서 무조건 더블로 올라가기때문.
	27496.345f;로 작성해야함.*/
		float x= 27496.345f;
		// double x= 27496.345;
	}
}

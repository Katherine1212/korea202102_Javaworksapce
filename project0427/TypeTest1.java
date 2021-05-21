/*자료형과 관련된 학습 연장*/
class TypeTest1{
	public static void main(String[] args){
		/* byte(1) short(2) int(4) long(8) float(4) double(8) char(2) boolean(1)*/
		
		/* 1
		byte b= 5; // 1byte 차지하는 숫자형
		short s= 8; // 2byte 차지하는 숫자형
		s=b; // 1byte짜리가 2byte안에 들어가는 것은 자연스러우므로 가능!
		b=s; // 2byte짜리가 1byte안에 들어가려고 하니 에러 발생.(데이터손실)
		*/

		/* 2
		아래의 코드가 에러가 발생하는 이유.
		고전적으로 C언어를 포함하여, 현대의 컴퓨터 언어에 이르기까지
		정수의 연산은 int를 기준으로 최적화 되어있기 때문에,
		연산시 int이하의 자료형들은 컴파일러 의해 자동으로 자료형을 int 형으로 변환해 버린다.
		이러한 현상을 개발자에 의해서가 아닌 system에 의한 형 변환이므로 '자동형변환'이라고 함.
		
		[Solution]
		1. short result를 int result로 선언.
		ig) int result= s1+s2;

		2. 손실을 감안하고 강제로 short으로 진행. -> 강제 형 변환
		ig) short result=(short)(s1+s2);
		(자료형) result= (자료형)(연산);
		이때 (자료형)를 cast 연산자라고 함.
		short s1=8;
		short s2=9;
		short result= s1+s2; // +연산 수행 전 시스템이 s1 과 s2를 int로 변환 후 연산 수행.
		*/
		

		/* 2
		아래의 코드가 에러가 발생하는 이유.
		int형 이하의 자료형들에 대해서만! 자동형변환이 일어나기때문에.
		그럼 왜? int이하의 자료형들만 자동형변환이 되느냐?
		- 손실을 감수하면서 까지 자동형변환을 할 이유가 없음.
		컴파일러가 연산을 수행 시 연산 대상이 되는 데이터는 무조건 같은 자료형으로 수평을 맞추고 수행.
		이때, 데이터 손실이 생기지 않도록 큰 자료형을 기준으로 형변환이 된다.

		아래의 코드는 long이 있으니 자동형변환이 일어나지 않았음.
		
		[Solution]
		1. 큰 자료형에 따라서 바꿔주자.
		ig) long result2= x+k;
		2. 손실 감안하면서 "강제형변환"
		int result2=(int)(x+k);

		long x= 65;
		int k= 78;
		int result2= x+k;
		*/
	}
}
package bank;
/*
자바는 클래스간 서로 사용이 가능하므로 보안 상 뜻하지 않은문제가 발생 할 수 있기 때문에 
이를 보안하기 위해 "접근제한자"라는 보안처리를 지원.
자바의 보안처리는 다음과 같이 총 4단계로 구성
(약함-강함)
public< protected< default< private
1. public- 공개
2. protected- 상속관계 or 같은 pkg내 접근 가능
3. default- 같은 pkg내에서만 접근가능
4. private- 나만 사용가능

*/
public class Account{
	// 기재 안 되어 있으면 기본은 default
	private String bankName="ShinHan";
	private String master="Katherine";
	private int balance=5000; // 멤버 메소드만 이 변수를 접근 가능.(즉 이 파일 내에서만 접근가능)
	// 계좌번호는 int 로 가면 0이 의미가 없어짐. 연산 목적 아님. - 때문에 String으로 진행
	String num="110-455-811448";

	/* 데이터를 보호하고, 사용 할 수 있는 메소드를 제공해 줘야 개발 가능하므로 \
	이렇게 습관화, 관례화 된 메소드 정의 기법을 가리켜 setter, getter 라고 함.
	setter, getter 메소드의 정의 규칙: get변수, set변수(첫 철자는 대문자)*/
	
	
	//데이터에 대한 직접 접근은 막았으나, 선의의 사용자도 접근 못하게 됨.
	// 선의의 사용자가 접근 할 수 있는 장치를 마련.
	
	public void setBalance(int balance){ // 변경용 setter
		this.balance= balance;
	}
	// 값을 반환 받아갈 수 있는 메소드 정의(return 값 있음)
	public int getBalance(){ // 변경 확인용 getter
		return balance;
	}


	// maseter
	public void setMaster(String balance){
		this.master= master;
	}
	public String getMaster(){
		return master;
	}

	// bankName
	public void setBankName(String bankName){
		this.bankName= bankName;
	}
	public String getBankName(){
		return bankName;
	}

	// num
	public void setNum(String num){
		this.num= num;
	}
	public String getNumr(){
		return num;
	}
}
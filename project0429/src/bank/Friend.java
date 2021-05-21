package bank;
// 직접 접근은 못하니, 간접 접근
class Friend{
	public static void main(String[] args){
		Account acc= new Account();
		/* 
		System.out.println("친구의 조작 전 잔고"+acc.balance);
		직접 접근대신 메소드 호출로 데이터 변경
		acc.balance= acc.balance+8000;
		System.out.println("친구의 조작 후 잔고"+acc.balance); */

		// private 으로 막혀도 접근 가능하도록 조작.
		System.out.println("친구의 조작 전 잔고"+acc.getBalance());
		acc.setBalance(8000);
		System.out.println("친구의 조작 후 잔고"+acc.getBalance());

		/*현재 Friend class는 Account와 같은 pkg에 있으므로,
		Account 가 보유한 default  접근 제한이 걸려잇는 모든 변수에 마음대로 접근 가능*/
		System.out.println("은행명: "+acc.bankName);
		System.out.println("계좌주: "+acc.master);
		System.out.println("계좌번호: "+acc.num);

	}
}
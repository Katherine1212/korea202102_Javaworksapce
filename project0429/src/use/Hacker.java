// Account와는 다른 pkg 내에서 접근 제한 실습
package use;
import bank.Account;
class Hacker{
	public static void main(String[] args){
		// bank를 메모리에 올리고 바꾸기.

		// bank.Account acc= new bank.Account(); // 인라인 css느낌 유지보수 어려움
		Account acc= new Account();

		/* private 없으면 해당 방법으로 접근 가능.
		즉, 아래의 코드는 pkg 위치와 상관 없이 balance 변수가 private인 경우에는 그 누구도 접근 불가
		System.out.println("현재"+acc.amster+"가/이 보유한 잔고는"+acc.balance);
		*/

		/*현재 Friend class는 Account와 다른 pkg에 있으므로,
		Account 가 보유한 default  접근 제한이 걸려잇는 모든 변수에 마음대로 접근 불가능*/
		System.out.println("은행명: "+acc.bankName);
		System.out.println("계좌주: "+acc.master);
		System.out.println("계좌번호: "+acc.num);



	}
}
// Account�ʹ� �ٸ� pkg ������ ���� ���� �ǽ�
package use;
import bank.Account;
class Hacker{
	public static void main(String[] args){
		// bank�� �޸𸮿� �ø��� �ٲٱ�.

		// bank.Account acc= new bank.Account(); // �ζ��� css���� �������� �����
		Account acc= new Account();

		/* private ������ �ش� ������� ���� ����.
		��, �Ʒ��� �ڵ�� pkg ��ġ�� ��� ���� balance ������ private�� ��쿡�� �� ������ ���� �Ұ�
		System.out.println("����"+acc.amster+"��/�� ������ �ܰ��"+acc.balance);
		*/

		/*���� Friend class�� Account�� �ٸ� pkg�� �����Ƿ�,
		Account �� ������ default  ���� ������ �ɷ��մ� ��� ������ ������� ���� �Ұ���*/
		System.out.println("�����: "+acc.bankName);
		System.out.println("������: "+acc.master);
		System.out.println("���¹�ȣ: "+acc.num);



	}
}
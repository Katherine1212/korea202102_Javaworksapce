package bank;
// ���� ������ ���ϴ�, ���� ����
class Friend{
	public static void main(String[] args){
		Account acc= new Account();
		/* 
		System.out.println("ģ���� ���� �� �ܰ�"+acc.balance);
		���� ���ٴ�� �޼ҵ� ȣ��� ������ ����
		acc.balance= acc.balance+8000;
		System.out.println("ģ���� ���� �� �ܰ�"+acc.balance); */

		// private ���� ������ ���� �����ϵ��� ����.
		System.out.println("ģ���� ���� �� �ܰ�"+acc.getBalance());
		acc.setBalance(8000);
		System.out.println("ģ���� ���� �� �ܰ�"+acc.getBalance());

		/*���� Friend class�� Account�� ���� pkg�� �����Ƿ�,
		Account �� ������ default  ���� ������ �ɷ��մ� ��� ������ ������� ���� ����*/
		System.out.println("�����: "+acc.bankName);
		System.out.println("������: "+acc.master);
		System.out.println("���¹�ȣ: "+acc.num);

	}
}
package bank;
/*
�ڹٴ� Ŭ������ ���� ����� �����ϹǷ� ���� �� ������ ���������� �߻� �� �� �ֱ� ������ 
�̸� �����ϱ� ���� "����������"��� ����ó���� ����.
�ڹ��� ����ó���� ������ ���� �� 4�ܰ�� ����
(����-����)
public< protected< default< private
1. public- ����
2. protected- ��Ӱ��� or ���� pkg�� ���� ����
3. default- ���� pkg�������� ���ٰ���
4. private- ���� ��밡��

*/
public class Account{
	// ���� �� �Ǿ� ������ �⺻�� default
	private String bankName="ShinHan";
	private String master="Katherine";
	private int balance=5000; // ��� �޼ҵ常 �� ������ ���� ����.(�� �� ���� �������� ���ٰ���)
	// ���¹�ȣ�� int �� ���� 0�� �ǹ̰� ������. ���� ���� �ƴ�. - ������ String���� ����
	String num="110-455-811448";

	/* �����͸� ��ȣ�ϰ�, ��� �� �� �ִ� �޼ҵ带 ������ ��� ���� �����ϹǷ� \
	�̷��� ����ȭ, ����ȭ �� �޼ҵ� ���� ����� ������ setter, getter ��� ��.
	setter, getter �޼ҵ��� ���� ��Ģ: get����, set����(ù ö�ڴ� �빮��)*/
	
	
	//�����Ϳ� ���� ���� ������ ��������, ������ ����ڵ� ���� ���ϰ� ��.
	// ������ ����ڰ� ���� �� �� �ִ� ��ġ�� ����.
	
	public void setBalance(int balance){ // ����� setter
		this.balance= balance;
	}
	// ���� ��ȯ �޾ư� �� �ִ� �޼ҵ� ����(return �� ����)
	public int getBalance(){ // ���� Ȯ�ο� getter
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
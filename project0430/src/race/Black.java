package race;
// �޸��� ������ ���� ������. �ߺ� ���� �� �ʿ� ���� ������ ���� Ư¡�� ����.
public class Black extends Human{
	/*
	�θ��� �ʱ�ȭ
	public Black(){
		super();
	}
	
	�θ��� �����ڿ� �Ű������� �����Ѵٸ�, ���̻� ���� Ŭ������ ����Ʈ �����ڿ� ���� �� �� ����.
	���� �����ڰ� �θ��� �μ��� �ִ� �����ڸ� ���� ȣ���ؾ� ���� �� ��.
	*/
	public Black(){
		super(110); // super �����ڴ� �׻� �� �տ� ��ġ�ؾ���.(�θ� �����ؾ� �ڽ��� ����)
		System.out.println("���� �ʱ�ȭ");
		
	}
	String color="black";
	int IQ=110;
	public void run(){
		System.out.println("������ �� �Ѵ�.");
	}

}
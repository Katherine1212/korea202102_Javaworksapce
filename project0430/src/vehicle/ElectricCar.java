package vehicle;

public class ElectricCar extends Car{
	// �θ��� ������ �������� ���� ��� ������ ������ �� �� ����.-> �������̵�(overriding)
	// ����: �������̵��� �θ��� �޼ҵ�� ���� ����. �޼ҵ尡 �ٸ��� ���ο� �żҵ��̹Ƿ� �������̵� x
	public void tick(){
		System.out.println("���⵿�¿����� ����.");
	}
	public void stop(){
		System.out.println("���⵿�¿����� ����.");
	}
}
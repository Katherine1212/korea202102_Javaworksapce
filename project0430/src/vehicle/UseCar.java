package vehicle;

class UseCar{
	public static void main(String args[]){
		Car car= new ElectricCar();
		car.turnOnLight();
		car.tick(); // �ڽ��� �������̵����� ��� �θ� �ƴ϶� �ڽİ��� ȣ��-> �������� �̿�
		/*
		��Ģ) ��Ӱ��迡 �ִ� �ν��Ͻ��� �ڷ����� �������� ã�ư� ���.
		ex) Bird b= new Duck();
			  b. �� ���� �� �� �ִ� �ν��Ͻ��� Bird�� �ν��Ͻ��� ���� ����.
		����) �ڽ��� �θ��� �޼ҵ带 �������̵� ���� ��� �����ݽ� ������ �θ�� �ڽ��̰�
			   ������ ���׷��̵� �� �޼ҵ带 �� �켱���� ȣ��.
		*/
	}
}
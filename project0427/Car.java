// �̷��� ���� ¥�� �ڵ��� ���뼺�� ������ ������.
class Car{
	String name= "BMW";
	int price= 9000;
	String color= "Balck";

	public void setPrice(int price){
		this.price=price;
	}
	// ���κκ�
	public static void main(String args[]){
		Car c1= new Car();
		Car c2= new Car();
		Car c3= c2; // ��������. �����δ� Car�� 2�븸 �ö��

		// c1�� ���� ����
		c1.setPrice(8000);
		System.out.println(c1.price);
		System.out.println(c2.price);// �ι�° �ڵ����� ������ �޾Ѵ��� ���� üũ
		// ���: �޸𸮿� �ö� �ν��Ͻ����� ���� �ٸ� ������ ��ü���̴�.

		// c3�� ���� ������ �ٲ� �� c2�� ���� ������ ���� ���ΰ�?
		c3.setPrice(7000);
		System.out.println(c2.price);
		// ���: c3�� c2�� ����Ű�� �ִ� �ڵ����� ������ ���� ����Ű�Ƿ� ���� ������ ������ �޴´�.
	}
}
package vehicle;
/*����: �ڵ����� �ν��Ͻ��� �����ϰ�, �� �ڵ����� ������ ������ �̸� �� ������ ������
����Ͻÿ�!!*/
class UseCar extends Car{
	 public static void main(String args[]){
		Car c= new Car();
		// ������ �����Ű��.(��� 1)
		// c.e= new Engine();

		// ��� 2 Car���� �̸� ȣ��
		System.out.println(c.e.name);
		System.out.println(c.w.price); 
	 }
}




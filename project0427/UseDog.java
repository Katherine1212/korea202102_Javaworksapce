// �� Ŭ������ ������ �繰�� ǥ���ϱ� ������ �ƴ� ������ �α� ���� ����� Ŭ����
class UseDog{
	public static void main(String args[]){
		// Dog�� �޸𸮿� �ø����� ���� �ؾ��ϸ�, Dog�� �ν��Ͻ��� �����ؾ���.
		// String name= new Dog().getName();
		// System.out.println(name);

		/* ������ ���̸� 3���� �ٲ� �� ���
		 java �� ���� ��ü������� �����ڰ� �ڷ����� ���� �� �� ����.
		�� ���Ǵ� class�� ������ �ۼ�. �����ڰ� ������ �ڷ����� "��������� �ڷ���"�̶�� ��.
		ig) �����ڰ� Dog��� Ŭ���� ���Ǹ� �ߴٸ� �װ��� Dog���� ź����Ų ��.
		�� �������ʹ� oop�ȿ����� �ڷ����� �� 4����� �� �� �ִ�. 
		*/

		// ���� ����
		Dog d2= new Dog(); // Dog������ �ڷ��� ����
		System.out.println("�������� ���� �� ���̴� "+d2.getAge());
		d2.age= 3;
		System.out.println("�������� ���� �� ���̴� "+d2.getAge());
		// �̸� ����
		System.out.println("�������� ���� �� �̸� "+d2.getName());
		d2.name= "Louis";
		System.out.println("�������� ���� �� �̸� "+d2.getName());


	}
}

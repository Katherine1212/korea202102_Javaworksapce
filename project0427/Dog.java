// ������ �������� ��������
class Dog{
	// �������� ���� �� �ִ� �Ӽ����� ������ ����
	// �ϳ��� class�� ������ �������� ������ ��ü�� �ݿ��� ����, �Ӽ��� ǥ���ߴٰ� �Ͽ� property(�Ӽ�)�̶�� ��.
	int age=5;
	String color="White"; // char�� ���� 1�� ������ String�� ���ڿ��� ��ü�� ����
	String name="�ǹ�";

	// �Լ� �� �޼ҵ� ����.(JS�� ��¦ �ٸ�. �׷��� ��ü���� Ʋ�� ����)
	public void run(){ // public- ���� ������, void- �ش� �޼ҵ尡 ��ȯ���� ����.
		System.out.println(name+"�� �پ��");
	}
	public String getName(){ // String�� ��ȯ�ϴ� �޼ҵ�
		return name;
	}
	public int getAge(){ // int�� ��ȯ�ϴ� �޼ҵ�
		return age;
	}
}
class Phone{
	int price= 5000;
	String name= "Iphone 11";
	static String brand= "Apple"; // static�� �������� �̶� ���� ������.
	// static���� ����� ����, �޼ҵ�� new �� �� �ش� �ν��Ͻ��� �Ҽӵ��� �ʴ´�.(���� Ŭ������ ����)
	// static���� ����� ��� ������ Ŭ����������� ��.

	public void ring(){
		System.out.println("Ring Ding Dong~");
	}

	public static void main(String[] args){
		phone.company; // ������ �ܺο� ���� ��) class�� ������ class������ �̷��� ����
		String c= company; // ���ο� ���� ��
		Phone p1= new Phone();
	}
}
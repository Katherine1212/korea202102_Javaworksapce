package vehicle;
class Bus{
	String color;
	String seat;
	boolean camera;
	// �����ڷ� �޼ҵ� �ʱ�ȭ
	public Bus(){
		color="red";
		seat="���� ��Ʈ";
		camera= true;
	}
	// �Ϲ� �޼ҵ�� �ʱ�ȭ
	public void init(){
		color="red";
		seat="���� ��Ʈ";
		camera= true;
	}

	public static void main(String args[]){
		Bus b= new Bus();

		b.init();
	}
}
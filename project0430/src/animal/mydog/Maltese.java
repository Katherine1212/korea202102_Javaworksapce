package animal.mydog;

class Maltese extends Dog{
	String name="�ǹ�";
	int age;

	public Maltese(int age){
		super(age);
		this.age= age; 
	}
	 public void eat(){
		System.out.println(name+"�� �Գ�~");
	 }
}
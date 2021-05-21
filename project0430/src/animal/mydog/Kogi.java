package animal.mydog;

class Kogi extends Dog{
	String name="½Ä»§ÀÌ";
	int age;

	public Kogi(int age){
		super(age);
		this.age= age; 
	}
	 public void happy(){
		System.out.println(name+"½Å³µ³×!");
	 }
}
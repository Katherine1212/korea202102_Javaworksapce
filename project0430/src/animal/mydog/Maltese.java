package animal.mydog;

class Maltese extends Dog{
	String name="»Ç¹Ì";
	int age;

	public Maltese(int age){
		super(age);
		this.age= age; 
	}
	 public void eat(){
		System.out.println(name+"Àß ¸Ô³×~");
	 }
}
package shop;
public class Customer{
	// 아래의 class에 대해 변수는 private. 접근은 getter와 setter
	// 은닉화, encapsulation
	private String name; 
    private int age; 
    private boolean isMarry; 

	/*[접근(setter/getter)]*/
	// name
	public void setName(String name){
		this.name= name;
	}
	public String getName(){
		return name;
	}
	// age
	public void setAge(int age){
		this.age= age;
	}
	public int getAge(){
		return age;
	}
	//is marry
	public void setIsMarry(boolean isMarry){
		this.isMarry= isMarry;
	}
	public boolean getIsMarry(){
		return isMarry;
	}

}
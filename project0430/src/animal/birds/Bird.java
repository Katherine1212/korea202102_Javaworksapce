package animal.birds;
/* ������ �ֻ��� ��ü�� ����. ���μ� ���� �� �ִ� �������� Ư¡�� ������.*/
public class Bird{
	String name= "�׳� ��";
	boolean wing= true;
	String color;

	public Bird(String color){
		this.color= color;
	}

	public void fly(){
		System.out.print(name+"����");
	}
}
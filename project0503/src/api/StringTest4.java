package api;
public class StringTest4{
	public static void main(String[] args){
		/*
		String class�� ������ immutable(�Һ�)�� �Ӽ��� �ִ�.
		*/
		String s1= "Korea";
		s1= s1+" vs USA"; 
		System.out.println(s1);

		// ������ �ڵ�
		/*�Ʒ��� �ڵ�� result�� ����Ǵ� ���� �ƴ϶� result�� ���� ����
		��� ������ ���ڿ��� ����. for�� ��ŭ ���ڿ� ����� �޸𸮿� �ö��.*/
		//String result="";
		//for(int i=0; i<10; i++){
		//	result+=:"apple"+i;
		// }
		/*���� �ذ��ϴ� ���� ���� ������ ���ڿ� ó�� ���� api�� ����
		StringBuffer, StringBuilde ��ü �̿�*/
		StringBuffer sb= new StringBuffer(); // ��Ʈ������Ŭ������. ��Ʈ�� �ƴ�
		sb.append("��ȣ");
		sb.append("����");
		sb.append("�ڹٰ�");
		sb.append("����");
		System.out.println(sb.toString());
	}
}

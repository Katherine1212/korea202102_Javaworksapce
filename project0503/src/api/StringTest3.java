package api;
public class StringTest3{
	public static void main(String[] args){
		
		String s1= "apple"; 
		String s2= "apple"; 
		// s1,s2�� ���۷��� �����̱⿡ �񱳿����ڴ� ������ �ּҰ��� ��
		System.out.println(s1==s2);

		// ���� ��(������� ��쿡�� �� �ʿ�!)
		boolean result= s1.equals(s2);
		System.out.println("�� ���ڿ��� ���� �� ����� "+result);
		
	}
}

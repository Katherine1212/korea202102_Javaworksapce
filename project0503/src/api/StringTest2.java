package api;
public class StringTest2{
	public static void main(String[] args){
		/*String�� ��ü���� �⺻�ڷ���� ��ü�� �����ϴ� ����� ����.
		implicit(�Ͻ���/������)�������̶�� ��.*/
		String str1= "apple"; // ��ü
		String str2= "apple"; // ��ü
		System.out.println(str1==str2);
		/* �ѹ� ������� �ν��Ͻ��� ���� ���� ������ �Ƿ��� �ϸ� 
		�ܽ���Ʈ���� �ߺ��� �����ϱ� ���� ������ ���� ��Ī.
		�ּҰ� ������, ���� �ּҸ� ����Ű�Ƿ� true.*/

		/* String �� class�̹Ƿ� ������ �̿�
		explicit(�����)������*/
		String s1= new String("korea");
		String s2= new String("korea");
		System.out.println(s1==s2);
		/*
		����� ���������� String��ü�� �����ϸ� ȿ���� ���ο� ������� 
		constant pool�� �������.
		���� s1��s2�� ����Ű�� �ִ� ��ü�� �ν��Ͻ�/�ּҰ��� �ٸ��Ƿ� false.
		*/
	}
}

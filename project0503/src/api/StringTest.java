/*
��������� ���� ������ Ŭ���� ���ַ� ����.
���� ���� �ÿ��� Sun���� �����ϴ� ������ Ŭ�������� �ַ� ���.
Sun���� �����ϴ� ���� Ŭ���� �� ���ڿ� ó���� �߿��� ����� �����ϴ�
String class�� ���� �н�
*/
package api;
class StringTest{
	public static void main(String[] args){
		/*String�� import �� ���� ���� ������ ����������, ���� ���Ǵ� ������ class����
		�����ڰ� ������� �ʾƵ� �̹� �⺻������ import�Ǿ� ����.
		java.lang ��Ű���� �װ���.*/ 
		String s= new String("apple"); 
		/*
		String Ŭ������ api document�� �̿��Ͽ� �����ڴ� ���� ��ɵ��� ��������.
		*/
		// ���ڿ��� ����
		System.out.println("���ڿ��� ���̴� "+s.length());
		// �빮�ڷ� ����
		System.out.println(s.toUpperCase());
		// �ι�° p�� index�� ��ȯ
		System.out.println("������ p�� index of�� "+s.lastIndexOf("p"));
		// ���ϴ� ��°�� �ִ� ���� 1���� ����
		System.out.println("���ϴ� ����° ���ĺ��� "+s.charAt(3));
	}
}
package util;
class UseObject{
	public static void main(String[] args){
		ObjectTest ot= new ObjectTest();
		String str= "Korea";
		boolean result= ot.equals(str);
		System.out.println(result);
		/*
		���� �ڵ忡�� equals()�� objTest������ ���� ���� �� ���� ����.
		�ٵ� �� ������ �߻����� �ʴ°�? -> �ý��ۿ� ���� �̹� �����ϰ��ִٴ� ����.
		����: �����ڰ� ������� �ʴ��� �ڹپ��� �ֻ��� ����� Ŭ������ Object Ŭ�����κ���
		��ӹ��� �����̱⿡ ������ �� ��.
		*/
		System.out.println(ot);
		/*
		ot�� ��ü�̹Ƿ� ���ڿ��� �ƴϴ�.
		������ System.out.println()���� ����� �õ��� �� ���ڿ� ȭ �Ǿ� �� �ּҰ����� ��ȯ.
		�츮�� toString()ȣ�� �� ���� ������, ���ڿ� ȭ �� �� obj Ŭ�����κ��� ��ӹ���
		toString()�޼ҵ尡 �ڵ����� ȣ�� �� ��
		*/
	}
}
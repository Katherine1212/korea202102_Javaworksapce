package animal.mydog;
/*
��ӿ��� ��ġ�� ���ƾ� �� �ٽ� ����.
1) �ڵ��� ����.
2) ��ü�� ����ȯ(���� �ܰ�)
*/
class UseDog{
	public static void main(String args[]){
		// [�⺻ �ڷ����� ����ȯ�� ��]
		int x= 7; // 4 byteū �ڷ���
		byte b= 3; // 1byte ���� �ڷ���
		x= b; // ����

		// [��ü �ڷ����� �� ��ȯ�� ��]
		Bird bird= new Bird("White");
		Duck duck= new Duck("Yellow");

		//-----------------------------------------�������� �� 3��(Bird, Duck, Bird�� Duck)

		bird=duck; // �⺻�ڷ����� ���߾� �뷮������ ���� x. ��ü�� ����ȯ�� �����ڷ����� �� ū �ڷ���
		// bird.swim();  bird������ �ڷ����� Bird�̱⶧���� Bird�� swim �޼ҵ尡 ������ ����.
		Duck duck=(Duck)bird; // ��ü�� ����ȯ ����. �ڽ� �ڷ������� ����ȯ �� �ս� ���⳪ ����
										   // �̰��� downCasting�̶�� ��
		duck.swim();
	} 
}
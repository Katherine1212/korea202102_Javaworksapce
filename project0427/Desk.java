public class Desk{ 

		int x; 

		static int y; 

		/*
		���� �ݺ����� �����Ͽ� �ڵ带 �����ϰ� �ʹٸ� {}���� ���� ����.
		�� Ŭ������ Desk�κ��� �ν��Ͻ��� ������ �� ���� �Ʒ��� �ڵ尡 ����
		
		1. �ν��Ͻ� �ʱ�ȭ ��({}): �ش� �ν��Ͻ��� ������ �� �����ϴ� �ڵ� ����.(������ ���Ұ� ���)
		2. static �ʱ�ȭ ��(static{}): ���� ������ �ʱ�ȭ ���� ����.
		*/ 
		{ // A -->

			for(int i=0;i<10;i++){ 

			x++; 

			} 

		} 

		 
		static { // B -->class�� �ε� �� �� ������. ��, main method ȣ�� ��(���� ��) ����.

			for(int i=0;i<20;i++){ 

			y++; 

			} 

		} 

			
		public static void main(String[] args){ 

			System.out.println(x); // C
			// --> ���� �Ұ�! �޸𸮿� �ö� �� ����, static�������� refernce���� ���� x ���� �� �� ����.

			int a=new Desk().x; // D 
			// --> (���� for�� ���鼭) x���� 10���� ���� ������ ���� a�� ����

			System.out.println(a); // E 
			// -->

			System.out.println(y); // F 
			// --> (���� for�� ���鼭) y���� 20���� ����.

			} 

	} 
class GuGu{
	public static void main(String[] args){
		// main�� �Ű������� java.exe ȣ�� �� �� ���� �ѱ� �� �ִ�.
		// java ��� ���� �ٳ���<-- �Ű����� ũ�Ⱑ 3�� String�迭�� ����
		int x = Integer.parseInt(args[0]);
		for(int i=1;i<=x;i++){
			for(int j=1;j<=9;j++){
				System.out.println(i+"*"+j+"="+i*j);				
			}
		}
	}
}

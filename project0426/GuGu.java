class GuGu{
	public static void main(String[] args){
		// main의 매개변수는 java.exe 호출 시 그 값을 넘길 수 있다.
		// java 사과 딸기 바나나<-- 매개변수 크기가 3인 String배열이 전달
		int x = Integer.parseInt(args[0]);
		for(int i=1;i<=x;i++){
			for(int j=1;j<=9;j++){
				System.out.println(i+"*"+j+"="+i*j);				
			}
		}
	}
}

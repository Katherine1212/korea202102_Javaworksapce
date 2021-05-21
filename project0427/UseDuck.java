// 실행부를 두기 위한 Dummy class
class UseDuck{
	public static void main(String args[]){
		// 실행해서 메모리에 올리기
		int x=7;
		Duck d1= new Duck();
		System.out.println("d1이 담고 있는 오리의 인스턴스의 주소 값은 "+d1);
		/*
		D1은 결국 실제 오리를 담고 있는 것이 아니라 
		Heap영역에서 생성된 
		*/
		
	}
}
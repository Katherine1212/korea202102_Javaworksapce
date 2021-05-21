class Phone{
	int price= 5000;
	String name= "Iphone 11";
	static String brand= "Apple"; // static은 고정적인 이란 뜻의 수정자.
	// static으로 선언된 변수, 메소드는 new 할 때 해당 인스턴스에 소속되지 않는다.(원본 클래스에 존재)
	// static으로 선언된 멤버 변수를 클래스변수라고 함.

	public void ring(){
		System.out.println("Ring Ding Dong~");
	}

	public static void main(String[] args){
		phone.company; // 메인이 외부에 있을 때) class가 보유한 class변수는 이렇게 접근
		String c= company; // 내부에 있을 때
		Phone p1= new Phone();
	}
}
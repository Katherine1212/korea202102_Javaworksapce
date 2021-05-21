class Phone1{
	int price= 5000;
	String name= "Iphone 11"; // 인스턴스 소속
	static String brand= "Apple";  // 멤버소속

	public void ring(){
		System.out.println("Ring Ding Dong~");
	}

	public static void main(String[] args){
		Phone1 p1= new Phone1();
		p1.brand= "LG";

		brand="Motorola";

		Phone1 p2= new Phone1();
		p2.brand="Sambo";

		System.out.println(p1.brand);
	}
}
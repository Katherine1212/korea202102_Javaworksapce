package vehicle;
class Bus{
	String color;
	String seat;
	boolean camera;
	// 생성자로 메소드 초기화
	public Bus(){
		color="red";
		seat="가죽 시트";
		camera= true;
	}
	// 일반 메소드로 초기화
	public void init(){
		color="red";
		seat="가죽 시트";
		camera= true;
	}

	public static void main(String args[]){
		Bus b= new Bus();

		b.init();
	}
}
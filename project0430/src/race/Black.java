package race;
// 휴먼의 내용을 전부 가져옴. 중복 서술 할 필요 없이 흑인이 가진 특징만 서술.
public class Black extends Human{
	/*
	부모의 초기화
	public Black(){
		super();
	}
	
	부모의 생성자에 매개변수가 존재한다면, 더이상 현재 클래스의 디폴트 생성자에 의존 할 수 없음.
	따라서 개발자가 부모의 인수가 있는 생성자를 직접 호출해야 에러 안 남.
	*/
	public Black(){
		super(110); // super 생성자는 항상 맨 앞에 위치해야함.(부모가 존재해야 자식이 존재)
		System.out.println("흑인 초기화");
		
	}
	String color="black";
	int IQ=110;
	public void run(){
		System.out.println("육상을 잘 한다.");
	}

}
// 실행중인 자바프로그램으로 메모장파일 내용 읽어오자= Input(입력)
// 자바의 java.io패키지에 io관련 클래스가 지원
package io.bytestream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ReadMemo{
	FileInputStream fis; // 파일 대상으로 한 입력스트림
	FileOutputStream fos; // 파일 대상으로 한 출력스트림
	public  ReadMemo(){
		/* 아래의 코드는 문법적으로 문제가 없지만, 개발자가 파일명을 잘못 기재한 경우,
			실핼 할 때 (runtime 시)에러가 발생되며 프로그램은 비정상종료가 된다. 
			fis= new FileInputStream("D:/Workspace/korea202102_Javaworksapce/app0514/res/memo.txt");
			해결법: try 라는 안정장치를 적용시킴
			try문 내에 예상된 오류가 발생한 경우 프로그램은 종료되는게 아니라
			catch문으로 진입.*/
		try{
			fis= new FileInputStream("D:/Workspace/korea202102_Javaworksapce/app0514/res/memo.txt");
			System.out.println("파일에 대한 스트림 생성 성공");
			// fos에 주소 넣고 파일명, 확장자 넣고 컴파일 후 실행하면 해당 디렉토리에 파일 생성
			fos= new FileOutputStream("D:/Workspace/korea202102_Javaworksapce/app0514/res/memo_copy.txt");
			// 빨대 생성 성공했으니 대상 자원으로부터 1바이트 읽어보자
			while(true){
				int data= fis.read();
				if(data== -1)break;
				System.out.print((char)data);
			}
			
		}catch(FileNotFoundException e){
			// 에러원인을 찾아낼 수 있는 로그, 담당자에게 연락 등
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e){
			// 에러원인을 찾아낼 수 있는 로그, 담당자에게 연락 등
			System.out.println("파일을 읽을 수 없음");
		}
		
	}
	public static void main(String[] args){
		new ReadMemo();
	}
}

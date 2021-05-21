package io.bytestream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopyImage{
	FileInputStream fis;
	FileOutputStream fos;

	public CopyImage(){
		try {
			fis= new FileInputStream("D:\\Workspace\\korea202102_Javaworksapce\\app0513\\res\\image\\a1.png");
			fos= new FileOutputStream("D:\\Workspace\\korea202102_Javaworksapce\\app0513\\res\\image\\a1_copy.png");
			// 입력스트림으로 데이터의 1 바이트씩 읽어드리고 출력 스트림으로는 데이터를 1바이트씩 출력해보자.
			int data= -1;
			while(true) {
				data= fis.read(); // 1byte 읽기
				// System.out.println(data);
				if(data== -1)break;
				fos.write(data); //1byte 쓰기
			}
			System.out.println("복사 완료.");
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없다.");
			// 예외처리하는 이유는 프로그램의 비정상 종료를 방지하고자
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일을 읽을 수 없다.");
		}finally { // 스트림을 반드시 닫아야함.
			// 아래의 코드는 객체의 생성이 성공했을 시에만 수행.
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
			if(fos != null) {
				 try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
	}
	public static void main(String[] args){
		new CopyImage();
	}
}

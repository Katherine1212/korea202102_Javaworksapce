package io.charstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {
	// FileInputStream fis;
	// 바이트 기반 스트림을 대상으로 묶어 문자로 해석 할 수 있는 능력을 보유한 문자기반 스트림
	FileReader fis;
	
	public ReadText() {
		try {
			fis = new FileReader("D:\\Workspace\\korea202102_Javaworksapce\\app0514\\res\\Diary.txt");
			int data=-1;
			while(true) {
				data = fis.read(); 
				if(data== -1)break;
				System.out.print((char)data);		
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ReadText();
	}
}
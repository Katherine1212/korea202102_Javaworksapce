package com.minssam.shoppingapp.util;
// 앞으로 파일과 관련된 여러가지 작접을 전담할 파일 제어 클래스 정의.
public class FileManager {
	// 넘겨받은 경로를 통해 확장자만 추출
	public static String getExtend(String path, String token) {
		int lastIndex= path.lastIndexOf(token); // 넘겨받은 문자열 내 가장 마지막 디렉토리 구분자위치
		String filename= path.substring(lastIndex+1, path.length()); // 파일명+확장자
		String ext=  filename.substring(filename.lastIndexOf(".")+1, filename.length()); // 확장자만 추출
		return ext;
	}
//	public static void main(String[] args) {
//		String result= getExtend("D:\\Workspace\\korea202102_jsworkspace\\class work\\Images\\Among Us\\1.png");
////		System.out.println(result);
//	}
}

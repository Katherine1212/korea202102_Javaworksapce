package app0513.collection;

import java.util.ArrayList;

// 자바의 컬렉션프레임웍 중 list에 대해 학습
public class ListApp {
	public static void main(String[] args) {
		/*	ArrayList list= new ArrayList(); 제너릭 미지정하면 Object로 뜸.
		
		list.add("apple"); // 자바에서 지원하는 모든 자료형을 담을 수 있다.
		list.add("apple");
		list.add("apple");
		list.add("apple");
		// 들어 있는 데이터 출력
		int length= list.size();
		System.out.println("리스트에 들어간 데이터 수는"+length);
		// list.get(1); 가져오기
		list.set(1, "사과");
		System.out.println("변경된 결과는 "+ list.get(1));
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		// jdk 5부터 개선된 for loop지원. 다른 언어의 for~each문과 비슷.
		for(Object item: list) { // 우측항의 집합 수 만큼 반복
			String s= (String)item;
			System.out.println(s);
		}
	}
	*/
		
		// Generic type으로 명시 된 컬렉션프레임웍 객체는 해당 객체만 받아드림. 컴파일러타임에 잡아냄.
		ArrayList<String> list= new ArrayList<String>(); // String 형 ArrayList
		list.add("apple"); // 자바에서 지원하는 모든 자료형을 담을 수 있다.
		list.add("apple");
		list.add("apple");
		list.add("apple");
		// 들어 있는 데이터 출력
		int length= list.size();
		System.out.println("리스트에 들어간 데이터 수는"+length);
		// list.get(1); 가져오기
		list.set(1, "사과");
		System.out.println("변경된 결과는 "+ list.get(1));
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		// jdk 5부터 개선된 for loop지원. 다른 언어의 for~each문과 비슷.
		for(String item: list) { // 우측항의 집합 수 만큼 반복
			System.out.println(item);
		}
	}
}

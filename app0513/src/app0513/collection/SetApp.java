package app0513.collection;

import java.util.HashSet;
import java.util.Iterator;

// 자바컬렉션 프레임웍 중 순서없는 데이터를 모아 처리 할 수 있는 set알아보자
public class SetApp {
	public static void main(String[] args) {
		HashSet<String> set= new HashSet<String>();
		set.add("banana"); // list와 동일하게 add()지원되는 이유는 모두 컬렉션객체의 자식
		set.add("Apple");
		set.add("Lemon");
		
		// 순서 없는 데이터형이므로 일렬로 늘어뜨리기
		Iterator<String> it= set.iterator();
		// 반복문을 이용해 모든 요소 출력
		while(it.hasNext()) { // 현위치 기준으로 다음 위치에 요소가 존재하는 동안만 반복문 수행
			 String item= it.next(); // 이동한 위치의 요소를 반환.
			 System.out.println("바나나 바 나나 나"+item);
		}
		/* 출력하면 banana, banana, banana 가 아닌 banana 한번만 출력
		 * 결론: Set은 데이터 중복을 허용하지 않음. */		
	}
}

package app0513.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// 자바의 컬렉션프레임웍 중 map학습. map이란 Key-value의 쌍으로 이루어진 데이터 집합.(ig. JSON)
public class MapApp {
	public static void main(String[] args) {
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("fruit1", "apple"); // map.put(key:value); key는 무조건 스트링 x
		map.put("fruit2", "pear");
		map.put("fruit3", "graph");
		map.put("fruit4", "mango");
		System.out.println(map.get("fruit3"));
		// 추출
		map.get("fruit2");
		
		// 결론: 직접 Iterator나 Enumeration으로 변환은 x, Set을 한번 거쳐 처리
		// 주의: 아래의 keySet()은 map에 들어있는 value가 아니가 key값만 추출
		Set<String> set= map.keySet(); // fruit 1, 2 3.. 
		// 반복문으로 요소 출력
		Iterator<String> it= set.iterator();
		while(it.hasNext()) {
			String key= it.next(); // key값 얻었으니 amp에 들어있는 데이터 검색 가능.
			String value= map.get(key); // key에 연결된 value반환.
			 System.out.println("과일 냠"+value);
		}
		// map은 중복된 데이터(value)는 허용하다 중복된 key는 허용하지 않음.
	}
}

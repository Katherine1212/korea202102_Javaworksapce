package com.minssam.shoppingapp.model.domain;
// 이 객체는 로직 작성용이 아니라 topcategory table에 recode(;data) 담기 위한 객체.
// 이러한 용도의 객체를 가리켜 설계분야에서는 Values Object(VO)라고 한다. JS의 JSON역할과 유사.
// 은닉화 시키는 대표적인 사례가 VO
public class Topcategory {
	private int topcategory_id;
	private String top_name;
	
	public int getTopcategory_id() {
		return topcategory_id;
	}
	public void setTopcategory_id(int topcategory_id) {
		this.topcategory_id = topcategory_id;
	}
	public String getTop_name() {
		return top_name;
	}
	public void setTop_name(String top_name) {
		this.top_name = top_name;
	}
	
}

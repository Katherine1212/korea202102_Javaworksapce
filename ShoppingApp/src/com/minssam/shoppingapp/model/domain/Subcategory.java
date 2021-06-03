package com.minssam.shoppingapp.model.domain;
// 오직 Subcategory 레코드의 1건담기위한 VO;
public class Subcategory {
	private int subcategory_id;
	private int topcategory_id;
	private String sub_name;
	
	
	public int getTopcategory_id() {
		return topcategory_id;
	}
	public void setTopcategory_id(int topcategory_id) {
		this.topcategory_id = topcategory_id;
	}
	
	public int getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}
	
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sun_name) {
		this.sub_name = sun_name;
	}
}

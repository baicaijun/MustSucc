package com.nox.domain;

public class PageElementEntity {
	
	private int id;
	private int page_id;
	private String elementType;
	private String ElementPath;
	private String element_name;
	private String page_name;
	
	public String getPage_name() {
		return page_name;
	}
	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
	public String getElementType() {
		return elementType;
	}
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}
	public String getElementPath() {
		return ElementPath;
	}
	public void setElementPath(String elementPath) {
		ElementPath = elementPath;
	}
	public String getElement_name() {
		return element_name;
	}
	public void setElement_name(String element_name) {
		this.element_name = element_name;
	}
	@Override
	public String toString() {
		return "PageElementEntity [id=" + id + ", page_id=" + page_id
				+ ", elementType=" + elementType + ", ElementPath="
				+ ElementPath + ", element_name=" + element_name + "]";
	}
	
}

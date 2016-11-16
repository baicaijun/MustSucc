package com.nox.domain;

public class PageEntity {
	
	private int id;
	private int project_id;
	private String page_name;
	private String page_url;
	private String project_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getPage_name() {
		return page_name;
	}
	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}
	public String getPage_url() {
		return page_url;
	}
	public void setPage_url(String page_url) {
		this.page_url = page_url;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	@Override
	public String toString() {
		return "PageEntity [id=" + id + ", project_id=" + project_id
				+ ", page_name=" + page_name + ", page_url=" + page_url
				+ ", project_name=" + project_name + "]";
	}
	

}

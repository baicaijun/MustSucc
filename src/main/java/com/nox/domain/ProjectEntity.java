package com.nox.domain;





public class ProjectEntity {

	private String id;
	private String project_name;
	private String createTime;
	public ProjectEntity() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", project_name=" + project_name
				+ ", createTime=" + createTime + "]";
	}
	
	
}

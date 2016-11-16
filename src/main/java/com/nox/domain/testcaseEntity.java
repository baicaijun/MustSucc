package com.nox.domain;

public class testcaseEntity {

	private int id;
	private String casename;
	private int project_id;
	private String project_name;
	private String caseExpValue;
	private String case_result;
	public String getCaseExpValue() {
		return caseExpValue;
	}
	public void setCaseExpValue(String caseExpValue) {
		this.caseExpValue = caseExpValue;
	}
	public String getCase_result() {
		return case_result;
	}
	public void setCase_result(String case_result) {
		this.case_result = case_result;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCasename() {
		return casename;
	}
	public void setCasename(String casename) {
		this.casename = casename;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	@Override
	public String toString() {
		return "testcaseEntity [id=" + id + ", casename=" + casename
				+ ", project_id=" + project_id + "]";
	}
	
	
}

package com.nox.domain;

public class casestepEntity {

	private int id;
	private String testcasename;
    private String stepName;
    private String stepPath;
    private String casestep_element;
	public String getCasestep_element() {
		return casestep_element;
	}
	public void setCasestep_element(String casestep_element) {
		this.casestep_element = casestep_element;
	}
	public String getStepPath() {
		return stepPath;
	}
	public void setStepPath(String stepPath) {
		this.stepPath = stepPath;
	}
	private String testcaseid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTestcasename() {
		return testcasename;
	}
	public void setTestcasename(String testcasename) {
		this.testcasename = testcasename;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getTestcaseid() {
		return testcaseid;
	}
	public void setTestcaseid(String testcaseid) {
		this.testcaseid = testcaseid;
	}
	@Override
	public String toString() {
		return "casestepEntity [id=" + id + ", testcasename=" + testcasename
				+ ", stepName=" + stepName + ", testcaseid=" + testcaseid + "]";
	}
	
	
	
}

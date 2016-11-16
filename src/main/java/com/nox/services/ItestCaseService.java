package com.nox.services;

import java.util.List;

import com.nox.domain.testcaseEntity;



public interface ItestCaseService {

	public testcaseEntity getTestCase(String CaseName);
	public int insertTestCase(testcaseEntity testcase);
	public List<testcaseEntity> getListTestCase(String ProName);
	public int UpTestCaseResult(testcaseEntity testcase);
}

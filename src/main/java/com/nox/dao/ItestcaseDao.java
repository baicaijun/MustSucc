package com.nox.dao;

import java.util.List;

import com.nox.domain.testcaseEntity;

public interface ItestcaseDao {
	
	    int insertCase(testcaseEntity testcase);

	    testcaseEntity selectCaseBycaseName(String CName);
	    
	    List<testcaseEntity> selectCaseByProjectName(String ProName);
	    
	    int updateByPrimaryKey(testcaseEntity testcase);

}

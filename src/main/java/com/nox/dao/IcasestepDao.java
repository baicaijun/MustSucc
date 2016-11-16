package com.nox.dao;

import java.util.List;

import com.nox.domain.casestepEntity;


public interface IcasestepDao {
	
	    int insertCaseStep(casestepEntity caseStep);
   
	    List<casestepEntity> selectCaseStepCaseName(String testCaseName);

}

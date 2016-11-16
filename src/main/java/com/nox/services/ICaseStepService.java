package com.nox.services;

import java.util.List;

import com.nox.domain.casestepEntity;



public interface ICaseStepService {
	
	public int insertCaseStep(casestepEntity page);
	public List<casestepEntity> getListCaseStep(String TestCaseName);

}

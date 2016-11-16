package com.nox.servicesImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nox.dao.IcasestepDao;
import com.nox.domain.casestepEntity;
import com.nox.services.ICaseStepService;

@Service("ICaseStepService")
public class ICaseStepImp implements ICaseStepService {
	@Resource
	 private IcasestepDao casestepDao;

	public int insertCaseStep(casestepEntity casestep) {
		// TODO Auto-generated method stub
		return this.casestepDao.insertCaseStep(casestep);
	}

	public List<casestepEntity> getListCaseStep(String TestCaseName) {
		// TODO Auto-generated method stub
		return this.casestepDao.selectCaseStepCaseName(TestCaseName);
	}
}

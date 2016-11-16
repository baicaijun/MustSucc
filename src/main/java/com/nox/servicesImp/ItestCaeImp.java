package com.nox.servicesImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nox.dao.ItestcaseDao;
import com.nox.domain.testcaseEntity;
import com.nox.services.ItestCaseService;

@Service("ItestCaseService")
public class ItestCaeImp implements ItestCaseService {
	@Resource
	private  ItestcaseDao testcaseDao;
	public testcaseEntity getTestCase(String CaseName) {
		// TODO Auto-generated method stub
		return this.testcaseDao.selectCaseBycaseName(CaseName);
	}

	public int insertTestCase(testcaseEntity testcase) {
		// TODO Auto-generated method stub
		return this.testcaseDao.insertCase(testcase);
	}

	public List<testcaseEntity> getListTestCase(String ProName) {
		// TODO Auto-generated method stub
		return this.testcaseDao.selectCaseByProjectName(ProName);
	}
	
	public int UpTestCaseResult(testcaseEntity testcase) {
		// TODO Auto-generated method stub
		return this.testcaseDao.updateByPrimaryKey(testcase);
	}

}

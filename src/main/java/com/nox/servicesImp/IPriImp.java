package com.nox.servicesImp;


import javax.annotation.Resource;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Service;

import com.nox.dao.IProjectDao;
import com.nox.domain.ProjectEntity;
import com.nox.services.IProjectServices;


@Service("IProjectServices")
public class IPriImp implements IProjectServices{

	@Resource
	private  IProjectDao userDao;

	public ProjectEntity getProjectByName(String ProjectName)throws MyBatisSystemException{
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(ProjectName);
	}

	public int inserPro(ProjectEntity p)throws MyBatisSystemException {
		// TODO Auto-generated method stub
		return this.userDao.insertkey(p);
	}

	
	

	
	
	
	
}

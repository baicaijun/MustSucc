package com.nox.dao;

import com.nox.domain.ProjectEntity;



public interface IProjectDao {
	
	    int deleteByPrimaryKey(Integer id);

	    public int insertkey(ProjectEntity record);

	    ProjectEntity selectByPrimaryKey(String id);

	    int updateByPrimaryKey(ProjectEntity record);

}

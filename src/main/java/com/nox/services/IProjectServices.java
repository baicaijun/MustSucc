package com.nox.services;

import com.nox.domain.ProjectEntity;



public interface IProjectServices {
	
	public ProjectEntity getProjectByName(String ProjectName);
	
	public int inserPro(ProjectEntity p);
}

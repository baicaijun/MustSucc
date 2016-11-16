package com.nox.services;

import java.util.List;

import com.nox.domain.PageElementEntity;


public interface IPageElementService {
	
	public PageElementEntity getAutoPageElement(String elementname);
	public int insertAutoPageElement(PageElementEntity PageElement);
	public List<PageElementEntity> getListAutoPageElement(String PageName);

}

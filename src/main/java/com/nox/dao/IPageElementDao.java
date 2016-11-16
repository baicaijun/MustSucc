package com.nox.dao;

import java.util.List;

import com.nox.domain.PageElementEntity;


public interface IPageElementDao {
	
	int insertPageElement(PageElementEntity PageElement);

	PageElementEntity selectElementByName(String pageName);
    
    List<PageElementEntity> selectElementByPageName(String ElementName);

}

package com.nox.dao;

import java.util.List;

import com.nox.domain.PageEntity;

public interface IPageDao {
	

    public int insertPage(PageEntity Page);

    PageEntity selectPageByPageName(String pageName);
    
    List<PageEntity> selectPageByProject(String projecetName);

}

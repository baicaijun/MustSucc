package com.nox.services;

import java.util.List;

import com.nox.domain.PageEntity;

public interface IPageService {
  
	public PageEntity getAutoPage(String PageName);
	public int insertAutoPage(PageEntity page);
	public List<PageEntity> getListAutoPage(String PageName);
}

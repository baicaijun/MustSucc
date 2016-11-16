package com.nox.servicesImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nox.dao.IPageElementDao;
import com.nox.domain.PageElementEntity;
import com.nox.services.IPageElementService;

@Service("IPageElementService")
public class IPageElementImp implements IPageElementService{
@Resource
 private IPageElementDao pageElementDao;
	public PageElementEntity getAutoPageElement(String elementname) {
		// TODO Auto-generated method stub
		return this.pageElementDao.selectElementByName(elementname);
			
	}

	public int insertAutoPageElement(PageElementEntity PageElement) {
		// TODO Auto-generated method stub
		return this.pageElementDao.insertPageElement(PageElement);
		
	}

	public List<PageElementEntity> getListAutoPageElement(String PageName) {
		// TODO Auto-generated method stub
		return this.pageElementDao.selectElementByPageName(PageName);
	}

}

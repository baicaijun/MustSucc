package com.nox.servicesImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nox.dao.IPageDao;
import com.nox.domain.PageEntity;
import com.nox.services.IPageService;
@Service("IPageService")
public class IPageImp implements IPageService {
	@Resource
	private IPageDao  pageDao;
	private PageEntity PAGE;
	private List<PageEntity> ListPage;
	private int flag;
	public PageEntity getAutoPage(String PageName) {
	 
		PAGE=this.pageDao.selectPageByPageName(PageName);   
	    return PAGE;
	}
	public List<PageEntity> getListAutoPage(String ProjectName) {
		 
		ListPage=this.pageDao.selectPageByProject(ProjectName);   
	    return ListPage;
	}

	public int insertAutoPage(PageEntity page) {
		// TODO Auto-generated method stub
		flag=this.pageDao.insertPage(page);
		return flag;
	}

}

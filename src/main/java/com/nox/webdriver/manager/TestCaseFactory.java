package com.nox.webdriver.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.nox.domain.PageElementEntity;
import com.nox.domain.PageEntity;
import com.nox.domain.ProjectEntity;
import com.nox.domain.casestepEntity;
import com.nox.domain.testcaseEntity;
import com.nox.services.ICaseStepService;
import com.nox.services.IPageElementService;
import com.nox.services.IPageService;
import com.nox.services.IProjectServices;
import com.nox.services.ItestCaseService;
import com.nox.servicesImp.IPriImp;
import com.nox.utils.CHException;

public class TestCaseFactory {
	@Resource
	private IProjectServices ProjService ;
	@Resource
	private IPageService  PageService ;
	@Resource
	private IPageElementService ElementService;
	@Resource
	private ItestCaseService CaseService;
	@Resource
	private ICaseStepService CaseStepService;
	
	public String excuTestCase(String projectName){
	    //获取工程的名称
		ProjectEntity pentity=this.ProjService.getProjectByName(projectName);
		String ProName=pentity.getProject_name();
		System.out.println(ProName);
		
		return ProName;
	}
	//获取所有页面的页面名称
	public List<String> getPageName(String ProjName) throws CHException{
		
		List<PageEntity>  PageEntityList = this.PageService.getListAutoPage(ProjName);
		List<String> PageNameList = new ArrayList<String>();
		if(PageEntityList.size()!=0){
		for(int i=0;i<PageEntityList.size();i++){
			PageNameList.add(PageEntityList.get(i).getPage_name());
		}
		}else{
			throw new CHException("数据为空");
		}
		return PageNameList;	
	}
	
//获取页面的url	
public String getPageURL(String ProjName) throws CHException{
		
		List<PageEntity>  PageEntityList = this.PageService.getListAutoPage(ProjName);
		String PageUrl = null;
		if(PageEntityList.size()!=0){
		
			PageUrl=PageEntityList.get(0).getPage_name();
		
		}else{
			throw new CHException("数据为空");
		}
		return PageUrl;	
	}

// 获取页面具体的元素

	public Map<String, String> getPageElementList(String pageName) throws CHException {

		List<PageElementEntity> ElementEntityList = this.ElementService
				.getListAutoPageElement(pageName);
		Map<String, String> ElementMap = new HashMap<String, String>();
		if (ElementEntityList.size() != 0) {
			for (int i = 0; i < ElementEntityList.size(); i++) {
				ElementMap.put(ElementEntityList.get(i).getElement_name(),
						ElementEntityList.get(i).getElementPath());
			}
		}else{
			throw new CHException("数据为空");
		}
		return ElementMap;

	}

//获取测试case的List
    
	public List<String> getCaseName(String ProName) throws CHException{
		
		List<testcaseEntity>  testcaseEntityList =this.CaseService.getListTestCase(ProName);
		List<String> caseNameList = new ArrayList<String>();
		if(testcaseEntityList.size()!=0){
		 for(int i=0;i<testcaseEntityList.size();i++){
			 caseNameList.add(testcaseEntityList.get(i).getCasename());
		 }
		}else{
			throw new CHException("数据为空");
		}
		return caseNameList;
	}
	
//获取caseList 里面的步骤操作
	
	public Map<String, String> getCaseStepMap(String TestCaseName) throws CHException {

		List<casestepEntity> casestepEntityList = this.CaseStepService.getListCaseStep(TestCaseName);
		Map<String, String> CaseStepMap = new HashMap<String, String>();
		if (casestepEntityList.size() != 0) {
			for (int i = 0; i < casestepEntityList.size(); i++) {
				CaseStepMap.put(casestepEntityList.get(i).getStepPath(),
						casestepEntityList.get(i).getStepName());
			}
		}else{
			throw new CHException("数据为空");
		}
		return CaseStepMap;

	}

	public static void main(String args[]){
		TestCaseFactory xx = new TestCaseFactory();
		xx.excuTestCase("testbaidu");
		
	}
	
}

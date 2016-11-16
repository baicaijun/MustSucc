package com.nox.control;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nox.constants.ConfigContansts;
import com.nox.domain.PageElementEntity;
import com.nox.domain.PageEntity;
import com.nox.domain.casestepEntity;
import com.nox.domain.testcaseEntity;
import com.nox.services.ICaseStepService;
import com.nox.services.IPageElementService;
import com.nox.services.IPageService;
import com.nox.services.IProjectServices;
import com.nox.services.ItestCaseService;
import com.nox.utils.ActionMapper;
import com.nox.utils.BaseDriver;
import com.nox.utils.CHException;
import com.nox.utils.ParamFitter;
import com.nox.utils.ReflectUtils;

@Controller
@RequestMapping("/ExcuCase")
public class ExcuCaseController extends BaseDriver{

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

	@ResponseBody
	@RequestMapping(value = "/ExceCaseStep", method = RequestMethod.GET)
	public Map<String, Object> excuTestCase(HttpServletRequest request) {
		// 获取工程的名称

		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> MsgMap = new HashMap<String, Object>();
		Map<String, String> StepMap = new LinkedHashMap<String, String>();
		List<String> caseTestList = new ArrayList<String>();
		try {
			paramMap = ParamFitter.myFittler(request);

			String projectName = (String) paramMap.get("projectName");
			String BrowserName = (String) paramMap.get("BrowserName");
			String Param = (String) paramMap.get("Param");
			WebDriver driver = ExcuCaseController.this
					.getBaseDriver(BrowserName);

			List<String> pageList = this.getPageName(projectName);

			String pageUrl = getPageURL(pageList.get(0));

			caseTestList = this.getCaseName(projectName);
			List<testcaseEntity> testcaseEntityList = this.CaseService
					.getListTestCase(projectName);

			for (int i = 0; i < caseTestList.size(); i++) {
				Object resultStr = null;
				List<String> value=new ArrayList<String>();
				StepMap = this.getCaseStepMap(caseTestList.get(i));
               
				for (String key : StepMap.keySet()) {
					String Method = key;
					String ElementValue = StepMap.get(key);

					if (ActionMapper.getActionMapDriverStr01().containsKey(
							Method)) {
                         
						resultStr = ReflectUtils.ExcuMethodOneString(
								ConfigContansts.WebApiPath, ActionMapper
										.getActionMapDriverStr01().get(Method),
								ElementValue, driver);
						if(ActionMapper.getVauleMap().containsKey(Method)){
							value.add(String.valueOf(resultStr));
						}

					} else if (ActionMapper.getActionMapOnlyDriverParam()
							.containsKey(Method)) {

						resultStr = ReflectUtils.ExcuMethodOnlyDriver(
								ConfigContansts.WebApiPath,
								ActionMapper.getActionMapOnlyDriverParam().get(
										Method), driver);
						if(ActionMapper.getVauleMap().containsKey(Method)){
							value.add(String.valueOf(resultStr));
						}

					} else if (ActionMapper.getActionMapOnlyStringParam()
							.containsKey(Method)) {

						resultStr = ReflectUtils.ExcuMethodNoDriver(
								ConfigContansts.WebApiPath,
								ActionMapper.getActionMapOnlyStringParam().get(
										Method), ElementValue);
						if(ActionMapper.getVauleMap().containsKey(Method)){
							value.add(String.valueOf(resultStr));
						}

					} else if (ActionMapper.getActionMapDriverStr02()
							.containsKey(Method)) {

						resultStr = ReflectUtils.ExcuMethodTwoString(
								ConfigContansts.WebApiPath, ActionMapper
										.getActionMapDriverStr02().get(Method),
								ElementValue, Param, driver);
						if(ActionMapper.getVauleMap().containsKey(Method)){
							value.add(String.valueOf(resultStr));
						}
					}
					else {
						MsgMap.put("result", "error");
						MsgMap.put("message", "未找到合适的方法");
					}
					
				}
				if(value.size()!=0){
				testcaseEntityList.get(i).setCase_result(value.get(0));
				System.out.println(value.get(0));
				this.CaseService.UpTestCaseResult(testcaseEntityList.get(i));
			  }
			}

			MsgMap.put("casename", caseTestList);
			MsgMap.put("url", pageUrl);
			MsgMap.put("projectname", projectName);
			MsgMap.put("message", "sucess");

		} catch (CHException e) {
			// TODO Auto-generated catch block
			MsgMap.put("result", "error01");
			MsgMap.put("message", e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			MsgMap.put("result", "error02");
			MsgMap.put("message", e.toString());
		}

		return MsgMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/GetTestCaseResult", method = RequestMethod.GET)
	public Map<String, Object> GetTestCaseResult(HttpServletRequest request){
		Map<String,List<String>> mapV = new LinkedHashMap<String,List<String>>();
		Map<String, Object> MsgMap = new HashMap<String, Object>();
		Map<String, Object> LsgMap = new HashMap<String, Object>();
		try {
			mapV=getCaseNameEValue(request.getParameter("projectName"));
			List<String> CaseNameEValue = mapV.get("CaseNameEValue");
			List<String> CaseResult = mapV.get("CaseResult");
			List<String> CaseName = mapV.get("CaseName");
			for(int i=0;i<CaseNameEValue.size();i++){
				if(CaseNameEValue.get(i).equals(CaseResult.get(i))){
					LsgMap.put(CaseName.get(i),"sucess");
				}else{
					LsgMap.put(CaseName.get(i),"fail");
				}
				MsgMap.put("result",LsgMap);			
			}
			
		} catch (CHException e) {
			// TODO Auto-generated catch block
			MsgMap.put("result", "error01");
			MsgMap.put("message", e.toString());
		}
		
		return MsgMap;
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
		PageEntity  PageEntityList = this.PageService.getAutoPage(ProjName);
		String PageUrl = null;
		if(PageEntityList!=null||PageEntityList.getPage_url()!=""){	
			PageUrl=PageEntityList.getPage_url();	
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
	
	//获取测试case的List
    
		public Map<String,List<String>> getCaseNameEValue(String ProName) throws CHException{
			
			List<testcaseEntity>  testcaseEntityList =this.CaseService.getListTestCase(ProName);
			List<String> CaseNameEValue = new ArrayList<String>();
			List<String> CaseResult = new ArrayList<String>();
			List<String> CaseName = new ArrayList<String>();
			Map<String,List<String>> map = new LinkedHashMap<String,List<String>>();
			if(testcaseEntityList.size()!=0){
			 for(int i=0;i<testcaseEntityList.size();i++){
				 CaseNameEValue.add(testcaseEntityList.get(i).getCaseExpValue());
				 CaseResult.add(testcaseEntityList.get(i).getCase_result());
				 CaseName.add(testcaseEntityList.get(i).getCasename());
			 }
			 map.put("CaseNameEValue", CaseNameEValue);
			 map.put("CaseResult", CaseResult);
			 map.put("CaseName", CaseName);
			}else{
				throw new CHException("数据为空");
			}
			return map;
		}
	
//获取caseList 里面的步骤操作
	
	public Map<String, String> getCaseStepMap(String TestCaseName) throws CHException {

		List<casestepEntity> casestepEntityList = this.CaseStepService.getListCaseStep(TestCaseName);
		Map<String, String> CaseStepMap = new LinkedHashMap<String, String>();
		if (casestepEntityList.size() != 0) {
			for (int i = 0; i < casestepEntityList.size(); i++) {
				CaseStepMap.put(casestepEntityList.get(i).getStepName(),
						casestepEntityList.get(i).getCasestep_element());
			}
		}else{
			throw new CHException("数据为空");
		}
		return CaseStepMap;

	}
	
	
	
	
}

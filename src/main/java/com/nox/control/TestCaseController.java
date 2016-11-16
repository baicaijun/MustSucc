package com.nox.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nox.domain.MSErrorConstants;
import com.nox.domain.testcaseEntity;
import com.nox.services.ItestCaseService;
import com.nox.utils.CHException;
import com.nox.utils.ParamFitter;

@Controller
@RequestMapping("/TestCase")
public class TestCaseController {
	
	@Resource
	private ItestCaseService testCaseService;
	@ResponseBody
	@RequestMapping(value="/addTestcase",method=RequestMethod.POST)
	public  Map<String,Object> InsertTestCase(@RequestBody testcaseEntity testcase){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			testcaseEntity Ttestcase= (testcaseEntity) ParamFitter.myFittler02(testcase);	
			int Flag=this.testCaseService.insertTestCase(Ttestcase);
			if(Flag==1){
			MsgMap.put("message","sucess");
			MsgMap.put("result","true");
			}else{
				MsgMap.put("message","fail");
				MsgMap.put("result",MSErrorConstants.InsertCaseErroeCode+":"+MSErrorConstants.InsertCaseErrorMsg);
			}		
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}

	@ResponseBody
	@RequestMapping(value="/getTestCase",method=RequestMethod.GET)
	public Map<String,Object> getTestCase(HttpServletRequest request){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap=ParamFitter.myFittler(request);
			String CaseName=(String) paramMap.get("casename");
			testcaseEntity testcase=this.testCaseService.getTestCase(CaseName);
			MsgMap.put("message","sucess");
			MsgMap.put("result",testcase);
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}
	
	@ResponseBody
	@RequestMapping(value="/getTestCaseList",method=RequestMethod.GET)
	public Map<String,Object> getTestCaseList(HttpServletRequest request){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap=ParamFitter.myFittler(request);
			String ProjectName=(String) paramMap.get("projectname");
			List<testcaseEntity> testcaseEntityList=this.testCaseService.getListTestCase(ProjectName);
			MsgMap.put("message","sucess");
			MsgMap.put("result",testcaseEntityList);
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}
	/**
	@ResponseBody
	@RequestMapping(value="/getTestCaseList2",method=RequestMethod.GET)
	public Map<String,Object> getTestCaseList2(HttpServletRequest request){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap=ParamFitter.myFittler(request);
		//	String ProjectName=(String) paramMap.get("projectname");
			//String ProjectName2=(String) paramMap.get("projectname2");
			List<testcaseEntity> testcaseEntityList=this.testCaseService.getListTestCase("testbaidu");
			testcaseEntityList.get(0).setCase_result("12312");
			int a=this.testCaseService.UpTestCaseResult(testcaseEntityList.get(0));
			MsgMap.put("message","sucess");
			MsgMap.put("result",a);
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}
	
	*/
}

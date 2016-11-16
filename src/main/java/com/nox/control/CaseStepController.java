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
import com.nox.domain.casestepEntity;
import com.nox.services.ICaseStepService;
import com.nox.utils.CHException;
import com.nox.utils.ParamFitter;
@Controller
@RequestMapping("/CaseStep")
public class CaseStepController {
	
	@Resource
	private ICaseStepService CaseStepService;
	@ResponseBody
	@RequestMapping(value="/addCaseStep",method=RequestMethod.POST)
	public  Map<String,Object> InsertCaseStep(@RequestBody casestepEntity testcase){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			casestepEntity Ttestcase= (casestepEntity) ParamFitter.myFittler02(testcase);	
			int Flag=this.CaseStepService.insertCaseStep(Ttestcase);
			if(Flag==1){
			MsgMap.put("message","sucess");
			MsgMap.put("result","true");
			}else{
				MsgMap.put("message","fail");
				MsgMap.put("result",MSErrorConstants.InsertCaseErroeCode+":"+MSErrorConstants.InsertCaseStepErrorMsg);
			}		
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}

	@ResponseBody
	@RequestMapping(value="/CaseStepList",method=RequestMethod.GET)
	public Map<String,Object> getCaseStepList(HttpServletRequest request){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap=ParamFitter.myFittler(request);
			String caseStep=(String) paramMap.get("casename");
			List<casestepEntity> Tcasestep= this.CaseStepService.getListCaseStep(caseStep);
			MsgMap.put("message","sucess");
			MsgMap.put("result",Tcasestep);
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}

}

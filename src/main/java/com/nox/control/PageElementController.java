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
import com.nox.domain.PageElementEntity;
import com.nox.services.IPageElementService;
import com.nox.utils.CHException;
import com.nox.utils.ParamFitter;

@Controller
@RequestMapping("/PageElement")
public class PageElementController {
	@Resource
	IPageElementService IPageElement;
	@ResponseBody
	@RequestMapping(value="/findElemet",method=RequestMethod.GET)
	public Map<String,Object> searchEelement(HttpServletRequest request){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap=ParamFitter.myFittler(request);
			String elementname=(String) paramMap.get("elementname");
			PageElementEntity pageElemetn=this.IPageElement.getAutoPageElement(elementname);
			MsgMap.put("message","sucess");
			MsgMap.put("result",pageElemetn);
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}
	@ResponseBody
	@RequestMapping(value="/findListElemet",method=RequestMethod.GET)
	public Map<String,Object> searchListEelement(HttpServletRequest request){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			Map<String,Object> paramMap= new HashMap<String,Object>();
			paramMap=ParamFitter.myFittler(request);
			String Pagename=(String) paramMap.get("Pagename");
			List<PageElementEntity> pageElemetList=this.IPageElement.getListAutoPageElement(Pagename);
			MsgMap.put("message","sucess");
			MsgMap.put("result",pageElemetList);
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}

	
	
	@ResponseBody
	@RequestMapping(value="/addElement",method=RequestMethod.POST)
	public Map<String,Object> insertEelement(@RequestBody PageElementEntity pageElement){
		Map<String,Object> MsgMap= new HashMap<String,Object>();
		try {
			//System.out.println(pageElement);
			PageElementEntity TpageElement= (PageElementEntity) ParamFitter.myFittler02(pageElement);	
			//System.out.println(TpageElement);
			int Flag=this.IPageElement.insertAutoPageElement(TpageElement);
			if(Flag==1){
			MsgMap.put("message","sucess");
			MsgMap.put("result","true");
			}else{
				MsgMap.put("message","fail");
				MsgMap.put("result",MSErrorConstants.searchPageEelemetnErroeCode+":"+MSErrorConstants.SearchPageEelemetnErrorMsg);
			}
			
		} catch (CHException e) {
			MsgMap.put("message","fail");
			MsgMap.put("result",e.toString());
		}
		return MsgMap;
	}
	
}

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
import com.nox.domain.PageEntity;

import com.nox.services.IPageService;
import com.nox.utils.CHException;
import com.nox.utils.ParamFitter;


@Controller
@RequestMapping("/page")
public class PageController {
	@Resource
	private IPageService PageService;
	@ResponseBody
	@RequestMapping(value="/getPageMsg",method=RequestMethod.GET)
	public Map<String,Object> getPage(HttpServletRequest request){
		String pagename=request.getParameter("PageName");
		PageEntity p=this.PageService.getAutoPage(pagename);
		Map<String,Object> pagemap = new HashMap<String,Object>();
		if(pagename==null||pagename.equals("")){
			pagemap.put("message","fail");
			pagemap.putIfAbsent("result",p);
			return pagemap;
		}
			pagemap.put("message","sucess");
			pagemap.putIfAbsent("result",p);
			return pagemap;
	}
	
	@ResponseBody
	@RequestMapping(value="/getPageList",method=RequestMethod.GET)
	public Map<String,Object> getListPage(HttpServletRequest request){
		String ProjectName=request.getParameter("ProjectName");
		List<PageEntity> p=this.PageService.getListAutoPage(ProjectName);
		Map<String,Object> Allpagemap = new HashMap<String,Object>();
		if(ProjectName==null || ProjectName.equals("")){
			Allpagemap.put("message","fail");
			Allpagemap.putIfAbsent("result",p);
			return Allpagemap;
		}
		Allpagemap.put("message","sucess");
		Allpagemap.putIfAbsent("result",p);
			return Allpagemap;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/insertPage",method=RequestMethod.POST)
	public Map<String,Object> InsertPage(@RequestBody PageEntity p2){
		Map<String,Object> InserPageMAP =  new HashMap<String,Object>();
		try {	
			PageEntity Tp2=(PageEntity)ParamFitter.myFittler02(p2);
			//System.out.println(Tp2);
			int Flag=this.PageService.insertAutoPage(Tp2);
			if(Flag==1){
				InserPageMAP.put("message","insert Sucess");
				InserPageMAP.put("result","true");
			}else{
				InserPageMAP.put("message","faile");
				InserPageMAP.put("result",MSErrorConstants.pageinserError+":"+MSErrorConstants.pageinsertErrorMsg);
			}
		} catch (CHException e) {
			// TODO Auto-generated catch block
			InserPageMAP.put("message","fail");
			InserPageMAP.put("result",MSErrorConstants.pageinserError+":"+MSErrorConstants.SearchPageErrorMsg2);
		}		
		return InserPageMAP;
	}
	
	
}

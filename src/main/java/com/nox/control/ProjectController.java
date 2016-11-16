package com.nox.control;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nox.domain.MSErrorConstants;
import com.nox.domain.ProjectEntity;
import com.nox.services.IProjectServices;
/**
 * 
 *添加工程接口  参数：项目名称，创建项目的时间
 * @author chenyixiao
 *
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
		@Resource
		private IProjectServices userService;
		@ResponseBody
		@RequestMapping(value="/showProj",method=RequestMethod.POST)
		public Map<String,Object> insertPro(@RequestBody ProjectEntity p2){		
			
			int flag=this.userService.inserPro(p2);
			Map<String, Object> map = new HashMap<String, Object>();
			if(flag==1){
				map.put("message","success");
				map.put("result",p2.getProject_name());
				return map;
			}
			map.put("message",MSErrorConstants.insertError);
			map.put("result",MSErrorConstants.insertErrorMsg);
			return map;	
		}

/**
 * 
 * @param request
 * @return
 * 跟进projectName查询项目的名称 
 *
 */
		@ResponseBody
		@RequestMapping(value="/findProj",method=RequestMethod.GET)
		public Map<String,Object> findPro(HttpServletRequest request){
			Map<String,Object> map = new HashMap<String,Object>();
			String projectName=request.getParameter("proname");
			if(projectName==null){
				map.put("message",MSErrorConstants.searchProjectErroeCode);
				map.put("result",MSErrorConstants.SearchErrorMsg);
				return map;
			}
				ProjectEntity p=this.userService.getProjectByName(projectName);
				map.put("message","success");
				map.put("result",p);
			    return map;
		}
		
		
   }

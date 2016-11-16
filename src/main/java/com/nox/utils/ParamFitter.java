package com.nox.utils;


import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
public class ParamFitter {
	
	public static Map<String,Object> myFittler(HttpServletRequest request) throws CHException{	
		Map<String,Object> map = new HashMap<String,Object>();
	    Enumeration<String> paramNames = request.getParameterNames();
	    while(paramNames.hasMoreElements()){
	    	String paramName=(String)paramNames.nextElement();
	    	String[] paramValues=request.getParameterValues(paramName);
            if(paramValues.length==1){
            	String paramValue=paramValues[0];
				if(paramValue==null||paramValue.equals("")){			
					throw new CHException("参数不合法");			
				}else{
					map.put(paramName, paramValue);
			 }
	       }
		
		}
		
		return map;
	}
	
public static Object myFittler02(Object Param) throws CHException{	
		    Object obj;		
			if(Param==null || Param.equals("")){		
				throw new CHException("参数不合法");
			}else{
				obj=Param;
				System.out.println(obj.toString());
			}	
		   return obj;
	}
	
	

}

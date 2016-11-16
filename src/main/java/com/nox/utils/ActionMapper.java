package com.nox.utils;

import java.util.HashMap;
import java.util.Map;

import com.nox.constants.ActionMpperContants;

public class ActionMapper {
	
	 static Map<String,String> actionMap = new HashMap<String,String>();
	 static Map<String,String> actionMap1 = new HashMap<String,String>();
	 static Map<String,String> actionMap2 = new HashMap<String,String>();
	 static Map<String,String> actionMap3 = new HashMap<String,String>();
	 static Map<String,String> actionMap4 = new HashMap<String,String>();
	 static Map<String,String> actionMap5 = new HashMap<String,String>();
	 static Map<String,String> getActionMap(){
		actionMap.put(ActionMpperContants.closeChrome,"closeChrome");
		actionMap.put(ActionMpperContants.ExcuAlert,"ExcuAlert");
		actionMap.put(ActionMpperContants.excuBack,"excuBack");
		actionMap.put(ActionMpperContants.ExcuClear,"ExcuClear");
		actionMap.put(ActionMpperContants.ExcuClick,"ExcuClick");
		actionMap.put(ActionMpperContants.excuForward,"excuForward");
		actionMap.put(ActionMpperContants.ExcuFresh,"ExcuFresh");
		actionMap.put(ActionMpperContants.ExcuJS,"ExcuJS");
		actionMap.put(ActionMpperContants.ExcuMaxWindow,"ExcuMaxWindow");
		actionMap.put(ActionMpperContants.ExcuSendKey,"ExcuSendKey");
		actionMap.put(ActionMpperContants.getEelement,"getEelement");
		actionMap.put(ActionMpperContants.getUrl,"getUrl");
		actionMap.put(ActionMpperContants.switchFrame,"switchFrame");
		actionMap.put(ActionMpperContants.switchToWindow,"switchToWindow");
		actionMap.put(ActionMpperContants.sleepThread,"sleepThread");
		actionMap.put(ActionMpperContants.getAttribute,"getAttribute");
		actionMap.put(ActionMpperContants.getCurrentUrl,"getCurrentUrl");
		actionMap.put(ActionMpperContants.getText,"getText");
		actionMap.put(ActionMpperContants.getTitle,"getTitle");
		return actionMap;
	}
	//只有一个参数的反射方法driver
	public static Map<String,String> getActionMapOnlyDriverParam(){
		actionMap1.put(ActionMpperContants.closeChrome,"closeChrome");
		actionMap1.put(ActionMpperContants.ExcuAlert,"ExcuAlert");
		actionMap1.put(ActionMpperContants.excuBack,"excuBack");
		actionMap1.put(ActionMpperContants.excuForward,"excuForward");
		actionMap1.put(ActionMpperContants.ExcuFresh,"ExcuFresh");
		actionMap1.put(ActionMpperContants.ExcuMaxWindow,"ExcuMaxWindow");
		actionMap1.put(ActionMpperContants.getCurrentUrl,"getCurrentUrl");
		actionMap1.put(ActionMpperContants.getTitle,"getTitle");
		return actionMap1;
	}
	//只有一个String参数
	public static Map<String,String> getActionMapOnlyStringParam(){

		actionMap2.put(ActionMpperContants.sleepThread,"sleepThread");
		actionMap2.put(ActionMpperContants.sleepThread01,"sleepThread01");
		actionMap2.put(ActionMpperContants.sleepThread02,"sleepThread02");
		actionMap2.put(ActionMpperContants.sleepThread03,"sleepThread03");
		actionMap2.put(ActionMpperContants.sleepThread04,"sleepThread04");
		actionMap2.put(ActionMpperContants.sleepThread05,"sleepThread05");
		actionMap2.put(ActionMpperContants.sleepThread06,"sleepThread06");
		actionMap2.put(ActionMpperContants.sleepThread07,"sleepThread07");
		actionMap2.put(ActionMpperContants.sleepThread08,"sleepThread08");
		actionMap2.put(ActionMpperContants.sleepThread09,"sleepThread09");
		actionMap2.put(ActionMpperContants.sleepThread10,"sleepThread10");
		
		return actionMap2;
	}
	//只有一个参数&&driver
	public static Map<String,String> getActionMapDriverStr01(){
	
		actionMap3.put(ActionMpperContants.ExcuClear,"ExcuClear");
		actionMap3.put(ActionMpperContants.ExcuClick,"ExcuClick");
		actionMap3.put(ActionMpperContants.ExcuJS,"ExcuJS");
		actionMap3.put(ActionMpperContants.getEelement,"getEelement");
		actionMap3.put(ActionMpperContants.getUrl,"getUrl");
		actionMap3.put(ActionMpperContants.switchFrame,"switchFrame");
		actionMap3.put(ActionMpperContants.switchToWindow,"switchToWindow");
		actionMap3.put(ActionMpperContants.getText,"getText");
		return actionMap3;
	}
	//两个参数&&driver
		public static Map<String,String> getActionMapDriverStr02(){
			actionMap4.put(ActionMpperContants.ExcuSendKey,"ExcuSendKey");
			actionMap4.put(ActionMpperContants.getAttribute,"getAttribute");
			actionMap4.put(ActionMpperContants.DBTVALUE,"DBTVALUE");
			actionMap4.put(ActionMpperContants.DBCVALUE,"DBCVALUE");
			return actionMap4;
		}
		
		public static Map<String,String> getVauleMap(){
	
			actionMap5.put(ActionMpperContants.getAttribute,"getAttribute");
			actionMap5.put(ActionMpperContants.getCurrentUrl,"getCurrentUrl");
			actionMap5.put(ActionMpperContants.getText,"getText");
			actionMap5.put(ActionMpperContants.getTitle,"getTitle");
			return actionMap5;
		}

}

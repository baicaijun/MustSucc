package com.nox.utils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.http.HttpException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ReflectUtils {
	
	
	public static  Object ExcuMethodOneString(String ClassName,String methodName,String MethodParam,WebDriver driver) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class<?> clazz=Class.forName(ClassName);
		Object o = clazz.newInstance();
	//	Constructor c=clazz.getConstructor(String.class);//获取有参构造
	//	WebDriverApi w= (WebDriverApi) c.newInstance(ConstructorName);    //通过有参构造创建对象
		
		Method m1 = clazz.getDeclaredMethod(methodName,String.class,WebDriver.class);
		Object g=m1.invoke(o,MethodParam,driver);	
		if(g==null){
			return "error";
		}
		return g;
	}
	public static Object  ExcuMethodNoDriver(String ClassName,String methodName,String MethodParam) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class<?> clazz=Class.forName(ClassName);
		Object o = clazz.newInstance();
	//	Constructor c=clazz.getConstructor(String.class);//获取有参构造
	//	WebDriverApi w= (WebDriverApi) c.newInstance(ConstructorName);    //通过有参构造创建对象
		
		Method m1 = clazz.getDeclaredMethod(methodName,String.class);
		Object g=m1.invoke(o,MethodParam);
		if(g==null){
			return "error";
		}
		return g;
	}
	public static Object  ExcuMethodTwoString(String ClassName,String methodName,String MethodParam,String Param,WebDriver driver) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class<?> clazz=Class.forName(ClassName);
		Object o = clazz.newInstance();
	//	Constructor c=clazz.getConstructor(String.class);//获取有参构造
	//	WebDriverApi w= (WebDriverApi) c.newInstance(ConstructorName);    //通过有参构造创建对象
		Method m1 = clazz.getDeclaredMethod(methodName,String.class,String.class,WebDriver.class);
		Object g=m1.invoke(o,MethodParam,Param,driver);
		if(g==null){
			return "error";
		}
		return g;
	}
	
	public static Object  ExcuMethodOnlyDriver(String ClassName,String methodName,WebDriver driver) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class<?> clazz=Class.forName(ClassName);
		Object o = clazz.newInstance();
	//	Constructor c=clazz.getConstructor(String.class);//获取有参构造
	//	WebDriverApi w= (WebDriverApi) c.newInstance(ConstructorName);    //通过有参构造创建对象
		Method m1 = clazz.getDeclaredMethod(methodName,WebDriver.class);
		Object g=m1.invoke(o,driver);
		
		if(g==null){
			return "error";
		}
		return g;
		
	}
	
	/**
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void  ExcuMethod02(String ClassName,String ConstructorName,String methodName,String MethodParam,String MethodParam02) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class clazz=Class.forName(ClassName);
		Constructor c=clazz.getConstructor(String.class);//获取有参构造
		WebDriverApi w= (WebDriverApi) c.newInstance(ConstructorName);    //通过有参构造创建对象
		Method m1 = clazz.getDeclaredMethod(methodName,String.class,String.class);
		m1.invoke(w,MethodParam,MethodParam02);
	}
	*/
	public static void main(String args[]) throws ClassNotFoundException, HttpException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		System.setProperty(BaseDriver.ChromeDriverName, BaseDriver.ChromeDriverPath);
		WebDriver driver=new ChromeDriver();		
		System.out.println(ReflectUtils.ExcuMethodOneString("com.nox.utils.WebDriverApi","getUrl","http://www.baidu.com",driver));
		//.ExcuMethod03("com.nox.utils.WebDriverApi","ExcuSendKey","//*[@id='kw']","http://www.baidu.com",driver);
		System.out.println(ReflectUtils.ExcuMethodNoDriver("com.nox.utils.WebDriverApi","sleepThread","5000"));
		System.out.println(ReflectUtils.ExcuMethodTwoString("com.nox.utils.WebDriverApi","ExcuSendKey","//*[@id='kw']","asdas",driver));
		System.out.println(ReflectUtils.ExcuMethodOnlyDriver("com.nox.utils.WebDriverApi","getTitle",driver));
		
	}

}

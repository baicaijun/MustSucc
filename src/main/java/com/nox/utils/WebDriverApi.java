package com.nox.utils;

import java.util.Set;

import org.apache.http.HttpException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author chenyixiao
 *  webdriver api 的封装，方便反射调用
 *  支持最多两个参数的形式
 */
public class WebDriverApi  {

	
	//一个参数的列表：
	
//打开网址
	public void getUrl(String Url,WebDriver driver) throws HttpException, CHException{
	
		
			driver.get(Url);
	
	}
	public WebElement getEelement(String path,WebDriver driver) throws NoSuchElementException, CHException{
		
		try{
		  WebElement element = null;
		  element = driver.findElement(By.xpath(path));
		  return element;
		}catch(NoSuchElementException e){
			throw new CHException("未找到元素");
		}
	}
	public void ExcuSendKey(String path,String param,WebDriver driver) throws CHException{	
		try{
			getEelement(path, driver).sendKeys(param);
		
		}catch(NoSuchElementException e){
			throw new CHException("执行输入失败");
		}
	} 
	
	

//执行点击操作
	public void ExcuClick(String path,WebDriver driver) throws CHException{	
		getEelement(path,driver).click();
	}
//执行clear操作
	public void ExcuClear(String path,WebDriver driver) throws CHException{	
		getEelement(path,driver).clear();
	} 

//执行js
    public void ExcuJS(String js,WebDriver driver){	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript(js);
}
//切换浏览器的标签页
    public String switchToWindow(String windowTitle,WebDriver driver){  
	    String flag = "false";  
	    try { 		    	
	        String currentHandle = driver.getWindowHandle();  
	        Set<String> handles = driver.getWindowHandles();  
	        for (String s : handles) {  
	            if (s.equals(currentHandle))  
	                continue;  
	            else {  
	            	driver.switchTo().window(s);
	                if (driver.getTitle().contains(windowTitle)) {  
	                    flag = "cxy";  
	                    System.out.println("Switch to window: "  
	                            + windowTitle + " successfully!");  
	                    break;  
	                } else  
	                    continue;  
	            }  
	        }  
	    } catch (Exception e) {  
	        System.out.printf("Window: " + windowTitle  
	                + " cound not found!", e.fillInStackTrace());  
	        flag = "false";  
	    }  
	    return flag;  
	} 
//切换frame
    public String switchFrame(String path,WebDriver driver) throws CHException{
    	
    	try{
    	driver.switchTo().frame(getEelement(path,driver));
    	return "cxy";
    	}catch(Exception e){
    		throw new CHException("Frame未找到");  		
    	}
    } 
 //alert()弹窗处理
    public String ExcuAlert(WebDriver driver) throws CHException{
    	try{
    	driver.switchTo().alert().accept();
    	return "cxy";
    	}catch(Exception e){
    		throw new CHException("处理alert弹窗失败");
    	}
    }
  //浏览器放大
    public String ExcuMaxWindow(WebDriver driver) throws CHException{
    	try{
    	driver.manage().window().maximize();
    	return "cxy";
    	}catch(Exception e){
    		throw new CHException("浏览器操作失败");
    	}
    }
//浏览器刷新
    public String ExcuFresh(WebDriver driver) throws CHException{
    	try{
    	     driver.navigate().refresh();
    	     return "cxy";
    	}catch(Exception e){
    		
    		throw new CHException("浏览器操作失败");
    	}
    }
 //浏览器回退
    public String excuBack(WebDriver driver) throws CHException{
    	try{
    	driver.navigate().back();
    	return "cxy";
      }catch(Exception e){
    	  throw new CHException("浏览器回退操作执行失败");
      }
  }
    //浏览器前跳
    public String excuForward(WebDriver driver) throws CHException{	
    	try{
    		driver.navigate().forward();
    		return "cxy";
    	}catch(Exception e){
    		
    	  throw new CHException("浏览器回退操作执行失败");	
    	}
    }
    
    public String closeChrome(WebDriver driver) throws CHException{
    	try{
    	driver.quit();
    	return  "cxy";
    	}catch(Exception e){
    		throw new CHException("退出浏览器失败");	
    	}
    }
    public String sleepThread(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread01(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread02(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread03(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread04(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread05(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread07(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread08(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread09(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    public String sleepThread10(String time) throws CHException{
    	try{
    		int Ttime=Integer.parseInt(time);
    	    Thread.sleep(Ttime);
    	    return "cxy";
    	}catch(Exception e){
    		throw new CHException("执行等待失败");	
    	}
    }
    //获取页面标题
    public String getTitle(WebDriver driver) throws CHException{
    	try{
    	String title =driver.getTitle();
    	return title;
    	}catch(Exception e){
    		throw new CHException("获取标题失败");
    	}
    }
    //获取某个Url
    public String getCurrentUrl(WebDriver driver) throws CHException{
    	try{
    	String title =driver.getCurrentUrl();
    	return title;
    	}catch(Exception e){
    		throw new CHException("获取当前Url失败");
    	}
    }
    //获取某个元素的text
    public String getText(String path,WebDriver driver) throws CHException{
    	try{
    		String text=getEelement(path,driver).getText();
    	return text;
    	}catch(Exception e){
    		throw new CHException("获取text失败");
    	}
    }
  //获取某个标签的属性
    public String getAttribute(String path,String Attribute,WebDriver driver) throws CHException{
    	try{
    		String text=getEelement(path,driver).getAttribute(Attribute);
    	return text;
    	}catch(Exception e){
    		throw new CHException("获取属性信息失败");
    	}
    }
    //equals
    public String DBTVALUE(String Pone,String Ptwo,WebDriver driver) {
    	if(Pone.equals(Ptwo)){
    		return "DUI";
    	}return "CUO";
    	
    }
    //contins
    public String DBCVALUE(String Pone,String Ptwo,WebDriver driver) {
    	if(Pone.contains(Ptwo)){
    		return "DUI";
    	} return "CUO";
    	
    }
    
	public static void main(String args[]) throws HttpException, CHException{
		
		
	}
	
	
}
package cn.WebDriverAPI;
//使用Title属性识别和操作新弹出的浏览器窗口

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewWindowTile {
	WebDriver driver;
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/Administrator.USER-20180602NR/Desktop/selenium.html");
		//定位点击连接元素，打开新窗口
		driver.findElement(By.xpath("//a[text()='Open new window打开百度']")).click();
		//获取当前页面句柄
		String handle=driver.getWindowHandle();
		//获取所有页面句柄
		Set<String> allHandle=driver.getWindowHandles();
		//如果容器存储的对象不为空，则遍历allHandle中所有句柄
		if(!allHandle.isEmpty()){
			for(String windowhandle:allHandle){
				try{
					//调用driver.switchTo().window(windowhandle).getTitle()方法
					//获取浏览器的Title属性，并判断是否是“百度一下，你就知道”
					if(driver.switchTo().window(windowhandle).getTitle().equals("百度一下，你就知道"))
						//判断正确则说明是百度首页，则在输入框中输入  javaselenium
						driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("javaselenium");
				}catch(NoSuchWindowException e){
					//如果没有，抛出NoSuchWindowException，打印异常的堆栈信息
					e.printStackTrace();
				}
			}
		}
		//返回最开始打开的浏览器页面
		driver.switchTo().window(handle);
		//断言浏览器页面的Title属性值是否是   SeleniumElement
		Assert.assertEquals(driver.getTitle(),"SeleniumElement");
		driver.findElement(By.xpath("//input[@id='input']")).sendKeys("123456");
	}
	@AfterMethod
	public void quit() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}

}

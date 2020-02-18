package cn.WebDriverAPI;
//通过页面的文字识别和处理新弹出的浏览器窗口

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewWindowText {
	WebDriver driver;
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/Administrator.USER-20180602NR/Desktop/selenium.html");
		//打开新窗口 百度页面
		driver.findElement(By.xpath("//a[text()='Open new window打开百度']")).click();
		//获取当前页面的句柄
		String OldHandle=driver.getWindowHandle();
		//获取所有句柄
		Set<String> AllHandle=driver.getWindowHandles();
		//判断如果AllHandle不为空则进行遍历AllHandle
		if(!AllHandle.isEmpty()){
			try{
			for(String Handle:AllHandle){
				//调用driver.switchTo().window(Handle).getPageSource().contains()方法
				//逐个获取页面的源码，判断是否包含“百度一下，你就知道”
				if(driver.switchTo().window(Handle).getPageSource().contains("百度一下，你就知道"))
					//如果判断成立，则说明当前页面为百度首页，并在输入框中输入  java
					driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("java");
			}
			}catch(NoSuchWindowException e){
				e.printStackTrace();
			}
			//调用driver.switchTo().window()方法切到原页面，在输入框中输入old页面
			driver.switchTo().window(OldHandle).findElement(By.xpath("//input[@id='input']")).sendKeys("old页面");
			//断言页面源码包含   SeleniumElement
			Assert.assertTrue(driver.getPageSource().contains("SeleniumElement"));
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void aftermethod(){
		driver.quit();
	}
}

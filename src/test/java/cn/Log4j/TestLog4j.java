package cn.Log4j;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLog4j {
	WebDriver driver;
	@BeforeClass
	public void beforeClass(){
		
		//读取log4j配置文件 Log4j.xml 的信息
		DOMConfigurator.configure("Log4j.xml");
		Log.info("读取log4j配置文件 Log4j.xml 的信息");
	}
	@BeforeMethod
	public void before(){
		Log.startTestCase("百度搜索：selenium java");
		Log.info("设置浏览器驱动路径");
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		Log.info("初始化Chrome浏览器");
		driver=new ChromeDriver();
		Log.info("访问百度首页");
		driver.get("http://www.baidu.com");
	}
	@Test
	public void test(){
		Log.info("百度首页输入框中输入：selenium java");
		driver.findElement(By.id("kw")).sendKeys("selenium java");
		Log.info("点击 百度一下 按钮");
		driver.findElement(By.id("su")).click();
		Log.info("断言页面Title值是否为：selenium java_百度搜索");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("selenium java_百度搜索",driver.getTitle());
		
	}
	@AfterMethod
	public void after(){
		Log.info("退出Chrome浏览器");
		driver.quit();
		Log.endTestCase("搜索");
	}
}

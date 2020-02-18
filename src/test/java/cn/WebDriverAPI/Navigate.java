package cn.WebDriverAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
//浏览器网页的操作
import org.testng.annotations.Test;

import junit.framework.Assert;


public class Navigate {
	public WebDriver driver;
	@Test
	public void GetUrl() throws InterruptedException{
		//初始化Chrome浏览器
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		driver= new ChromeDriver();
		//访问网页地址
		String url="http://www.baidu.com/";
		driver.get(url);
		driver.findElement(By.id("kw")).sendKeys("123123123");
		Thread.sleep(2000);
		//刷新浏览器当前网页
		driver.navigate().refresh();
		//获取页面的title属性
		String title=driver.getTitle();
		System.out.println(title);
		//断言页面上的title值是不是  百度一下，你就知道
		Assert.assertEquals("百度一下，你就知道",title);
		//获取页面源代码
		String pagesource=driver.getPageSource();
		//断言源代码中是否包含“百度一下，你就知道”
		Assert.assertTrue(pagesource.contains("百度一下，你就知道"));

		driver.navigate().to(url);
		//获取URL地址
		String getUrl=driver.getCurrentUrl();
		System.out.println(getUrl);
		//断言
		Assert.assertEquals("https://www.baidu.com/", getUrl);
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}

}

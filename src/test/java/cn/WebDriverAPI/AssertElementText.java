package cn.WebDriverAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AssertElementText {
	WebDriver driver;
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.baidu.com");
		//获取网页title文字
		String text=driver.getTitle();
		Assert.assertEquals("百度一下，你就知道",text);
		//判断title文字内容是否包含 百度一下
		Assert.assertTrue(text.contains("百度一下"));
		//判断title文字内容开始文字是不是  百度
		Assert.assertTrue(text.startsWith("百度"));
		//判断title文字内容的末尾文字是不是  知道
		Assert.assertTrue(text.endsWith("知道"));
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
}

package cn.Location;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPath {
	public WebDriver driver;
	String url="file:///C:/Users/Administrator.USER-20180602NR/Desktop/Xpath.html";
	@Test
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		  //打开谷歌浏览器
		driver=new ChromeDriver();
		driver.get(url);
		//通过索引号进行定位到第2个radio按钮
//		driver.findElement(By.xpath("//div[@id='radio']/input[2]")).click();
		//通过属性值定位
		//使用class属性定位到值为 yi 的按钮
//		driver.findElement(By.xpath("//input[@class='yi']")).click();
		//定位到id为sousuo的div中href属性值为http://www.baidu.com 超链接
//		driver.findElement(By.xpath("//div[@id='sousuo']/a[@href='http://www.baidu.com']")).click();
		//使用type属性值定位输入框
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("123");
		//查找输入框id属性开始位置包含“in”关键字的页面元素
//		driver.findElement(By.xpath("//input[starts-with(@id,'in')]")).sendKeys("123123");
		//查找链接href属性包含“baidu”关键字的页面元素
//		driver.findElement(By.xpath("//a[contains(@href,'baidu')]")).click();
		//查找元素文本为 baidu搜索  的链接
//		driver.findElement(By.xpath("//a[text()='baidu搜索']")).click();
		//搜索包含  sogou 的连链接
//		driver.findElement(By.xpath("//a[contains(text(),'sogou')]")).click();
		//表示在包含 baidu  关键字的链接页面元素的前面查找超链接元素
//		driver.findElement(By.xpath("//a[contains(text(),'baidu')]/preceding::a")).click();
		//
		
		//
		//
		//
		//
		//
		//
		//
		Thread.sleep(2000);
		driver.quit();  
	}
	

}

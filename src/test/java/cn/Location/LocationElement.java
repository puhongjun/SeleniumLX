package cn.Location;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocationElement {
	public WebDriver driver;
	String url="file:///C:/Users/Administrator.USER-20180602NR/Desktop/selenium.html";
	@Test
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		  //打开谷歌浏览器
		driver=new ChromeDriver();
		driver.get(url);
//		driver.findElement(By.linkText("baidu搜索")).click();
//		driver.findElement(By.partialLinkText("baidu")).click();
//		driver.findElement(By.partialLinkText("搜索")).click();
//		driver.findElement(By.tagName("a")).click();
//		driver.findElement(By.xpath("//input[@name='ips']")).sendKeys("12");
//		driver.findElement(By.xpath("//input[2]")).click();
//		driver.findElement(By.xpath("//input[@type='text']")).click();
//		driver.findElement(By.xpath("//div[@id='radio']/input[@class='yi']")).click();
		//查找按钮class属性开始位置包含“sa”关键字的页面元素
//		driver.findElement(By.xpath("//input[starts-with(@class,'sa')]")).click();
		//查找按钮class属性包含“an”关键字的页面元素
//		driver.findElement(By.xpath("//input[contains(@class,'an')]")).click();
		//使用页面元素的文本来定位元素
//		driver.findElement(By.xpath("//a[text()='baidu搜索']")).click();
		//搜索包含  baidu 的连接页面元素
//		driver.findElement(By.xpath("//a[contains(text(),'baidu')]")).click();
		//表示在包含 搜索  两个字的连接页面元素的前面查找超链接元素
//		driver.findElement(By.xpath("//a[contains(text(),'搜索')]/preceding::a")).click();
		Thread.sleep(2000);
		driver.quit();  
	}
	

}

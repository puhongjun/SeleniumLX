package cn.WebDriverAPI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class iFrame {
	WebDriver driver;
	@Test
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/Administrator.USER-20180602NR/Desktop/Xpath.html");
		//通过iframe标签的id属性值定位到Iframe1中的iframe，并将控制权交给它
		driver.switchTo().frame("iFrameId");
		//定位iframe框架1中的输入框并输入  iFreme1
		WebElement iF1=driver.findElement(By.xpath("//input[@id='input']"));
		iF1.sendKeys("iFreme1");
		//等2秒看效果
		Thread.sleep(2000);
		//清除文本
		iF1.clear();
		//控制权交回原来的界面
		driver.switchTo().defaultContent();
		//在外面的输入框中输入   defaultContend
		WebElement in=driver.findElement(By.xpath("//input[@id='input']"));
		in.sendKeys("defaultContend");
		Thread.sleep(2000);
		in.clear();
		Thread.sleep(2000);
		
		//通过iframe的name属性值定位Iframe2中的iframe，并将控制权交给它
		driver.switchTo().frame("iFrameName");
		//在Iframe框架2中的输入框中输入iFrame2
		WebElement iF2=driver.findElement(By.xpath("//input[@id='input']"));
		iF2.sendKeys("iFreme2");
		Thread.sleep(2000);
		iF2.clear();
		//控制权交回原来的界面
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		//通过WebElement方法定位到iFrame。
		//通过iframe标签的height属性值定位iframe1
		WebElement ifr1=driver.findElement(By.xpath("//iframe[@height='153']"));
		//控制权交给iframe1
		driver.switchTo().frame(ifr1);
		//定位里面的输入框
		WebElement iFrame1input=driver.findElement(By.id("input"));
		//输入   WebElement
		iFrame1input.sendKeys("WebElement");
		Thread.sleep(2000);
		//清除文本
		iFrame1input.clear();
		//控制权交给原来的界面
		driver.switchTo().defaultContent();
		
		
		//使用index方法进入指定iframe，索引号从 0 开始
		//控制权交给iframe2。如果是0的话切到iframe1中
		driver.switchTo().frame(1);
		//定位里面的输入框
		WebElement iFrame2input=driver.findElement(By.id("input"));
		//输入   WebElement
		iFrame2input.sendKeys("index");
		//清除文本
		Thread.sleep(2000);
		iFrame2input.clear();
		//控制权交给原来的界面
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		//使用iframe中的HTML源码内容来定位操作iframe
		//找到页面中所有iframe，并存储到iframes容器里
		List<WebElement> iframes= driver.findElements(By.tagName("iframe"));
		//遍历iframes中所有iframe页面，查找包含  iFrameId 的iframe页面
		for(WebElement iframe:iframes){
			//将控制权交给iframe
			driver.switchTo().frame(iframe);
			//逐个iframe页面进行判断是否包含 iFrameId 关键字
			if(driver.getPageSource().contains("iFrameId")){
				//判断成立说明找到指定iframe页面，则在当前iframe页面中的输入框中输入  PageSourceIFrameID
				WebElement pg=driver.findElement(By.id("input"));
				pg.sendKeys("PageSourceIFrameID");
				//找到指定iframe后退出for循环
				break;
			}else{
				//如果没有找到指定iframe，则退出当前iframe页面。for循环继续进入下一轮循环
				driver.switchTo().defaultContent();
			}
		}
		//找到指定iframe页面并执行完后面语句后退出当前iframe页面
		driver.switchTo().defaultContent();
		//在输入框中输入  控制权回到原点
		driver.findElement(By.id("input")).sendKeys("控制权回到原点");
	}
	@AfterMethod
	public void AfterMethod(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}

package cn.WebDriverAPI;
//显示等待,使用PhantomJSDriver 无头模式

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XianShiWait {
	@Test
	public void test(){
//		PhantomJSDriver driver;
//		System.setProperty("phantomjs.binary.path","E://phantomjs.exe");
//		driver=new PhantomJSDriver();
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		//声明一个Action对象
		Actions action=new Actions(driver);
		//鼠标移动到  更多产品 上
		action.moveToElement(driver.findElement(By.xpath("//a[text()='更多产品']"))).perform();
		//显示等待时间10s 等   全部产品>>  出现
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text()='全部产品>>']")));
		//等待的元素出现后点击  音乐  
		WebElement cp=driver.findElement(By.xpath("//a[text()='音乐']"));
		cp.click();
		//断言音乐页面的Title值为   千千音乐-听见世界
		String Titletext=driver.getTitle();
		System.out.println("音乐界面Title："+Titletext);
		Assert.assertEquals("千千音乐-听见世界1",Titletext);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		driver.quit();
	}

}

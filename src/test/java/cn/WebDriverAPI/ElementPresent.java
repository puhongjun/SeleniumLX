package cn.WebDriverAPI;
//判断页面元素是否存在

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;


public class ElementPresent {
	WebDriver driver;
	//写一个判断页面元素是否存在的方法 IsElementPresent
	private boolean IsElementPresent(By by){
		try{
			//如果使用传入的参数by能找到页面元素，则函数返回true，表示成功地找到页面元素
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e){
			//如果使用传入的参数by 没有找到页面元素,返回false
			return false;
		}
	}
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		//调用写的IsElementPresent方法查找元素
		if(IsElementPresent(By.xpath("//input[@name='wd']"))==true){
			//如果成功定位到页面元素，则把页面元素对象存储到element变量中
			WebElement element=driver.findElement(By.xpath("//input[@name='wd']"));
			//判断element变量对象是否处于可能状态。如果可用则输入“selenium”关键字
			if(element.isEnabled()==true){
				element.sendKeys("selenium");
			}
		}else{
			//如果页面元素没找到，则将此用例设置为失败，并打印原因
			Assert.fail("页面元素没找到");
		}
	}
	@AfterMethod
	public void aftermethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}

}

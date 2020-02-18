package cn.WebDriverAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//操作radio单选框
public class Radio {
	WebDriver driver;
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/Administrator.USER-20180602NR/Desktop/selenium.html");
		//查找class属性为yi的按钮
		WebElement yi=driver.findElement(By.className("yi"));
		//判断此按钮是否为选中状态，如果不是则调用click方法进行点击
		if(!yi.isSelected())
			yi.click();
		//断言class属性值为yi的按钮处于被选中状态。此时isSelected方法返回值应为True
		Assert.assertTrue(yi.isSelected());
		//输出isSelected方法返回值
		Boolean b=yi.isSelected();
		System.out.println("b："+b);
		
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}

}

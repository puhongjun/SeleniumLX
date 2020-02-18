package cn.WebDriverAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DoubleClick {
	public WebDriver driver;

	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/Administrator.USER-20180602NR/Desktop/selenium.html");
		WebElement inputB=driver.findElement(By.xpath("//input[@id='inputBox']"));
		//声明Action对象
		Actions ac=new Actions(driver);
		//使用doubleClick方法在定位的元素中进行鼠标的双击操作
		ac.doubleClick(inputB).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}

}

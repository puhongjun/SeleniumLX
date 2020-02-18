package cn.WebDriverAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

//模拟鼠标右键

public class ActionRigthClick {
	WebDriver driver;
	@Test
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		//声明一个Action对象
		Actions action=new Actions(driver);
		//调用Action对象的contextClick方法，在id为su的按钮上单击鼠标右键
		action.contextClick(driver.findElement(By.id("su"))).perform();
		Thread.sleep(3000);
		driver.quit();
	}
	
}

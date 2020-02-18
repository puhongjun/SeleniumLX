package cn.WebDriverAPI;
//在指定元素上方进行鼠标悬浮

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionMoveToElement {
	WebDriver driver;
	@Test
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		WebElement move=driver.findElement(By.xpath("//a[text()='更多产品']"));
		//声明一个Action对象
		Actions action=new Actions(driver);
		//调用moveToElement方法将鼠标移到  更多产品  链接上
		action.moveToElement(move).perform();
		//点击  百度营销
		driver.findElement(By.xpath("//a[text()='百度营销']")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}

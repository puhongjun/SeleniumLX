package cn.WebDriverAPI;
//模拟键盘操作

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionKeyDownAndUp {
	WebDriver driver;
	@Test
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		//声明一个Actions对象
		Actions action=new Actions(driver);
		//按下SHIFT键并输入  abcdefg 
		action.keyDown(Keys.SHIFT).sendKeys("abcd").perform();
		Thread.sleep(3000);
		driver.quit();
	}

}

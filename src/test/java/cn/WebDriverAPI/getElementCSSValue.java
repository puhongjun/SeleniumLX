package cn.WebDriverAPI;
//获取页面元素CSS属性值

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getElementCSSValue {
	@Test
	public void test(){
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		WebElement input=driver.findElement(By.id("kw"));
		String value=input.getCssValue("id");
		System.out.println("id:"+value);
		driver.quit();
	}
}

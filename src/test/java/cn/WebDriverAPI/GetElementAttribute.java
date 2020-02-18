package cn.WebDriverAPI;
//查看页面元素属性

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetElementAttribute {
	@Test
	public void test(){
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		WebElement input=driver.findElement(By.id("kw"));
		input.sendKeys("Selenium");
		//调用getAttribute方法获取到输入框中的文本内容，并赋给text
		String text=input.getAttribute("value");
		//断言
		Assert.assertEquals("Selenium",text);
		System.out.println(text);
		driver.quit();
	}

}

package cn.WebDriverAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class HighLightElement {
	public static  WebDriver driver;
	@Test
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		WebElement kw=driver.findElement(By.id("kw"));
		WebElement su=driver.findElement(By.id("su"));
		HL(driver,kw);
		
		kw.click();
		kw.sendKeys("123456");
		HL(driver,su);
		su.click();
		Thread.sleep(3000);
		driver.quit();
	}
	//封装高亮显示元素方法
	public static void HL(WebDriver driver,WebElement element){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style',arguments[1])",
				           element,"background:yellow;border:3px solid red;");
	}
}

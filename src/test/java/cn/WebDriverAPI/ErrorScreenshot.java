package cn.WebDriverAPI;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ErrorScreenshot {
	WebDriver driver;
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.baidu.com");
		File ScrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(ScrFile, new File("c:\\testing\\test.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void afterMethod(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}

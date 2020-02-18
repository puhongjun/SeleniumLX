package cn.WebDriverAPI;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class OperationCookis {
	WebDriver driver;
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		//获取cookies
		Set<Cookie> data = driver.manage().getCookies();
		System.out.println(data);
		//获得cookies个数
		System.out.println(driver.manage().getCookies().size());
		
		//删除所有cookies
		driver.manage().deleteAllCookies();
		//获得cookies个数,此时cookies的个数为0
		System.out.println(driver.manage().getCookies().size());
		
		//设置cookies
		Cookie c1 = new Cookie("addCookies", "123456789");
		driver.manage().addCookie(c1);
		//新增了一条，此时cookie个数为1
		System.out.println(driver.manage().getCookies().size());

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void AfterMethod(){
		driver.quit();
	}

}

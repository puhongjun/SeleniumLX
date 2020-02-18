package cn.WebDriverAPI;
//多选的选择列表
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MultipleDownList {
	WebDriver driver;
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/Administrator.USER-20180602NR/Desktop/selenium.html");
		WebElement mus=driver.findElement(By.id("selects"));
		Select select=new Select(mus);
		//断言下拉列表是否支持多选，支持多选isMultiple方法则返回True
		Assert.assertTrue(select.isMultiple());
		//通过索引选择
		select.selectByIndex(0);
		//获取当前被选中选项的文字
		String text=select.getFirstSelectedOption().getText();
		//断言获取到的文字是否符合实际
		Assert.assertEquals("java",text);
		//通过value值选择
		select.selectByValue("c");
		//通过选项文字选择
		select.selectByVisibleText("VB");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//取消所有选项的选中状态
		select.deselectAll();
		
	}
	@AfterMethod
	public void AfterMethod(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}

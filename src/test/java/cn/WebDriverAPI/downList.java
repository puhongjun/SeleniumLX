package cn.WebDriverAPI;
//单选下拉框
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class downList {
	public WebDriver driver;
	@Test
	public void test(){
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/Administrator.USER-20180602NR/Desktop/selenium.html");
		WebElement s=driver.findElement(By.xpath("//select[@id='selected']"));
		Select select=new Select(s);
		//isMultiple表示此下拉框列表是否允许多选，返回结果应为false
		Assert.assertFalse(select.isMultiple());
		//输出isMultiple方法返回的值
		Boolean b=select.isMultiple();
		System.out.println("b:"+b);
		//通过选项的文字进行选中
		select.selectByVisibleText("oppo");
		//获取当前被选中的下拉列表选项文本并赋给text1
		String text1=select.getFirstSelectedOption().getText();
		//断言
		Assert.assertEquals("oppo", text1);
		System.out.println("文本"+text1);
		//使用下拉列表选项的value属性值进行选中操作
		select.selectByValue("c");
		//获取当前被选中的下拉列表选项文本并赋给text2
		String text2=select.getFirstSelectedOption().getText();
		//断言
		Assert.assertEquals("vivo",text2);
		System.out.println("文本"+text2);
		//通过索引选择，从0开始
		select.selectByIndex(3);
		String text3=select.getFirstSelectedOption().getText();
		Assert.assertEquals("xiaomi",text3);
		System.out.println("文本"+text3);
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

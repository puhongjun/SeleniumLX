package cn.WebDriverAPI;
//操作CheckBox复选框

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckBox {
	WebDriver driver;
	@Test
	public void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/Administrator.USER-20180602NR/Desktop/selenium.html");
		//查找name值为checkbox2的复选框
		WebElement liu=driver.findElement(By.xpath("//input[@name='checkbox2']"));
		//判断如果此复选框还未被选中，则调用click方法单击选中
		if(!liu.isSelected())
			liu.click();
		//断言此复选框被成功选中
		Assert.assertTrue(liu.isSelected());
		//停2秒看效果
		Thread.sleep(2000);
		//判断如果此复选框处于被选中状态则再次调用click方法进行单击取消复选框的选中状态
		if(liu.isSelected())
			liu.click();
		//断言此复选框处于非选中状态
		Assert.assertFalse(liu.isSelected());
		Thread.sleep(2000);	
		//再次选中name值为checkbox2的复选框
		liu.click();
		Thread.sleep(2000);	
		//查找所有type属性值为 checkBox的复选框，并存在list容器内
		List<WebElement> checkboxs= driver.findElements(By.xpath("//input[@type='checkbox']"));
		//遍历容器中所有元素，判断每个复选框处于非选中状态，非选中状态的则调用click方法单击
		//因为name值为checkbox2的复选框在上一步时已被选中所有在for循环中不会再被点击
		for(WebElement checkbox:checkboxs){
			System.out.println(checkbox.isSelected());
			Thread.sleep(1000);
			if(!checkbox.isSelected())
				checkbox.click();
		}
		
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
}

package cn.testng;
//Testng运行webDriver测试用例
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestngDemo1 {
	
	public WebDriver driver;
	//访问网站地址
	String Url="http://www.sogou.com/";
	
  @Test
  public void test() {
	  //打开要访问网站
	  driver.get(Url);
	  //定位输入框并输入 zidonghuaceshi
	  driver.findElement(By.id("query")).sendKeys("zidonghuaceshi");
	  //定位并点击 搜索 按钮
	  driver.findElement(By.id("stb")).click();
  }
  
  @BeforeMethod
  public void beforeMethod(){
	  System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	  //打开谷歌浏览器
	  driver=new ChromeDriver();
  }
    @AfterMethod
  public void AfterMethod(){
      //关闭浏览器
	  driver.quit();
  }
}

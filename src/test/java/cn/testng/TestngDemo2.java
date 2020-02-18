package cn.testng;
//TestNG常用注解
import org.testng.annotations.*;

public class TestngDemo2 {
	
	@Test
	public void Testcase1(){
		System.out.println("@Test测试用例1 被执行");
	}
	@Test
	public void Testcase2(){
		System.out.println("@Test测试用例2 被执行");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("@BeforeMethod在每个测试方法开始运行前执行");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("@AfterMethod在每个测试方法运行结束后执行");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("@BeforeClass在当前测试类的任一测试用例开始运行前执行");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("@AfterClass在当前测试类的所有测试用例结束运行后执行");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("@BeforeTest在测试类中的Test开始运行前执行");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("@AfterTest在测试类中所有的test运行结束后执行");
	}
	
	@BeforeGroups
	public void beforeGroups(){
		System.out.println("@BeforeGroups在分组测试用例的任一用例开始运行前执行");
	}
	@AfterGroups
	public void afterGroups(){
		System.out.println("@AfterGroups在分组测试用例的所有用例运行结束后执行");
	}
	
	@BeforeSuite
	public void beforesuite(){
		System.out.println("@BeforeSuite在当前测试集合 Suite 中的所有测试程序开始运行前执行");
	}
	@AfterSuite
	public void aftersuite(){
		System.out.println("@AfterSuite在当前测试集合 Suite 中的所有测试程序运行结束后执行");
	}
}

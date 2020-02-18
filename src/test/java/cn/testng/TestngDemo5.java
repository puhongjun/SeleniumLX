package cn.testng;

import org.testng.annotations.Test;

//特定顺序执行测试用例
public class TestngDemo5 {
	@Test (priority=2)
	public void test1(){
		System.out.println("test1方法");
	}
	@Test (priority=1)
	public void test2(){
		System.out.println("test2方法");
	}
	@Test (priority=0)
	public void test3(){
		System.out.println("test3方法");
	}

}

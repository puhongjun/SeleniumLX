package cn.testng;

import org.testng.annotations.Test;

//依赖测试
public class TestngDemo4 {
	@Test (dependsOnMethods={"b"})
	public void a(){
		System.out.println("a方法被调用");
	}
	@Test (dependsOnMethods={"c"})
	public void b(){
		System.out.println("b方法被调用");
	}
	@Test
	public void c(){
		System.out.println("c方法被调用");
	}

}

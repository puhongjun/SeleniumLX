package cn.testng;

import org.testng.annotations.Test;

//测试用例的分组
public class TestngDemo3 {
	@Test (groups=("a"))
	public void student(){
		System.out.println("学生方法");
	}
	@Test(groups=("a"))
	public void tea(){
		System.out.println("老师方法");
	}
	@Test(groups=("b"))
	public void cat(){
		System.out.println("小猫方法");
	}
	@Test(groups=("b"))
	public void dog(){
		System.out.println("小狗方法");
	}
	@Test(groups={"a","b"})
	public void feede(){
		System.out.println("饲养员方法");
	}

}

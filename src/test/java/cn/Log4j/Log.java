package cn.Log4j;

import org.apache.log4j.Logger;


public class Log {
		//初始化Logger对象
		private static Logger Log=Logger.getLogger(Log.class.getName());
		//定义一个静态方法，可以打印自定义的某个测试用例开始执行的日志信息
	    public static void startTestCase(String CaseName){

	    	Log.info("======================================================");
	    	Log.info("*********   "+CaseName+"用例开始执行"+"   *********");
	    }
	    //定义一个静态方法，可以打印自定义的某个测试用例结束执行的日志信息
	    public static void endTestCase(String CaseName){
	    	Log.info("*********   "+CaseName+"用例执行结束"+"   *********");        
	    	Log.info("======================================================");
	    }
	    //定义一个静态info方法，打印自定义的info级别的日志信息
	    public static void info(String message){
	    	Log.info(message);
	    }
	    //定义一个静态的warn方法，打印自定义的warn级别的日志信息
	    public static void warn(String message){
	    	Log.warn(message);      
	    }
	    //定义一个静态的error方法，打印自定义的error级别的日志信息
	    public static void error(String message){
	    	Log.error(message);     
	    }
	    //定义一个静态的fatal方法，打印自定义的fatal级别的日志信息
	    public static void fatal(String message){
	    	Log.fatal(message);     
	    }
	    //定义一个静态的debug方法，打印自定义的debug级别的日志信息
	    public static void debug(String message){
	    	Log.debug(message);     
	    }

}

package org.cocky.lab.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//封装打桩信息，将来当切面组件使用
@Component
@Aspect//指定为切面
public class DebugLoggerBean {
	//用前置通知
	@Before("within(org.cocky.lab.controller..*)")
	  public void debugController(){
			System.out.println("进入controller方法处理");
	}
	
	@Before("within(org.cocky.lab.service.*)")
	  public void debugService(){
			System.out.println("进入Servlet方法处理");
	}
}

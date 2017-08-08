package org.cocky.lab.aop;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//作切面
@Component
@Aspect
public class ExceptionHanlder {
	//e参数作用是，接收目标组织抛出的异常对象
	//最终通知
	@AfterThrowing(throwing="e",pointcut="within(org.cocky.lab.controller..*)")
	public void hanlder(Exception e){
		 //将异常信息写入文件
		 System.out.println("发生异常了:"+e);
		 try {
			FileWriter fw=new FileWriter("note_error.log",true);
			PrintWriter pw=new PrintWriter(fw);
			e.printStackTrace(pw);
			pw.flush();
			pw.close();
			fw.close();
		} catch (Exception e1) {
			System.out.println("记录异常日志失败");
		}
		 
	 }
}

package org.cocky.lab.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.cocky.lab.service.UserService;
import org.cocky.lab.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult execute(
			String username,String password,String role){
		//调用业务组件处理
		
	System.out.println("ctr:"+role);
		
		NoteResult result = 
			userService.checkLogin(username, password,role);
		return result;
	}	
}

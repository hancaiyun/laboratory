package org.cocky.lab.controller.user;

import javax.annotation.Resource;

import org.cocky.lab.service.UserService;
import org.cocky.lab.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/user")
public class UserAddController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/addUser.do")
	@ResponseBody
	public NoteResult execute(String userId,String userName,String gender,String position,String tel
		){
		//System.out.println(password);
		//调用业务组件处理
		//System.out.println(userId+";"+userName+";"+gender+";"+position+";"+tel);
		NoteResult result = 
			userService.addUser(userId,userName,"1234",gender,position,tel );
		return result;
	}
}

package org.cocky.lab.controller.user;

import javax.annotation.Resource;

import org.cocky.lab.service.UserService;
import org.cocky.lab.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserInfoController {
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/show_user_info.do")
	@ResponseBody
	 public NoteResult execute(
			String username,String password){
			//System.out.println(password);
			//调用业务组件处理
			NoteResult result = 
				userService.userInfo();
			return result;
		}
	
}

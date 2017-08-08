package org.cocky.lab.controller.user;

import javax.annotation.Resource;

import org.cocky.lab.service.UserService;
import org.cocky.lab.util.NoteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserFindByIdController {
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/findUser.do")
	@ResponseBody
	 public NoteResult execute(String userName){
			//System.out.println(password);
			//调用业务组件处理
			NoteResult result = 
				userService.userFindById(userName);
			return result;
		}
}

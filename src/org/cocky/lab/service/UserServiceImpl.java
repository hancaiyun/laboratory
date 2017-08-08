package org.cocky.lab.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.cocky.lab.dao.UserDao;
import org.cocky.lab.entity.User;
import org.cocky.lab.util.NoteResult;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public NoteResult checkLogin(
		String username, String password,String role) {
		NoteResult result = new NoteResult();
		//检测用户
			User user=new User();
			System.out.println("Im:"+role);
		if("管理员".equals(role)){//查管理员表
			user=userDao.findAdminByName(username);
		}else{//查用户表
		    user = userDao.findByName(username);
		}
		
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户不存在");
//			result.setData(null);
			return result;
		}
		//检测密码
		//将用户收入的密码加密
		//String md5_password = NoteUtil.md5(password);
		//将加密结果和数据表中的密文对比
		if(!user.getUser_pwd().equals(password)){
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		result.setData(user.getUser_id());
		return result;
	}

	/*读取全部用户信息*/
	public NoteResult userInfo() {
		NoteResult result = new NoteResult();
		List<User> users=userDao.findAll();
		result.setStatus(0);
		result.setData(users);
		return result;
	}

	/*模糊查询用户信息*/
	public NoteResult userFindById(String UserName) {
		NoteResult result = new NoteResult();
		List<User> users=userDao.findUserById(UserName);
		result.setStatus(0);
		result.setData(users);
		return result;
	}

	/*添加用户信息  精确查找是否已有该用户*/
	public NoteResult addUser(String userId, String userName,String pwd, String gender,
			String position, String tel) {
		NoteResult result = new NoteResult();
		
		User user=userDao.findUserBeforeAdd(userId);
		
		//System.out.println("查出来的USERID:"+user.getUser_id());
		
		//System.out.println(userId); 
		
		if(user!=null){
			result.setStatus(1);
		    return result;
		 }
		
			User user1=new User();
			user1.setUser_id(userId);
			user1.setUser_name(userName);
			user1.setUser_pwd(pwd);
			user1.setGender(gender);
			user1.setPosition(position);
			user1.setTel(tel);
			userDao.addUser(user1);
			
			result.setStatus(0);	
		    return result;
	}
}

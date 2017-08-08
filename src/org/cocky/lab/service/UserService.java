package org.cocky.lab.service;

import org.cocky.lab.util.NoteResult;

public interface UserService {
		public NoteResult checkLogin(
			String username,String password,String role);
		public NoteResult userInfo();
		public NoteResult userFindById(String UserName);
		public NoteResult addUser(String userId, String userName,String pwd,
				String gender, String position, String tel);
}

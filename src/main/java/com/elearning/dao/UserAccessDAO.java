package com.elearning.dao;

import java.util.List;

import com.elearning.model.Contents;
import com.elearning.model.Student;
import com.elearning.model.UserRegisterReturnObject;

public interface UserAccessDAO {
	
	public UserRegisterReturnObject registerNewUser(Student st);
	public List<Contents> loginByUserName(Student st);
	public List<Contents> loggedUserContents(Student st);

}

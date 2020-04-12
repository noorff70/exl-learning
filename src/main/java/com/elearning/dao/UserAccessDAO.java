package com.elearning.dao;

import com.elearning.model.Student;
import com.elearning.model.UserRegisterReturnObject;

public interface UserAccessDAO {
	
	public UserRegisterReturnObject registerNewUser(Student st);

}

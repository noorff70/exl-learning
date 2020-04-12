package com.elearning.service;

import com.elearning.model.Student;
import com.elearning.model.UserRegisterReturnObject;

public interface UserAccessService {
	
	public UserRegisterReturnObject register (Student student);

}

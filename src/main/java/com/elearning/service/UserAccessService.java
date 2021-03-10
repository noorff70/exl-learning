package com.elearning.service;

import java.util.List;

import com.elearning.model.Contents;
import com.elearning.model.Student;
import com.elearning.model.UserRegisterReturnObject;

public interface UserAccessService {
	
	public UserRegisterReturnObject register (Student student);
	public List<Contents> loginByUserName(Student st);
	public List<Contents> loggedContents(Student st);
}

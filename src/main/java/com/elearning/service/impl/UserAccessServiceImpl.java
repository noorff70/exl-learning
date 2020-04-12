package com.elearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.UserAccessDAO;
import com.elearning.model.Student;
import com.elearning.model.UserRegisterReturnObject;
import com.elearning.service.UserAccessService;


@Service("userAccess")
public class UserAccessServiceImpl implements UserAccessService{

	@Autowired
	private UserAccessDAO userAccessDAO;
	
	@Override
	public UserRegisterReturnObject register(Student student) {
		
		UserRegisterReturnObject newUser = userAccessDAO.registerNewUser(student);
		
		return newUser;
	}

}

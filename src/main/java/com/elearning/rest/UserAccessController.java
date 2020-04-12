package com.elearning.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.model.Student;
import com.elearning.model.UserRegisterReturnObject;
import com.elearning.service.UserAccessService;

@RestController
public class UserAccessController {
	
		@Autowired
		private UserAccessService userAccess;
		
		@PostMapping("/registerNewUser")
		public UserRegisterReturnObject registerNewUser (@RequestBody Student student) {

			UserRegisterReturnObject userRegister = userAccess.register(student);
			
			return userRegister;
			
		}
}

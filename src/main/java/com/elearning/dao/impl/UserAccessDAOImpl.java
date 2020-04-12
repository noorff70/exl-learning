package com.elearning.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elearning.dao.UserAccessDAO;
import com.elearning.model.Student;
import com.elearning.model.UserRegisterReturnObject;


@Transactional
@Repository
public class UserAccessDAOImpl implements UserAccessDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate1;

	@Override
	public UserRegisterReturnObject registerNewUser(Student st) {
		
		UserRegisterReturnObject userReturn = new UserRegisterReturnObject();
				
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
		    parameters.put("STUDENTFNAME", st.getStudentFName());
		    parameters.put("STUDENTLNAME", st.getStudentLName());
		    parameters.put("PASSWORD", st.getPassword());
		    parameters.put("USERNAME", st.getUserName());
		    parameters.put("STUDENTEMAIL", st.getStudentEmail());
		    parameters.put("USERLOGGED", 1);
			
		    SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate1)
	                .withTableName("STUDENT")
	                .usingGeneratedKeyColumns("STUDENTID");
		  
		    Long id = simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
		    
		    userReturn.setRegisterSuccess(true);
		    userReturn.setMsgReturned("");
		    userReturn.setUserId(id);
		    
		  //  return id;
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("userName_UNIQUE")) {
				userReturn.setRegisterSuccess(false);
				userReturn.setMsgReturned("User name already exists");
			}	
		}
		return userReturn;
	}

}

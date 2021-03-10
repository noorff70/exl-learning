package com.elearning.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elearning.dao.ContentDAO;
import com.elearning.dao.UserAccessDAO;
import com.elearning.dao.rowmapper.StudentRowMapper;
import com.elearning.model.Contents;
import com.elearning.model.Student;
import com.elearning.model.UserRegisterReturnObject;


@Transactional
@Repository
public class UserAccessDAOImpl implements UserAccessDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate1;
	
	@Autowired
	private ContentDAO contentDAO;

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
	
	public List<Contents> loginByUserName(Student st) {
		
		String userName = st.getUserName().toLowerCase();
		String password = st.getPassword();
		List<Contents> contents = null;
		
		// update student as logged
		String updateQuery = "update Student set userLogged = 1 where LOWER(username) = ? AND password =?";
		int updateColumns = jdbcTemplate1.update(updateQuery, userName, password);
		
		if (updateColumns == 1) {
			// retrieve logged user
			String queryStudent = "select * from Student where LOWER(username) = ? AND password =?";

	        Student student = jdbcTemplate1.queryForObject
	        		(queryStudent, new Object[]{userName, password}, new StudentRowMapper());
	        
	        if (student != null ) {
	        	//get all the contents
	        	contents = contentDAO.getContentsByContentIdList(student.getStudentId());
	        }
		}
		return contents;
	}
	
	/*
	 * Return contents of a logged user
	 * 
	 */
	public List<Contents> loggedUserContents(Student st) {

		String userName = st.getUserName().toLowerCase();

		List<Contents> contents = null;

		// retrieve logged user
		String queryStudent = "select * from Student where LOWER(username) = ? ";

		Student student = jdbcTemplate1.queryForObject(queryStudent, new Object[] { userName }, new StudentRowMapper());

		if (student != null) {
			// get all the contents
			contents = contentDAO.getContentsByContentIdList(student.getStudentId());
		}

		return contents;
	}

}

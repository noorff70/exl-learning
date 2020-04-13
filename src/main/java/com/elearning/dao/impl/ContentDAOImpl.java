package com.elearning.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elearning.dao.ContentDAO;
import com.elearning.dao.rowmapper.ContentsRowMapper;
import com.elearning.dao.rowmapper.StudentRowMapper;
import com.elearning.model.Contents;
import com.elearning.model.Student;


@Transactional
@Repository
public class ContentDAOImpl  implements ContentDAO{
	
	
	@Autowired
	@Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;
	
	@Override
	public List<Contents> getAllContentsById(long id) {
		
		String query = "SELECT * FROM contents WHERE contentId = ?";
		List<Contents> contents = jdbcTemplate1.query(
		  query, new Object[] { id}, new ContentsRowMapper());

		return contents;
		
	}
	
	public List<Contents> getContentsByContentIdList(long studentId) {
		
		String query = "SELECT * FROM contents c "
				+ "inner join student_content sc "
				+ "on c.contentId = sc.contentId "
				+ "inner join student s "
				+ "on s.studentId = sc.studentId "
				+ " and s.studentId=?";
		List<Contents> contents = jdbcTemplate1.query(
		  query, new Object[] { studentId }, new ContentsRowMapper());

		return contents;
		
	}
	
	public List<Contents> getContentsListByContentDesc(String desc) {
		
		desc = desc.toLowerCase();
		
		String query = "select * from contents where LOWER(contentDesc) LIKE ?";
		List<Contents> contents = jdbcTemplate1.query(
				query, new Object[] { "%"+desc+ "%" }, new ContentsRowMapper());

		return contents;
		
	}
	
	@Override
	public Boolean insertStudentContent(String userName, long contentId ) {
		
		// StudentContent studentContent = new StudentContent();
		
		String queryStudent = "select * from Student where LOWER(username) = ? ";
		
		// find user with username
        Student student = jdbcTemplate1.queryForObject
        		(queryStudent, new Object[]{userName}, new StudentRowMapper());
				
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("STUDENTID", student.getStudentId());
		parameters.put("CONTENTID", contentId);
		    
			
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate1)
	            .withTableName("STUDENT_CONTENT")
	            .usingGeneratedKeyColumns("STUDENTID_CONTENT_ID");
		  
		Long id = simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
		    
		if (id >0)
			return Boolean.TRUE;
		else 
			return Boolean.FALSE;
	}
	
}
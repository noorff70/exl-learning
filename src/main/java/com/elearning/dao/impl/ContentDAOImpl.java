package com.elearning.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elearning.dao.ContentDAO;
import com.elearning.dao.rowmapper.ContentsRowMapper;
import com.elearning.model.Contents;


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
	
}
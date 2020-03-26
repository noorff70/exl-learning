package com.elearning.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.StudentContent;

public class StudentContentRowMapper implements RowMapper<StudentContent>{

		
		public StudentContent mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentContent contents = new StudentContent();
			contents.setStudentContentId(rs.getLong("student_content_id"));
			contents.setStudentId(rs.getLong("studentId"));
			contents.setContentId(rs.getLong("contentId"));
			return contents;
	   }
}

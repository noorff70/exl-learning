package com.elearning.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		student.setStudentFName(rs.getString("studentFName"));
		student.setStudentLName(rs.getString("studentLName"));
		student.setStudentEmail(rs.getString("studentEmail"));
		student.setUserName(rs.getString("userName"));
		student.setPassword(rs.getString("password"));
		student.setStudentId(rs.getLong("studentId"));
		student.setUserLogged(rs.getInt("userLogged"));
		
		return student;
	}

}

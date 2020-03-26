package com.elearning.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Lessons;

public class LessonRowMapper implements RowMapper<Lessons>{
	
	public Lessons mapRow(ResultSet rs, int rowNum) throws SQLException {
	/*	Lessons lessons = new Lessons();
		lessons.setLessonId(rs.getLong("lessonId"));
		lessons.setLessonTitle(rs.getString("lessonTitle"));
		lessons.setLessonDesc(rs.getString("lessonDesc"));
		lessons.setContentId(rs.getLong("contentId"));
		lessons.setLessonLink(rs.getString("lessonLink")); */
	//	return lessons;
		return null;
   }
}

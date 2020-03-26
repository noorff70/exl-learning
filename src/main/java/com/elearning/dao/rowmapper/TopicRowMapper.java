package com.elearning.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.elearning.model.Topic;

public class TopicRowMapper implements RowMapper<Topic>{
	
	public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
		Topic topic = new Topic();
		topic.setTopicId(rs.getInt("topicId"));
		topic.setTopicName(rs.getString("topicName"));
		topic.setTopicDesc(rs.getString("topicDesc"));
		return topic;
   }
}

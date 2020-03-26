package com.elearning.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.elearning.dao.TopicDAO;
import com.elearning.dao.rowmapper.TopicRowMapper;
import com.elearning.model.Topic;

@Repository
public class TopicDAOImpl implements TopicDAO {
	
	//@Autowired
	//DataSource dataSource1;
	
	@Autowired
    private JdbcTemplate jdbcTemplate1;
	
	/*@PostConstruct
	private void initialize(){
		setDataSource(dataSource1);
	}*/
	

	@Override
	public List<Topic> getAllTopic() {

		String sql = "SELECT * from topic";
		List<Map<String, Object>> rows = jdbcTemplate1.queryForList(sql);
		
		List<Topic> topicList = new ArrayList<Topic>();
		
		for (Map<String, Object> row: rows) {
			Topic topic = new Topic();
			topic.setTopicDesc((String)row.get("topicDesc"));
			topicList.add(topic);
		}
		
		return topicList;
	}
	
	public List<Topic> getTopicListByName(String topicType) {
		
		topicType = topicType.toLowerCase();
		
		String query = "SELECT * FROM topic WHERE LOWER(topicName) = ?";
		List<Topic> topics = jdbcTemplate1.query(
		  query, new Object[] { topicType }, new TopicRowMapper());

		return topics;
	}
	
	public List<Topic> getTopicListByDescription(String topicDesc) {
		
		topicDesc = topicDesc.toLowerCase();
		
		String query = "SELECT * FROM topic WHERE LOWER(topicDesc) LIKE ?";
		List<Topic> topics = jdbcTemplate1.query(
		  query, new Object[] { "%"+topicDesc+ "%" }, new TopicRowMapper());

		return topics;
	}
	
}
package com.elearning.dao;

import java.util.List;

import com.elearning.model.Topic;

public interface TopicDAO {
	
	public List<Topic> getAllTopic();
	public List<Topic> getTopicListByName(String topicType);
	public List<Topic> getTopicListByDescription(String topicDesc);

}

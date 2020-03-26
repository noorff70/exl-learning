package com.elearning.service;

import java.util.List;

import com.elearning.model.Topic;

public interface TopicService {
	
	public List<Topic> getAllTopics();
	public List<Topic>getTopicListByName(String topicType);
	public List<Topic>getTopicListByDescription(String topicDesc);

}

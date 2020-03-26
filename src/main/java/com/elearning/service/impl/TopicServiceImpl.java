package com.elearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.TopicDAO;
import com.elearning.model.Topic;
import com.elearning.service.TopicService;


@Service("topicService")
public class TopicServiceImpl  implements TopicService{
	
	@Autowired
	private TopicDAO topicDAO;

	@Override
	public List<Topic> getAllTopics() {

		return topicDAO.getAllTopic();
	}
	
	public List<Topic>getTopicListByName(String topicType) {
		return topicDAO.getTopicListByName(topicType);
	}
	
	public List<Topic>getTopicListByDescription(String topicDesc) {
		return topicDAO.getTopicListByDescription(topicDesc);
	}

}
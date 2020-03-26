package com.elearning.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.model.Topic;
import com.elearning.service.TopicService;


@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@GetMapping("/getTopicList")
	public List<Topic> getTopicDescription () {

		List<Topic> topicList = topicService.getAllTopics();
		
		return topicList;
		
	}
	
	@GetMapping("/getTopicByName")
	public List<Topic> getTopicByName (@RequestParam("TOPICNAME") String topicName) {

		List<Topic> topicList = topicService.getTopicListByName(topicName);
		
		return topicList;
		
	}
	
	@GetMapping("/getTopicByDescription")
	public List<Topic> getTopicByDescription (@RequestParam("TOPICDESC") String topicDesc) {

		List<Topic> topicList = topicService.getTopicListByDescription(topicDesc);
		
		return topicList;
		
	}

}

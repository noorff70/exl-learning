package com.elearning.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.model.Lessons;
import com.elearning.service.LessonService;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@GetMapping("/getLessonByContentId")
	public Lessons getTopicDescription (@RequestParam("CONTENTID") long contentId) {

		Lessons lesson = lessonService.getLessonByContentId(contentId);
		
		return lesson;
		
	}

}

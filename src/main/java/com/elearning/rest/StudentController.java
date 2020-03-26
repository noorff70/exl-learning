package com.elearning.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.model.Contents; 
import com.elearning.service.ContentService;


@RestController
public class StudentController {
	
	@Autowired
	private ContentService contentService;
	
	@GetMapping("/getContentListByStudentId")
	public List<Contents> getContentsByStudentId (@RequestParam("STUDENTID") long studentId) {

		List<Contents> contentsList = contentService.getContentsListByStudentId(studentId);
		
		return contentsList;
		
	}

}

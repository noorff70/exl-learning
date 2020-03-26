package com.elearning.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.model.Contents;
import com.elearning.service.ContentService;


@RestController
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@GetMapping("/getContentListById")
	public List<Contents> getTopicListById (@RequestParam("CONTENTID") long contentId) {

		List<Contents> contentList = contentService.getAllContentsById(contentId);
		
		return contentList;
		
	}
	
	@PostMapping("/getContentListByContentDesc")
	public List<Contents> getTopicListByContentDescription (@RequestBody String desc) {

		List<Contents> contentList = contentService.getContentsListByContentDesc(desc);
		
		return contentList;
		
	}
	
	@GetMapping("/getAllContentList")
	public List<Contents> getAllContentList () {

		List<Contents> contentList = contentService.getContentsListByContentDesc(null);
		
		return contentList;
		
	}

}

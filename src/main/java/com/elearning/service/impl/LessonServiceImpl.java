package com.elearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dao.LessonDAO;
import com.elearning.model.Lessons;
import com.elearning.service.LessonService;

@Service("lessonService")
public class LessonServiceImpl implements LessonService{

	@Autowired
	private LessonDAO lessonDAO;
	

	@Override
	public Lessons getLessonByContentId(long id) {
		return lessonDAO.getLessonByContentId(id);
	}

}

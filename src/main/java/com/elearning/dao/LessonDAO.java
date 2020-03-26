package com.elearning.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.elearning.model.Lessons;

@Repository
public interface LessonDAO extends MongoRepository<Lessons, Long> {
	
	public Lessons getLessonByContentId(long id);

}

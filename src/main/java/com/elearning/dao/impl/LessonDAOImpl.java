package com.elearning.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import com.elearning.dao.LessonDAO;
import com.elearning.model.Lessons;

@Repository
public class LessonDAOImpl implements LessonDAO{
	
	
	@Autowired
    private MongoTemplate  mongoTemp;

	
	@Override
	public Lessons getLessonByContentId(long id) {
		
		Lessons lessons = null;
		
	//	try {
		//	CountDownLatch latch = new CountDownLatch(1);
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			lessons = mongoTemp.findOne(query, Lessons.class);

		//	latch.await();
			
	//	} catch(InterruptedException  ex) {
			
	//	}
		
		return lessons;
	}


	@Override
	public <S extends Lessons> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Lessons> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Lessons> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Lessons> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Lessons> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Lessons> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Lessons> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Lessons> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Lessons> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Lessons> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterable<Lessons> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Lessons entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends Lessons> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Lessons> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Lessons> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Lessons> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public <S extends Lessons> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


}
package com.elearning.service;

import java.util.List;


import com.elearning.model.Contents;

public interface ContentService {
	
	public List<Contents> getAllContentsById(long id);
	public List<Contents> getContentsListByStudentId(long studentId);
	public List<Contents> getContentsListByContentDesc(String desc);

}

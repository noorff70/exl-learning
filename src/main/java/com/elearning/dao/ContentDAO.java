package com.elearning.dao;

import java.util.List;

import com.elearning.model.Contents;

public interface ContentDAO {

	public List<Contents> getAllContentsById(long id);
	public List<Contents> getContentsByContentIdList(long studentId);
	public List<Contents> getContentsListByContentDesc(String desc);
	public Boolean insertStudentContent(String userName, long contentId );
}

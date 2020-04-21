package com.elearning.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("lesson")
public class Lessons {
	
	@Id
	long _id;
	String lessonTitle;
	String lessonAuthor;
	List<LessionMission> lessonMission;
	List<LessonContent> lessonContent;
	//long contentId;	
	
	public long get_Id() {
		return _id;
	}
	public void set_Id(long lessonId) {
		this._id = lessonId;
	}
	public String getLessonTitle() {
		return lessonTitle;
	}
	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}
	public List<LessionMission> getLessonMission() {
		return lessonMission;
	}
	public void setLessonMission(List<LessionMission> lessonMission) {
		this.lessonMission = lessonMission;
	}
	public List<LessonContent> getLessonContent() {
		return lessonContent;
	}
	public void setLessonContent(List<LessonContent> content) {
		this.lessonContent = content;
	}
	/*public String getLessonLink() {
		return lessonLink;
	}
	public void setLessonLink(String lessonLink) {
		this.lessonLink = lessonLink;
	}*/
	
	public String getLessonAuthor() {
		return this.lessonAuthor;
	}
	
	public void setLessonAuthor(String author) {
		this.lessonAuthor = author;
	}
	
}

@Document
class LessionMission {
	private int id;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

@Document
class LessonContent {
	
	String lessonTitle;
	List<LessonSubTitle> subTitle;
	
	
	public String getLessonTitle() {
		return lessonTitle;
	}
	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}
	public List<LessonSubTitle> getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(List<LessonSubTitle> subTitle) {
		this.subTitle = subTitle;
	}
}

@Document
class LessonSubTitle {
	
	String name;
	String lessonLink;
	String lessonType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLessonLink() {
		return lessonLink;
	}
	public void setLessonLink(String lessonLink) {
		this.lessonLink = lessonLink;
	}
	public String getLessonType() {
		return lessonType;
	}
	public void setLessonType(String lessonType) {
		this.lessonType = lessonType;
	}
}

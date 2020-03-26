package com.elearning.model;

public class Topic {
	
	int topicId;
	String topicName;
	String typeDesc;
	
	public Topic() {
		
	}
	
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int id) {
		this.topicId = id;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String typeName) {
		this.topicName = typeName;
	}
	public String getTopicDesc() {
		return typeDesc;
	}
	public void setTopicDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	
	

}

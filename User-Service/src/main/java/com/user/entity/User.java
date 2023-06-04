package com.user.entity;

import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("user_info")
public class User {
	int id;
	String name;
	private HashMap<String, Object> careers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Object> getCareers() {
		return careers;
	}
	public void setCareers(HashMap<String, Object> careers) {
		this.careers = careers;
	}
	
	
	
}

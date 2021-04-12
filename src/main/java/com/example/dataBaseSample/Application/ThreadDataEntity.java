package com.example.dataBaseSample.Application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ThreadDataEntity {
@Id
@GeneratedValue
private Integer id;
private String title;
private String name;
private String message;

//コンストラクタ
public ThreadDataEntity() {
	super();
}
public ThreadDataEntity(String title ,String name,String message) {
	super();
	this.title=title;
	this.name=name;
	this.message=message;
}
public Integer getId(){
	return id;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}

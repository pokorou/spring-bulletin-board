package com.example.dataBaseSample.Application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = " ComentDataEntity.findThread", query =  "SELECT c FROM ComentDataEntity c")
public class ComentDataEntity {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer threadNumber;
	private String name;
	private String message;
	
	public ComentDataEntity() {
		super();
	}
	public ComentDataEntity(Integer threadNumber,String name,String message) {
		super();
		this.threadNumber=threadNumber;
		this.name=name;
		this.message=message;
	}
	public Integer getId() {
		return id;
	}
	public Integer getThreadName() {
		return threadNumber;
	}
	public void setThreadName(Integer threadNumber) {
		this.threadNumber = threadNumber;
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

package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
  @Id
  @GeneratedValue
  private long id;
  private String description;
  private String supervisor;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getSupervisor() {
	return supervisor;
}
public void setSupervisor(String supervisor) {
	this.supervisor = supervisor;
}

}

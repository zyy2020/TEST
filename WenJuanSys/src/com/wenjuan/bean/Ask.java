package com.wenjuan.bean;

public class Ask {
  int id;
  String question;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public Ask(String question) {
	super();
	this.question = question;
}
public Ask(int id, String question) {
	super();
	this.id = id;
	this.question = question;
}
public Ask() {
	super();
	
}
@Override
public String toString() {
	return "Ask [id=" + id + ", question=" + question + "]";
}
}

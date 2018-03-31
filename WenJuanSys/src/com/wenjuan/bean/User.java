package com.wenjuan.bean;

import java.util.Date;

public class User {
	int id;
	String name;
	String pwd;
	String gender;
	Date birth;
	String img;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", gender=" + gender + ", birth=" + birth
				+ ", img=" + img + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public User(String name, String pwd, String gender, Date birth, String img) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.gender = gender;
		this.birth = birth;
		this.img = img;
	}

	public User() {
		super();

	}

	public User(int id, String name, String pwd, String gender, Date birth, String img) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.gender = gender;
		this.birth = birth;
		this.img = img;
	}
}

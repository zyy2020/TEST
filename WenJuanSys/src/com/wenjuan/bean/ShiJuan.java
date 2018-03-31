package com.wenjuan.bean;

import java.util.Date;

public class ShiJuan {
	int id;
	String title;
	Date riqi;
	int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRiqi() {
		return riqi;
	}

	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ShiJuan [id=" + id + ", title=" + title + ", riqi=" + riqi + ", score=" + score + "]";
	}

	public ShiJuan(int id, String title, Date riqi, int score) {
		super();
		this.id = id;
		this.title = title;
		this.riqi = riqi;
		this.score = score;
	}

	public ShiJuan(String title, Date riqi, int score) {
		super();
		this.title = title;
		this.riqi = riqi;
		this.score = score;
	}

	public ShiJuan() {
		super();

	}

}

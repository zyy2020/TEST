package com.wenjuan.bean;

public class TianKong {
	int id;
	String question;
	String answer;
	int score;

	@Override
	public String toString() {
		return "TianKong [id=" + id + ", question=" + question + ", answer=" + answer + ", score=" + score + "]";
	}

	public TianKong(String question, String answer, int score) {
		super();
		this.question = question;
		this.answer = answer;
		this.score = score;
	}

	public TianKong() {
		super();
	}

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public TianKong(int id, String question, String answer, int score) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.score = score;
	}

}

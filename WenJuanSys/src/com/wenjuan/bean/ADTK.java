package com.wenjuan.bean;

public class ADTK {
	int shiJuanId;
	int askId;
	int userId;
	String answer;

	public int getShiJuanId() {
		return shiJuanId;
	}

	public void setShiJuanId(int shiJuanId) {
		this.shiJuanId = shiJuanId;
	}

	public int getAskId() {
		return askId;
	}

	public void setAskId(int askId) {
		this.askId = askId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "ADTK [shiJuanId=" + shiJuanId + ", askId=" + askId + ", userId=" + userId + ", answer=" + answer + "]";
	}

	public ADTK(int shiJuanId, int askId, int userId, String answer) {
		super();
		this.shiJuanId = shiJuanId;
		this.askId = askId;
		this.userId = userId;
		this.answer = answer;
	}

	public ADTK() {
		super();

	}

}

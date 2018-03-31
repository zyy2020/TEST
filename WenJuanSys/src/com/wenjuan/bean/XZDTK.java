package com.wenjuan.bean;

public class XZDTK {
	int shiJuanId;
	int xuanZeId;
	int userId;
	String answer;
	@Override
	public String toString() {
		return "XZDTK [shiJuanId=" + shiJuanId + ", xuanZeId=" + xuanZeId + ", userId=" + userId + ", answer=" + answer
				+ "]";
	}
	public int getShiJuanId() {
		return shiJuanId;
	}
	public void setShiJuanId(int shiJuanId) {
		this.shiJuanId = shiJuanId;
	}
	public int getXuanZeId() {
		return xuanZeId;
	}
	public void setXuanZeId(int xuanZeId) {
		this.xuanZeId = xuanZeId;
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
	public XZDTK(int shiJuanId, int xuanZeId, int userId, String answer) {
		super();
		this.shiJuanId = shiJuanId;
		this.xuanZeId = xuanZeId;
		this.userId = userId;
		this.answer = answer;
	}
	public XZDTK() {
		super();
		
	}
	
}

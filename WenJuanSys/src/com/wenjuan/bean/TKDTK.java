package com.wenjuan.bean;

public class TKDTK {
	int shiJuanId;
	int tianKongId;
	int userId;
	String answer;

	public int getShiJuanId() {
		return shiJuanId;
	}

	public void setShiJuanId(int shiJuanId) {
		this.shiJuanId = shiJuanId;
	}

	public int getTianKongId() {
		return tianKongId;
	}

	public void setTianKongId(int tianKongId) {
		this.tianKongId = tianKongId;
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
		return "TKDTK [shiJuanId=" + shiJuanId + ", tianKongId=" + tianKongId + ", userId=" + userId + ", answer="
				+ answer + "]";
	}

	public TKDTK(int shiJuanId, int tianKongId, int userId, String answer) {
		super();
		this.shiJuanId = shiJuanId;
		this.tianKongId = tianKongId;
		this.userId = userId;
		this.answer = answer;
	}

	public TKDTK() {
		super();

	}

}

package com.wenjuan.bean;

public class SJAsk {
	ShiJuan shiJuan;
	Ask ask;

	public ShiJuan getShiJuan() {
		return shiJuan;
	}

	public void setShiJuan(ShiJuan shiJuan) {
		this.shiJuan = shiJuan;
	}

	public Ask getAsk() {
		return ask;
	}

	public void setAsk(Ask ask) {
		this.ask = ask;
	}

	@Override
	public String toString() {
		return "SJAsk [shiJuan=" + shiJuan + ", ask=" + ask + "]";
	}

	public SJAsk(ShiJuan shiJuan, Ask ask) {
		super();
		this.shiJuan = shiJuan;
		this.ask = ask;
	}

	public SJAsk() {
		super();

	}

}

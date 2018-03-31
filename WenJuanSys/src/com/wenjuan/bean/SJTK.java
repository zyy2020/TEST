package com.wenjuan.bean;

public class SJTK {
	ShiJuan shiJuan;
	TianKong tianKong;

	public ShiJuan getShiJuan() {
		return shiJuan;
	}

	public void setShiJuan(ShiJuan shiJuan) {
		this.shiJuan = shiJuan;
	}

	public TianKong getTianKong() {
		return tianKong;
	}

	public void setTianKong(TianKong tianKong) {
		this.tianKong = tianKong;
	}

	@Override
	public String toString() {
		return "SJTK [shiJuan=" + shiJuan + ", tianKong=" + tianKong + "]";
	}

	public SJTK(ShiJuan shiJuan, TianKong tianKong) {
		super();
		this.shiJuan = shiJuan;
		this.tianKong = tianKong;
	}

	public SJTK() {
		super();

	}

}

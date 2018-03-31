package com.wenjuan.bean;

public class SJXZ {
	ShiJuan shiJuan;
	XuanZe xuanZe;

	public ShiJuan getShiJuan() {
		return shiJuan;
	}

	public void setShiJuan(ShiJuan shiJuan) {
		this.shiJuan = shiJuan;
	}

	public XuanZe getXuanZe() {
		return xuanZe;
	}

	public void setXuanZe(XuanZe xuanZe) {
		this.xuanZe = xuanZe;
	}

	@Override
	public String toString() {
		return "SJXZ [shiJuan=" + shiJuan + ", xuanZe=" + xuanZe + "]";
	}

	public SJXZ(ShiJuan shiJuan, XuanZe xuanZe) {
		super();
		this.shiJuan = shiJuan;
		this.xuanZe = xuanZe;
	}

	public SJXZ() {
		super();

	}

}

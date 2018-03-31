package com.wenjuan.bean;

public class XuanZe {
	int id;
	String title;
	String key1;
	int weight1;
	String key2;
	int weight2;
	String key3;
	int weight3;
	String key4;
	int weight4;

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

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public int getWeight1() {
		return weight1;
	}

	public void setWeight1(int weight1) {
		this.weight1 = weight1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public int getWeight2() {
		return weight2;
	}

	public void setWeight2(int weight2) {
		this.weight2 = weight2;
	}

	public String getKey3() {
		return key3;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public int getWeight3() {
		return weight3;
	}

	public void setWeight3(int weight3) {
		this.weight3 = weight3;
	}

	public String getKey4() {
		return key4;
	}

	public void setKey4(String key4) {
		this.key4 = key4;
	}

	public int getWeight4() {
		return weight4;
	}

	public void setWeight4(int weight4) {
		this.weight4 = weight4;
	}

	@Override
	public String toString() {
		return "XuanZe [id=" + id + ", title=" + title + ", key1=" + key1 + ", weight1=" + weight1 + ", key2=" + key2
				+ ", weight2=" + weight2 + ", key3=" + key3 + ", weight3=" + weight3 + ", key4=" + key4 + ", weight4="
				+ weight4 + "]";
	}

	public XuanZe(String title, String key1, int weight1, String key2, int weight2, String key3, int weight3,
			String key4, int weight4) {
		super();
		this.title = title;
		this.key1 = key1;
		this.weight1 = weight1;
		this.key2 = key2;
		this.weight2 = weight2;
		this.key3 = key3;
		this.weight3 = weight3;
		this.key4 = key4;
		this.weight4 = weight4;
	}

	public XuanZe(int id, String title, String key1, int weight1, String key2, int weight2, String key3, int weight3,
			String key4, int weight4) {
		super();
		this.id = id;
		this.title = title;
		this.key1 = key1;
		this.weight1 = weight1;
		this.key2 = key2;
		this.weight2 = weight2;
		this.key3 = key3;
		this.weight3 = weight3;
		this.key4 = key4;
		this.weight4 = weight4;
	}

	public XuanZe() {
		super();
		
	}
}

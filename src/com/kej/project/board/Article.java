package com.kej.project.board;

public class Article {
	private int id;
	private String title;
	private String body;
	private String date;
	private String userName;

	Article(int id, String title, String body, String date, String userName) {

		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return String.format("[No.%d] [제목:%s] [내용:%s] [작성자:%s] [작성일:%s]", id, title, body, userName, date);

	}

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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

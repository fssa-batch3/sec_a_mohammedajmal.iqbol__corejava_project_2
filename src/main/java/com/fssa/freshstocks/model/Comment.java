package com.fssa.freshstocks.model;

public class Comment {
	
	private int courseId;
	private int commentId;
	private int userId;
	private String comment;
	
	public Comment(int courseId, int userId, String comment) {
		super();
		this.courseId = courseId;
		this.userId = userId;
		this.comment = comment;
	}
	
	public Comment(int commentId,int courseId, int userId, String comment) {
		super();
		this.commentId = commentId;
		this.courseId = courseId;
		this.userId = userId;
		this.comment = comment;
	}
	
	public Comment(String comment) {
		super();
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "[courseId=" + courseId + ", commentId=" + commentId + ", userId=" + userId + ", comment="
				+ comment + "]" + "\n";
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}

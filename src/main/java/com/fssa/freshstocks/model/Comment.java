package com.fssa.freshstocks.model;

public class Comment {

    // Fields
    private int commentId;
    private int userId;
    private int courseId;
    private String commentBody;
    private String username;
    private String coursename;

    // Constructors
    
    /**
     * Constructor for creating a comment with course ID, user ID, and comment body.
     *
     * @param courseId The ID of the course the comment is related to.
     * @param userId   The ID of the user who posted the comment.
     * @param comment  The content of the comment.
     */
    public Comment(int courseId, int userId, String comment) {
        this.courseId = courseId;
        this.userId = userId;
        this.commentBody = comment;
    }

   
    /**
     * Constructor for creating a comment with comment ID, username, coursename, and comment body.
     *
     * @param commentId   The ID of the comment.
     * @param username    The username of the user who posted the comment.
     * @param coursename  The name of the course the comment is related to.
     * @param commentBody The content of the comment.
     */

    public Comment(int commentId, String username, String coursename, String commentBody) {
        this.commentId = commentId;
        this.username = username;
        this.coursename = coursename;
        this.commentBody = commentBody;
    }

   
    /**
     * Constructor for creating a comment with comment ID, course ID, user ID, and comment body.
     *
     * @param commentId   The ID of the comment.
     * @param courseId    The ID of the course the comment is related to.
     * @param userId      The ID of the user who posted the comment.
     * @param commentBody The content of the comment.
     */

    public Comment(int commentId, int courseId, int userId, String comment) {
        this.commentId = commentId;
        this.courseId = courseId;
        this.userId = userId;
        this.commentBody = comment;
    }

   
    /**
     * Constructor for creating a comment with just the comment body.
     *
     * @param comment The content of the comment.
     */
    public Comment(String comment) {
        this.commentBody = comment;
    }

    /**
     * Constructor for creating a comment with only the course ID.
     *
     * @param courseId The ID of the course the comment is related to.
     */
    public Comment(int courseId) {
        this.courseId = courseId;
    }

    // Getters and Setters
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
		return commentBody;
	}

    // toString method to provide a string representation of the Comment object
	@Override
	public String toString() {
		return "[commentId=" + commentId + ", username=" + username + ", coursename=" + coursename
				+ ", commentBody=" + commentBody + "]";
	}

}

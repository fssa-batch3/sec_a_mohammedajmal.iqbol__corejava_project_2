package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.services.exception.*;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.dao.*;

public class TestGetAllCommentsFeature {

	public static void main(String[] args) {

		CommentDAO commentDAO = new CommentDAO();
		int courseID = 1;

		List<Comment> cleanedEntries = null;
		try {
			cleanedEntries = commentDAO.getAllComments(courseID);
			if(cleanedEntries.isEmpty()) {
				System.out.println("Comments Doesn't Exist!");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

		for (Comment str : cleanedEntries) {
			System.out.println(str);
		}
	}

	@Test
	void testGetAllCommentSuccess() {
		CommentDAO commentDAO = new CommentDAO();
		int courseID = 1;
		List<Comment> cleanedEntries = null;
		try {
			cleanedEntries = commentDAO.getAllComments(courseID);
			if(cleanedEntries.isEmpty()) {
				System.out.println("Comments Doesn't Exist!");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		assertTrue(cleanedEntries.size() > 0);
	}

	@Test
	void testGetAllCommentsInvalid() {
		CommentDAO commentDAO = new CommentDAO();
		int courseID = 10;
		List<Comment> cleanedEntries = null;
		try {
			cleanedEntries = commentDAO.getAllComments(courseID);
			if(cleanedEntries.isEmpty()) {
				System.out.println("Comments Doesn't Exist!");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		assertFalse(!cleanedEntries.isEmpty());
	}

	@Test
	void testGetAllCommentsNull() {
		CommentDAO commentDAO = new CommentDAO();
		List<Comment> cleanedEntries = null;
		assertNull(cleanedEntries);
	}
}
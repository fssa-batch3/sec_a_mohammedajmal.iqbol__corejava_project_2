package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.dao.*;

public class TestGetAllCommentsFeature {

	public static void main(String[] args) throws DAOException {

		CommentDAO commentDAO = new CommentDAO();
		int courseID = 21;
		
		 List<Comment> cleanedEntries = commentDAO.getAllComments(courseID);

		try {
			 for(Comment str : cleanedEntries) {
				 System.out.println(str);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testGetAllCommentSuccess() throws DAOException, SQLException {
		CommentDAO commentDAO = new CommentDAO();
		int courseID = 21;
		 List<Comment> cleanedEntries = commentDAO.getAllComments(courseID);
		assertTrue(cleanedEntries.size() > 0);
	}
	
	@Test
	void testGetAllCommentsInvalid() throws DAOException, SQLException {
		CommentDAO commentDAO = new CommentDAO();
		int courseID = 10;
		 List<Comment> cleanedEntries = commentDAO.getAllComments(courseID);
		 assertFalse(!cleanedEntries.isEmpty());
	}
	
	@Test
	void testGetAllCommentsNull() throws DAOException, SQLException {
		CommentDAO commentDAO = new CommentDAO();
		 List<Comment> cleanedEntries = null;
		 assertNull(cleanedEntries);
	}
}
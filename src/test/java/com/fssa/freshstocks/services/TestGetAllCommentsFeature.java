package com.fssa.freshstocks.services;

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

	public static void main(String[] args) throws SQLException, DAOException {

		CommentDAO commentDAO = new CommentDAO();
		
		 List<Comment> cleanedEntries = commentDAO.getAllComments();

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
		 List<Comment> cleanedEntries = commentDAO.getAllComments();
		assertTrue(cleanedEntries.size() > 0);
	}
	
	@Test
	void testGetAllCommentsInvalid() throws DAOException, SQLException {
		CommentDAO commentDAO = new CommentDAO();
		 List<Comment> cleanedEntries = commentDAO.getAllComments();
		assertFalse(cleanedEntries.size() <= 0);
	}
	
	@Test
	void testGetAllCommentsNull() throws DAOException, SQLException {
		CommentDAO commentDAO = new CommentDAO();
		 List<Comment> cleanedEntries = null;
		 assertNull(cleanedEntries);
	}
}
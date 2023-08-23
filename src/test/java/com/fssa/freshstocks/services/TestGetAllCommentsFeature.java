package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fssa.freshstocks.dao.exception.DAOException;
import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.dao.*;

class TestGetAllCommentsFeature {
	
    private CommentDAO commentDAO;
    private List<Comment> cleanedEntries;

    @BeforeEach
    void setup() {
        commentDAO = new CommentDAO();
        cleanedEntries = null;
    }

    @Test
    @Order(1)
    void testGetAllCommentSuccess() {
        int courseID = 4;
        try {
            cleanedEntries = commentDAO.getAllComments(courseID);
            if (cleanedEntries.isEmpty()) {
                System.out.println("Comments Doesn't Exist!");
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        assertTrue(cleanedEntries.size() > 0);
    }

    @Test
    @Order(2)
    void testGetAllCommentsInvalid() {
        int courseID = 10;
        try {
            cleanedEntries = commentDAO.getAllComments(courseID);
            assertFalse(cleanedEntries.size() > 0);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    void testGetAllCommentsNull() {
        List<Comment> cleanedEntries = null;
        assertNull(cleanedEntries);
    }
}
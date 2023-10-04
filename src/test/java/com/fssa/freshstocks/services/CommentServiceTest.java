package com.fssa.freshstocks.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.freshstocks.model.Comment;
import com.fssa.freshstocks.services.exception.ServiceException;

 class CommentServiceTest {
    private CommentService commentService;

    @BeforeEach
     void setUp() {
        // Initialize the service
        commentService = new CommentService();
    }

    @Test
     void testListCommentWithValidCourseId() throws ServiceException {
        // Arrange
        int courseId = 14;

        // Act
        List<Comment> comments = commentService.listComment(courseId);

        // Assert
        assertNotNull(comments);
        // Add more specific assertions based on your expectations
    }

    @Test
     void testListCommentWithInvalidCourseId() {
        // Arrange
        int invalidCourseId = -1;

        // Act and Assert
        assertThrows(ServiceException.class, () -> {
            commentService.listComment(invalidCourseId);
        });
    }

    @Test
     void testGetCommentByValidCommentID() throws ServiceException {
        // Arrange
        int commentId = 26;

        // Act
        Comment comment = commentService.getCommentByCommentID(commentId);

        // Assert
        assertNotNull(comment);
        // Add more specific assertions based on your expectations
    }
 
    @Test
     void testGetCommentByInvalidCommentID() {
        // Arrange
        int invalidCommentId = -1;

        // Act and Assert
        try {
			assertNull(commentService.getCommentByCommentID(invalidCommentId));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
    }
    
    @Test
    void testCommentConstructor() {
        Comment comment = new Comment(27, 14, 56, "nice course");
        assertNotNull(comment);
    }
}

package freshstocks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import freshstocks.model.Course;
import freshstocks.model.User;

public class CourseDAO {
	
	 //connect to database
	 public Connection getConnection() throws SQLException {
	        String dbUrl = "jdbc:mysql://localhost:3306/project";
	        String dbUser = "root";
	        String dbPassword = "root";

	     return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	 }

	//add new course to DB - Register
	public boolean createCourse(Course course) throws SQLException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		int rows = 0;
		   
		try {
		//Get Connection
		connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO course (courseID,name,cover_image,timing,language,marked_price,selling_price,instructor_name,company_name,company_category,top_skills) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		pst = connection.prepareStatement(insertQuery);
		pst.setInt(1, course.getCourseID());
		pst.setString(2, course.getName());
		pst.setString(3, course.getCoverImage());
		pst.setString(4, course.getTiming());
		pst.setString(5, course.getLanguage());
		pst.setString(6, course.getMarkedPrice());
		pst.setString(7, course.getSellingPrice());
		pst.setString(8, course.getInstructorName());
		pst.setString(9, course.getCompanyName());
		pst.setString(10, course.getCompanyCategory());
		pst.setString(11, course.getTopSkills());
		//Execute query
		rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			   if(pst != null) {
				   pst.close();
			   }
			   if(connection != null) {
				   connection.close();
			   }
		}
		
		//Return Successful or not
		return (rows == 1);
	}
	
	   //Name Should Not Exist
	   public boolean SameNameExist(Course course) throws SQLException {
			
		   boolean match = false;
		   Connection connection = null;
		   ResultSet resultSet = null;
		   PreparedStatement pst = null;
		   
		   try {
		   connection = getConnection();
		   
		   String NameExistQuery = "SELECT * FROM course WHERE name = ?";
		   pst = connection.prepareStatement(NameExistQuery);
		   pst.setString(1, course.getName());
		   resultSet = pst.executeQuery();
		   
		   while (resultSet.next()) {
			   String name = resultSet.getString("name");
			   
			   System.out.println("Name: " + name);
			   
			   if(course.getName().equals(name)) {
				   match = true;
			   }
		   }
		   } catch (SQLException e) {
			   e.printStackTrace();
		   } finally {
			   
			   if(resultSet != null) {
				   resultSet.close();
			   }
			   if(pst != null) {
				   pst.close();
			   }
			   if(connection != null) {
				   connection.close();
			   }
		   }
		   return match;
		}
	   
	   //get courses by course name
	   public String readCourse(Course course) throws SQLException {
	       Connection connection = null;
	       ResultSet resultSet = null;
	       PreparedStatement pst = null;
	       StringBuilder resultBuilder = new StringBuilder();

	       try {
	           connection = getConnection();
	           String selectQuery = "SELECT * FROM course WHERE name = ?";
	           pst = connection.prepareStatement(selectQuery);
	           pst.setString(1, course.getName());
	           resultSet = pst.executeQuery();

	           if (!resultSet.isBeforeFirst()) {
	               return "No courses found for the given name: " + course.getName();
	           }

	           while (resultSet.next()) {
	               String name = resultSet.getString("name");
	               String coverImage = resultSet.getString("cover_image");
	               String timing = resultSet.getString("timing");
	               String language = resultSet.getString("language");
	               String markedPrice = resultSet.getString("marked_price");
	               String sellingPrice = resultSet.getString("selling_price");
	               String description = resultSet.getString("description");
	               String instructorName = resultSet.getString("instructor_name");
	               String companyName = resultSet.getString("company_name");
	               String companyCategory = resultSet.getString("company_category");
	               String topSkills = resultSet.getString("top_skills");

	               if (course.getName().equalsIgnoreCase(name)) {
	                   resultBuilder.append("Name: ").append(name).append(", Cover Image: ").append(coverImage)
	                           .append(", Timing: ").append(timing).append(", Language: ").append(language)
	                           .append(", Marked Price: ").append(markedPrice).append(", Selling Price: ").append(sellingPrice)
	                           .append(", Description: ").append(description).append(", Instructor Name: ").append(instructorName)
	                           .append(", Company Name: ").append(companyName).append(", Company Category: ").append(companyCategory)
	                           .append(", Top Skills: ").append(topSkills).append("\n");
	               }

	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           if (resultSet != null) {
	               resultSet.close();
	           }
	           if (pst != null) {
	               pst.close();
	           }
	           if (connection != null) {
	               connection.close();
	           }
	       }
	       return resultBuilder.toString();
	   }

	   
}

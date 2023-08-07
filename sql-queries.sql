USE project;
SHOW tables;

 <--MILESTONE-1 COURSE USER DB CRUD QUERIES STARTED -->
  <-- CREATE USER -->

CREATE TABLE freshstocks (
    userID INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    mobile_number VARCHAR(20),
    date_of_birth DATE,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    is_deleted TINYINT(1) DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

  <-- READ USER BY USER BY USER EMAIL -->

SELECT * FROM freshstocks WHERE email = "freekyajmal@gmail.com";
 
 
   <-- UPDATE USER BY USER EMAIL -->
   
UPDATE freshstocks SET gender = "MALE", mobile_number = "9500320194", date_of_birth = "2004-12-26" WHERE email = "freekyajmal@gmail.com";
   
   
      <-- DELETE USER BY USER EMAIL -->
      
      
UPDATE freshstocks SET is_deleted = 1 WHERE email = "freekyajmal@gmail.com";
      

  <--MILESTONE-2 COURSE MODULE DB CRUD QUERIES STARTED -->
      
        <-- CREATE COURSE -->

CREATE TABLE course (
    courseID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    cover_image LONGTEXT NOT NULL,
    timing VARCHAR(20),
    language VARCHAR(50) NOT NULL,
    marked_price DECIMAL(10, 2) NOT NULL,
    selling_price DECIMAL(10, 2) NOT NULL,
    instructor_name VARCHAR(100),
    company_name VARCHAR(100),
    company_category VARCHAR(100),
    top_skills VARCHAR(255),
    is_deleted INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

  <-- READ COURSE FROM COURSE TABLE BY COURSE NAME -->

 SELECT * FROM course WHERE name = "forex course";
 
 
   <-- UPDATE COURSE BY COURSE NAME -->
   
UPDATE course SET cover_image="https://example.com", timing="40hrs", language="English", marked_price="5000", selling_price="1500", 
instructor_name="Ajmal", company_name="freshstocks", company_category="Finance and banking", top_skills="smart money concepts" WHERE name = "forex course";
   
   <-- DELETE COURSE BY COURSE NAME -->
      
UPDATE course SET is_deleted = 1 WHERE name = "forex course";
      

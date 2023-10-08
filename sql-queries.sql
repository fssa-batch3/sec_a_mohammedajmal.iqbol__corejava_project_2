-- USE freshstocks_trading;
-- SHOW tables;

-- MILESTONE-1 COURSE USER DB CRUD QUERIES STARTED

-- CREATE TABLE for Users
CREATE TABLE freshstocks (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    mobile_number VARCHAR(20),
    date_of_birth DATE,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_deleted TINYINT(1) NOT NULL DEFAULT 0,
    created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_seller TINYINT(1) NOT NULL DEFAULT 0,
    avatar_url LONGBLOB NOT NULL,
    purchased_courses TEXT
);

-- CREATE USER BY USER DETAILS
INSERT INTO freshstocks (username, gender, mobile_number, date_of_birth, email, password, is_deleted, created_at, modified_at, is_seller, avatar_url, purchased_courses)
VALUES ('John Doe', 'Male', '9500320194', '1995-10-15', 'johndoe@example.com', 'Password@123', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0, 'https://example.com', '');

-- READ USER BY USER EMAIL
SELECT * FROM freshstocks WHERE email = "freekyajmal@gmail.com";

-- UPDATE USER BY USER EMAIL
UPDATE freshstocks SET gender = "MALE", mobile_number = "9500320194", date_of_birth = "2004-12-26" WHERE email = "freekyajmal@gmail.com";

-- DELETE USER BY USER EMAIL
UPDATE freshstocks SET is_deleted = 1 WHERE email = "freekyajmal@gmail.com";

-- MILESTONE-2 COURSE MODULE DB CRUD QUERIES STARTED

-- CREATE TABLE for Courses
CREATE TABLE course (
    course_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    cover_image longtext NOT NULL,
    timing VARCHAR(20),
    language VARCHAR(50) NOT NULL,
    marked_price DECIMAL(10,2) NOT NULL,
    selling_price DECIMAL(10,2) NOT NULL,
    instructor_name VARCHAR(100),
    company_name VARCHAR(100),
    description longtext,
    company_category VARCHAR(100),
    top_skills VARCHAR(255),
    is_deleted INT NOT NULL DEFAULT '0',
    created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    courseVideo1 longblob NOT NULL,
    courseVideo2 longblob NOT NULL,
    courseVideo3 longblob NOT NULL,
    courseVideoName1 VARCHAR(255) NOT NULL,
    courseVideoName2 VARCHAR(255) NOT NULL,
    courseVideoName3 VARCHAR(255) NOT NULL,
    PRIMARY KEY (course_id),
    KEY user_id (user_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES freshstocks(user_id)
);

-- INSERT NEW COURSE
INSERT INTO course (user_id, name, cover_image, timing, language, marked_price, selling_price, instructor_name, company_name, description, company_category, top_skills, courseVideo1, courseVideo2, courseVideo3, courseVideoName1, courseVideoName2, courseVideoName3)
VALUES (1, 'Course Name', 'https://example.com/cover.jpg', '2h 30m', 'English', 100.00, 49.99, 'John Doe', 'XYZ Company', 'Course Description', 'Technology', 'HTML, CSS, JavaScript', 'Video1DataHere', 'Video2DataHere', 'Video3DataHere', 'Video1Name.mp4', 'Video2Name.mp4', 'Video3Name.mp4');

-- LIST ALL COURSES
SELECT * FROM course;

-- UPDATE COURSE DETAILS
UPDATE course
SET 
    cover_image = 'https://example.com/trading_cover.jpg',
    timing = '3hrs',
    language = 'English',
    marked_price = 199.99,
    selling_price = 99.99,
    instructor_name = 'John Smith',
    company_name = 'Trading Experts Ltd.',
    description = 'Learn the ins and outs of stock market and forex trading with this comprehensive course.',
    company_category = 'Finance',
    top_skills = 'Stock Trading, Forex Trading, Technical Analysis',
    courseVideo1 = 'https://example.com/trading_video1.mp4',
    courseVideo2 = 'https://example.com/trading_video2.mp4',
    courseVideo3 = 'https://example.com/trading_video3.mp4',
    courseVideoName1 = 'Introduction to Stock Trading',
    courseVideoName2 = 'Understanding Forex Markets',
    courseVideoName3 = 'Technical Analysis Fundamentals'
WHERE course_id = 1;

-- DELETE A COURSE
UPDATE course SET is_deleted = 1 WHERE course_id = 1;

-- CREATE TABLE for Comments
CREATE TABLE comment (
    comment_id INT NOT NULL AUTO_INCREMENT,
    course_id INT NOT NULL,
    user_id INT NOT NULL,
    comment TEXT NOT NULL,
    created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_deleted INT NOT NULL DEFAULT '0',
    PRIMARY KEY (comment_id),
    KEY course_id (course_id),
    KEY user_id (user_id),
    CONSTRAINT FK_course_id FOREIGN KEY (course_id) REFERENCES course(course_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES freshstocks(user_id)
);

-- INSERT NEW COMMENT
INSERT INTO comment (course_id, user_id, comment)
VALUES (1, 1, 'This course is amazing!');

-- LIST ALL COMMENTS FOR A COURSE
SELECT * FROM comment WHERE course_id = 1;

-- UPDATE A COMMENT
UPDATE comment 
SET comment = 'I found this course really helpful!'
WHERE comment_id = 1;

-- DELETE A COMMENT
UPDATE comment SET is_deleted = 1 WHERE comment_id = 1;

-- CREATE TABLE for user_quiz_info
CREATE TABLE user_quiz_info (
    user_quiz_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    streak_count INT NOT NULL DEFAULT 0,
    quiz_start_time DATETIME NULL,
    answered_today TINYINT(1) DEFAULT 0,
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES freshstocks(user_id)
);

-- CREATE USER QUIZ INFO BY USER DETAILS
INSERT INTO user_quiz_info (user_id, streak_count, quiz_start_time, answered_today)
VALUES (1, 0, '2023-10-08 12:00:00', 1);

-- READ USER QUIZ INFO BY USER ID
SELECT * FROM user_quiz_info WHERE user_id = 1;

-- UPDATE USER QUIZ INFO BY USER ID
UPDATE user_quiz_info SET streak_count = 1, quiz_start_time = '2023-10-09 13:00:00', answered_today = 1 WHERE user_id = 1;

-- CREATE TABLE for Quiz Questions
CREATE TABLE quiz_questions (
    question_id INT AUTO_INCREMENT PRIMARY KEY,
    question_text VARCHAR(255) NOT NULL,
    option1 VARCHAR(255) NOT NULL,
    option2 VARCHAR(255) NOT NULL,
    option3 VARCHAR(255) NOT NULL,
    option4 VARCHAR(255) NOT NULL,
    correct_answer VARCHAR(255) NOT NULL
);

-- SELECT ALL FROM TABLE
SELECT * FROM quiz_questions;

-- CREATE TABLE for Course Progress
CREATE TABLE course_progress (
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    video_id INT NOT NULL,
    progress INT,
    watched TINYINT(1),
    modified_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, course_id, video_id),
    KEY course_id (course_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES freshstocks(user_id),
    CONSTRAINT FK_course_id FOREIGN KEY (course_id) REFERENCES course(course_id)
);

-- SELECT ALL FROM TABLE
SELECT * FROM course_progress;

-- UPDATE PROGRESS FOR A VIDEO
UPDATE course_progress
SET progress = 50, watched = 1
WHERE user_id = 1 AND course_id = 101 AND video_id = 201;

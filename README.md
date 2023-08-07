# freshstocks Application Checklist

## Project Setup
- Create a new Java project
- Set up a MySQL database
- Add necessary libraries
  - JDBC
  - MySQL Connector
  - JUnit

## Module: User

### Feature 1: Create User
**User Story**: 
   ```
User details will successfully store in the database
   ```

**Pre-requisites**:
- User table
- User model
- User Dao (create)
- User service (create)

**Validations**:
- Form validator
  - User object (null)
  - User email (null, empty, patternRegex)
  - User name (null, empty, patternRegex)
  - User password (null, empty, patternRegex)
  - User date of birth (null, empty, patternRegex)
  - User gender (null, empty , patternRegex)
  - User mobile Number (null, empty , patternRegex)

**Business Validation**:
- Email Already exists

**Messages**:
- User object cannot be null
- Invalid name input
- Invalid gender input
- Invalid mobile Number input
- Invalid date of birth input
- Invalid email input
- Invalid password input
- User already exists

### Feature 2: Read User
**User Story**: 
   ```
User details will successfully read from the database
   ```

**Pre-requisites**:
- User Dao (create)
- User service (create)

**Validations**:
- Form validator
  - User object (null)

**Business Validation**:
- Email Already exists

**Messages**:
- User login not successful
- User Email Doesn't exists

### Feature 3: Update User
**User Story**: 
 ```
User details will successfully update and store in the database
 ```

**Pre-requisites**:
- Completed feature 1 - create user
- User Dao (update)
- User service (update)

**Validations**:
- Form validator
  - date of birth (null, empty, patternRegex)
  - gender (null, empty, patternRegex)
  - mobile Number (null, empty, patternRegex)

**Business Validation**:
- Check whether the Same User Email exists

**Messages**:
- Invalid date of birth input
- Invalid gender input
- Invalid mobile Number input
- User Not Successfully Updated

### Feature 4: Delete User
**User Story**: 
```
User details will successfully delete
```

**Pre-requisites**:
- Completed feature 1 - create user
- User Dao (delete)
- User service (delete)

**Validations**:
- Form Validation
  - User Email (Should be Valid)

**Business Validation**:
- Check whether the User Email exists

**Messages**:
- Invalid Email Input
- User Email not found


## Module: Course

### Feature 5: Create Course
**User Story**: 
   ```
User will successfully create a Course
   ```

**Pre-requisites**:
- Course table
- Course model
- Course Dao (create)
- Course service (create)

**Validations**:
- Form validator
  - Course object (null)
  - Course name (null, empty, patternRegex)
  -  Course Cover Image (null, empty, patternRegex)
  -  Course timing (null, empty, patternRegex)
  - Course Language (null, empty, patternRegex)
  - Course Marked Price (null, empty, patternRegex)
  - Course Selling Price (null, empty , patternRegex)
  - Course Description (null, empty , patternRegex)
  - Course Instructor Name (null, empty , patternRegex)
  - Course Company Name (null, empty , patternRegex)
  - Course Company Category (null, empty , patternRegex)
  - Course Top Skills (null, empty , patternRegex)

**Business Validation**:
- Course Name Already exists

**Messages**:
- Course object cannot be null
- Invalid name input
- Invalid Cover Image input
- Invalid timing input
- Invalid Language input
- Invalid Marked Price input
- Invalid Selling Price input
- Invalid Description input
- Invalid Instructor Name input
- Invalid Company Name input
- Invalid Company Category input
- Invalid Top Skills input
- Course already exists


### Feature 6: Read Course
**User Story**: 
   ```
User will successfully read the course details
   ```

**Pre-requisites**:
- Course Dao (create)
- Course service (create)

**Validations**:
- Form validator
  - Course object (null)

**Business Validation**:
- Course Name Already exists

**Messages**:
- Course Read not successful
- Course Name Already exists

### Feature 7: Update Course
**User Story**: 
 ```
User will successfully update the Course Details Except (Course Name)
 ```

**Pre-requisites**:
- Completed feature 1 - create user
- Completed feature 5 - create Course
- Course Dao (update)
- Course service (update)

**Validations**:
- Form validator
  - Course Cover Image (null, empty, patternRegex)
  - Course timing (null, empty, patternRegex)
  - Course Language (null, empty, patternRegex)
  - Course Marked Price (null, empty, patternRegex)
  - Course Selling Price (null, empty , patternRegex)
  - Course Description (null, empty , patternRegex)
  - Course Instructor Name (null, empty , patternRegex)
  - Course Company Name (null, empty , patternRegex)
  - Course Company Category (null, empty , patternRegex)
  - Course Top Skills (null, empty , patternRegex)

**Business Validation**:
- Check whether the Same Course Name exists

**Messages**:
- Invalid Cover Image input
- Invalid timing input
- Invalid Language input
- Invalid Marked Price input
- Invalid Selling Price input
- Invalid Description input
- Invalid Instructor Name input
- Invalid Company Name input
- Invalid Company Category input
- Invalid Top Skills input
- Course Not Successfully Updated



### Feature 8: Delete Course
**User Story**: 
```
User will successfully delete the Course
```

**Pre-requisites**:
- Completed feature 1 - create user
- Completed feature 5- create Course
- Course Dao (delete)
- Course service (delete)

**Validations**:
- Form Validation
  - Course Name (Should be Valid)

**Business Validation**:
- Check whether the Course Name exists

**Messages**:
- Invalid Course Name Input
- Course Name not found



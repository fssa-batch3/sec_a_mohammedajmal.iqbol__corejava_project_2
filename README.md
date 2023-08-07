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
   ```User details will successfully store in the database```

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

  ### Feature 1: Read User
**User Story**: 
   `User details will successfully read from the database`

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

### Feature 2: Update User
**User Story**: 
 `User details will successfully update and store in the database`

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

### Feature 3: Delete User
**User Story**: 
`User details will successfully delete`

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


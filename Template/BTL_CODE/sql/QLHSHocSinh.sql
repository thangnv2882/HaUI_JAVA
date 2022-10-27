CREATE DATABASE IF NOT EXISTS QLHSHocSinh;
USE QLHSHocSinh;
-- Tạo bảng Accounts
CREATE TABLE QLHSHocSinh.Accounts(
	AccountId INTEGER AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(60) UNIQUE,
    Password VARCHAR(60),
    DisplayName VARCHAR(60) CHARACTER SET UTF8MB4,
    Role VARCHAR(10)
);
-- Tạo bảng Courses
CREATE TABLE QLHSHocSinh.Courses(
	CourseId INTEGER AUTO_INCREMENT PRIMARY KEY,
    CourseName VARCHAR(60),
    StartTime DATE,
    EndTime DATE
);
-- Tạo bảng Semesters
CREATE TABLE QLHSHocSinh.Semesters(
	SemesterId INTEGER AUTO_INCREMENT PRIMARY KEY,
    SemesterName VARCHAR(60),
    StartTime DATE,
    EndTime DATE,
    CourseId INTEGER,
    FOREIGN KEY (CourseId) REFERENCES Courses(CourseId)
);
-- Tạo bảng Classes
CREATE TABLE QLHSHocSinh.Classes(
	ClassId INTEGER AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60),
    StartTime DATE,
    EndTime DATE,
    SemesterId INTEGER,
    FOREIGN KEY (SemesterId) REFERENCES Semesters(SemesterId)
);
-- Tạo bảng Students
CREATE TABLE QLHSHocSinh.Students(
	StudentId INTEGER AUTO_INCREMENT PRIMARY KEY,
	FullName VARCHAR(60) CHARACTER SET UTF8MB4,
    YearOfBirth INTEGER,
    Address VARCHAR(200) CHARACTER SET UTF8MB4,
    ClassId INTEGER,
    FOREIGN KEY (ClassId) REFERENCES Classes(ClassId)
);
package services;

import csdl.CSDL;
import dao.Clazz;
import dao.Course;
import dao.Semester;
import dao.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class StudentService {

    public List<Student> getAllStudents() {
        List<Student> students = new LinkedList<>();

        String sqlGetAllStudents = "SELECT StudentId, FullName, YearOfBirth, "
                + "Address, classes.ClassId, classes.ClassName, semesters.SemesterId, "
                + "semesters.SemesterName, courses.CourseId, courses.CourseName "
                + "FROM classes, semesters, courses, students "
                + "WHERE classes.SemesterId = semesters.SemesterId "
                + "AND semesters.CourseId = courses.CourseId AND students.ClassId = classes.ClassId";
        try {

            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllStudents);
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("CourseId"));
                course.setCourseName(resultSet.getString("CourseName"));

                Semester semester = new Semester();
                semester.setSemesterId(resultSet.getInt("SemesterId"));
                semester.setSemesterName(resultSet.getString("SemesterName"));
                semester.setCourse(course);

                Clazz clazz = new Clazz();
                clazz.setClassId(resultSet.getInt("ClassId"));
                clazz.setClassName(resultSet.getString("ClassName"));
                clazz.setSemester(semester);

                Student student = new Student();
                student.setStudentId(resultSet.getInt("StudentId"));
                student.setFullName(resultSet.getString("FullName"));
                student.setYearOfBirth(resultSet.getInt("YearOfBirth"));
                student.setAddress(resultSet.getString("Address"));
                student.setClassName(clazz);

                students.add(student);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
    
    public List<Student> getStudentsLikeStudentName(String studentName) {
        List<Student> students = new LinkedList<>();

        String sqlGetStudentsLikeStudentName = "SELECT StudentId, FullName, YearOfBirth, "
                + "Address, classes.ClassId, classes.ClassName, semesters.SemesterId, "
                + "semesters.SemesterName, courses.CourseId, courses.CourseName "
                + "FROM classes, semesters, courses, students "
                + "WHERE classes.SemesterId = semesters.SemesterId "
                + "AND semesters.CourseId = courses.CourseId AND students.ClassId = classes.ClassId AND FullName LIKE ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetStudentsLikeStudentName);
            preparedStatement.setString(1, "%" + studentName + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("CourseId"));
                course.setCourseName(resultSet.getString("CourseName"));

                Semester semester = new Semester();
                semester.setSemesterId(resultSet.getInt("SemesterId"));
                semester.setSemesterName(resultSet.getString("SemesterName"));
                semester.setCourse(course);

                Clazz clazz = new Clazz();
                clazz.setClassId(resultSet.getInt("ClassId"));
                clazz.setClassName(resultSet.getString("ClassName"));
                clazz.setSemester(semester);

                Student student = new Student();
                student.setStudentId(resultSet.getInt("StudentId"));
                student.setFullName(resultSet.getString("FullName"));
                student.setYearOfBirth(resultSet.getInt("YearOfBirth"));
                student.setAddress(resultSet.getString("Address"));
                student.setClassName(clazz);

                students.add(student);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public Boolean createNewStudent(Student student) {
        String sqlCreateClass = "INSERT INTO students VALUES(null, ?, ?, ?, ?)";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateClass);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2, student.getYearOfBirth());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setInt(4, student.getClassName().getClassId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateStudent(Student student) {

        String sqlUpdateClass = "UPDATE students SET FullName = ?, YearOfBirth = ?, Address = ?, ClassId = ? WHERE StudentId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateClass);

            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2, student.getYearOfBirth());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setInt(4, student.getClassName().getClassId());
            preparedStatement.setInt(5, student.getStudentId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteStudent(Integer studentId) {
        String sqlDeleteStudent = "DELETE FROM students WHERE StudentId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteStudent);

            preparedStatement.setInt(1, studentId);

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

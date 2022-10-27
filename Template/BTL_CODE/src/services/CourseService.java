package services;

import csdl.CSDL;
import dao.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseService {

    public List<Course> getAllCourses() {
        List<Course> courses = new LinkedList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlGetAllCourses = "SELECT CourseId, CourseName, StartTime, EndTime FROM Courses";
        try {

            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllCourses);
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("CourseId"));
                course.setCourseName(resultSet.getString("CourseName"));
                course.setStartTime(simpleDateFormat.parse(resultSet.getDate("StartTime").toString()));
                course.setEndTime(simpleDateFormat.parse(resultSet.getDate("EndTime").toString()));
                courses.add(course);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }

    public List<Course> getCoursesLikeCourseName(String courseName) {
        List<Course> courses = new LinkedList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlGetCoursesLikeCourseName = "SELECT CourseId, CourseName, StartTime, EndTime FROM Courses WHERE CourseName LIKE ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetCoursesLikeCourseName);
            preparedStatement.setString(1, "%" + courseName + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("CourseId"));
                course.setCourseName(resultSet.getString("CourseName"));
                course.setStartTime(simpleDateFormat.parse(resultSet.getDate("StartTime").toString()));
                course.setEndTime(simpleDateFormat.parse(resultSet.getDate("EndTime").toString()));
                courses.add(course);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }

    public Boolean createNewCourse(Course course) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlCreateCourse = "INSERT INTO courses VALUES(null, ?, ?, ?)";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateCourse);
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setString(2, simpleDateFormat.format(course.getStartTime()));
            preparedStatement.setString(3, simpleDateFormat.format(course.getEndTime()));

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateCourse(Course course) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlUpdateCourse = "UPDATE courses SET CourseName = ?, StartTime = ?, EndTime = ? WHERE CourseId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateCourse);

            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setString(2, simpleDateFormat.format(course.getStartTime()));
            preparedStatement.setString(3, simpleDateFormat.format(course.getEndTime()));
            preparedStatement.setInt(4, course.getCourseId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteCourse(Integer courseId) {
        String sqlDeleteCourse = "DELETE FROM courses WHERE CourseId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteCourse);

            preparedStatement.setInt(1, courseId);

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

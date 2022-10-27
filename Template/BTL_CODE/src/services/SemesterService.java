package services;

import csdl.CSDL;
import dao.Course;
import dao.Semester;
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

public class SemesterService {

    public List<Semester> getAllSemesters() {
        List<Semester> semesters = new LinkedList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlGetAllSemesters = "SELECT SemesterId, SemesterName, "
                + "semesters.StartTime, semesters.EndTime, semesters.CourseId, "
                + "CourseName FROM semesters, courses WHERE semesters.CourseId = courses.CourseId";
        try {

            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllSemesters);
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("CourseId"));
                course.setCourseName(resultSet.getString("CourseName"));

                Semester semester = new Semester();
                semester.setSemesterId(resultSet.getInt("SemesterId"));
                semester.setSemesterName(resultSet.getString("SemesterName"));
                semester.setStartTime(simpleDateFormat.parse(resultSet.getDate("StartTime").toString()));
                semester.setEndTime(simpleDateFormat.parse(resultSet.getDate("EndTime").toString()));
                semester.setCourse(course);

                semesters.add(semester);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return semesters;
    }

    public List<Semester> getSemestersLikeCourseName(String semesterName) {
        List<Semester> semesters = new LinkedList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlGetSemestersLikeCourseName = "SELECT SemesterId, SemesterName, "
                + "semesters.StartTime, semesters.EndTime, semesters.CourseId, "
                + "CourseName FROM semesters, courses WHERE semesters.CourseId = courses.CourseId AND SemesterName LIKE ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetSemestersLikeCourseName);
            preparedStatement.setString(1, "%" + semesterName + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("CourseId"));
                course.setCourseName(resultSet.getString("CourseName"));

                Semester semester = new Semester();
                semester.setSemesterId(resultSet.getInt("SemesterId"));
                semester.setSemesterName(resultSet.getString("SemesterName"));
                semester.setStartTime(simpleDateFormat.parse(resultSet.getDate("StartTime").toString()));
                semester.setEndTime(simpleDateFormat.parse(resultSet.getDate("EndTime").toString()));
                semester.setCourse(course);

                semesters.add(semester);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return semesters;
    }

    public List<Semester> getSemestersByCourseId(Integer courseId) {
        List<Semester> semesters = new LinkedList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlGetSemestersByCourseId = "SELECT * FROM semesters WHERE CourseId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetSemestersByCourseId);
            preparedStatement.setInt(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Semester semester = new Semester();
                semester.setSemesterId(resultSet.getInt("SemesterId"));
                semester.setSemesterName(resultSet.getString("SemesterName"));
                semester.setStartTime(simpleDateFormat.parse(resultSet.getDate("StartTime").toString()));
                semester.setEndTime(simpleDateFormat.parse(resultSet.getDate("EndTime").toString()));

                semesters.add(semester);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return semesters;
    }

    public Boolean createNewSemester(Semester semester) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlCreateSemester = "INSERT INTO semesters VALUES(null, ?, ?, ?, ?)";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateSemester);
            preparedStatement.setString(1, semester.getSemesterName());
            preparedStatement.setString(2, simpleDateFormat.format(semester.getStartTime()));
            preparedStatement.setString(3, simpleDateFormat.format(semester.getEndTime()));
            preparedStatement.setInt(4, semester.getCourse().getCourseId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateSemester(Semester semester) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlUpdateSemester = "UPDATE semesters SET SemesterName = ?, StartTime = ?, EndTime = ?, CourseId = ? WHERE SemesterId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateSemester);

            preparedStatement.setString(1, semester.getSemesterName());
            preparedStatement.setString(2, simpleDateFormat.format(semester.getStartTime()));
            preparedStatement.setString(3, simpleDateFormat.format(semester.getEndTime()));
            preparedStatement.setInt(4, semester.getCourse().getCourseId());
            preparedStatement.setInt(5, semester.getSemesterId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteSemester(Integer semesterId) {
        String sqlDeleteSemester = "DELETE FROM semesters WHERE SemesterId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteSemester);

            preparedStatement.setInt(1, semesterId);

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

package services;

import csdl.CSDL;
import dao.Clazz;
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

public class ClassService {

    public List<Clazz> getAllClasses() {
        List<Clazz> clazzs = new LinkedList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlGetAllClasses = "SELECT ClassId, ClassName, classes.StartTime, "
                + "classes.EndTime, semesters.SemesterId, SemesterName, courses.CourseId, "
                + "courses.CourseName FROM classes, semesters, courses "
                + "WHERE classes.SemesterId = semesters.SemesterId AND semesters.CourseId = courses.CourseId";
        try {

            Connection connection = CSDL.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllClasses);
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
                clazz.setStartTime(simpleDateFormat.parse(resultSet.getDate("StartTime").toString()));
                clazz.setEndTime(simpleDateFormat.parse(resultSet.getDate("EndTime").toString()));

                clazz.setSemester(semester);

                clazzs.add(clazz);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazzs;
    }

    public List<Clazz> getClassesLikeClassName(String className) {
        List<Clazz> clazzs = new LinkedList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlGetClassesLikeClassName = "SELECT ClassId, ClassName, classes.StartTime, "
                + "classes.EndTime, semesters.SemesterId, SemesterName, courses.CourseId, "
                + "courses.CourseName FROM classes, semesters, courses "
                + "WHERE classes.SemesterId = semesters.SemesterId AND semesters.CourseId = courses.CourseId AND ClassName LIKE ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetClassesLikeClassName);
            preparedStatement.setString(1, "%" + className + "%");

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
                clazz.setStartTime(simpleDateFormat.parse(resultSet.getDate("StartTime").toString()));
                clazz.setEndTime(simpleDateFormat.parse(resultSet.getDate("EndTime").toString()));

                clazz.setSemester(semester);

                clazzs.add(clazz);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazzs;
    }

    public List<Clazz> getClassesBySemesterId(Integer semesterId) {
        List<Clazz> clazzs = new LinkedList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlGetClassesBySemesterId = "SELECT * FROM classes WHERE SemesterId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetClassesBySemesterId);
            preparedStatement.setInt(1, semesterId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Clazz clazz = new Clazz();
                clazz.setClassId(resultSet.getInt("ClassId"));
                clazz.setClassName(resultSet.getString("ClassName"));
                clazz.setStartTime(simpleDateFormat.parse(resultSet.getDate("StartTime").toString()));
                clazz.setEndTime(simpleDateFormat.parse(resultSet.getDate("EndTime").toString()));

                clazzs.add(clazz);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazzs;
    }

    public Boolean createNewClass(Clazz clazz) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlCreateClass = "INSERT INTO classes VALUES(null, ?, ?, ?, ?)";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateClass);
            preparedStatement.setString(1, clazz.getClassName());
            preparedStatement.setString(2, simpleDateFormat.format(clazz.getStartTime()));
            preparedStatement.setString(3, simpleDateFormat.format(clazz.getEndTime()));
            preparedStatement.setInt(4, clazz.getSemester().getSemesterId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateClass(Clazz clazz) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String sqlUpdateClass = "UPDATE classes SET ClassName = ?, StartTime = ?, EndTime = ?, SemesterId = ? WHERE ClassId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateClass);

            preparedStatement.setString(1, clazz.getClassName());
            preparedStatement.setString(2, simpleDateFormat.format(clazz.getStartTime()));
            preparedStatement.setString(3, simpleDateFormat.format(clazz.getEndTime()));
            preparedStatement.setInt(4, clazz.getSemester().getSemesterId());
            preparedStatement.setInt(5, clazz.getClassId());

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteClass(Integer classId) {
        String sqlDeleteClass = "DELETE FROM classes WHERE ClassId = ?";
        try {

            Connection connection = CSDL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteClass);

            preparedStatement.setInt(1, classId);

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

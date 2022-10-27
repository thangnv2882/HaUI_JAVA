package dao;

import java.util.Date;

public class Course {

    private Integer courseId;
    private String courseName;
    private Date startTime;
    private Date endTime;

    public Course() {
    }

    public Course(Integer courseId, String courseName, Date startTime, Date endTime) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", courseName=" + courseName + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }

}

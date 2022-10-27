package dao;

import java.util.Date;

public class Semester {

    private Integer semesterId;
    private String SemesterName;
    private Date startTime;
    private Date endTime;
    private Course course;

    public Semester() {
    }

    public Semester(Integer semesterId, String SemesterName, Date startTime, Date endTime, Course course) {
        this.semesterId = semesterId;
        this.SemesterName = SemesterName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
    }

    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return SemesterName;
    }

    public void setSemesterName(String SemesterName) {
        this.SemesterName = SemesterName;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Semester{" + "semesterId=" + semesterId + ", SemesterName=" + SemesterName + ", startTime=" + startTime + ", endTime=" + endTime + ", course=" + course + '}';
    }

}

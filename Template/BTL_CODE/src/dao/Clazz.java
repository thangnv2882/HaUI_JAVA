package dao;

import java.util.Date;

public class Clazz {

    private Integer classId;
    private String className;
    private Date startTime;
    private Date endTime;
    private Semester semester;

    public Clazz() {
    }

    public Clazz(Integer classId, String className, Date startTime, Date endTime, Semester semester) {
        this.classId = classId;
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.semester = semester;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Clazz{" + "classId=" + classId + ", className=" + className + ", startTime=" + startTime + ", endTime=" + endTime + ", semester=" + semester + '}';
    }

}

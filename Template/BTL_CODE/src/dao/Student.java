package dao;

public class Student {

    private Integer studentId;
    private String fullName;
    private Integer yearOfBirth;
    private String address;
    private Clazz className;

    public Student() {
    }

    public Student(Integer studentId, String fullName, Integer yearOfBirth, String address, Clazz className) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.className = className;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Clazz getClassName() {
        return className;
    }

    public void setClassName(Clazz className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + ", address=" + address + ", className=" + className + '}';
    }

}

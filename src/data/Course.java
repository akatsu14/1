package src.data;

import java.util.List;

public class Course {

    private String courseId;
    private String courseName;
    private int maxStudent;
    private int currentStudent;
    private List<String> names;
    private String courseInstructor;
    private int courseSection;
    private String courseLocation;

    public Course(String courseId, String courseName, int maxStudent, int currentStudent, List<String> names,
            String courseInstructor, int courseSection, String courseLocation) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.maxStudent = maxStudent;
        this.currentStudent = currentStudent;
        this.names = names;
        this.courseInstructor = courseInstructor;
        this.courseSection = courseSection;
        this.courseLocation = courseLocation;
    }

    public void addStudent(String studentName) {
        this.names.add(studentName);
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public int getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(int currentStudent) {
        this.currentStudent = currentStudent;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public int getCourseSection() {
        return courseSection;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public void setCourseSection(int courseSection) {
        this.courseSection = courseSection;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public String getAllCourses() {
        return courseId + courseName + maxStudent + currentStudent + names + courseInstructor + courseSection
                + courseLocation + " ";
    }
}

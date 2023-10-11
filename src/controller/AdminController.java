package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import dao.DataRepository;
import data.Course;
import data.Student;

public class AdminController {
    
    private DataRepository<Course> courseRespository;
    private DataRepository<Student> studentRespository;

    public AdminController(DataRepository<Course> courseRespository, DataRepository<Student> studentRespository) {
        this.courseRespository = courseRespository;
        this.studentRespository = studentRespository;
    }

    public void editCourse(String courseId) {

    }

    public void sortCourse() {
        this.courseRespository.sort();
    }

    public List<Course> getAllCourse() {
        return this.courseRespository.findAll();
    }

    public boolean createCourse(Course course) throws IOException {
        return this.courseRespository.save(course);
    }

    public boolean deleteCourse(String courseId) throws IOException {
        return this.courseRespository.deleteById(courseId);
    }

    public Course getCourse(String courseId) {
        return this.courseRespository.findById(courseId).orElse(null);
    }

    public boolean addStudent(String courseId, String studentId) throws IOException {
        Optional<Course> course = this.courseRespository.findById(courseId);
        Optional<Student> student = this.studentRespository.findById(studentId);

        if (course.isPresent() && student.isPresent()) {
            this.courseRespository.deleteById(courseId);
            this.studentRespository.deleteById(studentId);

            Course temp1 = course.get();
            temp1.addStudent(student.get().getName());
            this.courseRespository.save(temp1);

            Student temp2 = student.get();
            temp2.addCourse(courseId);
            this.studentRespository.save(temp2);

            return true;
        }

        return false;
    }
}

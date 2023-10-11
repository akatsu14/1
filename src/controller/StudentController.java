package controller;

import dao.DataRepository;
import data.Student;

public class StudentController {

    private DataRepository<Student> studentRespository;

    public StudentController(DataRepository<Student> studentRespository) {
        this.studentRespository = studentRespository;
    }
}

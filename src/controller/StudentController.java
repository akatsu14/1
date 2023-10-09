package controller;

import dao.DataRespository;
import data.Student;

public class StudentController {

    private DataRespository<Student> studentRespository;

    public StudentController(DataRespository<Student> studentRespository) {
        this.studentRespository = studentRespository;
    }
}

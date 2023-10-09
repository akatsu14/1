package src.controller;

import src.dao.DataRespository;
import src.data.Student;

public class StudentController {

    private DataRespository<Student> studentRespository;

    public StudentController(DataRespository<Student> studentRespository) {
        this.studentRespository = studentRespository;
    }
}

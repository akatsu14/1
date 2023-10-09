package controller;

import dao.DataRespository;
import data.Faculty;

public class FacultyController {

    private DataRespository<Faculty> facultyRespository;

    public FacultyController(DataRespository<Faculty> facultyRespository) {
        this.facultyRespository = facultyRespository;
    }

}

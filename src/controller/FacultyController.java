package src.controller;

import src.dao.DataRespository;
import src.data.Faculty;

public class FacultyController {

    private DataRespository<Faculty> facultyRespository;

    public FacultyController(DataRespository<Faculty> facultyRespository) {
        this.facultyRespository = facultyRespository;
    }

}

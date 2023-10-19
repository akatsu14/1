package data;

import java.util.List;


public class Student {

    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String _class;
    private List<String> courseId;

    public Student(String id, String name, String address, String email, String phoneNumber, String _class,
            List<String> courseId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this._class = _class;
        this.courseId = courseId;
    }

    public void addCourse(String id) {
        this.courseId.add(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String get_class() {
        return _class;
    }

    public List<String> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<String> courseId) {
        this.courseId = courseId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void set_class(String _class) {
        this._class = _class;
    }
}

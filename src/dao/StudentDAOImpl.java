package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import data.Student;

public class StudentDAOImpl implements DataRepository<Student> {

    private List<Student> students;
    private final String DATA_SOURCE;

    public StudentDAOImpl(String dataSource) throws IOException {
        this.DATA_SOURCE = dataSource;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_SOURCE));
        this.students = bufferedReader
            .lines()
            .skip(1)
            .map(line -> {
                String[] words = line.split(",");
                if (words.length != 7) {
                    return null;
                } else {
                    return new Student(
                        words[0], 
                        words[1], 
                        words[2], 
                        words[3], 
                        words[4], 
                        words[5], 
                        Arrays.asList(words[6].split("|"))
                    );
                }
            })
            .toList();
        bufferedReader.close();
    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }

    @Override
    public Optional<Student> findById(String studentId) {
        return this.students
            .stream()
            .filter(e -> e.getId().equals(studentId))
            .findAny();
    }

    @Override
    public boolean save(Student student) throws IOException {
        boolean isExist = this.students
            .stream()
            .anyMatch(e -> e.getId().equals(student.getId()));
        if (isExist == false) {
            this.students.add(student);
            this.saveAll();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(String studentId) throws IOException {
        Optional<Student> target = this.students
            .stream()
            .filter(e -> e.getId().equals(studentId))
            .findAny();
        if (target.isPresent()) {
            this.students.remove(target.get());
            this.saveAll();
            return true;
        }
        return false;
    }

    @Override
    public void saveAll() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DATA_SOURCE));
        bufferedWriter.write(
            "Id,Name,Email,Address,Phone Number,Class,Course"
        );
        bufferedWriter.newLine();
        this.students.forEach(e -> {
            try {
                bufferedWriter.write(
                    e.getId() + "," +
                    e.getName() + "," +
                    e.getEmail() + "," +
                    e.getAddress() + "," +
                    e.getPhoneNumber() + "," +
                    e.get_class() + "," +
                    e.getCourseId().stream().reduce("", (s1, s2) -> s1 + "|" + s2)
                );
                bufferedWriter.newLine();
            } catch (IOException e1) {
                System.out.println("Writer get error!");
            }
        });
        bufferedWriter.close();
    }
    
}

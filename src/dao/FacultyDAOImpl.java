package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import data.Faculty;

public class FacultyDAOImpl implements DataRepository<Faculty> {

    private List<Faculty> faculties;
    private final String DATA_SOURCE;

    public FacultyDAOImpl(String dataSource) throws IOException {
        this.DATA_SOURCE = dataSource;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_SOURCE));
        this.faculties = bufferedReader
            .lines()
            .skip(1)
            .map(line -> {
                String[] words = line.split(",");
                if (words.length != 7) {
                    return null;
                } else {
                    return new Faculty(
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
    public List<Faculty> findAll() {
        return this.faculties;
    }

    @Override
    public Optional<Faculty> findById(String falcutyId) {
        return this.faculties
            .stream()
            .filter(e -> e.getId().equals(falcutyId))
            .findAny();
    }

    @Override
    public boolean save(Faculty faculty) throws IOException {
        boolean isExist = this.faculties
            .stream()
            .anyMatch(e -> e.getId().equals(faculty.getId()));
        if (isExist == false) {
            this.faculties.add(faculty);
            this.saveAll();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(String facultyId) throws IOException {
        Optional<Faculty> target = this.faculties
            .stream()
            .filter(e -> e.getId().equals(facultyId))
            .findAny();
        if (target.isPresent()) {
            this.faculties.remove(target.get());
            this.saveAll();
            return true;
        }
        return false;
    }

    @Override
    public void saveAll() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DATA_SOURCE));
        bufferedWriter.write(
            "Id,Name,Email,Address,Phone Number,Department,Courses"
        );
        bufferedWriter.newLine();
        this.faculties.forEach(e -> {
            try {
                bufferedWriter.write(
                    e.getId() + "," +
                    e.getName() + "," +
                    e.getEmail() + "," +
                    e.getAddress() + "," +
                    e.getPhoneNumber() + "," +
                    e.getDepartment() + "," +
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

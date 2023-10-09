package src.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import src.data.Course;

public class CourseDAOImpl implements DataRespository<Course> {

    private List<Course> courses;
    private final String DATA_SOURCE;

    public CourseDAOImpl(String dataSource) throws IOException {
        this.DATA_SOURCE = dataSource;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_SOURCE));
        this.courses = bufferedReader
                .lines()
                .skip(1)
                .map(line -> {
                    System.out.println(line);
                    String[] words = line.split(",");
                    if (words.length != 8) {
                        return null;
                    } else {
                        return new Course(
                                words[0],
                                words[1],
                                Integer.parseInt(words[2]),
                                Integer.parseInt(words[3]),
                                Arrays.asList(words[4].split(";")),
                                words[5],
                                Integer.parseInt(words[6]),
                                words[7]);
                    }
                })
                .collect(Collectors.toList());

        bufferedReader.close();
    }

    @Override
    public void sort() {
        this.courses.sort(Comparator.comparing(Course::getCurrentStudent));
    }

    @Override
    public List<Course> findAll() {
        return this.courses;
    }

    @Override
    public Optional<Course> findById(String courseId) {
        return this.courses
                .stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findAny();
    }

    @Override
    public boolean save(Course course) throws IOException {
        boolean isExist = this.courses
                .stream()
                .anyMatch(e -> e.getCourseId().equals(course.getCourseId()));
        if (isExist == false) {
            this.courses.add(course);
            this.saveAll();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(String courseId) throws IOException {
        Optional<Course> target = this.courses
                .stream()
                .filter(e -> e.getCourseId().equals(courseId))
                .findAny();
        if (target.isPresent()) {
            this.courses.remove(target.get());
            this.saveAll();
            return true;
        }
        return false;
    }

    @Override
    public void saveAll() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DATA_SOURCE));
        bufferedWriter.write(
                "Course ID,Course Name,Max Student,Current Student,Names of Students,Course Instructor,Course Section,Course Location");
        bufferedWriter.newLine();
        this.courses.forEach(e -> {
            try {
                bufferedWriter.write(
                        e.getCourseId() + "," +
                                e.getCourseName() + "," +
                                e.getMaxStudent() + "," +
                                e.getCurrentStudent() + "," +
                                e.getNames().stream().reduce("", (s1, s2) -> s1 + ";" + s2) + "," +
                                e.getCourseInstructor() + "," +
                                e.getCourseSection() + "," +
                                e.getCourseLocation());
                bufferedWriter.newLine();
            } catch (IOException e1) {
                System.out.println("Writer get error!");
            }
        });
        bufferedWriter.close();
    }

}

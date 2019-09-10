package dev.claudiocarvalho.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import dev.claudiocarvalho.schedule.model.Student;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> allStudents() {
        return new ArrayList<>(students);
    }
}

package ru.gb.studygroup.service;

import ru.gb.studygroup.data.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements PersonDataService<Student> {

    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    @Override
    public void createPerson(Integer quantity) {
        students.add(new Student());
    }

    @Override
    public List<Student> getAll() {
        return students;
    }
}

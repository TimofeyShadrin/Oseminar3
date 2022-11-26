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
        for (int i = 0; i < quantity; i++) {
            students.add(new Student());
        }
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    public List<Student> clearAll() {
        students.clear();
        return students;
    }
}

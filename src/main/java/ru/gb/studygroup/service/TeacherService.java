package ru.gb.studygroup.service;

import ru.gb.studygroup.data.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements PersonDataService<Teacher>{

    private final List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public void createPerson(Integer quantity) {
        this.teachers.add(new Teacher());
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }
}

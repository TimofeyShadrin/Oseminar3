package ru.gb.studygroup.service;

import ru.gb.studygroup.data.Person;

import java.util.List;

public interface PersonDataService<T extends Person> {
    void createPerson(Integer quantity);
    List<T> getAll();
}

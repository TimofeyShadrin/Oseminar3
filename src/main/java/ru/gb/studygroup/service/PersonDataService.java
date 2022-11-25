package ru.gb.studygroup.service;

import java.util.List;

public interface PersonDataService<T> {
    void createPerson(Integer quantity);
    List<T> getAll();
}

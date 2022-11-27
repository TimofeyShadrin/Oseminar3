package ru.gb.studygroup.data;

import java.util.UUID;

public abstract class Person {

    private final String uniqueID;
    private String name;
    private String patronymic;
    private String surname;
    private Gender gender;

    public Person() {
        this.uniqueID = UUID.randomUUID().toString();
    }

    public Person(String name, String patronymic, String surname, Gender gender) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.gender = gender;
        this.uniqueID = UUID.randomUUID().toString();
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

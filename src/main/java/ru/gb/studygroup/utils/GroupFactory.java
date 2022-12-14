package ru.gb.studygroup.utils;

import ru.gb.studygroup.data.Gender;
import ru.gb.studygroup.data.Person;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class GroupFactory<T extends Person> {

    private final Random random = new Random();
    private final List<T> persons;

    public GroupFactory(List<T> persons) {
        this.persons = persons;
    }

    public List<T> orderPerson() {
        persons.forEach(person -> {
            boolean choice = random.nextBoolean();
            Gender gender = Gender.FEMALE;
            if (choice) gender = Gender.MALE;
            try {
                new SimplyFactory<>(person)
                        .createPerson(gender);
            } catch (IOException e) {
                throw new IllegalStateException("File with resources not found!");
            }
        });
        return persons;
    }

    /**
     @param consumer foreach person
     */
    public List<T> orderPerson(Consumer<T> consumer) {
        persons.forEach(person -> {
            boolean choice = random.nextBoolean();
            Gender gender = Gender.FEMALE;
            if (choice) gender = Gender.MALE;
            try {
                new SimplyFactory<>(person)
                        .createPerson(gender);
            } catch (IOException e) {
                throw new IllegalStateException("File with resources not found!");
            }
        });
        persons.forEach(consumer);
        return persons;
    }
}

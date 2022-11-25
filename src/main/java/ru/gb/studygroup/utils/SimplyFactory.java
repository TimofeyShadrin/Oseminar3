package ru.gb.studygroup.utils;

import ru.gb.studygroup.data.Gender;
import ru.gb.studygroup.data.Person;

import java.io.IOException;

public class SimplyFactory<T extends Person>{

    private final T person;

    public SimplyFactory(T person) {
        this.person = person;
    }

    public T createPerson(Gender gender) throws IOException {

        switch (gender) {
            case MALE:
                person.setName(new ReadFile(Path.MALENAME.getPath()).getRandomRaw());
                person.setPatronymic(new ReadFile(Path.MALEPATRONYMIC.getPath()).getRandomRaw());
                person.setSurname(new ReadFile(Path.LASTNAME.getPath()).getRandomRaw());
                person.setGender(gender);
                break;
            case FEMALE:
                person.setName(new ReadFile(Path.FEMALENAME.getPath()).getRandomRaw());
                person.setPatronymic(new ReadFile(Path.FEMALEPATRONYMIC.getPath()).getRandomRaw());
                person.setSurname(new ReadFile(Path.LASTNAME.getPath()).getRandomRaw() + 'а');
                person.setGender(gender);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gender);
        }
        return person;
    }
}

package ru.gb.studygroup.data;

import ru.gb.studygroup.utils.RandomDate;
import java.time.LocalDate;

public class Student extends Person{

    private final RandomDate birthday;
    private Long numberStudyGroup;

    public Student() {
        super();
        this.birthday = new RandomDate(
                LocalDate.of(1999, 12, 29),
                LocalDate.of(2005,12,29));
    }

    /**
     * @param dataOfBirth input year, month, date
     */
    public Student(String name, String patronymic, String surname, Gender gender, Integer... dataOfBirth) {
        super(name, patronymic, surname, gender);
        this.birthday = new RandomDate(
                LocalDate.of(dataOfBirth[0], dataOfBirth[1], dataOfBirth[2]),
                LocalDate.of(dataOfBirth[0], dataOfBirth[1], dataOfBirth[2] + 1));
    }

    public String getBirthday() {
        return birthday.nextDate().toString();
    }

    public Long getNumberStudyGroup() {
        return numberStudyGroup;
    }

    public void setNumberStudyGroup(Long numberStudyGroup) {
        this.numberStudyGroup = numberStudyGroup;
    }

    @Override
    public String toString() {
        return String.format("\n%s %s %s, birthday: %s, gender: %s, group No %d  \nid: %s",
                super.getName(),
                super.getPatronymic(),
                super.getSurname(),
                this.birthday.nextDate(),
                super.getGender(),
                this.numberStudyGroup,
                super.getUniqueID());
    }
}

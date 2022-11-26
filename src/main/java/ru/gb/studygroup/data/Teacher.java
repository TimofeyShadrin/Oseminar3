package ru.gb.studygroup.data;

import ru.gb.studygroup.utils.RandomDate;

import java.time.LocalDate;

public class Teacher extends Person{
    private final RandomDate birthday;
    private Long numberStudyGroup;

    public Teacher() {
        super();
        this.birthday = new RandomDate(
                LocalDate.of(1980, 12, 29),
                LocalDate.of(1999,12,29));
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
        return String.format("\n%s %s %s, birthday: %s, group No %d \nid: %s",
                super.getName(),
                super.getPatronymic(),
                super.getSurname(),
                this.birthday.nextDate(),
                this.numberStudyGroup,
                super.getUniqueID());
    }
}

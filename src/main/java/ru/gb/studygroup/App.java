package ru.gb.studygroup;

import ru.gb.studygroup.data.Gender;
import ru.gb.studygroup.data.Student;
import ru.gb.studygroup.data.Teacher;

public class App
{
    public static void main( String[] args )
    {
        System.out.println(new Teacher("Ivan",
                "Jovanovich",
                "Petrov",
                Gender.MALE));
    }
}

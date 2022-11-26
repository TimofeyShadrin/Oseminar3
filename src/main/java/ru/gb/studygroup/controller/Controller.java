package ru.gb.studygroup.controller;

import ru.gb.studygroup.data.Student;
import ru.gb.studygroup.data.StudyGroup;
import ru.gb.studygroup.data.Teacher;
import ru.gb.studygroup.service.PersonDataService;
import ru.gb.studygroup.service.StudentService;
import ru.gb.studygroup.service.StudyGroupService;
import ru.gb.studygroup.service.TeacherService;
import ru.gb.studygroup.utils.GroupFactory;
import ru.gb.studygroup.view.SendOnConsole;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Controller {

    private final PersonDataService<Teacher> teacherService = new TeacherService();
    private final StudyGroupService studyGroupService = new StudyGroupService();
    private final SendOnConsole sendOnConsole = new SendOnConsole();

    public void createStudyGroup(Integer quantityTeachers, Integer quantityStudents) {

        List<Teacher> teachers;
        AtomicReference<List<Student>> students = new AtomicReference<>();

        teacherService.createPerson(quantityTeachers);
        teachers = teacherService.getAll();
        teachers = new GroupFactory<>(teachers).orderPerson();

        teachers.forEach(teacher -> {
            StudentService studentService = new StudentService();
            studentService.createPerson(quantityStudents);
            students.set(studentService.getAll());
            students.set(new GroupFactory<>(students.get()).orderPerson());
            studyGroupService.createStudyGroup(teacher, students.get());
        });

        List<StudyGroup> studyGroups = studyGroupService.getStudyGroups().stream()
                .peek(studyGroup -> {
                    Long number = studyGroup.getStudyGroupID();
                    studyGroup.getStudentList()
                            .forEach(student -> student.setNumberStudyGroup(number));
                })
                .peek(studyGroup -> {
                    Long number = studyGroup.getStudyGroupID();
                    studyGroup.getTeacher().setNumberStudyGroup(number);
                })
                .collect(Collectors.toList());

        sendOnConsole.viewList(studyGroups);
        sendOnConsole.viewList(sortedStudentList(studyGroups));
    }

    private List<Student> sortedStudentList (List<StudyGroup> studyGroups) {
        return studyGroups.stream()
                .map(StudyGroup::getStudentList)
                .flatMap(Collection::stream)
                .sorted((Student o1, Student o2) -> {
                    if ((o1.getSurname()).equals(o2.getSurname()))
                        return (o1.getName()).compareTo(o2.getName());
                    return (o1.getSurname()).compareTo(o2.getSurname());
                    })
                .collect(Collectors.toList());
    }
}

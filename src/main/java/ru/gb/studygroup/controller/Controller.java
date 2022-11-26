package ru.gb.studygroup.controller;

import ru.gb.studygroup.data.Student;
import ru.gb.studygroup.data.StudyGroup;
import ru.gb.studygroup.data.Teacher;
import ru.gb.studygroup.service.StudentService;
import ru.gb.studygroup.service.StudyGroupService;
import ru.gb.studygroup.service.TeacherService;
import ru.gb.studygroup.utils.GroupFactory;
import ru.gb.studygroup.view.StudyGroupView;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    private final TeacherService teacherService = new TeacherService();
    private final StudyGroupService studyGroupService = new StudyGroupService();
    private final StudyGroupView studyGroupView = new StudyGroupView();

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

        List<StudyGroup> studyGroups = studyGroupService.getStudyGroups();
        studyGroupView.sendOnConsole(studyGroups);
    }
}

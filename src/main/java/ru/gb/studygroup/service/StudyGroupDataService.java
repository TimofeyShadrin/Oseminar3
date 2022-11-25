package ru.gb.studygroup.service;

import ru.gb.studygroup.data.Student;
import ru.gb.studygroup.data.StudyGroup;
import ru.gb.studygroup.data.Teacher;

import java.util.List;

public interface StudyGroupDataService {

    void createStudyGroup(Teacher teacher, List<Student> studentList);

    List<StudyGroup> getStudyGroups();
}

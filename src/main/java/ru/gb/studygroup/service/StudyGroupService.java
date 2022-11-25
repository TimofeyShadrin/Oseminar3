package ru.gb.studygroup.service;

import ru.gb.studygroup.data.Student;
import ru.gb.studygroup.data.StudyGroup;
import ru.gb.studygroup.data.Teacher;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupService implements StudyGroupDataService {

    List<StudyGroup> studyGroups;

    public StudyGroupService() {
        this.studyGroups = new ArrayList<>();
    }

    @Override
    public void createStudyGroup(Teacher teacher, List<Student> studentList) {
        this.studyGroups.add(new StudyGroup(teacher, studentList));
    }

    @Override
    public List<StudyGroup> getStudyGroups() {
        return this.studyGroups;
    }
}

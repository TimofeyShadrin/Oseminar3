package ru.gb.studygroup.view;

import ru.gb.studygroup.data.StudyGroup;

import java.util.List;
import java.util.logging.Logger;

public class StudyGroupView {

    public void sendOnConsole(List<StudyGroup> groupList) {
        Logger logger = Logger.getAnonymousLogger();
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
        groupList.forEach(group -> logger.info(group.toString()));
    }

}

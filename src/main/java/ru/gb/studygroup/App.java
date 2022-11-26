package ru.gb.studygroup;

import ru.gb.studygroup.controller.Controller;

public class App {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createStudyGroup(3, 8);
    }
}

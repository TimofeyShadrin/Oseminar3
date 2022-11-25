package ru.gb.studygroup.utils;

public enum Path {

    MALENAME("src/main/resources/raw/name_m.csv"),
    FEMALENAME("src/main/resources/raw/name_w.csv"),
    MALEPATRONYMIC("src/main/resources/raw/patronymic_m.csv"),
    FEMALEPATRONYMIC("src/main/resources/raw/patronymic_w.csv"),
    LASTNAME("src/main/resources/raw/surname.csv");

    private final String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

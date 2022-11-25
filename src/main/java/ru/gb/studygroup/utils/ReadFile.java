package ru.gb.studygroup.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ReadFile {

    String path;

    public ReadFile(String path) {
        this.path = path;
    }

    public String getRandomRaw() throws IOException {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
        }
        Random random = new Random();
        int size = strings.size();
        return strings.get(random.nextInt(size));
    }

}

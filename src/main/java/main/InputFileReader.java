package main;

import java.util.ArrayList;
import java.util.List;

public class InputFileReader {
    public static School convertFileToSchool(String instructions) {
        String[] lines = instructions.split("\n");
        List<List<String>> sections = splitIntoSectionsByEmptyLines(lines);

        if (sections.size() != 4) {
            throw new IllegalArgumentException("El formato del archivo de entrada es incorrecto.");
        }

        return new School(
            Integer.parseInt(sections.getFirst().getFirst()),
            sections.get(1).stream().map(Room::new).toList(),
            sections.get(2).stream().map(Course::new).toList(),
            sections.get(3).stream().map(Teacher::new).toList()
        );
    }

    public static List<List<String>> splitIntoSectionsByEmptyLines(String[] lines) {
        List<List<String>> sections = new ArrayList<>();
        List<String> currentSection = new ArrayList<>();

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                currentSection.add(line);
                continue;
            }

            if (!currentSection.isEmpty()) {
                sections.add(new ArrayList<>(currentSection));
                currentSection.clear();
            }
        }

        if (!currentSection.isEmpty()) {
            sections.add(currentSection);
        }

        return sections;
    }
}

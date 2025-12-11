package main;

import utils.*;

public class Main {
    private static ArgProcessor argP;
    private static Printer printer;
    private static Algorithm algorithm;

    public static void main(String[] args) {
        argP = new ArgProcessor(args);
        String schoolInstructions;
        School school;

        if (argP.getFileOut() != null) {
            printer = new FilePrinter(argP.getFileOut());
        }else {
            printer = new ScreenPrinter();
        }

        if (argP.isHelpMode()) {
            printHelpMessage();
            return;
        }

        if (argP.getFileIn() == null) {
            //throw new NullPointerException("XX Fichero de entrada no especificado.");
        }

        // Read input file
        try {
            //SchoolInstructions = FileReader.readFile(argP.getFileIn());
            schoolInstructions = "2\n\n101 30\n102 25\n\n201 20\n202 26\n\n301 201 202\n302 201";
        } catch (NullPointerException e) {
            printer.println(e.getMessage());
            return;
        }

        // Create School
        try {
            assert schoolInstructions != null;
            school = InputFileReader.convertFileToSchool(schoolInstructions);
        } catch (IllegalArgumentException e) {
            printer.println("XX " + e.getMessage());
            return;
        }

        // Print school
        printer.println(school.toString());

        // Execute algorithm

        // Print solution
    }

    public static void printHelpMessage() {
        String text =
                "\nSINTAXIS: asignacionCursos [-t][-h] [fichero entrada] [fichero salida]\n" +
                        "    -t Traza cada paso\n" +
                        "    -h Muestra esta ayuda\n" +
                        "    [fichero entrada] Valores n y listas de aulas, cursos y profesores\n" +
                        "    [fichero salida] Lista de curso y profesor asignado\n";

        printer.print(text);
    }
}
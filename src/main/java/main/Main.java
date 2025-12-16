package main;

import utils.*;

import java.util.List;

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
            throw new NullPointerException("XX Fichero de entrada no especificado.");
        }

        // Read input file
        try {
            schoolInstructions = FileReader.readFile(argP.getFileIn());
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

        // Execute algorithm
        algorithm = new Algorithm(argP.isTraceMode(), printer);

        if (argP.isTraceMode()) {
            System.out.println("\n/------------------- Algoritmo Vuelta atrás ------------------\\");
        }

        List<AcademicRegister> result = algorithm.execute(school);

        if (argP.isTraceMode()) {
            System.out.println("\n\\-------------------------------------------------------/\n");
        }

        // No solution found
        if (result == null) {
            printer.println("0");
            return;
        }

        // Print solution
        for (AcademicRegister register : result) {
            printer.println(
                    register.getRoom().getId() + " " +
                    register.getCourse().getId() + " " +
                    register.getTeacher().getId()
            );
        }
    }

    public static void printHelpMessage() {
        String text =
                """
                    SINTAXIS: asignacionCursos [-t][-h] [fichero entrada] [fichero salida]
                        -t Traza cada paso
                        -h Muestra esta ayuda
                        [fichero entrada] Valores n y listas de aulas, cursos y profesores
                        [fichero salida] Lista de curso y profesor asignado
                """;

        printer.print(text);
    }
}
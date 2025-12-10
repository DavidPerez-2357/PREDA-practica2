package main;

import utils.*;

import java.util.ArrayList;

public class Main {
    private static ArgProcessor argP;
    private static Printer printer;
    private static Algorithm algorithm;

    public static void main(String[] args) {
        argP = new ArgProcessor(args);
        String matrixInstructions;

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
            matrixInstructions = FileReader.readFile(argP.getFileIn());
        } catch (NullPointerException e) {
            printer.println(e.getMessage());
            return;
        }

        // Create matrix

        // Execute algorithm

        // Print solution
    }

    public static void printHelpMessage() {
        String text =
                "\nSINTAXIS: conectividad [-t][-h] [fichero entrada] [fichero salida]\n" +
                        "    -t Traza cada paso\n" +
                        "    -h Muestra esta ayuda\n" +
                        "    [fichero entrada] Valores n,y, las conexiones y su coste\n" +
                        "    [fichero salida] Conexiones seleccionadas, su coste y el coste total\n";

        printer.print(text);
    }
}
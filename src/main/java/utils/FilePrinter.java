package utils;

import java.io.FileWriter;

public class FilePrinter implements Printer {
    private FileWriter fileWriter;

    public FilePrinter(String fileName) {
        super();

        try {
            this.fileWriter = new FileWriter(fileName);
        } catch (Exception e) {
            System.err.println("XX Error inicializando FileWriter: " + e.getMessage());
        }
    }

    @Override
    public void print(String message) {
        try {
            fileWriter.write(message);
            fileWriter.flush();
        } catch (Exception e) {
            System.err.println("XX Error editando el archivo: " + e.getMessage());
        }
    }

    @Override
    public void println(String message) {
        try {
            fileWriter.write(message + System.lineSeparator());
            fileWriter.flush();
        } catch (Exception e) {
            System.err.println("XX Error editando el archivo: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            fileWriter.close();
        } catch (Exception e) {
            System.err.println("XX Error closing FileWriter: " + e.getMessage());
        }
    }
}

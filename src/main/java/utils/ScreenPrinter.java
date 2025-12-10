package utils;

public class ScreenPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void close() {
        // No resources to close for screen printing
    }
}

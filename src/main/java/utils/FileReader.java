package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public static String readFile(String filePath) {
        Path path = Path.of(filePath);

        // Validar que el archivo exista
        if (!Files.exists(path)) {
            throw new NullPointerException("XX El archivo no existe: " + path);
        }

        // Leer todas las líneas del archivo
        try {
            List<String> lines = Files.readAllLines(path);
            return String.join("\n", lines);
        } catch (IOException e) {
            System.err.println("!! Error al leer el archivo: " + e.getMessage());
        }

        return null;
    }
}

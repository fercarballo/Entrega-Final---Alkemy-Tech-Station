package com.qa.services;

import com.qa.model.TestCase;
import com.qa.model.TestStatus;
import com.qa.utils.FileFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private List<String> errorLog = new ArrayList<>();

    public List<TestCase> readTests(String filePath) {
        List<TestCase> tests = new ArrayList<>();
        errorLog.clear(); // Limpiar errores previos

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                // Omitir cabecera si existe (puedes ajustar esta lógica)
                if (lineNumber == 1 && line.toLowerCase().contains("idtest")) continue;

                try {
                    tests.add(parseLine(line));
                } catch (FileFormatException | NumberFormatException e) {
                    errorLog.add("Error en línea " + lineNumber + ": " + line + " -> " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error fatal leyendo el archivo: " + e.getMessage());
        }
        return tests;
    }

    private TestCase parseLine(String line) throws FileFormatException {
        String[] parts = line.split(",");
        
        // Validación de estructura
        if (parts.length != 4) {
            throw new FileFormatException("Formato incorrecto (se esperaban 4 columnas)");
        }

        String id = parts[0].trim();
        String name = parts[1].trim();
        String statusStr = parts[2].trim().toUpperCase();
        String timeStr = parts[3].trim();

        // Validaciones de tipos de datos
        TestStatus status;
        try {
            status = TestStatus.valueOf(statusStr);
        } catch (IllegalArgumentException e) {
            throw new FileFormatException("Estado desconocido: " + statusStr);
        }

        double time;
        try {
            time = Double.parseDouble(timeStr);
            if (time < 0) throw new FileFormatException("El tiempo no puede ser negativo");
        } catch (NumberFormatException e) {
            throw new FileFormatException("Formato de tiempo inválido: " + timeStr);
        }

        return new TestCase(id, name, status, time);
    }

    public List<String> getErrorLog() {
        return errorLog;
    }

}

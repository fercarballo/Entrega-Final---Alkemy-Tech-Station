package com.qa.services;

import com.qa.model.TestCase;
import com.qa.model.TestStatus;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class ReportGenerator {

    public void generateReport(String filePath, List<TestCase> tests, List<String> errors) {
        StatsCalculator stats = new StatsCalculator();

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("REPORTE DE RESULTADOS DE PRUEBAS");
            writer.println("=================================");
            writer.println("Total de Tests: " + stats.getTotalTests(tests));
            writer.println("Tiempo Promedio: " + String.format("%.2f", stats.getAverageTime(tests)) + " ms");
            
            Optional<TestCase> slowest = stats.getSlowestTest(tests);
            slowest.ifPresent(testCase -> 
                writer.println("Test más lento: " + testCase.getNombreTest() + " (" + testCase.getTiempoEjecucion() + " ms)")
            );

            writer.println("\n--- Estadísticas por Estado ---");
            for (TestStatus status : TestStatus.values()) {
                writer.println(status + ": " + stats.getCountByStatus(tests, status) + 
                               " (" + stats.getPercentageByStatus(tests, status) + ")");
            }

            writer.println("\n--- Log de Errores ---");
            if (errors.isEmpty()) {
                writer.println("No se encontraron errores de formato.");
            } else {
                errors.forEach(writer::println);
            }
            
            System.out.println("Reporte generado exitosamente en: " + filePath);

        } catch (IOException e) {
            System.err.println("Error escribiendo reporte: " + e.getMessage());
        }
    }

    // Bonus: Exportar a CSV [cite: 35, 104]
    public void exportToCsv(String filePath, List<TestCase> tests) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("ID,Nombre,Estado,Tiempo");
            for (TestCase t : tests) {
                writer.println(t.toString());
            }
            System.out.println("CSV exportado exitosamente en: " + filePath);
        } catch (IOException e) {
            System.err.println("Error exportando CSV: " + e.getMessage());
        }
    }
}
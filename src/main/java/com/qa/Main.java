package com.qa;

import com.qa.model.TestCase;
import com.qa.services.CsvReader;
import com.qa.services.ReportGenerator;
import com.qa.services.StatsCalculator;
import com.qa.model.TestStatus;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Asegúrate de tener un archivo 'datos.csv' en la raíz del proyecto para probar
        String inputFile = "datos.csv"; 
        
        CsvReader reader = new CsvReader();
        StatsCalculator calculator = new StatsCalculator();
        ReportGenerator reporter = new ReportGenerator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cargando datos...");
        List<TestCase> tests = reader.readTests(inputFile);
        List<String> errors = reader.getErrorLog();

        if (tests.isEmpty()) {
            System.out.println("No se encontraron tests válidos. Verifique el archivo.");
            errors.forEach(System.out::println);
            return;
        }

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE PRUEBAS ---");
            System.out.println("1. Ver cantidad total de tests");
            System.out.println("2. Ver desglose por estados (Passed/Failed/Skipped)");
            System.out.println("3. Generar Reporte TXT completo");
            System.out.println("4. Exportar datos válidos a CSV");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Total de tests procesados: " + calculator.getTotalTests(tests));
                    break;
                case 2:
                    System.out.println("Passed: " + calculator.getCountByStatus(tests, TestStatus.PASSED));
                    System.out.println("Failed: " + calculator.getCountByStatus(tests, TestStatus.FAILED));
                    System.out.println("Skipped: " + calculator.getCountByStatus(tests, TestStatus.SKIPPED));
                    break;
                case 3:
                    reporter.generateReport("reporte_final.txt", tests, errors);
                    break;
                case 4:
                    reporter.exportToCsv("datos_validos.csv", tests);
                    break;
                case 5:
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
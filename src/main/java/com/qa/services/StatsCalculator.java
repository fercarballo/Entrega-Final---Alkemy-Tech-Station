package com.qa.services;

import com.qa.model.TestCase;
import com.qa.model.TestStatus;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StatsCalculator {

    // a. Cantidad total de tests [cite: 24]
    public int getTotalTests(List<TestCase> tests) {
        return tests.size();
    }

    // b. Cantidad por estado [cite: 25]
    public long getCountByStatus(List<TestCase> tests, TestStatus status) {
        return tests.stream().filter(t -> t.getEstado() == status).count();
    }

    // b. Porcentaje por estado
    public String getPercentageByStatus(List<TestCase> tests, TestStatus status) {
        if (tests.isEmpty()) return "0.0%";
        long count = getCountByStatus(tests, status);
        double percentage = (double) count / tests.size() * 100;
        return String.format("%.2f%%", percentage);
    }

    // c. Tiempo promedio [cite: 27]
    public double getAverageTime(List<TestCase> tests) {
        return tests.stream()
                .mapToDouble(TestCase::getTiempoEjecucion)
                .average()
                .orElse(0.0);
    }

    // d. Test más lento [cite: 28]
    public Optional<TestCase> getSlowestTest(List<TestCase> tests) {
        return tests.stream()
                .max(Comparator.comparingDouble(TestCase::getTiempoEjecucion));
    }
}
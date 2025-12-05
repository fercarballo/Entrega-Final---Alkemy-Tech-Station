package com.qa.service;

import com.qa.model.TestCase;
import com.qa.model.TestStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import com.qa.services.StatsCalculator;

class StatsCalculatorTest {

    private StatsCalculator calculator;
    private List<TestCase> testData;

    @BeforeEach
    void setUp() {
        calculator = new StatsCalculator();
        testData = new ArrayList<>();
        testData.add(new TestCase("001", "Login", TestStatus.PASSED, 100));
        testData.add(new TestCase("002", "Cart", TestStatus.FAILED, 200));
        testData.add(new TestCase("003", "Pay", TestStatus.PASSED, 150));
        testData.add(new TestCase("004", "Logout", TestStatus.SKIPPED, 0));
    }

    @Test
    void testGetTotalTests() {
        assertEquals(4, calculator.getTotalTests(testData), "El total de tests debería ser 4");
    }

    @Test
    void testGetCountByStatus() {
        assertEquals(2, calculator.getCountByStatus(testData, TestStatus.PASSED), "Debería haber 2 PASSED");
        assertEquals(1, calculator.getCountByStatus(testData, TestStatus.FAILED), "Debería haber 1 FAILED");
    }

    @Test
    void testGetAverageTime() {
        // (100 + 200 + 150 + 0) / 4 = 112.5
        assertEquals(112.5, calculator.getAverageTime(testData), 0.01, "El promedio de tiempo es incorrecto");
    }

    @Test
    void testGetSlowestTest() {
        TestCase slowest = calculator.getSlowestTest(testData).orElse(null);
        assertNotNull(slowest);
        assertEquals("Cart", slowest.getNombreTest(), "El test más lento debería ser Cart");
    }
}
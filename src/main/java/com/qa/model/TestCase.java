package com.qa.model;

public class TestCase {
    private String idTest;
    private String nombreTest;
    private TestStatus estado;
    private double tiempoEjecucion; // En milisegundos o segundos

    public TestCase(String idTest, String nombreTest, TestStatus estado, double tiempoEjecucion) {
        this.idTest = idTest;
        this.nombreTest = nombreTest;
        this.estado = estado;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    // Getters
    public String getIdTest() { return idTest; }
    public String getNombreTest() { return nombreTest; }
    public TestStatus getEstado() { return estado; }
    public double getTiempoEjecucion() { return tiempoEjecucion; }

    @Override
    public String toString() {
        return idTest + "," + nombreTest + "," + estado + "," + tiempoEjecucion;
    }
}
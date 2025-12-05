# Sistema de Gestión y Validación de Resultados de Pruebas (QA Automation Tool)

## 📋 Descripción del Proyecto
Este proyecto es el resultado final del **Trabajo Integrador Individual**. Consiste en una herramienta de línea de comandos (CLI) desarrollada en **Java** bajo el ecosistema **Maven**.

La herramienta simula un entorno real de QA donde se reciben logs de ejecución de pruebas automatizadas en formato CSV. El sistema procesa estos archivos, valida la integridad de los datos, calcula métricas clave de desempeño y genera reportes para el equipo, cumpliendo con los estándares de **Programación Orientada a Objetos (POO)** y **Buenas Prácticas**.

### Alcance
El proyecto cubre el 100% de los requerimientos de las Etapas 1, 2 y 3, incluyendo:
* Lectura y parsing de archivos.
* Cálculo de estadísticas complejas.
* Generación de reportes.
* Testing Unitario (JUnit 5).
* **Bonus Tracks:** Menú interactivo y exportación a múltiples formatos.

## 🚀 Funcionalidades Principales

1.  **Lectura Robusta de Datos:**
    * Importación de archivos `.csv`.
    * Validación línea por línea.
    * Manejo de excepciones personalizadas (`FileFormatException`) para datos corruptos o tipos inválidos.
    * Generación de un **Log de Errores** detallado indicando la línea y la causa del fallo.

2.  **Motor de Estadísticas:**
    * Cálculo de cantidad total de tests.
    * Desglose de cantidad y porcentaje por estado (`PASSED`, `FAILED`, `SKIPPED`).
    * Cálculo del tiempo promedio de ejecución.
    * Identificación del test con mayor latencia (Test más lento).

3.  **Reportes y Salida:**
    * Generación automática de un reporte resumen en `.txt`.
    * **Bonus:** Exportación de datos depurados (válidos) a un nuevo archivo `.csv`.
    * **Bonus:** Interfaz de menú en consola para selección de operaciones.

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java (JDK 17+)
* **Gestión de Proyecto:** Apache Maven
* **Testing:** JUnit 5 (Jupiter API & Engine)
* **IDE:** Visual Studio Code (con extensiones Java Extension Pack)

## 📂 Arquitectura del Proyecto
El código sigue una arquitectura en capas para respetar el principio de Responsabilidad Única (SRP) y facilitar el mantenimiento.


src/
├── main/java/com/qa/
│   ├── Main.java              # Entry Point: Controla el flujo y el menú interactivo
│   ├── model/                 # Capa de Modelo
│   │   ├── TestCase.java      # POJO que representa un caso de prueba
│   │   └── TestStatus.java    # Enum para restringir estados (PASSED, FAILED, SKIPPED)
│   ├── service/               # Capa de Lógica de Negocio
│   │   ├── CsvReader.java     # Lógica de lectura, parsing y validación de excepciones
│   │   ├── StatsCalculator.java # Algoritmos matemáticos y estadísticos
│   │   └── ReportGenerator.java # Escritura de archivos de salida (I/O)
│   └── util/
│       └── FileFormatException.java # Excepción customizada para errores de formato
└── test/java/com/qa/service/
    └── StatsCalculatorTest.java # Pruebas Unitarias para asegurar la calidad del cálculo


## ⚙️ Guía de Ejecución

### 1\. Prerrequisitos

Asegúrese de tener el archivo de entrada `datos.csv` en la raíz del proyecto (al mismo nivel que `pom.xml`) con el siguiente formato:


idTest,nombre Test,estado,tiempo Ejecucion
001,Login Test,PASSED,120
002,Checkout Process,FAILED,500
003,Update Profile,PASSED,150.5
004,Search Item,SKIPPED,0
999,Test Malformado,ERROR_TYPE


### 2\. Ejecutar la Aplicación (Menú Interactivo)

Para iniciar el sistema y ver el menú de opciones:

**Opción A (Desde VS Code):**
Abra el archivo `src/main/java/com/qa/Main.java` y haga clic en **"Run"** sobre el método `main`.

**Opción B (Desde Terminal/Maven):**

mvn clean compile exec:java -Dexec.mainClass="com.qa.Main"


### 3\. Ejecutar Pruebas Unitarias

Para validar la corrección de los cálculos estadísticos (Requerimiento de Etapa 3):

mvn test


*Salida esperada:* `Build Success` con 0 fallos.

## 📝 Ejemplo de Reporte Generado

Al seleccionar la opción de generar reporte, el sistema creará `reporte_final.txt`:


REPORTE DE RESULTADOS DE PRUEBAS
=================================
Total de Tests: 4
Tiempo Promedio: 192.62 ms
Test más lento: Checkout Process (500.0 ms)

--- Estadísticas por Estado ---
PASSED: 2 (50.00%)
FAILED: 1 (25.00%)
SKIPPED: 1 (25.00%)

--- Log de Errores ---
Error en línea 6: ... -> Estado desconocido: ERROR_TYPE


## 👤 Autor

**Nombre:** Fernando Daniel Carballo
**Rol:** QA 
**Fecha:** Diciembre 05 del 2025
**Contexto:** Entrega Final - Alkemy Tech Station


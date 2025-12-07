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


## ⚙️ Guía de Ejecución

### 1\. Ejecutar la Aplicación (Menú Interactivo)

Para iniciar el sistema y ver el menú de opciones:

**Opción A (Desde VS Code):**
Abra el archivo `src/main/java/com/qa/Main.java` y haga clic en **"Run"** sobre el método `main`.

**Opción B (Desde Terminal/Maven):**

mvn clean compile exec:java -Dexec.mainClass="com.qa.Main"


### 2\. Ejecutar Pruebas Unitarias

Para validar la corrección de los cálculos estadísticos (Requerimiento de Etapa 3):

mvn test


*Salida esperada:* `Build Success` con 0 fallos.

## 📝 Ejemplo de Reporte Generado

Al seleccionar la opción de generar reporte, el sistema creará `reporte_final.txt`:

## 👤 Autor

**Nombre:** Fernando Daniel Carballo
**Rol:** QA 
**Fecha:** Diciembre 05 del 2025
**Contexto:** Entrega Final - Alkemy Tech Station





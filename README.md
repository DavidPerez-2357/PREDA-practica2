# [Titulo del proyecto] - Algoritmo de [Nombre del algoritmo]
Este proyecto forma parte de una práctica de la asignatura **Programación y estructuras de datos avanzadas**, cuyo objetivo es
asignar cursos a aulas y profesorado teniendo en cuenta las restricciones de capacidad, disponibilidad y especialización.

Para lograrlo, el programa va recorriendo las posibles asignaciones, estructuradas como un arbol, donde cada nivel es un curso y cada nodo una posible asignación del curso a un aula y profesor. Utilizando vuelta atrás, se exploran las diferentes combinaciones de asignaciones, retrocediendo cuando se encuentra una asignación que no cumple con las restricciones establecidas.

</br>

## 🎯 Objetivos de la práctica
- Leer los datos de asignacion desde un fiechero.
- Construir la estructura de datos adecuada para representar el problema.
- Aplicar el algoritmo de Vuelta Atrás teniendo en cuenta las restricciones.
- Mostrar o guardar el resultado en un fichero.
- Permitir al usuario activar una opción de traza para ver los pasos realizados.

</br>

## 🛠️ Requisitos previos
- Java 21 o superior
- OpenJDK 22 o superior

</br>

## 🧱 Estructura del proyecto
- `src/main/java/main`: Clases principales para el algoritmo
    - `Main`: Punto de entrada para la implementación del algoritmo
    - `Algorithm`: Objeto del algoritmo, es donde se ejecuta
    - `InputFileReader`: Clase para manejar la lectura de archivos de entrada
    - `School`: Objeto para almacenar los datos de aulas, profesores y cursos
    - `AcademicRegister`: Objeto para representar una asignación de curso a aula y profesor
    - `Course`: Objeto para representar un curso
    - `Room`: Objeto para representar un aula
    - `Teacher`: Objeto para representar un profesor

- `src/main/java/utils`: Clases auxiliares para operaciones del algoritmo
- `src/tests`: Ficheros de texto con archivos de entrada de prueba numerados

</br>

## 🧠 Uso
Ejecutar el programa:

```bash
java -jar asignacionCursos.jar [-t] [-h] [src/tests/archivo_entrada] [src/tests/archivo_salida]
```

Opciones:

- `-t`: Muestra los pasos de ejecución del algoritmo
- `-h`: Muestra la ayuda y cierra la ejecución
- `archivo_entrada`: Archivo con las instrucciones de cursos, aulas y profesores
- `archivo_salida`: Archivo para los resultados

Formato de entrada:

```javascript
3 // Número de elementos de cada tipo: cursos, aulas y profesores

1 22 // Curso 1: ID 1, 22 estudiantes
2 18 // Curso 2: ID 2, 18 estudiantes
3 30 // Curso 3: ID 3, 30 estudiantes

1 25 // Aula 1: ID 1, capacidad 25
2 20 // Aula 2: ID 2, capacidad 20
3 35 // Aula 3: ID 3, capacidad 35

1 1 2 // Profesor 1: ID 1, puede impartir cursos 1 y 2
2 3   // Profesor 2: ID 2, puede impartir curso 3
3 1 2 3 // Profesor 3: ID 3, puede impartir cursos 1, 2 y 3
```

Formato de salida:
```javascript
2 1 1 // Aula 2, Curso 1, Profesor 1
3 2 3 // Aula 3, Curso 2, Profesor 3
1 3 2 // Aula 1, Curso 3, Profesor 2
```
> Si no hay solución, en el archivo de salida se indicará con "0".
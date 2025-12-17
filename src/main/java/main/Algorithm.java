package main;

import java.util.*;

// El objetivo es explorar niveles y volver atras cuando ya no sea posible continuar

// Empezamos con un colegio donde no hay ninguna asignacion

// La primera posibilidad de asignacion podria ser [1, 1, 1]
//  Despues de eso se seguiria con [1, 1, 2]
//    Depues de eso se seguiria con [1, 1, 3]
//      Despues de eso se seguiria con [1, 2, 1]
//        Si esta asignacion es valida, se continua con el siguiente nivel

//      Ahora se prueba con [2, 1, 2]
//      Si no es valida, se prueba con la siguiente asignacion en este nivel

public class Algorithm {
    private final boolean traceMode;
    private School school;


    public Algorithm(boolean traceMode) {
        this.traceMode = traceMode;
    }

    public List<int[]> fillBranchesToExplore(int n, int actualCourse, List<AcademicRegister> currentRegisters) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> usedRooms = new HashSet<>();
        Set<Integer> usedTeachers = new HashSet<>();

        // Registrar las salas y profesores ya utilizados
        for (AcademicRegister register : currentRegisters) {
            usedRooms.add(register.indexRoom);
            usedTeachers.add(register.indexTeacher);
        }

        // Generar combinaciones válidas
        for (int roomIndex = 0; roomIndex < n; roomIndex++) {
            if (usedRooms.contains(roomIndex)) continue; // Evitar salas ya usadas

            for (int teacherIndex = 0; teacherIndex < n; teacherIndex++) {
                if (usedTeachers.contains(teacherIndex)) continue; // Evitar profesores ya usados

                result.add(new int[]{actualCourse, roomIndex, teacherIndex});
            }
        }

        return result;
    }

    public List<AcademicRegister> execute(School school) {
        this.school = school;
        return exploreBranch(new ArrayList<>(), 0);
    }

    public List<AcademicRegister> exploreBranch(List<AcademicRegister> result, int k) {
        List<int[]> branchesToExplore = fillBranchesToExplore(school.getTotal(), k, result);
        AcademicRegister current;


        if (traceMode && k < school.getTotal()) {
            System.out.println("\n-- Explorando nivel " + (k+1) + " con " + branchesToExplore.size() + " ramas posibles.");
        }

        for (int[] register : branchesToExplore) {
            if (isSolutionComplete(result)) {
                if (traceMode && k == school.getTotal() - 2) {
                    System.out.println("Solución completa encontrada!");
                }

                return result;
            }

            // Eliminar registros de niveles superiores al actual
            while (!result.isEmpty() && result.getLast().indexCourse >= k) {
                result.removeLast();
            }


            current = new AcademicRegister(
                school.getRooms().get(register[1]),
                school.getCourses().get(register[0]),
                school.getTeachers().get(register[2])
            );

            if (traceMode) {
                System.out.println("\nExplorando rama: " + (current.getCourse().getId()) + " " + (current.getRoom().getId()) + " " + (current.getTeacher().getId()));
            }

            current.indexCourse = k;
            current.indexRoom = register[1];
            current.indexTeacher = register[2];

            if (!isSolutionCompletable(current)) {
                if (traceMode) {
                    System.out.println("Rama no completable, retrocediendo...");
                }

                continue;
            }

            if (traceMode && k+1 < school.getTotal()) {
                System.out.println("Rama completable, avanzando al siguiente nivel ->");
            }else if (traceMode) {
                System.out.println("Rama completable y último nivel alcanzado");
            }

            result.add(current);
            exploreBranch(result, k + 1);
        }

        return null;
    }

    public boolean isSolutionCompletable(AcademicRegister current) {
        return current.isValid();
    }

    public boolean isSolutionComplete(List<AcademicRegister> register) {
        return register.size() == school.getTotal();
    }
}

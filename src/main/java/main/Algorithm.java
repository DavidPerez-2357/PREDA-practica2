package main;
import utils.Printer;

import java.util.*;

/*

// El objetivo es explorar niveles y volver atras cuando ya no sea posible continuar

// Empezamos con un colegio donde no hay ninguna asignacion

// La primera posibilidad de asignacion podria ser [1, 1, 1]
//  Despues de eso se seguiria con [1, 1, 2]
//    Depues de eso se seguiria con [1, 1, 3]
//      Si este ultimo tambien falla, se suma uno al siguiente numero y se empieza
// Ahora [1, 2, 1]

*/

public class Algorithm {
    private final boolean traceMode;
    private Printer printer;

    private School school;


    public Algorithm(boolean traceMode, Printer printer) {
        this.traceMode = traceMode;
        this.printer = printer;
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

        for (int[] register : branchesToExplore) {
            if (isSolutionComplete(result)) {
                System.out.println("Rama completada con exito!");
                return result;
            }

            // Eliminar registros de niveles superiores al actual
            while (!result.isEmpty() && result.getLast().indexCourse >= k) {
                result.removeLast();
            }

            System.out.println("\nExplorando rama: " + (register[0]) + " " + (register[1]) + " " + (register[2]));
            System.out.println("Branches to explore: " + branchesToExplore.size());

            current = new AcademicRegister(
                school.getRooms().get(register[1]),
                school.getCourses().get(register[0]),
                school.getTeachers().get(register[2])
            );

            current.indexCourse = k;
            current.indexRoom = register[1];
            current.indexTeacher = register[2];

            if (!current.isValid() || !isSolutionCompletable(result)) {
                System.out.println("Rama no completables, retrocediendo...");
                continue;
            }

            result.add(current);
            exploreBranch(result, k+1);
        }

        return null;
    }

    public boolean isSolutionCompletable(List<AcademicRegister> registers) {
        return registers.isEmpty() || registers.getLast().isValid();
    }

    public boolean isSolutionComplete(List<AcademicRegister> register) {
        return register.size() == school.getTotal();
    }
}

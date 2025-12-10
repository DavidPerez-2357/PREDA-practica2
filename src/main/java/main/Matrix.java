package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
    private int[][] matrixInt;
    private int y;
    private int length;
    private int totalCost;
    private final ArrayList<Edge> edges;

    public int[][] getMatrix() {
        return matrixInt;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public Matrix(String instructions) {
        // The instructions go like this:
        // 8 6 <- First number is the length and the second the y
        // 1 1 0 <- First two numbers are the nodes to connect and the third is the weight
        // 1 2 2

        String[] lines = instructions.split("\n");
        String[] firstLine = lines[0].split(" ");
        int length = Integer.parseInt(firstLine[0]);
        this.matrixInt = new int[length][length];
        this.length = length;
        this.y = Integer.parseInt(firstLine[1]);
        this.totalCost = 0;
        this.edges = new ArrayList<>();

        // Make all weights -1 (no connection)
        matrixInt = Arrays.stream(matrixInt.clone())
                .map(row -> Arrays.stream(row).map(value -> -1).toArray())
                .toArray(int[][]::new);

        // Validations
        if (length < 1) {
            throw new IllegalArgumentException("La longitud debe ser al menos 1");
        }

        if (y < 0) {
            throw new IllegalArgumentException("El valor de y no puede ser negativo");
        }

        int nodeA, nodeB, weight;

        // Fill the adjacency matrix
        for (int i = 0; i < lines.length - 1; i++) {
            String[] parts = lines[i + 1].split(" ");
            nodeA = Integer.parseInt(parts[0]) - 1;
            nodeB = Integer.parseInt(parts[1]) - 1;
            weight = Integer.parseInt(parts[2]);

            // Skip if weight is "-"
            if (parts[2].equals("-")) {
                continue;
            }

            // Validation of i and j
            if (!isEdgeCorrect(nodeA + 1, nodeB + 1, weight)) {
                throw new IllegalArgumentException("La arista entre los nodos " + (nodeA + 1) + " y " + (nodeB + 1) +
                        " con peso " + weight + " no cumple la condición (nodeA * nodeB) % y == weight");
            }

            // Update matrix
            this.matrixInt[nodeA][nodeB] = weight;
            this.matrixInt[nodeB][nodeA] = weight; // For Undirected graph
            this.totalCost += weight;
            this.edges.add(new Edge(nodeA + 1, nodeB + 1, weight));
        }
    }

    public Matrix(int length, int y) {
        this.length = length;
        this.y = y;
        this.matrixInt = new int[length][length];
        this.totalCost = 0;
        this.edges = new ArrayList<>();

        if (length < 1) {
            throw new IllegalArgumentException("La longitud debe ser al menos 1");
        }

        if (y < 0) {
            throw new IllegalArgumentException("El valor de y no puede ser negativo");
        }
    }

    public int getTotalCost() {
        return totalCost;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public boolean isEdgeCorrect(int nodeA, int nodeB, int weight) {
        // TODO: Poner la condición correcta
    }

    public void addEdge(int nodeA, int nodeB, int weight) {
        this.totalCost -= this.matrixInt[nodeA - 1][nodeB - 1];
        this.matrixInt[nodeA - 1][nodeB - 1] = weight;
        this.matrixInt[nodeB - 1][nodeA - 1] = weight; // For Undirected graph
        this.edges.add(new Edge(nodeA, nodeB, weight));
        this.totalCost += weight;
    }

    public int getWeight(int nodeA, int nodeB) {
        return this.matrixInt[nodeA - 1][nodeB - 1];
    }

    @Override
    public String toString() {
        return "Matrix{\n" +
                "matrix=" + java.util.Arrays.deepToString(matrixInt) +
                ", y=" + y +
                ", length=" + length +
                "\n}";
    }
}

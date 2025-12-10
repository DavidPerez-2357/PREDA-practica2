package main;

public class Edge {
    private int nodeA;
    private int nodeB;
    private int weight;

    public Edge(int nodeA, int nodeB, int weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.weight = weight;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "Edge{\n"
                + "  nodeA=" + nodeA + ",\n"
                + "  nodeB=" + nodeB + ",\n"
                + "  weight=" + weight + ",\n"
                + "}\n";
    }
}

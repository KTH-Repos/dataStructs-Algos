import java.util.Arrays;

public class GraphMatrix {

    private boolean adjMatrix[][];
    private int numVertices;

    // Initialize the matrix
    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add edges
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    // Remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? true : false) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        boolean[][] graph = new boolean[4][4];
        for (int i = 0; i < graph.length; i++){
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = false;
            }
        }
        System.out.println(Arrays.deepToString(graph));

    }

}

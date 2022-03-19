import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 *
 * @author [Tomas]
 * @version [2021-02-19]
 */
public class Graph {
    /**
     * The map edges[v] contains the key-value pair (w, c) if there is an edge from
     * v to w; c is the cost assigned to this edge. The maps may be null and are
     * allocated only when needed.
     */
    private final Map<Integer, Integer>[] edges;

    /** Number of edges in the graph. */
    private int numEdges;

    /**
     * Constructs a HashGraph with n vertices and no edges. Time complexity: O(n)
     *
     * @throws IllegalArgumentException if n < 0
     */
    public Graph(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n = " + n);

        // The array will contain only Map<Integer, Integer> instances created
        // in addEdge(). This is sufficient to ensure type safety.
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] a = new HashMap[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new HashMap<>();
        }
        edges = a;
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int numVertices() {
       int numVertices = edges.length;
       return numVertices;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int numEdges() {
        int numberOfEdges = 0;
        for(int i = 0; i < edges.length; i++){
            Map<Integer, Integer> current = edges[i];
            numberOfEdges += current.size();
        }
        return numberOfEdges/2;
    }


    /**
     * Returns the outdegree of vertex v.
     *
     * @param v vertex
     * @return the outdegree of vertex v
     * @throws IllegalArgumentException if v is out of range
     */
    public int degree(int v) throws IllegalArgumentException {
        if( v < 0 || v > edges.length){
            throw new IllegalArgumentException( v + " doesn't exist in the graph");
        }
        else{
            Map<Integer, Integer> current = edges[v];
            int degree = current.size();
            return degree;
        }
    }

    /**
     * Returns an iterator of vertices adjacent to v.
     *
     * @param v vertex
     * @return an iterator of vertices adjacent to v
     * @throws IllegalArgumentException if v is out of range
     */
    public Iterator<Integer> neighbors(int v) {
        if(v < 0 || v > edges.length){
            throw new IllegalArgumentException(v + " doesn't exist in the graph.");
        }

        Map<Integer, Integer> current = edges[v];
        return current.keySet().iterator();

//        Iterator<Integer> it = current3.keySet().iterator();
//        while(it.hasNext()){
//            int neighbours = it.next();
//            System.out.println(neighbours);
//        }
    }

    /**
     * Returns true if there is an edge (from, to).
     *
     * @param v vertex
     * @param w vertex
     * @return true if there is an edge (from, to).
     * @throws IllegalArgumentException if from or to are out of range
     */
    public boolean hasEdge(int v, int w) {
        if(v < 0 || v > edges.length - 1){
            throw new IllegalArgumentException(v + " doesn't exist in the graph");
        }
        if(w < 0 || w > edges.length - 1){
            throw new IllegalArgumentException(w + " doesn't exist in the graph");
        }
        Map<Integer, Integer> current = edges[v];
        if(current.containsKey(w)){
            return true;
        }
        return false;
    }

    /**
     * Returns the edge cost if from and to are adjacent, otherwise -1.
     *
     * @param v vertex
     * @param w vertex
     * @return edge cost if available, -1 otherwise
     * @throws IllegalArgumentException if from or to are out of range
     */
    public int cost(int v, int w) throws IllegalArgumentException {
        if(v < 0 || v > edges.length - 1){
            throw new IllegalArgumentException(v + " doesn't exist in the graph");
        }
        if(w < 0 || w > edges.length - 1){
            throw new IllegalArgumentException(w + " doesn't exist in the graph");
        }
        Map<Integer, Integer> fromVertix = edges[v];
        if(fromVertix.containsKey(w)){
            int cost = fromVertix.get(w);
            return cost;
        }
        return -1;
    }

    /**
     * Inserts an edge with edge cost c.
     *
     * @param c edge cost, c >= 0
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if from or to are out of range
     */
    public void add(int v, int w, int c) {
        if(v < 0 || v > edges.length - 1){
            throw new IllegalArgumentException(v + " doesn't exist in the graph");
        }
        if(w < 0 || w > edges.length - 1){
            throw new IllegalArgumentException(w + " doesn't exist in the graph");
        }
        Map<Integer, Integer> fromVertix = edges[v];
        Map<Integer, Integer> toVertix = edges[w];
        fromVertix.put(w, c);
        toVertix.put(v, c);
        numEdges++;
    }

    /**
     * Removes the edges between v and w.
     *
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if v or w are out of range
     */
    public void remove(int v, int w) {
        if(v < 0 || v > edges.length - 1){
            throw new IllegalArgumentException(v + " doesn't exist in the graph");
        }
        if(w < 0 || w > edges.length - 1){
            throw new IllegalArgumentException(w + " doesn't exist in the graph");
        }
        Map<Integer, Integer> fromVertix = edges[v];
        Map<Integer, Integer> toVertix = edges[w];
        fromVertix.remove(w);
        toVertix.remove(v);
    }

    /**
     * Returns a string representation of this graph.
     *
     * Should represent the graph in terms of edges (order does not matter). For
     * example, if a graph has edges (2,3,0) and (1,0,0), the
     * representaiton should be:
     *
     * "{(1,0,0), (2,3,0)}" or "{(2,3,0), (1,0,0)}"
     *
     * An empty graph is just braces:
     *
     * "{}"
     *
     * @return a String representation of this graph
     */
    @Override
    public String toString() {
        if (numVertices() == 0) {
            String myGraph = "{}";
            return myGraph;
        }
        if (numVertices() == 1) {
            StringBuilder myGraph = new StringBuilder();
            boolean[][] added = new boolean[numVertices()][numVertices()];
            myGraph.append("{");
            for (int i = 0; i < numVertices(); i++) {
                Iterator<Integer> it = neighbors(i);
                while (it.hasNext()) {
                    int neighbours = it.next();
                    if (!(added[i][neighbours]) || !(added[neighbours][i])) {
                        myGraph.append("(");
                        myGraph.append(i + ",");
                        myGraph.append(neighbours + "," + cost(i, neighbours));
                        added[i][neighbours] = true;
                        added[neighbours][i] = true;
                        myGraph.append(")");
                    }
                }
            }
            myGraph.append("}");
            return myGraph.toString();
        }
        else {
            StringBuilder myGraph = new StringBuilder();
            boolean[][] added = new boolean[numVertices()][numVertices()];
            myGraph.append("{");
            for (int i = 0; i < numVertices(); i++) {
                Iterator<Integer> it = neighbors(i);
                while (it.hasNext()) {
                    int neighbours = it.next();
                    if (!(added[i][neighbours]) || !(added[neighbours][i])) {
                        myGraph.append("(");
                        myGraph.append(i + ",");
                        myGraph.append(neighbours + "," + cost(i, neighbours));
                        added[i][neighbours] = true;
                        added[neighbours][i] = true;
                        myGraph.append(")");
                    }
                }
            }
            myGraph.insert(9,", ");
            myGraph.append("}");
            return myGraph.toString();
        }
    }
}

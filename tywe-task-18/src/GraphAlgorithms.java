import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for solving graph problems.
 *
 * @author [Tomas]
 * @version [2021-02-25]
 */
public class GraphAlgorithms {

    /**
    * Determines if a component has a cycle.
    *
    * @param g the graph to search
    * @param v the node to start at
    * @param visited boolean array keeping track of visited nodes
    * @param parent parent node of v
    * @return true if component has cycle, false otherwise
    */
    private static boolean DFS(Graph g, int v, boolean[] visited, int parent) {
        visited[v] = true;
        Iterator<Integer> it = g.neighbors(v);
        while (it.hasNext()) {
            int neighbours = it.next();
            if (!visited[neighbours]) {
                if (DFS(g, neighbours, visited, v)){
                    return true;
                }
            }
            else if(parent != neighbours){   //if there is a back edge in the graph
                return true;
            }
        }
        return false;
    }

    /**
    * Determine if there is a cycle in the graph. Implement using DFS.
    *
    * @param g the graph to search
    * @return true if there exists at least one cycle in the graph, false otherwise
    */
    public static boolean hasCycle(Graph g) {
        boolean[] visisted = new boolean[g.numVertices()];
        boolean hasCycle = DFS(g,2, visisted, 2);
        return hasCycle;
    }

    /**

    * Determine if there is a path between two vertices. Implement using
    * BFS.
    *
    * @param v vertex
    * @param w vertex
    * @param g the graph to search
    * @return true if there is a path between v and w, false otherwise
    */
    public static boolean hasPath(Graph g, int v, int w) {
        boolean[] visited = new boolean[g.numVertices()];
        //Integer[] path = new Integer[g.numVertices()];
        LinkedList<Integer> myQueue = new LinkedList<>();
        visited[v] = true;
        myQueue.addLast(v);

        while(myQueue.size() != 0){
            int n = myQueue.remove();
            Iterator<Integer> it = g.neighbors(n);
            while(it.hasNext()){
                int neighbours = it.next();
                if(!visited[neighbours]){
                    visited[neighbours] = true;
                    myQueue.addLast(neighbours);
                    //path[neighbours] = n;
                }
            }
        }
        if(visited[w]){
            return true;
        }
        return false;
        }
    }

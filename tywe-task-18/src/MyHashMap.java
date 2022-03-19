import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {


    private static boolean DFS(Graph g, int v, boolean[] visited, int parent) {
        visited[v] = true;
        Iterator<Integer> it = g.neighbors(v);
        while (it.hasNext()) {
            int neighbours = it.next();
            //System.out.println(neighbours);
            if (!visited[neighbours]) {
                if (DFS(g, neighbours, visited, v)){
                    return true;
                }
            }
            else if(parent != neighbours){
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(Graph g) {
        boolean[]visited = new boolean[g.numVertices()];
        //boolean[]

        return false;
    }
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

    public static void main(String[] args) {
//

        Graph myGraph = new Graph(4);
//        myGraph.add(0,2,1);
//        myGraph.add(0,1,1);
//       // myGraph.add(1,0,1);
//        myGraph.add(1,2,1);
//        myGraph.add(1,3,1);
//        myGraph.add(1,4,1);
//       // myGraph.add(2,0,1);
//       // myGraph.add(2,1,1);
//        myGraph.add(2,3,1);
//       // myGraph.add(3,1,1);
//       // myGraph.add(3,2,1);
//        myGraph.add(3,4,1);
//       // myGraph.add(4,1,1);
//       // myGraph.add(4,3,1);

//        myGraph.add(0,1,1);
//        myGraph.add(1,2,1);
//        myGraph.add(2,6,1);
//        myGraph.add(2,3,1);
//       // myGraph.add(3,2,1);
//        myGraph.add(3,4,1);
//       // myGraph.add(4,3,1);
//        myGraph.add(4,5,1);
//        //myGraph.add(4,6,1);
//       // myGraph.add(5,4,1);
//       // myGraph.add(6,2,1);
//        //myGraph.add(6,4,1);

        myGraph.add(0,1,1);
        myGraph.add(0,3,1);
        myGraph.add(1,2,1);
        myGraph.add(3,2,1);

//        System.out.println(myGraph.toString());

        boolean[] visited = new boolean[myGraph.numVertices()];
////        for(int i=0; i < visited.length; i++){
////            System.out.println(visited[i]);
////        }
//        System.out.println(hasPath(myGraph,0,5));
        System.out.println(DFS(myGraph, 0, visited, 0));
        System.out.println(" ");
        for(int i=0; i < visited.length; i++){
            System.out.println(visited[i]);
        }

       // System.out.println(hasPath(myGraph,0,5));

    }


}

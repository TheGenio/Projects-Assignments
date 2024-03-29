package LAB09.Task03;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
// Determines if a vertex is reachable from another vertex in a directed graph
public class Graph {
    private List<List<Integer>> adjList = null;
    private int numVertices;
 
    public Graph(List<Edge> edges, int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
 
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the directed graph
        for (Edge edge: edges){
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
        }
    }
  
    public boolean isReachable(int src, int dest){
      boolean[] visited = new boolean[numVertices];
      return isReachable(src, dest, visited);
    }
    
    // Function to perform BFS traversal from the source vertex in the graph to
    // determine if the destination vertex is reachable from the source or not
    private boolean isReachable(int src, int dest, boolean[] visited)
    {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        visited[src] = true;
        while(!queue.isEmpty()){
            int current = queue.poll(); // same as pop

            if(current == dest){
                return true;
            }
            for(int i = 0; i < adjList.get(current).size(); i++){
                int next = adjList.get(current).get(i);
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
            
        return false;
    }
}
package LAB09.Task03;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class GraphDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Edge> edges = Arrays.asList(Edge.getEdge(0, 3), Edge.getEdge(1, 0),
                Edge.getEdge(1, 2), Edge.getEdge(1, 4),
                Edge.getEdge(2, 7), Edge.getEdge(3, 4),
                Edge.getEdge(3, 5), Edge.getEdge(4, 3),
                Edge.getEdge(4, 6), Edge.getEdge(5, 6),
                Edge.getEdge(6, 7));

        // Number of nodes in the graph (labelled from 0 to N-1)
        int numVertices = 8;
        // To be completed by students

        Graph graph = new Graph(edges, numVertices);
        System.out.println("Enter source vertex: ");
        int source = scanner.nextInt();
        System.out.println("Enter destination vertex: ");
        int dest = scanner.nextInt();
        if (graph.isReachable(source, dest)) {
            System.out.println("There is a path from " + source + " to " + dest);
        }else{
            System.out.println("There is no path from " + source + " to " + dest);
        }
    }
}
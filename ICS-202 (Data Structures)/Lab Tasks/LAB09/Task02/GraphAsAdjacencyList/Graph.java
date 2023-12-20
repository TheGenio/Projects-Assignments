package LAB09.Task02.GraphAsAdjacencyList;

import java.util.*;

class Graph { 
          int numVertices;
        LinkedList<String>[] adjacencyList;
        String[] labels;

        Graph(int numVertices, String[] labels) {
            this.labels =  labels;
            this.numVertices = numVertices;

            adjacencyList = new LinkedList[numVertices];
            for (int i = 0; i < adjacencyList.length; i++)
                adjacencyList[i] = new LinkedList<String>();
        }
          
        //To add a directed edge to graph 
        void addDirectedEdge(int v, int w)  {
            adjacencyList[v].add(labels[w]); // Add w to v�s list.
        }
         //To add undirected edge to graph 
        void addUndirectedEdge(int v, int w) {          
            adjacencyList[v].add(labels[w]); // Add w to v�s list.
            adjacencyList[w].add(labels[v]); // Add v to w�s list.);
        } 
        
        void displayGraph(){
           for (int i = 0; i < adjacencyList.length; i++){  
               System.out.println(i + " ----> " + adjacencyList[i]);
            } 
            System.out.println(); 
        
       } 
   }


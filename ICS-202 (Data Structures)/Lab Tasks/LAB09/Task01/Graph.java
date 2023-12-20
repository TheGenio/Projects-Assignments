package LAB09.Task01;

public class Graph {
      private boolean adjacencyMatrix[][];
      private int numberOfVertices;

      public Graph(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;
            adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];
      }

      public void addEdge(int i, int j) {
          if (i > adjacencyMatrix.length || j > adjacencyMatrix[0].length) {
              System.out.println("Not allowed");
              return;
          }
          adjacencyMatrix[i][j] = true;
          adjacencyMatrix[j][i] = true;
      }

      public void removeEdge(int i, int j) {
          if (i > adjacencyMatrix.length || j > adjacencyMatrix[0].length) {
              System.out.println("Not allowed");
              return;
          }
          adjacencyMatrix[i][j] = false;
          adjacencyMatrix[j][i] = false;
      }

      public boolean isEdge(int i, int j) {
          if (i > adjacencyMatrix.length || j > adjacencyMatrix[0].length) {
              System.out.println("Not allowed");
              return false;
          }
          return adjacencyMatrix[i][j] & adjacencyMatrix[j][i];
      }
      
      public void displayGraph(){
        System.out.printf("%10s", " ");
        for(int i = 0; i < numberOfVertices; i++)
          System.out.printf("%10s", i);
          System.out.println();
        for(int i = 0; i < numberOfVertices; i++){
          System.out.printf("%10s", i);
          for(int j = 0; j < numberOfVertices; j++){
            System.out.printf("%10s", adjacencyMatrix[i][j]);
           }
           System.out.println();
       }
       
   }
 }

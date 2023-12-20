package LAB08;

import java.util.Arrays;

public class BinaryHeap 
{
   protected Comparable array[];
   int count;
	  
   public BinaryHeap(int i)
   {
      array = new Comparable[i + 1];
   }
    
   public BinaryHeap(Comparable[] comparable) 
   {
      this(comparable.length);
   	for(int i = 0; i < comparable.length; i++)
         array[i + 1] = comparable[i];
    	   
      count = comparable.length;
   	
      //buildHeapTopDown();
      buildHeapBottomUp();
   }
	
   private void buildHeapBottomUp() {


      for (int i = count/2; i>=1; i--){
         percolateDown(i);
      }
      //Q1
   }
	
private void buildHeapTopDown() {
    for (int i = 2; i <= count; i++) {
        percolateUp(i);
    }
}

	
	private void percolateDown(int index) {
    int leftChild;
    int rightChild;
    int minChild;

    while (2 * index <= count) {
        leftChild = 2 * index;
        rightChild = leftChild + 1;

        if (rightChild <= count && array[rightChild].compareTo(array[leftChild]) < 0) {
            minChild = rightChild;
        } else {
            minChild = leftChild;
        }

        if (array[index].compareTo(array[minChild]) > 0) {
            Comparable temp = array[index];
            array[index] = array[minChild];
            array[minChild] = temp;

            index = minChild;
        } else {
            break;
        }
    }
}

	
   private void percolateUp(int index)
   {
      //last leaf node
      while(index > 1 && array[index].compareTo(array[index/2]) < 0){

         Comparable temp =  array[index/2];
         array[index/2] = array[index];
         array[index] = temp;
         index = index/2;

      }
      //Q1
   }
	
   public void purge()
   {
      while(count > 0) 
         array[count--] = null;
   }

   public void enqueue(Comparable comparable)
   {
      int index = ++count;
        
      //percolate up via a gap
      while(index > 1 && array[index / 2].compareTo(comparable) > 0)
      {
         array[index] = array[index / 2];
         index = index / 2 ;
      }

      array[index] = comparable;
   }

   public Comparable findMin()
   {
      return array[1];
   }

   public Comparable dequeueMin()
   {
      Comparable minItem = array[1];
      array[1] = array[count];
      count--;
      percolateDown(1);
      return minItem;
   }
    
   public Comparable[] heapSort() 
   {
      Comparable[] x = new Comparable[count];
      int total = count;
      for(int i = 0; i < total; i++) {
         x[i] = dequeueMin();    		
      }
   return x;
   }
    
    
   public boolean isFull()
   {
      return count == array.length - 1;
   }
    
   public boolean isEmpty() 
   {
      return count == 0;
   }
    
   public String toString()
   {
      Comparable[] tempArray = new Comparable[array.length - 1];
    	System.arraycopy(array, 1, tempArray, 0, array.length - 1);
    	return Arrays.toString(tempArray);
   }


    
   public static void main(String[] args) 
   {
      Integer[] a = {10, 2, 8, 9, 1, 6, 3, 4, 0, 5};
      System.out.println("The original array is: "+Arrays.toString(a));
      BinaryHeap bh = new BinaryHeap(a);
    	//builds heap bottom up: change the constructor to build it top-down
      System.out.println("\nThe heap is: "+bh);
    	System.out.println("\nSorted Array is: "+Arrays.toString(bh.heapSort()));
   }
}
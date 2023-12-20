package LAB05.Task02;// Java program to implement a queue using an array

class TestQueue {
    public static void main(String[] args) {
        QueueAsArray<Integer> queue = new QueueAsArray<>(5);

        // Enqueue elements
        queue.enqueue(60);
        queue.enqueue(20);
        queue.enqueue(40);
        queue.enqueue(30);
        queue.enqueue(70);

        // Display the initial queue
        System.out.println("The queue is: " + queue);

        // Dequeue and display elements
        System.out.println("First dequeued element is: " + queue.dequeue());
        System.out.println("Second dequeued element is: " + queue.dequeue());

        // Display the queue after two node deletion
        System.out.println("After two node deletion the queue is: " + queue);

        // Display the element at the front of the queue
        System.out.println("Element at queue front is: " + queue.peek());
    }
}
public class QueueAsArray<T> {
    private int front, rear, capacity; 
    private T[] queue; 
  
    public QueueAsArray(int capacity) { 
        front = rear = -1; 
        this.capacity = capacity; 
        queue = (T[]) new Object[capacity]; 
    } 
    
    public boolean isEmpty(){
       return front == -1;
    }
    
    public boolean isFull(){
      return rear == capacity - 1;
    }
  
    // function to insert an element at the rear of the queue 
    public void enqueue(T data)  { 
        if (isFull())
            throw new UnsupportedOperationException("Queue is full!"); 
        if(isEmpty())
           front++;
           
           rear++; 
           queue[rear] = data; 
    } 
  
//    public T dequeue() {
//        if (isEmpty())
//            throw new UnsupportedOperationException("Queue is empty!");
//        T temp = queue[front];
//        if (rear == 0) {
//            rear = front = -1;
//        }
//        else{
//            for(int i = 0; i <= rear - 1; i++) {
//                queue[i] = queue[i + 1];
//            }
//            rear--;
//        }
//        return temp;
//    }

    public T dequeue() {
        if(isEmpty()){
            throw new UnsupportedOperationException("Queue is empty");
        }else{
            T temp = queue[front];
            dequeueHelper(0);
            rear--;
            return temp;
        }
    }

    public void dequeueHelper(int i ) {
        if (i == rear - 1) {
            queue[i] = queue[ i + 1 ];

        } else {
            queue[i] = queue[i + 1];
             dequeueHelper(i + 1);
        }
    }


    public boolean search(T e){
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
            
        for(int i = 0; i <= rear; i++) 
            if(e.equals(queue[i]))
               return true;
               
        return false;
  }
  
  public String toString()  { 
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
         
        String str = "";  
        for (int i = 0; i <= rear; i++) { 
            str = str + queue[i] + "   "; 
        } 
        
        return str;
    } 
  
    public  T peek() { 
        if (isEmpty())
             throw new UnsupportedOperationException("Queue is empty!"); 
 
        return queue[front];  
    } 
} 
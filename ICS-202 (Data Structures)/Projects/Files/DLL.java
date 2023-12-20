package LabProject;//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
             return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
             head = new DLLNode<T>(el,head,null);
             head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
             tail = new DLLNode<T>(el,null,tail);
             tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)
             head = tail = null;
        else {
             head = head.next;
             head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)
             head = tail = null;
        else {
             tail = tail.prev;
             tail.next = null;
        }
        return el;
    }
//    public void printAll() {
//        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
//             System.out.print(tmp.info + " ");
//        System.out.println();
//    }
    public String printAll() {
    StringBuilder result = new StringBuilder();
    for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
        result.append("'").append(tmp.info).append("'").append(", ");
    System.out.println();
    return result.toString().trim();
}

    public boolean find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        return tmp != null;

    }


    public void printReverse(){
        DLLNode<T> tmp = tail;
        while(tmp != null){
            System.out.print(tmp.info+ " ");
            tmp = tmp.prev;
        }

    }

public void delete(T el) {
    DLLNode<T> tmp;

    // Handle the case where the element to be deleted is the head
    while (head != null && head.info.equals(el)) {
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // Traverse the list to find and delete the element
    for (tmp = head; tmp != null; tmp = tmp.next) {
        if (tmp.info.equals(el)) {
            if (tmp.prev != null) {
                tmp.prev.next = tmp.next;
            }
            if (tmp.next != null) {
                tmp.next.prev = tmp.prev;
            }
            break; // Element found and deleted, exit the loop
        }
    }
}







    }





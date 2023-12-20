package LAB02;

//**************************  SLL.java  *********************************
//           a generic singly linked list class


public class SLL<T> {

    private class SLLNode<T> {
      private T info;
      private SLLNode<T> next;
      public SLLNode() {
         this(null,null);
      }
      public SLLNode(T el) {
        this(el,null);
      }
      public SLLNode(T el, SLLNode<T> ptr) {
         info = el; next = ptr;
      }
    }

    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info;
        if (isEmpty())
             return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
             head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
             return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
             head = tail = null;
        else {                  // if more than one node in the list,
             SLLNode<T> tmp;    // find the predecessor of tail;
             for (tmp = head; tmp.next != tail; tmp = tmp.next);
             tail = tmp;        // the predecessor of tail becomes tail;
             tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                 head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                 head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                 SLLNode<T> pred, tmp;// and el is in a nonhead node;
                 for (pred = head, tmp = head.next;
                      tmp != null && !tmp.info.equals(el);
                      pred = pred.next, tmp = tmp.next);
                 if (tmp != null) {   // if el was found;
                     pred.next = tmp.next;
                     if (tmp == tail) // if el is in the last node;
                        tail = pred;
                 }
            }
    }

    @Override
    public String toString() {
       if(head == null)
          return "[ ]";
       String str = "[ ";
       SLLNode<T> tmp = head;
       while(tmp != null){
         str += tmp.info + " ";
         tmp = tmp.next;
       }
       return str+"]";
    }

    public boolean contains(T el) {
        if(head == null)
            return false;
        SLLNode<T> tmp = head;
        while(tmp != null){
           if(tmp.info.equals(el))
              return true;
           tmp = tmp.next;
        }
        return false;
    }

    public int size(){
        if(head == null)
          return 0;

        int count = 0;
        SLLNode<T> p = head;
        while(p != null) {
           count++;
           p = p.next;
        }

        return count;
    }

    //  Please write the methods of Task02 here:

    public void insertBefore(int index, T newElem) {

        int sizeSll = size();
        int count = 0;
        SLLNode<T> ThisNode, NextNode, tmp;
        ThisNode = head;
        NextNode = head.next;
        if (index >= sizeSll || isEmpty() || index < 0) {
            throw new RuntimeException("List is empty");
        }
            else{
                while (sizeSll != count) {

                    if (index == 0) {
                        tmp = new SLLNode<T>(newElem);
                        tmp.next = ThisNode;
                        head = ThisNode;
                        break;
                    } else if (index == count + 1) {
                        tmp = new SLLNode<T>(newElem);
                        tmp.next = NextNode;
                        ThisNode.next = tmp;
                        break;
                    }
                    ThisNode = ThisNode.next;
                    NextNode = NextNode.next;
                    count++;
                }
            }
        }

        public T delete(int index){
        int count = 0;
        if (!isEmpty() && (!(index >= size()) && !(index < 0) ) ){
            if (head == tail) {
                head = tail = null;
                return null;
            } else if (index == 0) {
                head = head.next;
            }else {
                SLLNode<T> pred, tmp;
                for (pred = head, tmp = head.next;
                     tmp != null;
                     pred = pred.next, tmp = tmp.next, count++) {
                    if (count + 1 == index) {
                        pred.next = tmp.next;
                        return tmp.info;
                    }
                }
            }

            }else{
            throw new RuntimeException("List is empty or index is out of bounds");
        }
        // if statement end
            return null;
        }

        public void insertAfterSecondOccurrence(T e1, T e2){
            int Occurance = 0;

            SLLNode<T> ThisNode, NextNode, Tmp;
            ThisNode = head;
            NextNode = head.next;
            boolean check = false;


                    while (ThisNode != null) {

                        if (ThisNode.info.equals(e2)){
                            Occurance++;
                            if(Occurance == 2){
                                if(ThisNode.next == null){
                                    Tmp = new SLLNode<T>(e1);
                                    ThisNode.next = Tmp;
                                    check = true;
                                break;
                                } else {
                                    Tmp = new SLLNode<T>(e1);
                                    ThisNode.next = Tmp;
                                    Tmp.next = NextNode;
                                    check = true;
                                    break;
                                }
                            }
                        }


                        ThisNode = ThisNode.next;
                        if (NextNode != null) {
                            NextNode = NextNode.next;
                        }
                    }
                    if(check){}else{
                        throw new RuntimeException("List is empty or list has no second occurrence of the number");
                    }

        }


        public void examq(){
            SLLNode<T> p = head;
            int i = 0;
            while(p.next != null){
                p = p.next;
                if(i%2 == 0){
                    p.next = p.next.next;
                }
                i++;
            }

        }


}

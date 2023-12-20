package LAB03;//****************************  DLL.java  *******************************
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
    public void printAll() { 
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             System.out.print(tmp.info + " ");
        System.out.println();
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
             return null;
        else return tmp.info;
    }


    public void printReverse(){
        DLLNode<T> tmp = tail;
        while(tmp != null){
            System.out.print(tmp.info+ " ");
            tmp = tmp.prev;
        }

    }

    public void delete7(){
        try {
            int numOfElem = 0;
            DLLNode<T> tmp = head;

            while (tmp != null) {
                tmp = tmp.next;
                numOfElem++;
            }
            int count = 0;
            tmp = head;
            if (numOfElem >= 7) {
                while (count < 6) {
                    tmp = tmp.next;
                    count++;
                }
                if (tmp.next == null) {
                    tmp.prev.next = null;
                    tail = tmp;
                } else {
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                    tmp.next = tmp.prev;
                }

            } else if (numOfElem < 7) {
                boolean flagHead = true;
                boolean flagTail = false;
                boolean finish = false;
                while (!finish) {

                    // for moving the element
                    if (flagHead) {
                        if (tmp.next == null) {
                            flagHead = false;
                            flagTail = true;
                        } else {
                            tmp = tmp.next;
                            count++;
                        }
                    } else if (flagTail) {

                        if (tmp.prev == null) {
                            flagTail = false;
                            flagHead = true;
                        } else {
                            tmp = tmp.prev;
                            count++;
                        }
                    }

                    if (count == 6) {
                        if (tmp.next == null) {
                            tmp.prev.next = null;
                            tail = tmp.prev;
                        } else if (tmp == head) {
                            tmp.next.prev = null;
                            head = tmp.next;
                        } else {
                            tmp.prev.next = tmp.next;
                            tmp.next.prev = tmp.prev;
                            tmp.next = tmp.prev;
                        }
                        finish = true;

                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void insertAlternate(DLL<T> newList){

    int numOfElem = 0;
        DLLNode<T> tmp = head;
        DLLNode<T> tmp2 = newList.head;
        while (tmp != null){
            numOfElem++;
            tmp = tmp.next;
        }
        numOfElem =0;
        while(tmp2 != null){
            numOfElem++;
            tmp2 = tmp2.next;
        }

        if(numOfElem % 2 != 0){
            System.out.println("The two lists are not the same length");
        }
        else if(isEmpty()){
            System.out.println("The list is empty");
        }
        else if(head==tail) {

            head.next = newList.head ;
            tail = newList.head ;
            tail.prev = head ;
        }
        else{
            DLLNode<T> tmpLst1 = head ;
            DLLNode<T> tmpLst1Tail = tail ;

            DLLNode<T> tmpLst2 = newList.head ;
            DLLNode<T> tmlLst2Nxt = newList.head.next ;

            while(tmpLst1 != tmpLst1Tail){
                tmpLst2.prev = tmpLst1 ;
                tmpLst1.next.prev = tmpLst2 ;
                tmpLst2.next = tmpLst1.next ;
                tmpLst1.next = tmpLst2 ;

                tmpLst2 = tmlLst2Nxt ;
                tmpLst1 = tmpLst1.next.next ;
                if(tmlLst2Nxt.next == null){
                    tmpLst2.prev = tmpLst1 ;
                    tmpLst1.next = tmpLst2 ;
                    tail = tmpLst2 ;
                }
                else{
                     tmlLst2Nxt = tmlLst2Nxt.next ;
                }
            }
        }
    }






    }





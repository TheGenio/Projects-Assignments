package LAB10;

import java.util.Arrays;

public class entry<T> {

    String status;
    T dataObject;

    entry(T dataObject) {
        this.dataObject = dataObject;
        this.status = "O";
    }

    entry(){
        this.status = "E";
    }

    public int getHashCode() {
        return dataObject.hashCode();
    }


    @Override
    public String toString() {
        return "[" +dataObject + ", " +status + "]" +"\n";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


class HashTable<T> {
    entry[] hashs;

    HashTable(int size) {
        hashs = new entry[size];
        for (int i = 0; i < size; i++){
            hashs[i] = new entry();
        }
    }

    public boolean insert(T dataObject) {
        entry temp = new entry(dataObject);
        int index = temp.getHashCode() % 13;
        if (hashs[index].status == "E") {
            hashs[index] = temp;
            return true;
        }else {
            int nextIndex =  findNextAvailableSlot(index);
            if (nextIndex==-1) return false;
            hashs[nextIndex] = temp;
            return true;
        }


    }


    public int findNextAvailableSlot(int currentSlot){
        if (hashs[currentSlot].status == "O" || hashs[currentSlot].status == "D") {
            for (int i = 1; i < hashs.length; i++) {
                currentSlot = currentSlot % 13 + i;
                if (hashs[currentSlot].status == "E") {
                    return currentSlot;
                }
            }

        }

        return -1;
    }

    public boolean delete(T dataObject){
        entry temp = new entry(dataObject);
        int index = temp.getHashCode() % 13;
        if(hashs[index].status == "E") {
            return false;
        }
        hashs[index].setStatus("D");
        return true;

    }

    public int find(T dataObject){
        entry temp = new entry(dataObject);
        int index = temp.getHashCode() % 13;

        if (hashs[index].status == "O" || hashs[index].status == "D") {
            if (hashs[index].dataObject == dataObject) {
                return index;
            }else{
                    for (int i = 1; i < hashs.length; i++) {
                        index = index % 13 + i;
                        if (hashs[index].dataObject == dataObject) {
                            return index;
                        }
                        if (hashs[index].status == "E") {
                            return -1;
                        }
                    }

            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < hashs.length; i++) {
            result += i + ": " + hashs[i].toString();
        }
        return result;
    }
}


class main{
    public static void main(String[] args){

        //test the hash table
        HashTable<Integer> hashTable = new HashTable<>(13);
        hashTable.insert(18);
        hashTable.insert(26);
        hashTable.insert(35);
        hashTable.insert(9);

        System.out.println(hashTable);

        if(hashTable.find(15) == -1) {
            System.out.println("15 Not Found");
        }
        if(hashTable.find(48) == -1) {
            System.out.println("48 Not Found");
        }
        if (hashTable.delete(35)){
            System.out.println("35 Successfully deleted");
        }
        System.out.println("9 found at " + hashTable.find(9));

        System.out.println("After deleting 35 and inserting 64 and 47, the hashtable is");
        hashTable.insert(64);
        hashTable.insert(47);
        System.out.println(hashTable);

    }



}
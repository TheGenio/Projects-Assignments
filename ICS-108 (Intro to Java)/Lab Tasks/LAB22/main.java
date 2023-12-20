package LAB22;

public class main {

    public static void main(String[] args){
        dynamicarray da = new dynamicarray();
        da.add("X");
        da.add("Y");
        da.add("Z");

        System.out.println(da.remove()); // Returns Z
        System.out.println(da.remove()); // Returns Y
        System.out.println(da.remove()); // Returns X
        System.out.println(da.remove()); // Returns null


    }



}




class dynamicarray<T>{

    int size = 2;
    int index = 0;
    T[] array;
    dynamicarray(){
        this.array = (T[]) new Object[size];
    }

    void add(T element){

        if(index == array.length){
            size = size * 2;
            T[] newArray = (T[]) new Object[size];
            for(int i = 0; i < array.length; i++){
                newArray[i] = array[i];
            }
            array = newArray;
            array[index] = element;
            index++;
        }
        else {
            array[index] = element;
            index++;

        }
    }

    T remove(){
        if(index == 0){
            T temp = array[index];
            return null;
        }else {
            index--;
            T temp = array[index];
            T[] newArray = (T[]) new Object[size];
            for (int i = 0; i < array.length - 1; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            return temp;

        }
    }









}

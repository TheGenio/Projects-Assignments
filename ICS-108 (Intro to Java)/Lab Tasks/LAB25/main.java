package LAB25;

public class main {
    public static void main(String[] args){
        int[] numbers = new int[100000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        long startTime = System.nanoTime();
        linearSearch(numbers, 50000);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Linear search: "+executionTime);


        startTime = System.nanoTime();
        binarySearch(numbers,50000);

        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("Binary search: "+ executionTime);






    }

    public static int linearSearch(int[] numbers, int target){

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] numbers, int target){
        int indexLow = 0;
        int indexHigh = numbers.length - 1;
        int indexMid = (indexHigh + indexLow) / 2;

        while (true) {
            int mid = numbers[indexMid];
            if (mid == target) {
                return mid;
            } else {
                if (target < mid) {
                    indexHigh = indexMid - 1;
                    indexMid = (indexHigh + indexLow) / 2;
                }
                else if (target > mid){
                    indexLow = indexMid + 1;
                    indexMid = (indexHigh + indexLow) / 2;
                }
            }

        }

    }




}

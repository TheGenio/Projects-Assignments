package LAB08;

import java.util.Arrays;
import java.util.Random;

public class patient implements Comparable {

    String name;
    int emergencyLevel;

    patient(String name, int emergencyLevel) {
        this.name = name.toLowerCase();
        this.emergencyLevel = emergencyLevel;
    }


    public int compareTo(Object otherPatient) {
        if (otherPatient instanceof patient) {
            patient castedPatient = (patient) otherPatient;
            if (this.emergencyLevel < castedPatient.emergencyLevel) {
                return -1;
            } else if (this.emergencyLevel > castedPatient.emergencyLevel) {
                return 1;
            }
            return this.name.compareTo(castedPatient.name);
        }

        return 0;
    }

    @Override
    public String toString() {
        return "patient{" +
                "name='" + name + '\'' +
                ", emergencyLevel=" + emergencyLevel +
                '}';
    }
}





class Hospital {

    public static void main(String[] args) {
        patient[] patients = new patient[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String name = "Patient" + (i + 1);
            int emergencyLevel = random.nextInt(5) + 1;
            patients[i] = new patient(name, emergencyLevel);
        }


        BinaryHeap hos = new BinaryHeap(10);
        System.out.println("Unsorted Patients:");
        for (int i = 0; i < patients.length; i++) {
            System.out.println(patients[i]);
            hos.enqueue(patients[i]);
        }



        Comparable[] sortedPatients = hos.heapSort();
        System.out.println("Sorted Patients:");
            for (Comparable element : sortedPatients) {
                System.out.println(element);
}


    }


}







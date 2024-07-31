package org.pkoleva.duplicates;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Duplicates {

    public static void main(String[] args) {
        int[] numbers = readFromConsole();
        System.out.println(countDuplicates(numbers));
    }

    public static int[] readFromConsole(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int size = sc.nextInt();
        if(size<1||size>1000){
            System.out.println("Invalid number");
        }
        int[] numbersArray = new int[size];
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            if(val>0 && val<=1000){
                numbersArray[i]=val;
            }
            else{
                System.out.println("Invalid number");
                break;
            }
        }
        return numbersArray;
    }

    public static int countDuplicates(int[] numbers){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int freq : frequencyMap.values()) {
            if (freq > 1) {
                count ++;
            }
        }

        return count;
    }
}

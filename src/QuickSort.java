/*
 * Patty Bagwell
 * Data Structures
 * December 2017
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class QuickSort 
{
    //this method creates a partition and moves elements that is greater than
    //the pivot to the right, and elements less then the partition to the left.
    int partition(String arr[], int low, int high)
    {
       String pivot = arr[high];//pivot set to last element in the array
       int i = (low-1); //index of smaller element
       for (int j = low; j<high; j++)//start traversing the array
        {
           //if current element is smaller than or equal to pivot
            if(arr[j].compareTo(pivot)<0)
            {
             i++;
            //swap arr[i] and arr[j]
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            }
       }
       //swap arr[i+1] and arr[high] (or pivot)
       String temp = arr[i+1];
       arr[i+1] = arr[high];
       arr[high] = temp;
       
       return i+1;
    }



void sort(String arr[], int low, int high)
{
if(low < high)
{
    int pi = partition (arr, low, high);
    // Recursively sort elements before
    // partition and after partition
    sort(arr, low, pi-1);
    sort(arr, pi+1, high);
}
}

    // Driver program
    static Scanner scn;
    public static void main(String[] args) {
    long insertStartTime = System.currentTimeMillis();    
    try
    {
        scn = new Scanner(new File("test/words.txt"));
    }
    catch(FileNotFoundException ex)
    {
        System.out.println(ex.getMessage());
    }
    System.out.println("Items loaded into the Array: ");
    
    String[] array = scn.next().split(",");
    System.out.println(array.length);
            
        for(int i = 0; i<array.length; i++)
        {
            System.out.print(array[i] + ", ");
        }
        
        int n = array.length;
        
        QuickSort ob = new QuickSort();
        ob.sort(array, 0, n-1);
 
        
        
        System.out.print("\n");
        System.out.println("Unique Items in Sorted Order:");
        
        
        //print unique items in an array
        String t = array[0]; //assign first value of the array to var t
        System.out.print(t); //print out first value in the array
        for (int i = 1; i < array.length; i++)//iterate through the remaining values in the array
        {
            if (!array[i].equals(t))//if next value in array does not equal the 
                                    //t then assign t to the new value and print
                                    //print the new value followed by a comma.
            {
                t = array[i];
                System.out.print(", " + array[i]);
            }
            
        }
        long insertEndTime = System.currentTimeMillis();
        System.out.print("\n");
        System.out.println("Quick Sort Took " + 
                (insertEndTime - insertStartTime) + " milliseconds");
    }
}


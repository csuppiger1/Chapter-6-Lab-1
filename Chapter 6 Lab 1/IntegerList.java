package labs.apcs_ch6_lab_1;

// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//          
// ****************************************************************

import java.util.Scanner;

public class IntegerList{

    int[] list; //values in the list
    Scanner scan = new Scanner(System.in);
    int size;

    //-------------------------------------------------------
    //create a list of the given size
    //-------------------------------------------------------
    public IntegerList(int size)
    {
        list = new int[size];
        this.size = size;
    }
    
    public void increaseSize()
    {
        int[] temp = new int[size];
        for (int i = 0; i < size; i++)
        {
            temp[i] = list[i];
        }
        
        size *= 2;
        
        list = new int[size];
        
        for (int j = 0; j < size/2; j++)
        {
            list[j] = temp[j];
        }
        
    }
    
    public void addElement(int element)
    {
        if (list[list.length -1] != 0) //space is available at end
        {
            increaseSize();
        }
        int insertionLoc = search(0);
        list[insertionLoc] = element;
    }
    
    public void removeFirst(int value)
    {
        int location = search(value);
        
        for (int i = location ; i < list.length-1; i++)
        {
            list[i] = list[i + 1];
        }
        list[list.length -1] = 0;
    }
    
    public void removeAll(int value)
    {
        boolean valueInArray = true; //will be true as long as one item in list matches value
        while (valueInArray)
        {
            if (search(value) != -1) removeFirst(value);
            else valueInArray = false;
            
        }
        
    }
    
    public void addInOrder(int value)
    {
      selectionSort();
      int location = 0;
       while (list[location] < value && location < list.length -1)
       {
           location++;
        }
        insert(value, location);
    }
    
    public void insert(int value, int location)
    {
        int endOfArray = list.length;
        //increase size
        increaseSize();
        //move items to right from location
        for(int i = endOfArray-1; i >= location; i--)
        {
            list[i + 1] = list[i];
        }
        //assign value to location
        list[location] = value;
    }
    
    //-------------------------------------------------------
    //fill array with integers between 1 and 100, inclusive
    //-------------------------------------------------------
    public void randomize()
    {
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * 100) + 1;
    }

    //-------------------------------------------------------
    //print array elements with indices
    //-------------------------------------------------------
    public void print()
    {
        for (int i=0; i<list.length; i++)
            System.out.println(i + ":\t" + list[i]);
    }

    //-------------------------------------------------------
    //return the index of the first occurrence of target in the list.
    //return -1 if target does not appear in the list
    //-------------------------------------------------------
    public int search(int target)
    {
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
            if (list[i] == target)
            location = i;
        return location;
    }

    //-------------------------------------------------------
    //sort the list into ascending order using the selection sort algorithm
    //-------------------------------------------------------
    public void selectionSort()
    {
        int minIndex;
        for (int i=0; i < list.length-1; i++)
            {
            //find smallest element in list starting at location i
            minIndex = i;
            for (int j = i+1; j < list.length; j++)
                if (list[j] < list[minIndex])
                    minIndex = j;
    
            //swap list[i] with smallest element
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
            }
    }
    
    public void sortDecreasing()
    {
         int maxIndex;
        for (int i=0; i < list.length-1; i++)
            {
            //find smallest element in list starting at location i
            maxIndex = i;
            for (int j = i+1; j < list.length; j++)
                if (list[j] > list[maxIndex])
                    maxIndex = j;
    
            //swap list[i] with smallest element
            int temp = list[i];
            list[i] = list[maxIndex];
            list[maxIndex] = temp;
            }
    }
    
    public void replaceFirst(int oldVal, int newVal)
    {
        int location = search(oldVal);
        list[location] = newVal;
    }
    
    public void replaceAll(int oldVal, int newVal)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == oldVal) list[i] = newVal;
        }
    }
}

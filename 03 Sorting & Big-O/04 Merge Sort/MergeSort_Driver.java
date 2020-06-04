// Name: S2-17
// Date: 10/28/19

import java.util.*;
import java.io.*;

public class MergeSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      //Part 1, for doubles
      double[] array = {3,1,4,1,5,9,2,6};    // small example array from the MergeSort handout
      int n = (int)(Math.random()*50+10);
      //double[] array = new double[n];
      //for(int k = 0; k < array.length; k++)
         //array[k] = Math.random();
         	
      MergeSort.sort(array);
   
      print(array);
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("oops!");
         
      //Part 2, for Comparables
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      MergeSort.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }

   
   public static void print(double[] a)   
   {                             
      for(double number : a)    
         System.out.print(number+" ");
      System.out.println();
   }
   
/*It loops through the array starting at 1 (since there's nothing to the left of 0 for it to compare to) and we check if
   the item in the index to left is greater than than the item in the current index. If this is true, it means it is not in 
   ascending order so we return false. If false isn't returned, that means it is in ascending order so at the end we return true.*/
  
   public static boolean isAscending(double[] a)
   {
      for(int x = 1; x < a.length; x++)
      {
         if(a[x-1] > a[x])
         {
            return false;
         }
      }  
      return true;
   }
   
   /*It prints every object in the peach array*/
  
   public static void print(Object[] peach)
   {
      for(Object number : peach)    
         System.out.print(number+" ");
      System.out.println();
   }
   
/*It loops through the array starting at 1 (since there's nothing to the left of 0 for it to compare to) and we check if
   the item in the index to left is greater than than the item in the current index. If this is true, it means it is not in 
   ascending order so we return false. If false isn't returned, that means it is in ascending order so at the end we return true.*/
   
   @SuppressWarnings("unchecked")
   public static boolean isAscending(Comparable[] a)
   {
      for(int x = 1; x < a.length; x++)
      {
         if(a[x-1].compareTo(a[x]) > 0)
         {
            return false;
         }
      }  
      return true;
   }
}
/////////////////////////////////////////////
// 15 Oct 07
// MergeSort Code Handout
// from Lambert & Osborne, p. 482 - 485

class MergeSort
{
   private static final int CUTOFF = 10; // for small lists, recursion isn't worth it
  
   public static void sort(double[] array)
   { 
      double[] copyBuffer = new double[array.length];
      mergeSortHelper(array, copyBuffer, 0, array.length - 1);
   }
   
   /*  array			array that is being sorted
       copyBuffer		temp space needed during the merge process
       low, high		bounds of subarray
       middle			midpoint of subarray   
   */
   private static void mergeSortHelper(double[] array, double[] copyBuffer, 
                                                      int low, int high)
   {  
      // if ( high - low  < CUTOFF )                  //switch to selection sort  when
         // SelectionLowHigh.sort(array, low, high);        //the list gets small enough 
      // else
      if (low < high)
      {
         int middle = (low + high) / 2;
         mergeSortHelper(array, copyBuffer, low, middle);
         mergeSortHelper(array, copyBuffer, middle + 1, high);
         merge(array, copyBuffer, low, middle, high);
      }
   }
   
   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low				beginning of first sorted subarray
      middle			end of first sorted subarray
      middle + 1		beginning of second sorted subarray
      high				end of second sorted subarray   
   */
   
   /*First, we instantiate the i1 variable as low (because this is where we start checking in the first subarray) and the i2 variable
   as middle+1 (because this is where we start checking in the second subarray). Then I made a variable to store the current location in
   copyBuffer where the next value should be placed. After this, I have a large while loop that runs while i1 and i2 are both not higher
   than middle and high respectively. If this is true, then we first check if array[i1] (the leftmost item of the first subarray) is less
   than or equal to array[i2] (the leftmost item of the second subarray), and if it is, then we set the current location in the copyBuffer 
   array to the array[i1], since array[i1] was less. Then we increase i1 by 1 so that we can check the next item in that subarray if there 
   is one. The same thing happens if we get to the else, but this time we set the current location in copyBuffer to array[i2] since array[i2] 
   was less. Then, we increase the place variable by 1 so that we put the next item in the correct location of copyBuffer. Once this while 
   loop finishes going through, there is a chance that not every spot that we want to fill has been filled, since i1 or i2 may have gone over 
   middle or high before the other one has gotten through its own subarray. To fix this, we have two while loops which each do the same thing. 
   While either i1 or i2 is less than its respective upper bound, we set the location in copyBuffer to this value and increment both the place 
   variable and i1/i2. After this, we just read copyBuffer back into the original array, and we're done!*/
   
   public static void merge(double[] array, double[] copyBuffer,
                                   int low, int middle, int high)
   {
      int i1 = low;
      int i2 = middle + 1;
      int place = low;
      while(i1 <= middle && i2 <= high)
      {
         if(array[i1] <= array[i2])
         {
            copyBuffer[place] = array[i1];
            i1++;
         }
         else
         {
            copyBuffer[place] = array[i2];
            i2++;
         } 
         place++;
         
      }
      
      while(i1 <= middle)
      {
         copyBuffer[place] = array[i1];
         i1++;
         place++;
      }
   
      while(i2 <= high)
      {
         copyBuffer[place] = array[i2];
         i2++;
         place++;
      }
   
      for(int x = low; x <= high; x++)
      {
         array[x] = copyBuffer[x];
      } 
   }	
      
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static void sort(Comparable[] array)
   { 
      Comparable[] copyBuffer = new Comparable[array.length];
      mergeSortHelper(array, copyBuffer, 0, array.length - 1);
   }

   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low, high		bounds of subarray
      middle			midpoint of subarray  */
   @SuppressWarnings("unchecked")
   private static void mergeSortHelper(Comparable[] array, Comparable[] copyBuffer, int low, int high)
   {
      if (low < high)
      {
         int middle = (low + high) / 2;
         mergeSortHelper(array, copyBuffer, low, middle);
         mergeSortHelper(array, copyBuffer, middle + 1, high);
         merge(array, copyBuffer, low, middle, high);
      }
   }
   
   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low				beginning of first sorted subarray
      middle			end of first sorted subarray
      middle + 1		beginning of second sorted subarray
      high				end of second sorted subarray   */
      
   /*First, we instantiate the i1 variable as low (because this is where we start checking in the first subarray) and the i2 variable
   as middle+1 (because this is where we start checking in the second subarray). Then I made a variable to store the current location in
   copyBuffer where the next value should be placed. After this, I have a large while loop that runs while i1 and i2 are both not higher
   than middle and high respectively. If this is true, then we first check if array[i1] (the leftmost item of the first subarray) is less
   than or equal to array[i2] (the leftmost item of the second subarray), and if it is, then we set the current location in the copyBuffer 
   array to the array[i1], since array[i1] was less. Then we increase i1 by 1 so that we can check the next item in that subarray if there 
   is one. The same thing happens if we get to the else, but this time we set the current location in copyBuffer to array[i2] since array[i2] 
   was less. Then, we increase the place variable by 1 so that we put the next item in the correct location of copyBuffer. Once this while 
   loop finishes going through, there is a chance that not every spot that we want to fill has been filled, since i1 or i2 may have gone over 
   middle or high before the other one has gotten through its own subarray. To fix this, we have two while loops which each do the same thing. 
   While either i1 or i2 is less than its respective upper bound, we set the location in copyBuffer to this value and increment both the place 
   variable and i1/i2. After this, we just read copyBuffer back into the original array, and we're done!*/
      
   @SuppressWarnings("unchecked")
   public static void merge(Comparable[] array, Comparable[] copyBuffer,
                                   int low, int middle, int high)
   {
      int i1 = low;
      int i2 = middle + 1;
      int place = low;
      while(i1 <= middle && i2 <= high)
      {
         if(array[i1].compareTo(array[i2]) < 0 || array[i1].compareTo(array[i2]) == 0)
         {
            copyBuffer[place] = array[i1];
            i1++;
         }
         else
         {
            copyBuffer[place] = array[i2];
            i2++;
         } 
         place++;
         
      }
      
      while(i1 <= middle)
      {
         copyBuffer[place] = array[i1];
         i1++;
         place++;
      }
   
      while(i2 <= high)
      {
         copyBuffer[place] = array[i2];
         i2++;
         place++;
      }
      
      for(int x = low; x <= high; x++)
      {
         array[x] = copyBuffer[x];
      }
   
   }    	
}

/***************************************************
This is the extension.  You will have to uncomment Lines 54-56 above.
***************************************************/

/*class SelectionLowHigh
{
   public static void sort(double[] array, int low, int high)
   {  
   
   }
   private static int findMax(double[] array, int low, int upper)
   {
      return 0;
   }
   private static void swap(double[] array, int a, int b)
   {
   
   } 
}*/

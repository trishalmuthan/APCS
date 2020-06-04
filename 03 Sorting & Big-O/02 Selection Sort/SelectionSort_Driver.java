// Name: S2-17
// Date: 10/24/19

import java.util.*;
import java.io.*;

public class SelectionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
     //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Selection.sort(array);
      print(array);
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
      System.out.println();
      
      //Part 2, for Strings
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      Selection.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }
  
   public static void print(double[] a)
   {
      for(double d: a)         //for-each
         System.out.print(d+" ");
      System.out.println();
   }
  
   public static void print(Object[] papaya)
   {
      for(Object abc : papaya)     //for-each
         System.out.print(abc+" ");
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
/////////////////////////////////////////////////////

class Selection
{

/*We loop through the array, and each time through, we find the position of the max value and use that max position to
move the value to the current max we are checking up to, using the sort method.  After this, the array will be sorted*/

   public static void sort(double[] array)
   {
      int maxPos;
      for(int x = 0; x < array.length; x++)
      {
         maxPos = findMax(array, array.length - x);
         swap(array, maxPos, array.length - x - 1);
      }
   }
   
    /*First, we create a maxPosition variable. Then, we have a for loop that goes through the array from the beginning
   to whatever the upper bound of what we are checking is. Inside this, we have an if statement that checks if the item in
   the current index of the array is greater than the greatest value of the array we have found so far. If it is, this
   becomes the new max value and we set maxPosition equal to the current index to store it's location. Then we return maxPosition.*/
   
   // upper controls where the inner loop of the Selection Sort ends
   private static int findMax(double[] array, int upper)
   {
      int maxPosition = 0;
      for(int x = 0; x < upper; x++)
      {
         if(array[x] > array[maxPosition])
         {
            maxPosition = x;
         }
      }
      return maxPosition;
   }
   
   /*We make a double temp variable that stores the value in array[a]. Then we set array[a] to array[b] and set array[b] to 
   temp which, again, stores the value that array[a] used to store*/
   
   private static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }   	
   
	/*******  for Comparables ********************/
   
   /*We loop through the array, and each time through, we find the position of the max value and use that max position to
move the value to the current max we are checking up to, using the sort method.  After this, the array will be sorted*/
   
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   {
      for(int x = 0; x < array.length; x++)
      {
         int maxPos = findMax(array, array.length - x);
         swap(array, maxPos, array.length  - x - 1);
      }
   
   }
   
   /*First, we create a maxPosition variable. Then, we have a for loop that goes through the array from the beginning
   to whatever the upper bound of what we are checking is. Inside this, we have an if statement that checks if the item in
   the current index of the array is greater than the greatest value of the array we have found so far. If it is, this
   becomes the new max value and we set maxPosition equal to the current index to store it's location. Then we return maxPosition.*/
   
   @SuppressWarnings("unchecked")
   public static int findMax(Comparable[] array, int upper)
   {
      int maxPosition = 0;
      for(int x = 0; x < upper; x++)
      {
         if(array[x].compareTo(array[maxPosition]) > 0)
         {
            maxPosition = x;
         }
      }
      return maxPosition; 
   }
   
   /*We make a double Object variable that stores the value in array[a]. Then we set array[a] to array[b] and set array[b] to 
   temp which, again, stores the value that array[a] used to store*/
   
   public static void swap(Object[] array, int a, int b)
   {
      Object temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
}


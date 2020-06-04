 //Name: S2-17  
 //Date: 10/24/19

import java.util.*;
import java.io.*;

public class InsertionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Insertion.sort(array);
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
   
      Insertion.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }
   
   public static void print(double[] a)
   {
      for(double d: a)         // for-each loop
         System.out.print(d+" ");
      System.out.println();
   }
   
   public static void print(Object[] papaya)
   {
      for(Object abc : papaya)    
         System.out.print(abc+" ");
   }
   
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
   
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
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

//**********************************************************

class Insertion
{

/*First, we have a for loop that goes through the array, starting at 1 since the item at the 0th index is already in order
Then, we store the item at the current index, and then set the location variable to a call of the shift method with the arguments
array (the array to be sorted), x (the current index), and array[x] (the value to be sorted out). This makes location the index where
the new item should go. We do this, and set that location to the temp variable we stored before, moving the value to the correct spot.*/

   public static void sort(double[] array)
   { 
      int location;
      for(int x = 1; x < array.length; x++)
      {
         double temp = array[x];
         location = shift(array, x, array[x]);
         array[location] = temp;
      }
   }
   
   /*We have a while loop that runs while index is greater than 0 and while the item to the left of the current item
   is greater than the value we want to find the location of (the index would keep getting lower while this is true
   to find the correct location. In this while loop we set the current index to the item to the left of it to shift all the
   values over. Then we reduce index by 1 to check the next index to the left. Then we just return the final location of index,
   which is found when the item to the left is less than the value who's location we are searching for.*/
 
   private static int shift(double[] array, int index, double value)
   {
      while(index > 0 && array[index-1] > value)
      {
         array[index] = array[index - 1];
         index--;
      }
      return index;
   }
   
/*First, we have a for loop that goes through the array, starting at 1 since the item at the 0th index is already in order
Then, we store the item at the current index, and then set the location variable to a call of the shift method with the arguments
array (the array to be sorted), x (the current index), and array[x] (the value to be sorted out). This makes location the index where
the new item should go. We do this, and set that location to the temp variable we stored before, moving the value to the correct spot.*/
 
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   { 
      int location;
      for(int x = 1; x < array.length; x++)
      {
         Comparable temp = array[x];
         location = shift(array, x, array[x]);
         array[location] = temp;
      }
   }
   
   /*We have a while loop that runs while index is greater than 0 and while the item to the left of the current item
   is greater than the value we want to find the location of (the index would keep getting lower while this is true
   to find the correct location. In this while loop we set the current index to the item to the left of it to shift all the
   values over. Then we reduce index by 1 to check the next index to the left. Then we just return the final location of index,
   which is found when the item to the left is less than the value who's location we are searching for.*/
   
   @SuppressWarnings("unchecked")
   private static int shift(Comparable[] array, int index, Comparable value)
   {
      while(index > 0 && array[index-1].compareTo(value) > 0)
      {
         array[index] = array[index - 1];
         index--;
      }
      return index;
   }
}

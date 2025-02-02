// Name: S2-17
// Date: 10/30/19

import java.util.*;
import java.io.*;

public class QuickSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      //Part 1 for doubles
      int n = (int)(Math.random()*50 + 10);
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random();
         	
      QuickSort.sort(array);
      print(array);
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("oops!");
         
      //Part 2 for Comparables
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      QuickSort.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }
   
   public static void print(double[] a)   
   {
      for(double number : a)    //doing something to each element
         System.out.print(number+" ");
      System.out.println();
   }
   
   public static void print(Object[] grape)
   {
      for(Object fruit : grape)     
         System.out.print(fruit +" ");
   }
      
   public static boolean isAscending(double[] a)
   {
      for(int i = 0; i < a.length - 1; i++) //we must access the index numbers
         if(a[i] > a[i+1])
            return false;
      return true;
   } 
   
   @SuppressWarnings("unchecked")
   public static boolean isAscending(Comparable[] a)
   {
      for(int k = 1; k < a.length; k++)
         if(a[k-1].compareTo(a[k]) > 0)
            return false;
      return true;
   }
}

class QuickSort
{
   public static void sort(double[] array)
   {
      sort(array, 0, array.length - 1);
   }
   private static void sort(double[] array, int first, int last)
   {
      int indexOfPivot;
      if (first < last) // General case
      {    
         indexOfPivot = rearrange(array, first, last);
         sort(array, first, indexOfPivot - 1);	// sort left side
         sort(array, indexOfPivot + 1, last);	   // sort right side
      }
   }
  
   /* choose pivot and rearrange data so that
    * array[first] ...array[splitPt - 1] <= pivot and 
    * array[splitPt + 1] ... array[last] >= pivot
    */
   private static int rearrange(double[] array, int first, int last)
   {
   
      int indexOfPivot = first;    //save the index   
      double pivot = array[first]; //save the pivot
      first++;
      while (first <= last)
      { 
         if(array[first] <= pivot)       //MY COMMENTS: We check if its in the correct place to the left of pivot
            first++;      //MY COMMENTS: We increase first so that we can check the next value to the left of pivot    
         else if(array[last] >= pivot)  //MY COMMENTS: We check if its in the correct place to the right of pivot
            last--;      //MY COMMENTS: We increase last so that we can check the next value to the right of povot
         else                                           //if both on the wrong side,  
         {  
            swap(array, first, last); //MY COMMENTS: We swap them in the array if they are in the wrong spot to the left or right of pivot in the array
                   //   then swap them,
                   //   update both right and left
         }
      }
      swap(array, last, indexOfPivot); 	// swap pivot with element at indexOfPivot
      indexOfPivot = last;			         // set indexOfPivot to place where the halves meet
      return indexOfPivot;
   }

   private static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   {
      sort(array, 0, array.length - 1);
   }
   
   @SuppressWarnings("unchecked")
   private static void sort(Comparable[] array, int first, int last)
   {
      int indexOfPivot;
      if (first < last) // General case
      {    
         indexOfPivot = rearrange(array, first, last);
         sort(array, first, indexOfPivot - 1);	// sort left side
         sort(array, indexOfPivot + 1, last);	   // sort right side
      }
   }

   @SuppressWarnings("unchecked")
   private static int rearrange(Comparable[] array, int first, int last)
   {
      int indexOfPivot = first;    //save the index   
      Comparable pivot = array[first]; //save the pivot
      first++;
      while (first <= last)  
      { 
         if(array[first].compareTo(pivot) <= 0)       //MY COMMENTS: We check if its in the correct place to the left of pivot 
            first++;      //MY COMMENTS: We increase first so that we can check the next value to the left of pivot      
         else if(array[last].compareTo(pivot) >= 0) ////MY COMMENTS: We check if its in the correct place to the right of pivot   
            last--;      ////MY COMMENTS: We increase last so that we can check the next value to the right of pivot
         else                                           //if both on the wrong side,  
         {  
            swap(array, first, last); //MY COMMENTS: We swap them in the array if they are in the wrong spot to the left or right of pivot in the array
                   //   then swap them,
                   //   update both right and left
         }
      }
      swap(array, last, indexOfPivot); 	// swap pivot with element at indexOfPivot
      indexOfPivot = last;			         // set indexOfPivot to place where the halves meet
      return indexOfPivot;
   }

   @SuppressWarnings("unchecked")
   private static void swap(Comparable[] array, int a, int b)
   {
      Comparable temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
}


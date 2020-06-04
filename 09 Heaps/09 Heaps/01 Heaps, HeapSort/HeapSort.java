// Name: S2-17
// Date: 3/25/20

import java.text.DecimalFormat;
public class HeapSort
{
   public static int SIZE;  //9 or 100
	
   public static void main(String[] args)
   {
      //Part 1: Given a heap, sort it. Do this part first. 
      // SIZE = 9;  
      // double heap[] = {-1,99,80,85,17,30,84,2,16,1};
   //    
      // display(heap);
      // sort(heap);
      // display(heap);
      // System.out.println(isSorted(heap));
      
      //Part 2:  Generate 100 random numbers, make a heap, sort it.
      SIZE = 100;
      double[] heap = new double[SIZE + 1];
      heap = createRandom(heap);
      display(heap);
      makeHeap(heap, SIZE);
      display(heap); 
      sort(heap);
      display(heap);
      System.out.println(isSorted(heap));
   }
   
	//******* Part 1 ******************************************
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(array[k] + "    ");
      System.out.println("\n");	
   }
   
   public static void sort(double[] array)
   {
      /* enter your code here */
      /*We create a variable and set it to the length of the array. We use a for loop starting at 1 until the end of the array. 
      In this loop, we swap the first index with max-1, the current last "index". We then decrease max by 1. Then we call heapDown
      on the first index of the array and max-1 as the size because the size of the array within which the heap is made of has been 
      restricted.*/
      int max = array.length;
      for(int x = 1; x < array.length; x++)
      {
         swap(array, 1, max-1);
         max--;
         heapDown(array, 1, max-1);
      }
     
      if(array[1] > array[2])   //just an extra swap, if needed.
         swap(array, 1, 2);
   }
  
  /*We store the value at a in a temp variable, set a to the value at b and set b to the temp variable.*/
   public static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   
   /*We have two cases, one if there are two children and the other if there is one left child. We don't need a case for no children because
   we wouldn't do anything in that case. The first case checks if k*2+1 (the location of the right child) is less than or equal to size. If it
   is, then there are 2 children, so we check which, if any, of the children is greater and call swap, then call heapDown recursively on that
   item. The next case checks if k*2 is less than or equal to size. If it is, then there is only a left child so we check to make sure its
   greater than the current element and call swap on it. We don't need to call heapDown since there isn't anything below it because the tree
   is complete.*/
   public static void heapDown(double[] array, int k, int size)
   {
      if(k*2+1 <= size)
      {
         if(array[k*2] >= array[k*2+1] && array[k] < array[k*2])
         {
            swap(array, k, k*2);
            heapDown(array, k*2, size);
         }
         else if(array[k*2+1] > array[k*2] && array[k] < array[k*2+1])
         {
            swap(array, k, k*2+1);
            heapDown(array, k*2+1, size);
         }
      }
      else if(k*2 <= size)
      {
         if(array[k] < array[k*2])
         {
            swap(array, k, k*2);
         }
      }
   }
   
   /*We loop through the array starting from 1 and until 1 less than the array length(so we don't go out of bounds) and in this
   loop we check whether array[x] is greater than the next element in the array. If it is, then we return false because it wouldn't
   be in order. At the end we return true, because it would be sorted.*/
   public static boolean isSorted(double[] arr)
   {
      for(int x = 1; x < arr.length-1; x++)
      {
         if(arr[x] > arr[x+1])
         {
            return false;
         }
      }
      return true;
   }
   
   //****** Part 2 *******************************************

   //Generate 100 random numbers (between 1 and 100, formatted to 2 decimal places) 
   /*We create a DecimalFormat object so we can make sure the final answer is to two decimal places. 
   We use a for loop to until the array length, and for each one, we set array[x] to a correctly formatted
   double which is calculated by Math.random * 99 + 1 which gives us value between 1 and 100.*/
   public static double[] createRandom(double[] array)
   {  
      array[0] = -1;   //because it will become a heap
      DecimalFormat twoDec = new DecimalFormat("0.00");
      for(int x = 1; x < array.length; x++)
      {
         array[x] = Double.parseDouble(twoDec.format((Math.random()*99 + 1)));
      }
      return array;
   }
   
   //turn the random array into a heap
   /*We start from the middle of the array and go down, calling heapDown on each element as we go.*/
   public static void makeHeap(double[] array, int size)
   {
      for(int x = size/2; x >= 1; x--)
      {
         heapDown(array, x, size);
      }
   }
}


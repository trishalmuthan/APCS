// Name: S2-17
// Date: 09/28/19 
  
import java.util.*;
public class Fibonacci
{
   public static void main(String[] args)
   {
      long start, end, fib; //why long?
      int[] fibNumber = {1, 5, 10, 20, 30, 40, 41, 42};
      System.out.println("\tFibonacci\tBy Iteration\tTime\tby Recursion\t Time");
      for(int n = fibNumber[0]; n <= fibNumber[fibNumber.length - 1]; n++)
      { 
         start = System.nanoTime();
         fib = fibIterate(n);
         end = System.nanoTime();
         System.out.print("\t\t" + n + "\t\t" + fib + "\t" + (end-start)/1000.);
         start = System.nanoTime();   	
         fib = fibRecur(n); 
         end = System.nanoTime();
         System.out.println("\t" + fib + "\t\t" + (end-start)/1000.);
      }
   }
   
   /**
    * Calculates the nth Fibonacci number by interation
    * @param n A variable of type int representing which Fibonacci number
    *          to retrieve
    * @returns A long data type representing the Fibonacci number
    */
    
    /* First, we check if the value is equal to 0, in which case we would just return 0.
    Then, we instantiate 2 variables, where first equals 0 and second equals 1 because 0 + 1 = the first fibonacci number.
    We also make the current variable which will be used to hold the current fibonacci number.
    Then we have a for loop which starts at 2 because we have already checked for 1 as current has already been set to 1.
    Then, inside we set current equal to the 2 numbers before it, and shift everything forward one fibonacci number.
    We set first equal to second to move it forward a number and second equal to current as we will use to in the formation
    of the next fibonacci number, the next loop through. Then, once all this goes through up until the input n, we return current.
    */
    
   public static long fibIterate(int n)
   {
      if(n == 0)
      {
         return 0;
      }
      int first = 0;
      int second = 1;
      int current = 1;
      for(int i = 2; i <= n; i++) 
      {
         current = first + second;
         first = second;
         second = current;
      }
      return current; 
   }
   

   /**
    * Calculates the nth Fibonacci number by recursion
    * @param n A variable of type int representing which Fibonacci number
    *          to retrieve
    * @returns A long data type representing the Fibonacci number
    */
    
    /*We first check for 0, which will return 0 if found, and 1, which is the base case and will return 1.
    We then return the sum of the 2 fibonacci numbers before it, which are found by using a recursive method.
    We use fibRecur to find the value which keeps happening until we hit the end (the base case) and 1 is returned.
    After this, it feeds all the values back up to the original call and returns the requested fibonacci number.*/
    
   public static long fibRecur(int n)
   {
      if(n == 0 || n == 1)
      {
         return n;
      }
      return fibRecur(n-1) + fibRecur(n-2);
   }
}


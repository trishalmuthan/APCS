// Name: S2-17
// Date: 09/30/19
    
import java.util.*;
  
public class Hailstone
{
   public static void main(String[] args)
   {
      System.out.println("Hailstone Numbers!");
      System.out.print("Enter the start value: ");
      Scanner sc = new Scanner(System.in);
      int start = sc.nextInt();
      int count = hailstone(start, 1);
      System.out.println(" With count variable, it takes " + count + " steps." );
      int count2 = hailstone(start);
      System.out.println(" Without count variable, it takes " + count2 + " steps." );
   }
      
   /**
    * Prints the hailstone sequence that starts with n.
    * Pre-condition: n > 0, count = 1.
    * This method is recursive.
    * If n is even, then the next number is n / 2.
    * If n is odd, then the next number is 3 * n + 1.
    * @param n The beginning hailstone number.
    * @param count The helper variable that counts the steps.
    * @returns An int representing the number of steps from n to 1.
    */
    
    /*First, we check the base case, which is if n equals 1. If it does, then we print out 1 without a dash since its the final number and we also 
    return count because its the end. Then, if the base case isn't satisfied, we check if it is even and if it is, we printout n with a dash after 
    and increase count by 1, because there is another number. Then, we call the hailstone method again with n/2 and the same new count. 
    The same thing happens if it is odd except that here, the thing we do to n is different. Here we multiply by 3 and add one. Then, we return the count.*/
    
   public static int hailstone(int n, int count)
   {
      if(n == 1)
      {
         System.out.print("1");
         return count;
      }
      if(n % 2 == 0)
      {
         System.out.print(n + "-");
         count++;
         return hailstone(n/2, count);
      }   
      else if(n % 2 != 0)
      {
         System.out.print(n + "-");
         count++;
         return hailstone(3 * n + 1, count);
      }
      
      
      return count;
      
   }
  
   /**
    * Prints the hailstone sequence that starts with n.
    * This method does not use a variable to count the steps.
    * Pre-condition: n > 0.
    * This method is recursive.
    * If n is even, then the next number is n / 2.
    * If n is odd, then the next number is 3 * n + 1.
    * @param n The beginning hailstone number.
    * @returns An int representing the number of steps from n to 1.
    */
    
    /*First, we check the base case, which is if n equals 1. If it does, then we print out 1 without a dash since its the final number, and then returns 1
    because we don't have the count variable. Then, if the base case isn't satisfied, we check if it is even and if it is, we printout n with a dash after 
    and instead of increasing count by 1, we just do 1 + the method call. This allows for the count to add up as the recursions take place. 
    The same thing happens if it is odd except that here, the thing we do to n is different. Here we multiply by 3 and add one. Then, we return 1 because we have
    reached the end.*/
    
   public static int hailstone(int n)
   {
      if(n == 1)
      {
         System.out.print("1");
         return 1;
      }
      if(n % 2 == 0)
      {
         System.out.print(n + "-");
         return 1 + hailstone(n/2);
      }   
      else if(n % 2 != 0)
      {
         System.out.print(n + "-");
         return 1 + hailstone(3 * n + 1);
      }
      
      
      return 1;
   
   
   }
}

/*
------------SAMPLE RUN----------------------

Hailstone Numbers!
Enter the start value: 12
12-6-3-10-5-16-8-4-2-1 With count variable, it takes 10 steps.
12-6-3-10-5-16-8-4-2-1 Without count variable, it takes 10 steps.

Hailstone Numbers!
Enter the start value: 100
100-50-25-76-38-19-58-29-88-44-22-11-34-17-52-26-13-40-20-10-5-16-8-4-2-1 With count variable, it takes 26 steps.
100-50-25-76-38-19-58-29-88-44-22-11-34-17-52-26-13-40-20-10-5-16-8-4-2-1 Without count variable, it takes 26 steps.

*/

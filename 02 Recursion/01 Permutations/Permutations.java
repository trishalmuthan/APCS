// Name: S2-17
// Date: 09/24/19
  
import java.util.*;
public class Permutations
{
   public static int count = 0;
    
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("\nHow many digits? ");
      int n = sc.nextInt();
      leftRight("", n);          
      oddDigits("", n);
      superprime(n);
      if(count==0)
         System.out.println("no superprimes");
      else
         System.out.println("Count is "+count);
   }
   
    /**
     * Builds all the permutations of a string of length n containing Ls and Rs
     * @param s A string 
     * @param n An postive int representing the length of the string
     */
     
   //The base case is that if the string is the length that they provided, then it will print the full letter permutation and leave the method
   //If the base case is not fulfilled, the leftRight method is called again, but another letter is added, either R or L. This develops into an entire
   //branch of leftRight methods that start with R and some that start with L, and eventually, as all the process fall through, all the permutations are printed.
   public static void leftRight(String s, int n)
   {
      if(s.length() == n)
      {
         System.out.println(s);
         return;
      }
      leftRight(s + "R", n);
      leftRight(s + "L", n);
   }
   
    /**
     * Builds all the permutations of a string of length n containing odd digits
     * @param s A string 
     * @param n A postive int representing the length of the string
     */
     
     //The same basic concept as leftRight
     //The base case is that if the string is the length that they provided, then it will print the full length number permutation and leave the method.
     //If the base case is not fulfilled, the oddDigits method is called again, but another number is added, either 1, 3, 5, 7, 9. This develops into an entire
     //branch of oddDigits methods that start with 1 and some that start with 3, and some that start with 5, and so on. Eventually, as all the process fall through, 
     //all the permutations are printed.

   public static void oddDigits(String s, int n)
   {
      if(s.length() == n)
      {
         System.out.println(s);
         return;
      }
      oddDigits(s + "1", n);
      oddDigits(s + "3", n);
      oddDigits(s + "5", n);
      oddDigits(s + "7", n);
      oddDigits(s + "9", n);
   }
      
    /**
     * Builds all combinations of a n-digit number whose value is a superprime
     * @param n A positive int representing the desired length of superprimes  
     */
     
     //Calls recur with 2, 3, 5, and 7 which are all the single digit prime numbers
     //This means that superprime numbers must start with one of these
     //There is also the extension at superprime which will see if count == 0 and will print the message if it is
   public static void superprime(int n)
   {
      recur(2, n); //try leading 2, 3, 5, 7, i.e. all the single-digit primes 
      recur(3, n); 
      recur(5, n);
      recur(7, n);
      if(count == 0)
      {
         System.out.println("There are no " + n + "-digit superprimes!");
      }
   }

    /**
     * Recursive helper method for superprime
     * @param k The possible superprime
     * @param n A positive int representing the desired length of superprimes
     */
     
     //it will first check the value if it is prime because that would automatically mean it isn't superprime.
     //if the length of it is 1, it means that it is prime (the value must be one of the prime single digit values),
     //and we print out the value (it is a superprime). We then, again, check if it is prime, and if it currently is, then we use recursion
     //and call the recur method 5 times. The way we use the method is similar to the way we use it in odd digits. The arguments
     //are the number * 10 plus an odd number (since even numbers can't be prime) and n-1 since we want to check the number with
     //the current units place shifted. We also have a count variable that gets added to whenever we find a superprime (extension).
   private static void recur(int k, int n)
   {
   
      if(!isPrime(k))
      {
         return;
      }
      if(n == 1)
      {
         count++;
         System.out.println(k);
         return;       
      }
      if(isPrime(k))
      {
         recur((k*10) + 1, n-1);
         recur((k*10) + 3, n-1);
         recur((k*10) + 5, n-1);
         recur((k*10) + 7, n-1);
         recur((k*10) + 9, n-1);   
      }   
   }

    /**
     * Determines if the parameter is a prime number.
     * @param n An int.
     * @return true if prime, false otherwise.
     */
     
     //Loops from 2 (first positive prime number) until the number that is inputted
     //Checks if the number is divisible by every value from 2 up to the number.
     //If it is then return false because it wouldn't be prime
   public static boolean isPrime(int n)
   {
      for(int i = 2; i < n; i ++)
      {
         if(n % i == 0)
         {
            return false;
         }
      }
      return true;
   }
}

// Name: S2-17
// Date: 10/22/19
import java.io.*;      //imports File 
import java.util.*;    //imports Scanner 

public class Searches_Driver
{
   private static int amount = 1325;
   
   public static void main(String[] args) throws Exception
   {
      String[] apple = input("declaration.txt");
      Arrays.sort(apple);  
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("Enter a word: ");
         String target = sc.next();   //Liberty  
         if(target.equals("-1") )
            break;
         Searches.reset();
         int found = Searches.linear(apple, target);
         if(found == -1)
            System.out.println(target + " was not found by the linear search.");
         else
            System.out.println("Linear Search found it at location "+found+" in " + Searches.getLinearCount()+" comparisons.");
         int found2 = Searches.binary(apple, target);
         if(found2 == -1)
            System.out.println(target + " was not found by the binary search.");
         else
            System.out.println("Binary Search found it at location "+found2+" in " + Searches.getBinaryCount()+" comparisons.");
      }
   }
   
   public static String[] input(String filename) throws Exception
   {
      Scanner infile = new Scanner( new File(filename) );
      String[] array = new String[amount];
      for (int k =0; k<amount; k++)    
         array[k] = infile.next();
      infile.close();
      return array;
   }
}

/////////////////////////////////////////////////////////
class Searches
{
   private static int linearCount = 0;
   private static int binaryCount = 0;      
   
   public static int getLinearCount()
   {
      return linearCount;
   }
   
   public static int getBinaryCount()
   {
      return binaryCount;
   }
   
   public static void reset()
   {
      linearCount = 0;
      binaryCount = 0;
   }
   
   /*We loop through the comparable array, increasing count by 1 every time we go through.
   We check if target.compareTo(array[x]) == 0 which would mean the 2 are equal to each other.
   If they are equal, then we return x, the index. If the loop finishes, it means that the word is
   not contained in the array, and that the word doesn't exist, so we return -1.*/
   
   @SuppressWarnings("unchecked")//removes the warning for Comparable
   public static int linear(Comparable[] array, Comparable target)
   { 
      for(int x = 0; x < array.length; x++)
      {
         linearCount++;
         if(target.compareTo(array[x]) == 0)
         { 
            return x;
         }
      }
      return -1;
   }
   
   /*This method just calls the binaryhelper method with the arguments array and target, which remain the same,
   as well as 0, the beginning, and array.length -1, the end. It sets a variable equal whatever the method returns
   and returns this variable*/
   
   @SuppressWarnings("unchecked")
   public static int binary(Comparable[] array, Comparable target)
   {
      int found = binaryhelper(array, target, 0, array.length - 1);
      return found;
   }
   
   /*The base case is that if start > end we return -1. The search would have passed the half way point which
   means the word wasn't found. Then, we increase the count by 1 because next is a new comparison. 
   We set a variable finallength to (start+end)/2 which is the halfway point. We then check if 
   target.compareTo(array[finallength]) == 0 which would mean they are equal. We would then return finallength,
   the index of the word. If this doesn't go through, we check if target.compareTo(array[finallength]) is greater than
   or less than 0. If it's greater than, it means that the word is after the halfway point so we recursively call and return the
   binaryhelper method with the same array and target but checking from the finallength - 1 (halfway point) to the end.*/
   
   @SuppressWarnings("unchecked")
   private static int binaryhelper(Comparable[] array, Comparable target, int start, int end)
   {
      if(start > end)
      {
         return -1;
      } 
      binaryCount++;
      int finallength = (start+end)/2;
      if(target.compareTo(array[finallength]) == 0)
      {
         return finallength;
      }
      
      if(target.compareTo(array[finallength]) < 0)
      {  
         return binaryhelper(array, target, start, finallength-1);
      }
      else
      {
         return binaryhelper(array, target, finallength+1, end);
      }
   }
}
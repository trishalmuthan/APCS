 // Name: S2-17
 // Date: 12/12/19
 // use for-each loops or iterators, not regular for-loops
import java.io.*;
import java.util.*;
public class IteratorLab
{
   public static void main(String[] args)
   {
      System.out.println("Iterator Lab\n");
      int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
      for(int n : rawNumbers )
         System.out.print(n + " ");    
      ArrayList<Integer> numbers = createNumbers(rawNumbers);
      System.out.println("\nArrayList: "+ numbers);      //Implicit Iterator!
      System.out.println("Count negative numbers: " + countNeg(numbers));
      System.out.println("Average: " + average(numbers));
      System.out.println("Replace negative numbers: " + replaceNeg(numbers));
      System.out.println("Delete zeros: " + deleteZero(numbers));
      String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
      ArrayList<String> movies = createMovies(rawMovies);
      System.out.println("Movies: " + movies);
      System.out.println("Movies: " +  removeDupes(movies));
   }
      // pre: an array of just int values 
   	// post: return an ArrayList containing all the values
      
    /*First, we create a new ArrayList that stores integers. Then, we use a for each loop to go through the array
    and add (using the add method) each int in that array to the ArrayList we just created. Then, we return the ArrayList, which 
    now stores all the ints that were in the array.*/
   public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
   {
      ArrayList<Integer> toReturn = new ArrayList<Integer>();
      for(int x: rawNumbers)
      {
         toReturn.add(x);
      }
      return toReturn;
   }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
   public static ArrayList<String> createMovies(String[] rawWords) 
   {
      ArrayList<String> myList = new ArrayList<String>();
      for ( String str : rawWords )
         myList.add( str );
      return myList;
   }
   
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
      
   /*First, we create a count variable. Then, we use a for each loop to loop through the ArrayList given and for each int,
   we check if it is less than 0, and if it is, we increase count by 1. Then, we return count.*/
   public static int countNeg(ArrayList<Integer> a)
   {
      int count = 0;
      for(int x: a)
      {
         if(x < 0)
         {
            count++;
         }
      }
      return count; 
   }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
      
      /*First, we create a count and totalInts variable. Then, we use a for each loop to loop through the ArrayList given and for each int,
      we increase totalInts by 1, and we increase count by the value of that int. Then, we return count/totalInts which is the all the numbers
      added up and divide by the number of values in the ArrayList, which is the average.*/
   public static double average(ArrayList<Integer> a)
   {
      int count = 0;
      int totalInts = 0;
      for(int x: a)
      {
         totalInts++;
         count+=x;
      }
      return count/totalInts;      
        
   }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values with 0 
      
      /*We create a ListIterator object for the ArrayList given as an argument. Then, we use a while to go through
      the ArrayList (by using iterator.hasNext()) and, if the value is less than 0 which we check by using the next method, 
      then we set that value to 0 using the set method. We do this for every value in the ArrayList. Then we just return a.*/
   public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
   {
      ListIterator<Integer> iterator = a.listIterator();
      while(iterator.hasNext())
      {
         if(iterator.next() < 0)
         {
            iterator.set(0);
         }
      }
      return a;  
   }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
      
       /*We create a ListIterator object for the ArrayList given as an argument. Then, we use a while to go through
      the ArrayList (by using iterator.hasNext()) and, if the value is equal to 0 which we check by using the next method, 
      then we remove that value using the remove method. We do this for every value in the ArrayList. Then we just return a.*/
   public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
   {
      ListIterator<Integer> iterator = a.listIterator();
      while(iterator.hasNext())
      {
         if(iterator.next() == 0)
         {
            iterator.remove();
         }
      }
      return a;
   }
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return ArrayList without duplicate movie titles
		// strategy: start with an empty array and add movies as needed
      
      /*First, we create a new ArrayList that stores Strings. Then, we use a for each loop to go through the ArrayList given in the argument
      In this for loop, we check if the new ArrayList we created doesn't already contain that string. If it does contain it, then that means it
      is a duplicate and we don't add it, but if it isn't contained, then we can add it since it isn't a duplicate currently. After we are done
      with the for each loop, toReturn will contain a single copy of each movie in the ArrayList given in the argument so we just return it.*/
   public static ArrayList<String> removeDupes(ArrayList<String> a)
   {
      ArrayList<String> toReturn = new ArrayList<String>();
      for(String s : a)
      {
         if(!toReturn.contains(s))
         {
            toReturn.add(s);
         }
      } 
      return toReturn;     
   }
   
}


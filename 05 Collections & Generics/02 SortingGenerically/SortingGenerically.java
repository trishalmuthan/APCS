// Name:   S2-17 
// Date:   12/05/19
 
import java.io.*;      //the File class
import java.util.*;    //ArrayList & the Scanner class in Java 1.5
 
public class SortingGenerically
{
   public static void main(String[] args) throws Exception
   {
      //Widgets
      List<Comparable> apple = inputWidgets("widgets.txt");
      sort(apple);
      output(apple);
      System.out.println("There are " + apple.size() +" widgets, sorted.");
 
      //Strings
      List<Comparable> strList = inputStrings("strings.txt");
      sort(strList);
      output(strList);
      System.out.println("There are " + strList.size() +" strings, alphabetized.");
   }
 
   /*First, we create a new Scanner object called infile that will read through the file. Then we create a new ArrayList of the Comparable type.
   Then we go through the file, and we use every 2 numbers to form a Widget and we add that widget to the ArrayList object we created. We do
   this until the end of the file. Then we close infile and return the ArrayList we created.*/
   public static List<Comparable> inputWidgets(String filename) throws Exception
   {
 
      Scanner infile = new Scanner(new File(filename));
      ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
      while(infile.hasNext())
      {
         int store1 = infile.nextInt();
         int store2 = infile.nextInt();
         arrayList.add(new Widget(store1, store2));
      }
      infile.close();
      return arrayList;
   }
 
   /*First, we create a new Scanner object called infile that will read through the file. Then we create a new ArrayList of the Comparable type.
   Then we go through the file, and add every string in the file to the ArrayList object we created. We do this until the end of the file. Then we 
   close infile and return the ArrayList we created.*/
   public static List<Comparable> inputStrings(String filename) throws Exception
   {
      Scanner infile = new Scanner(new File(filename));
      ArrayList<Comparable> arrayList = new ArrayList<Comparable>();
      while(infile.hasNext())
      {
         arrayList.add(infile.next());
      }
      infile.close();
      return arrayList;
   }
 
   /*  these methods are all GENERIC   */
   /*We loop through the indices of the array which actually have values, and each time through, we find the position of the max value 
   and use that max position to move the value to the current max we are checking up to, using the sort method.  After this, the array 
   will be sorted*/
   public static <T extends Comparable<T>> void sort(List<T> array)
   {
      int maxPos;
      for(int x = 0; x < array.size(); x++)
      {
         maxPos = findMax(array, array.size() - x);
         swap(array, maxPos, array.size() - x - 1);
      }
   } 
 
   /*First, we create a maxPosition variable. Then, we have a for loop that goes through the array from the beginning
   to whatever the upper bound of what we are checking is. Inside this, we have an if statement that checks if the item in
   the current index of the array is greater than the greatest value of the array we have found so far. If it is, this
   becomes the new max value and we set maxPosition equal to the current index to store it's location. Then we return maxPosition.*/
   public static <T extends Comparable<T>> int findMax(List<T> array, int upper)
   {
      int maxPosition = 0;
      for(int x = 0; x < upper; x++)
      {
         if(array.get(x).compareTo(array.get(maxPosition)) > 0)
         {
            maxPosition = x;
         }
      }
      return maxPosition; 
 
   }
 
   /*We make a T variable that stores the value in array[a]. Then we set array[a] to array[b] and set array[b] to 
   temp which, again, stores the value that array[a] used to store*/
   public static <T> void swap(List<T> array, int a, int b)
   {  
      T temp = array.get(a);
      array.set(a, array.get(b));
      array.set(b, temp);
   }
 
   /*We loop through the indices of the Collection and print each one out*/
   public static <T> void output(Collection<T> array)
   {
      /*for(int x = 0; x < array.size(); x++)
      {
         System.out.println(array.get(x));
      }*/
 
      for(T temp : array)
      {
         System.out.println(temp);
      }
   }
}
 
/*************************************
 0 cubits 14 hands
 1 cubits 3 hands
 2 cubits 14 hands
 5 cubits 14 hands
 10 cubits 14 hands
 11 cubits 11 hands
 12 cubits 0 hands
 12 cubits 7 hands
 13 cubits 9 hands
 15 cubits 12 hands
 17 cubits 5 hands
 18 cubits 13 hands
 19 cubits 13 hands
 19 cubits 13 hands
 22 cubits 6 hands
 23 cubits 7 hands
 24 cubits 15 hands
 24 cubits 15 hands
 26 cubits 2 hands
 28 cubits 5 hands
 28 cubits 12 hands
 29 cubits 15 hands
 31 cubits 0 hands
 32 cubits 1 hands
 32 cubits 11 hands
 32 cubits 11 hands
 32 cubits 12 hands
 35 cubits 3 hands
 39 cubits 2 hands
 39 cubits 5 hands
 41 cubits 10 hands
 43 cubits 2 hands
 43 cubits 5 hands
 43 cubits 6 hands
 51 cubits 2 hands
 54 cubits 14 hands
 55 cubits 8 hands
 56 cubits 3 hands
 57 cubits 12 hands
 62 cubits 15 hands
 63 cubits 0 hands
 64 cubits 13 hands
 67 cubits 3 hands
 70 cubits 0 hands
 73 cubits 5 hands
 74 cubits 7 hands
 75 cubits 9 hands
 81 cubits 5 hands
 85 cubits 14 hands
 86 cubits 3 hands
 90 cubits 13 hands
 91 cubits 3 hands
 92 cubits 1 hands
 92 cubits 8 hands
 96 cubits 1 hands
 98 cubits 8 hands
 99 cubits 5 hands
 There are 57 widgets, sorted.
 APCS
 Encapsulation
 Exam
 Generics
 Inheritance
 Java
 Method
 OOP
 Object
 Oriented
 Polymorphism
 Programming
 There are 12 strings, alphabetized.   ****************************************/
// Name: S2-17
// Date: 9/17/19
import java.util.Scanner;
import java.io.File;
import java.text.DecimalFormat;
import java.io.*;
//here any additional imports that you may need

public class Cemetery
{
   public static void main (String [] args)
   {
      File file = new File("cemetery.txt");
      int numEntries = countEntries(file);
      Person[] cemetery = readIntoArray(file, numEntries); 
      int min = locateMinAgePerson(cemetery);
      int max = locateMaxAgePerson(cemetery); 
      
      //EXTENSION
      int numYouth = youthAmount(cemetery);
      
      //for testing only
      for (int i = 0; i < cemetery.length; i++) 
         System.out.println(cemetery[i]);
      System.out.println("In the St. Mary Magdelene Old Fish Cemetery --> ");
      System.out.println("Name of youngest person: " + cemetery[min].getName());
      System.out.println("Age of youngest person: " + cemetery[min].getAge());    
      System.out.println("Name of oldest person: " + cemetery[max].getName());
      System.out.println("Age of oldest person: " + cemetery[max].getAge()); 
      
      //EXTENSION
      System.out.println("Number of people who died that weren't adults: " + numYouth); 
      //you may create other testing cases here
      //comment them out when you submt your file to gradeit    
   }
   
   /* Counts and returns the number of entries in File f. 
      Returns 0 if the File f is not valid.
      Uses a try-catch block.   
      @param f -- the file object
   */
   
   /*First we instantiate a Scanner object and set it equal to null. Then, in the try catch, we try
   and set it equal to a new Scanner with a File f. If this throws an exception, we catch it and return 0
   Then, we instantiate a count variable and keep adding 1 to that variable while there is a next line in the file
   After this, we return count, which has the number of lines.*/
   
   public static int countEntries(File f)
   {
      Scanner infile = null;;
      try
      {
         infile = new Scanner(f);
      }
      catch(Exception e)
      {
         return 0;
      }
      int count = 0;
      while(infile.hasNextLine())
      {
         count++;
         infile.nextLine();
      }
      return count;
   }

   /* Reads the data from file f (you may assume each line has same allignment).
      Fills the array with Person objects. If File f is not valid return an empty array.
      Uses a try-catch block.   
      @param f -- the file object 
      @param num -- the number of lines in the File f  
   */
   
   /*First we instantiate a Scanner object and set it equal to null. We also create a Person array, 
   the size of number. Then, in the try catch, we try and set it equal to a new Scanner with a File f. 
   If this throws an exception, we catch it and return an empty array. Then, we loop through the length 
   of the array, and set each index equal to the Person object outputted by the method MakeObjects, which 
   uses each line. Then, we return the array.*/

   public static Person[] readIntoArray (File f, int num)
   {
      Scanner infile;
      Person[] array = new Person[num];
      try
      {
         infile = new Scanner(f);
      }
      catch(Exception e)
      {
         return array;
      }
      for(int x = 0; x < array.length; x++)
      {
         array[x] = makeObjects(infile.nextLine());
      }
      return array;
   }
   
   /* A helper method that instantiates one Person object.
      @param entry -- one line of the input file.
      This method is made public for gradeit testing purposes.
      This method should not be used in any other class!!!
   */
   
   /*We create a bunch of substrings that contain each of the different items in 
   one entry in the list. Then, we create a new Person object with the same 3 items 
   in the entry. Then we return this object. */
   
   public static Person makeObjects(String entry)
   {
      String storeName = entry.substring(0, 25);
      String storeDate = entry.substring(25, 37);
      String storeAge = entry.substring(37, 42);
      Person person = new Person(storeName, storeDate, storeAge);
      return person;
   
   }  
   
   /* Finds and returns the location (the index) of the Person
      who is the youngest. (if the array is empty it returns -1)
      If there is a tie the lowest index is returned.
      @param arr -- an array of Person objects.
   */
   
   /*First, we check if the length of the array is 0 and if it is, then we just return -1. If we
   continue, then we make variables that store the current min age and the current min index. We go through
   the array and we check if the object at that index has an age lower than the current min age. If it is,
   then we set currentAge to the object's age, and set currentIndex to the index of the object (x). Then we return
   the index of the object with the min age.*/
   public static int locateMinAgePerson(Person[] arr)
   {
      if(arr.length == 0)
      {
         return -1;
      }
      double currentAge = arr[0].getAge();
      int currentIndex = 0;
      for(int x = 0; x < arr.length; x++)
      {
         if(arr[x].getAge() < currentAge)
         {
            currentAge = arr[x].getAge();
            currentIndex = x;
         }
      }
      return currentIndex;
      
   }   
   
   /* Finds and returns the location (the index) of the Person
      who is the oldest. (if the array is empty it returns -1)
      If there is a tie the lowest index is returned.
      @param arr -- an array of Person objects.
   */
   
   /*First, we check if the length of the array is 0 and if it is, then we just return -1. If we
   continue, then we make variables that store the current max age and the current max index. We go through
   the array and we check if the object at that index has an age greater than the current min age. If it is,
   then we set currentAge to the object's age, and set currentIndex to the index of the object (x). Then we return
   the index of the object with the max age.*/

   public static int locateMaxAgePerson(Person[] arr)
   {
      if(arr.length == 0)
      {
         return -1;
      }
      double currentAge = arr[0].getAge();
      int currentIndex = 0;
      for(int x = 0; x < arr.length; x++)
      {
         if(arr[x].getAge() > currentAge)
         {
            currentAge = arr[x].getAge();
            currentIndex = x;
         }
      }
      return currentIndex;
   }
   
   /*EXTENSION: This code will return the amount of people in the cemetery that had unfortunately died 
   while still a child (under the age of 18). It takes in an array. First, it will create a variable
   and set it equal to 0. It will loop through the array and check if the age of the object at that specific index
   is less than 18.0. If it is, then we will add 1 to count. Lastly, we will return count.*/
   
   public static int youthAmount(Person[] arr)
   {
      int count = 0;
      for(int x = 0; x < arr.length; x++)
      {
         if(arr[x].getAge() < 18.0)
            count++;
      }
      return count;
   }        
} 

class Person
{
   //constant that can be used for formatting purpose
   private static final DecimalFormat df = new DecimalFormat("0.0000");
   /* private fields */
   
   private String myName;
   private String myBirth;
   private double myAge;
      
   /* a three-arg constructor  
    @param name, birthdate may have leading or trailing spaces
    It creates a valid Person object in which each field has the leading and trailing
    spaces eliminated*/
    
    /*We first trim all 3 fields to get rid of any blank space at the beginning or the end, and then
    set them to their respective field (except age, where we first calculate the age and get the correctly
    formatted age)*/
   Person(String name, String birthdate, String age)
   {
      myName = name.trim();
      myBirth = birthdate.trim();
      age = age.trim();
      myAge = calculateAge(age);
   }
   /* any necessary accessor methods (at least "double getAge()" and "String getName()" )
   make sure your get and/or set methods use the same datat type as the field  */
   
  //All the get and set methods
   public String getName()
   {
      return myName;
   }
   
   public String getBirth()
   {
      return myBirth;
   }
   
   public double getAge()
   {
      return myAge;
   }
   
   public void setAge(String age)
   {
      age = age.trim();
      myAge = calculateAge(age);
   }
   
   public void setBirth(String birth)
   {
      myBirth = birth;
   }
   
   public void setName(String name)
   {
      myName = name;
   }
   
   /*handles the inconsistencies regarding age
     @param a = a string containing an age from file. Ex: "12", "12w", "12d"
     returns the age transformed into year with 4 decimals rounding
   */
   
   /*We first declare a double variable finalAge. Then, we check if the string ends with a w.
   If it does, then set finalAge equal to the number part of the string (changed to a double) divided
   by 365.0/7. This will give you a double which is equal to the percent of a year. Then you return
   the version that is formatted and turned back into a double. The next part does the same thing with
   the letter d except it just divides by 365.0 which gives you the percent of the year as well. After both
   of these, we have the general case if it is given without a letter at the end. It will just convert it to a double,
   format it, convert it back to a double, and return it.*/
   public double calculateAge(String a)
   {
      double finalAge;
      if(a.endsWith("w"))
      {
         finalAge = Double.parseDouble(a.substring(0, a.length() - 1))/ (365.0/7);
         return Double.parseDouble(df.format(finalAge));
      }
      else if(a.endsWith("d"))
      {
         a = a.substring(0, a.length() - 1);
         finalAge = Double.parseDouble(a)/365.0;
         return Double.parseDouble(df.format(finalAge));
      }
      return Double.parseDouble(df.format(Double.parseDouble(a)));
   }
   
   
   /*We store the name and use it to get the length of the name. Then we subtract 25 from it to 
   find the number of spaces necessary to align all the entries. Then we add the correct number of spaces
   to the variable spaces. Then, when we return the full string, we put spaces after myName along with myBirth
   another space and myAge*/
   
   public String toString()
   {
      String name = getName();
      int nameLength = name.length();
      int spaceAmount = 25 - nameLength;
      String spaces = "";
      for(int x = 0; x < spaceAmount; x++)
      {
         spaces += " ";
      }
      return myName + spaces + myBirth + " " + myAge;
   }
}
 // Name:  S2-17
 // Date:  3/4/2020

/* 
   Assignment:  This hashing program results in collisions.
   You are to implement three different collision schemes: linear 
   probing, rehashing, and chaining.  Then implement a search 
   algorithm that is appropriate for each collision scheme.
 */
import java.util.*;
import javax.swing.*;
public class Hashing
{
   public static void main(String[] args)
   {
      int arrayLength = Integer.parseInt(JOptionPane.showInputDialog(
                         "Hashing!\n"+
                         "Enter the size of the array:  "));//20
       
      int numItems = Integer.parseInt(JOptionPane.showInputDialog(
                         "Add n items:  "));               //15
     
      int scheme = Integer.parseInt(JOptionPane.showInputDialog(
           "The Load Factor is " + (double)numItems/arrayLength +
           "\nWhich collision scheme?\n"+
           "1. Linear Probing\n" +
           "2. Rehashing\n"+
           "3. Chaining"));
      Hashtable table = null;
      switch( scheme )
      {
         case 1:   
            table = new HashtableLinearProbe(arrayLength);
            break;
         case 2: 
            table = new HashtableRehash(arrayLength);
            break;
         case 3:  
            table = new HashtableChaining(arrayLength);
            break;
         default:  System.exit(0);    
      }
      for(int i = 0; i < numItems; i++)
         table.add("Item" + i);
      int itemNumber = Integer.parseInt(JOptionPane.showInputDialog(
                       "Search for:  Item0" + " to "+ "Item"+(numItems-1)));
      while( itemNumber != -1 )
      {
         String key = "Item" + itemNumber;
         int index = table.indexOf(key); 
         if( index >= 0)    //found it
            System.out.println(key + " found  at index " + index);
         else
            System.out.println(key + " not found!");
         itemNumber = Integer.parseInt(JOptionPane.showInputDialog(
                       "Search for:  Item0" + " to "+ "Item"+(numItems-1)));                           
      } 
      System.exit(0);
   }
}

/*********************************************/
interface Hashtable
{
   void add(Object obj);
   int indexOf(Object obj);
}
/***************************************************/ 

class HashtableLinearProbe implements Hashtable
{
   private Object[] array;
  //We set the array to an array of the size given in the argument that contains Objects.
   public HashtableLinearProbe(int size)//constructor
   {
      array = new Object[size];             
   }
   
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if(array[index] == null)  //empty
      {
         array[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      else //collision
      {
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         index = linearProbe(index);
         array[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
   }  
   
   public int linearProbe(int index)
   {      
      /*We first check if the value at the index given is null, which means we can just return index as it is an open space.*/
      if(array[index] == null)
      {
         return index;
      }
      /* We store the original index which is where the index would be if there was no collision. Then, we use a do while to keep running while
      we are not equal to this original index again. Within this loop, we increase index by 1 and mod by the array length to ensure we don't
      get an AOB error. Then, we check if the current index in the array is null, and if it is, we have found the location and return the index.
      Once index is equal to the original index, it means there are no open spots in the array so we return -1.*/
      int ogIndex = index;
      do{
         index = (index + 1) % array.length;
         if(array[index] == null)
         {
            return index;
         }
      }while(index != ogIndex);
      return -1;
   }
   
   public int indexOf(Object obj)     
   {
      //We create a variable index that is equal to the index that obj would be at if there was no collision
      int index = Math.abs(obj.hashCode() % array.length);
      while(array[index] != null)
      {
         //If obj at this index is equal to the target index, we just return index
         if(array[index].equals(obj))  //found it
         {
            return index;
         }
         else //search for it in a linear probe manner
         {
            /*We store the original index which is where the index would be if there was no collision. Then, we use a do while to keep running while
         we are not equal to this original index again. Within this loop, we increase index by 1 and mod by the array length to ensure we don't
         get an AOB error. Then, we first check if the current index in the array is not null and then if the object at the current index is equal to
         the target object. If it is, we have found the location and return the index. Once index is equal to the original index, it means there are
          no open spots in the array so we return -1.*/
            int ogIndex = index;
            do{
               index = (index + 1) % array.length;
               System.out.println("Looking at index " + index);
               if(array[index] != null && array[index].equals(obj))
               {
                  return index;
               }
            }while(index != ogIndex);
            return -1;
         }
      }
      return -1;
   }
}

/*****************************************************/
class HashtableRehash implements Hashtable
{
   private Object[] array;
   private int constant;  
   
   /*We set array to a new array of the size given in the argument that is of an Object type. Then, we try to find constant. We use a for loop starting at 2,
   the first prime number, and go until the array's length. Within this for loop, we check if the gcd of size and x is equal to 1. If the only divisor between the
   two is 1, it means that they are relatively prime, and this value is set to constant. Then we would break. This sets constant to the first relatively prime 
   number*/
   public HashtableRehash(int size) //constructor
   {
      array = new Object[size];
      for(int x = 2; x < array.length; x++)
      {
         if(gcd(size, x) == 1)
         {
            constant = x;
            break;
         }
      }
   }
   
   /*This method returns the greatest common divisor. We create a temp variable. We use a while loop to run while b!= 0. We store a in the temp variable and set
   a to b. Then we set b to the mod of t with b. When b is equal to 0, a will be equal to the gcd so we return a.*/
   public int gcd(int a, int b)
   {
      int t;
      while(b != 0){
         t = a;
         a = b;
         b = t%b;
      }
      return a;
   }
   
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if(array[index] == null)  //empty
      {
         array[index] = obj;//insert it
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      else //collision
      {
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         index = rehash(index);
         array[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
   }  
   
   public int rehash(int index)
   {
     /*We first check if the value at the index given is null, which means we can just return index as it is an open space.*/
      if(array[index] == null)
      {
         return index;
      }
      /* We store the original index which is where the index would be if there was no collision. Then, we use a do while to keep running while
      we are not equal to this original index again. Within this loop, we increase index by the constant and mod by the array length to ensure we 
      don't get an AOB error. Then, we check if the current index in the array is null, and if it is, we have found the location and return the 
      index. Once index is equal to the original index, it means there are no open spots in the array so we return -1.*/
      int ogIndex = index;
      do{
         index = (index + constant) % array.length;
         if(array[index] == null)
         {
            return index;
         }
      }while(index != ogIndex);
      return -1;
   }
   
   public  int indexOf(Object obj)
   {
      //We create a variable index that is equal to the index that obj would be at if there was no collision
      int index = Math.abs(obj.hashCode() % array.length);
      while(array[index] != null)
      {
         //If obj at this index is equal to the target index, we just return index
         if(array[index].equals(obj))  //found it
         {
            return index;
         }
         else //search for it in a rehashing manner
         {
            /*We store the original index which is where the index would be if there was no collision. Then, we use a do while to keep running while
         we are not equal to this original index again. Within this loop, we increase index by the constant and mod by the array length to ensure we don't
         get an AOB error. Then, we first check if the current index in the array is not null and then if the object at the current index is equal to
         the target object. If it is, we have found the location and return the index. Once index is equal to the original index, it means there are
          no open spots in the array so we return -1.*/
         
            int ogIndex = index;
            do{
               index = (index + constant) % array.length;
               System.out.println("Looking at index " + index);
               if(array[index] != null && array[index].equals(obj))
               {
                  return index;
               }
            }while(index != ogIndex);
            return -1;
         }
      }
      return -1;
   }
}

/********************************************************/
class HashtableChaining implements Hashtable
{
   private LinkedList[] array;
   
   /*We set the array field to an array of LinkedLists that is the size given in the argument. We also use a for loop to loop through the array
   and set each index in the array to a new LinkedList.*/
   public HashtableChaining(int size)
   {
      array = new LinkedList[size];
      for(int x = 0; x < array.length; x++)
      {
         array[x] = new LinkedList();
      }
      //instantiate the array
      //instantiate the LinkedLists
                            
   }
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      array[index].addFirst(obj);
      System.out.println(obj + "\t" + code + " " + " at " +index + ": "+ array[index]);
   }  
   
   public int indexOf(Object obj)
   {
      int index = Math.abs(obj.hashCode() % array.length);
      if( !array[index].isEmpty() )
      {
         //Once we have found the index of the array that the object should be located based on it's hashcode, we check if the first item
         //in the list at that index is equal to obj. This means we have already found it.
         if(array[index].getFirst().equals(obj)) //found it
         {
            return index;
         }
         else //search for it in a chaining manner
         {
            //We use a for each through loop through the list at array[index]. For each ob in this list, we check if it is equal to the
            //obj passed as the argument. If it is, we return index. If we can't find it and the for each loop ends, then -1 is returned.
            for(Object ob : array[index])
            {
               if(ob.equals(obj))
               {
                  return index;
               }
            }
         }
      }
      return -1;
   }
}
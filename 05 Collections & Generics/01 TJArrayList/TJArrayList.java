// Name: S2-17
// Date: 12/3/19

/**
 * Implements the cheat sheet's List interface.  Implements generics.
 * The backing array is an array of (E[]) new Object[10];
 * @override toString()
 */ 
public class TJArrayList<E>
{
   private int size;							//stores the number of objects
   private E[] myArray;
   public TJArrayList()                //default constructor makes 10 cells
   {
      myArray = (E[]) new Object[10];
      size = 0;
   }
   
   /*We just return the private field size.*/
   public int size()
   {
      return size;  
   }
 	/* appends obj to end of list; increases size;
      must be an O(1) operation when size < array.length, 
         and O(n) when it doubles the length of the array.
	  @return true  */
     
     /*First, we check if size < myArray.length which would mean that there is an open spot in the original array for the value to be added,
     so if this is true, we just add the value at size. If this is not true, it would mean that the array is too small for another value
     to be added. So, here we would make a new E array that is twice the size of the original array. Then, we use a for loop to go through
     the original array and copy each value into the new array. Then, in the new array, we add the value at the next spot (size) and set
     myArray to myNewArray to update the field. After the if and else, we increase size by 1 and return true.*/
   public boolean add(E obj)
   {
      if(size < myArray.length)
      {
         myArray[size] = obj;
      }
      else
      {
         E[] myNewArray = (E[]) new Object[myArray.length * 2];
         for(int x = 0; x < myArray.length; x++)
         {
            myNewArray[x] = myArray[x];
         }
         myNewArray[size] = obj;
         myArray = myNewArray;
      }
      size++;
      return true;
   }
   /* inserts obj at position index.  increments size. 
		*/
      
      /*First, we check if size >= myArray.length which would mean that the array is too small for another value
     to be added. So, here we would make a new E array that is twice the size of the original array. Then, we use a for loop to go through
     the original array and copy each value into the new array. Then, we set myArray to myNewArray to update the field. Then, in order to 
     open up a spot at the correct index for the new value to be added, we use a for loop that starts at size-1 (the index of the last 
     actual value in the array) and goes while x>= the index. In this for loop we set shift every value to the right one by saying 
     myArray[x+1] = myArray[x]. This leaves an extra spot at the correct index which allows us to set that value to the specified object. 
     Then we increase the size by 1.*/
   public void add(int index, E obj) throws IndexOutOfBoundsException  //this the way the real ArrayList is coded
   {
      if(index > size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      if(size >= myArray.length)
      {
         E[] myNewArray = (E[]) new Object[myArray.length * 2];
         for(int x = 0; x < myArray.length; x++)
         {
            myNewArray[x] = myArray[x];
         }
         myArray = myNewArray;
      }
      
      for(int x = size - 1; x >= index; x--)
      {
         myArray[x+1] = myArray[x];
      }
      
      myArray[index] = obj;
      size++;
   }

   /* return obj at position index.  
		*/
      
   /*We just return the value at the specified index.*/
   public E get(int index) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      return myArray[index];
   
   }
   /**
    * Replaces obj at position index. 
    * @return the object is being replaced.
    */ 
    
    /*First, we store the value at the index we want to replace. Then we change the value at that index, and return
    the value we stored, the one that got replaced.*/ 
   public E set(int index, E obj) throws IndexOutOfBoundsException  
   { 
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      E toReturn = myArray[index];
      myArray[index] = obj;  
      return toReturn;    
                            
   }
 /*  removes the node from position index. shifts elements 
     to the left.   Decrements size.
	  @return the object at position index.
	 */
    
    /*First, we store the value that we are about to remove. Then, we have a for loop that starts at the
    index we want to remove from because from that point forward (until size) we want to shift all the elements
    one to the left. After this loop, we will have removed the value originally at that index. Then, we decrease size
    and return the value we originally stored.*/
   public E remove(int index) throws IndexOutOfBoundsException  
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      E toReturn = myArray[index];
      for(int x = index; x < size; x++)
      {
         myArray[x] = myArray[x+1];
      }
      size--;
      return toReturn;
   }
	   /*
		   This method compares objects.
         Must use .equals(), not ==
     	*/
      
      /*We have a for loop that goes until the current number of objects in the array. For each value, we check
      if it equals the specified object using the .equals() method and if they are equal, we return true. Otherwise
      we return false.*/
   public boolean contains(E obj)
   {
      for(int x = 0; x < size; x++)
      { 
         if(myArray[x].equals(obj))
         {
            return true;
         }
      }
      return false;
   }
	 /*returns a String of E objects in the array with 
       square brackets and commas.
     	*/
      
   /*We create a string that stores a [ because that is the first thing that should be in the output.
   Next, we have a for loop that goes until less than size - 1 because we don't want to add a comma in front of the
   last value. Inside, we just add the current value and a comma to the string. After that, we add the last
   value to the string and return it.*/
   public String toString()
   {
      String toReturn = "[";
      for(int x = 0; x < size - 1; x++)
      {
         toReturn += (myArray[x] + ", ");
      }
      toReturn += myArray[size - 1] + "]";
      return toReturn;
   }
}
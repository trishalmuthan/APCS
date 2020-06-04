// Name: S2-17
// Date: 11/21/19

//  implements some of the List and LinkedList interfaces: 
//	 	  size(), add(i, o), remove(i);  addFirst(o), addLast(o); 
//  This class also overrides toString().
//  the list is zero-indexed.
//  Uses DLNode.

public class DLL        //DoubleLinkedList
{
  private int size;
   private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
   /*All we do is return the size field*/
   public int size()
   {
      return size;  
   }
   
   /* appends obj to end of list; increases size;
   	  @return true  */
        /*Just call addLast.*/
   public boolean add(Object obj)
   {
      addLast(obj);
      return true;   
   }
   
   /* inserts obj at position index.  increments size. 	*/
   /*First, we create a DLNode that starts at the node after head, which actually stores a value. We then have a for loop that goes
   until the index. After this loop, temp will be on the correct index. We create a new DLNode in between temp.getPrev() and temp which
   adds it in between temp and the one before it (the correct location). It stores the object specified in the argument. Then, we set
   the next of temp's prev to the new node connecting it to that node and set temp's prev to the new node which connects it on both sides
   , effectively adding the node at the correct index.*/
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
   {
      if( index > size || index < 0 )
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode temp = head.getNext();
      for(int x = 0; x < index; x++)
      {
         temp = temp.getNext();
      }
      DLNode insert = new DLNode(obj, temp.getPrev(), temp);
      temp.getPrev().setNext(insert);
      temp.setPrev(insert);
      size++;                      
   }
   
   /* return obj at position index. 	*/
   /*First, we create a DLNode that starts at the node after head, which actually stores a value. We then have a for loop that goes
   until the index. After this loop, temp will be on the correct index. Then we just return this node's value*/
   public Object get(int index)
   { 
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode temp = head.getNext();
      for(int x = 0; x < index; x++)
      {
         temp = temp.getNext();
      }
      return temp.getValue();
   }
   
   /* replaces obj at position index. 
        returns the obj that was replaced*/
   /*First, we create a DLNode that starts at the node after head, which actually stores a value. We then have a for loop that goes
   until the index. After this loop, temp will be on the correct index. We create an Object object to store the value so that we can
   return it after. Then, we change it's value to the object specified in the argument. Then we return the object we stored earlier.*/
   public Object set(int index, Object obj)
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode temp = head.getNext();
      for(int x = 0; x < index; x++)
      {
         temp = temp.getNext();
      }
      Object store = temp.getValue();
      temp.setValue(obj);
      return store;
   } 
   
   /*  removes the node from position index (zero-indexed).  decrements size.
       @return the object of the node that was removed.    */
       /*First, we create a DLNode that starts at the node after head, which actually stores a value. We then have a for loop that goes
   until the index. After this loop, temp will be on the correct index. We store this node's object to return later. We set the previous
   of temp's next to temp.getNext(), which removes the previous node's connection to temp. We then set the next of temp's prev to 
   temp.getPrev(), which removes the next node's connection to temp. We then decrease the size by 1 and return the object stored 
   earlier.*/
   public Object remove(int index)
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode temp = head.getNext();
      for(int x = 0; x < index; x++)
      {
         temp = temp.getNext();
      }
      Object toReturn = temp.getValue();
      temp.getPrev().setNext(temp.getNext());
      temp.getNext().setPrev(temp.getPrev());
      size--;
      return toReturn;  
   }
   
   /* inserts obj at front of list, increases size   */
   /*We create a new DLNode that has the object specified in the argument, a prev of head, since it's being added to the beginning, and 
   a next of head.getNext() since the original first node isn't getting moved but instead getting moved forward. We set the prev of the 
   next of head to insert, establishing that connection, and set the next of head to insert which establishes the connection from head
   to the new first node. Then, we increase size by 1.*/
   public void addFirst(Object obj)
   {
      DLNode insert = new DLNode(obj, head, head.getNext());
      head.getNext().setPrev(insert);
      head.setNext(insert);
      size++;
   }
   
   /* appends obj to end of list, increases size    */
   /*We create a new DLNode that has the object specified in the argument, a prev of head.getPrev(), since it's being added to the end, and 
   a next of head since we want to make sure the new node is connected back to head (keeping it circular). We set the next of the 
   prev of head to insert, establishing that connection, and set the prev of head to insert which establishes the connection from head
   to the new last node behind it. Then, we increase size by 1.*/
   public void addLast(Object obj)
   {
      DLNode insert = new DLNode(obj, head.getPrev(), head);
      head.getPrev().setNext(insert);
      head.setPrev(insert);
      size++;
   }
   
   /* returns the first element in this list  */
   /*We return the value of the node after head, the first node that stores an actual value.*/
   public Object getFirst()
   {
      return head.getNext().getValue();
   }
   
   /* returns the last element in this list  */
   /*We return the value of the node before head, the last node that stores an actual value.*/
   public Object getLast()
   {
      return head.getPrev().getValue();
   }
   
   /* returns and removes the first element in this list, or
       returns null if the list is empty  */
   /*First, we have an if statement that checks if the list is empty and returns null if it is. We then store the value of the node
   after head, the first node that stores an actual value. We set the next of head to head.getNext().getNext() which removes the
   connection of head to the original first node and sets it to the node after. We then set the new next of head's prev to head which
   removes the connection of the new first node to the node we removed. Then, we decrease size by 1 and return the object stored earlier.*/
   public Object removeFirst()
   {
      if(head.getNext() == head)
      {
         return null;
      }
      Object toReturn = head.getNext().getValue();
      head.setNext(head.getNext().getNext());
      head.getNext().setPrev(head);
      size--;
      return toReturn;
   }
   
   /* returns and removes the last element in this list, or
       returns null if the list is empty  */
   /*First, we have an if statement that checks if the list is empty and returns null if it is. We then store the value of the node
   before head, the last node that stores an actual value. We set the next of head.getPrev().getPrev() to head which removes the
   connection of the node two nodes before to the original last and sets it to head. We then set head's prev to the node two nodes before
   which removes the connection of the head to the node we removed. Then, we decrease size by 1 and return the object stored earlier.*/
   public Object removeLast()
   {
      if(head.getNext() == head)
      {
         return null;
      }
      Object toReturn = head.getPrev().getValue();
      head.getPrev().getPrev().setNext(head);
      head.setPrev(head.getPrev().getPrev());
      size--;
      return toReturn;
   }
   
   /*  returns a String with the values in the list in a 
       friendly format, for example   [Apple, Banana, Cucumber]
       The values are enclosed in [], separated by one comma and one space.
    */
    /*First, we create a DLNode that starts at the node after head, which actually stores a value. We make a new String toReturn
    which first has a [ at the beginning. We use a while loop (while temp != head) to llop through the list. Each time through, 
    we add the value of the current node. We also check if the next node is head (if we are at the end of the list) and if we are 
    not, then we add a comma. Then we move temp forward one. Lastly, we add a ] to the end of the string and return it.*/
   public String toString()
   {
      DLNode temp = head.getNext();
      String toReturn = "[";
      while(temp != head)
      {
         toReturn += (temp.getValue());
         if(temp.getNext() != head)
         {
            toReturn += ", ";
         }
         temp = temp.getNext();
      }
      toReturn += "]";
      return toReturn;
   }
}
// Name: S2-17
// Date: 12/9/19
   
import java.util.*;

public class CollectionsSpeed
{
   public static final int n = 10000;
   
   public static void main(String[] args)
   {
      ArrayList<Integer> alist = new ArrayList<Integer>();
      LinkedList<Integer> llist = new LinkedList<Integer>();
      makeValues(alist, llist);
      
      System.out.println("get each for ArrayList = " + timeGetEach(alist));
      System.out.println("get each for LinkedList = " + timeGetEach(llist));
      System.out.println("\nadd at 0 for ArrayList = " + timeAddFirst(alist));
      System.out.println("add at 0 for LinkedList = " + timeAddFirst(llist));
      System.out.println("\nadd at list.size() for ArrayList = " + timeAddLast(alist));
      System.out.println("add at list.size() for LinkedList = " + timeAddLast(llist));
      System.out.println("addLast for LinkedList = " + timeAddLastLL(llist));
   }
   
   public static void makeValues(ArrayList<Integer> alist, LinkedList<Integer> llist)
   {
      for( int i = 0; i < n; i++ )
      {
         alist.add(i);              		 
         llist.add(i);							
      }
   }
   
   /**
    * Get n items by searching for each one.
    */     
    
    /*We loop through 10000 times and get each integer. LinkedList takes longer since you have to start at the beginning and go through all the nodes
    ArrayList takes less time since you can just pick each item from a specific index without going through all items. The time is managed via the 
    nanoTime method and is returned.*/
   public static double timeGetEach(List<Integer> list)
   {
      double start = System.nanoTime();
      for( int i = 0; i < n; i++ )
      {
         int index = list.get(i);
      }
      return (System.nanoTime() - start)/1E6;
   }
   
   /**
    * Add 10000 new objects at position 0.
    */
    
    /*We add 10000 objects at the index of 0. It takes longer to add something at index 0 for an ArrayList since you have
    to move everything over 1 index. LinkedList takes less time since you can just add the node to the beginning and switch 
    around the nexts and prevs. The time is managed via the nanoTime method and is returned.*/
   public static double timeAddFirst(List<Integer> list)
   {
      double start = System.nanoTime();
      for( int i = 0; i < n; i++ )
      {
         list.add(0, i);
      }
      return (System.nanoTime() - start)/1E6;
   }
   
   /*    
    * Add 10000 new objects at position list.size() 
    */
    
     /*We add 10000 objects at the index of list.size() which is the next open spot or the end. It takes the same amount of time for all 
     types of lists. The time is managed via the nanoTime method and is returned.*/
   public static double timeAddLast(List<Integer> list)
   {
      double start = System.nanoTime();
      for( int i = 0; i < n; i++ )
      {
         list.add(list.size(), i);
      }
      return (System.nanoTime() - start)/1E6;
   }
   
   /*    
    * Add 10000 new objects at the end.  
    * Uses the LinkedList method addLast().
    * You must cast List list into a LinkedList. 
    */
    
     /*We add 10000 objects at the end through the addLast() method which is the next open spot or the end. We have to cast the list 
     as a LinkedList this time as well, which is the only other difference. The time is managed via the nanoTime method and is returned.*/
   public static double timeAddLastLL(List<Integer> list)
   {
      double start = System.nanoTime();
      for( int i = 0; i < n; i++ )
      {
         ((LinkedList)list).addLast(i);
      }
      return (System.nanoTime() - start)/1E6;
   }
}

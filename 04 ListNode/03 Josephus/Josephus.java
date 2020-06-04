// Name: S2-17
// Date: 11/18/19

import java.util.*;
import java.io.*;

public class Josephus
{
   private static String WINNER = "Josephus";
   
   public static void main(String[] args) throws FileNotFoundException
   {
      ListNode head, p;
      head = p = new ListNode("A", null);
      p.setNext(head);
      p = insert(p, "B");
      p = insert(p, "C");
      p = insert(p, "D");
      print(p);
        
      /* run numberCircle first with J_numbers.txt  */
      Scanner sc = new Scanner(System.in);
      System.out.print("How many names (2-20)? ");
      int n = Integer.parseInt(sc.next());
      System.out.print("How many names to count off each time?"  );
      int countOff = Integer.parseInt(sc.next());
      ListNode winningPos = numberCircle(n, countOff, "J_numbers.txt");
      System.out.println(winningPos.getValue() + " wins!");  
     
      /* run josephusCircle next with J_names.txt  */
      System.out.println("\n ****  Now start all over. **** \n");
      System.out.print("Where should "+WINNER+" stand?  ");
      int winPos = Integer.parseInt(sc.next());        
      ListNode theWinner = josephusCircle(n, countOff, "J_names.txt", winPos);
      System.out.println(theWinner.getValue() + " wins!");  
   }
   
   public static ListNode numberCircle(int n, int countOff, String filename) throws FileNotFoundException
   {
      ListNode p = null;
      p = readNLinesOfFile(n, new File(filename));
      p = countingOff(p, countOff, n);
      return p;
   }
   
   public static ListNode josephusCircle(int n, int countOff, String filename, int winPos) throws FileNotFoundException
   {
      ListNode p = null;
      p = readNLinesOfFile(n, new File(filename));
      replaceAt(p, WINNER, winPos);
      p = countingOff(p, countOff, n);
      return p;
   }

   /* reads the names, calls insert(), builds the linked list.
	 */
    
    /*First, we create a scanner that reads through File f. Then, we create a new ListNode head that has the value of the first
    line in the file, and has next has its null. Then we set its next to itself so it becomes a circular list. Then, we use a for
    loop that goes until the number of names/numbers that the user chose. Each time through, we get the next line in the file, and
    set head to a call of insert with head and the next line in the file. Now, head will be equal to an edited list with the next line
    added to it. After this for loop finishes, we return head.*/
   public static ListNode readNLinesOfFile(int n, File f) throws FileNotFoundException
   {
      Scanner infile = new Scanner(f);
      ListNode head = new ListNode(infile.nextLine(), null);
      head.setNext(head);
      for(int x = 1; x < n; x++)
      {
         String insert = infile.nextLine();
         head = insert(head, insert);
      }
      return head;
   }
   
   /* helper method to build the list.  Creates the node, then
    * inserts it in the circular linked list.
	 */
    
    /*First we create a ListNode that has a reference to p so that we can change what node we are on without losing the original
    reference to the head. Then, we have a while loop that keeps moving head through the list until the node right before the original
    first node. Then, we set the next of this head to a new ListNode object who's value is the object passed in the argument, and has a
    next of the original head, which effectively inserts the node at the end and maintains the circular nature of the list. Then we
    return the original head.*/
   public static ListNode insert(ListNode p, Object obj)
   {
      ListNode head = p;
      while(head.getNext() != p)
      {
         head = head.getNext();
      }
      head.setNext(new ListNode(obj, p));
      return p;
   }
   
   /* Runs a Josephus game, counting off and removing each name. Prints after each removal.
      Ends with one remaining name, who is the winner. 
	 */
    
    /*First, we have our base case, which is if there is only one item in the list (n == 1). If this is the case, we print
    out p and return it as it would be the winner. If we don't meet the base case, we first print out the current list, we set p to
    an edited list where one of the elements has been removed from the remove() method based off of the count.
    Then we recursively call and return countingOff with the edited list, the same count, and n-1 because there is one less item 
    in the list. Because it will keep removing nodes based off of the count and we eventually reach the base case, this will 
    eventually return the winner when we rise back up the stack.*/
   public static ListNode countingOff(ListNode p, int count, int n)
   {
      if(n == 1)
      {
         print(p);
         return p;
      }
      print(p);
      p = remove(p, count);
      return countingOff(p, count, n-1);
   }
   
   /* removes the node after counting off count-1 nodes.
	 */
    
    /*First, we have a case for if count == 1 because what we do is different for a single node. In this if statement,
    we create a ListNode temp. Then we use a while loop to find the last node in the list, or the one before the head
    since it is circular. Once, we find this node, we set its next to the next of the original first node, which effectively
    gets rid of the original node that was given in the argument (or the first node that we needed to remove since the count is 1)
    , and keeps the circular nature of the list. Then, we return p.getNext() since we were originally on the last node and we want 
    to get back to the node that was after the node we just removed. That was what we did for if the count is 1, but if the count is 
    above null, then there is a different method we use. For this method, we first have a loop that advances p count-1 times. We 
    use count-1 instead of just count because we don't want to actually get on the node. We want to stay before it so that we are 
    able to change the next to get around it. We do just this and we set p's next to p.getNext().getNext(), the node after the next 
    node. Again, this removes the node we wanted to remove based on the count. Then we return p.getNext() because we want to return 
    the node after the one we removed.*/
    
   public static ListNode remove(ListNode p, int count)
   {
      if(count == 1)
      {
         ListNode temp = p;
         while(p.getNext() != temp)
         {
            p = p.getNext();
         }
         p.setNext(temp.getNext());
         return p.getNext();
      }
      
      for(int x = 1; x < count-1; x++)
      {
         p = p.getNext();
      }
      p.setNext(p.getNext().getNext());
      return p.getNext();
   }
   
   /* prints the circular linked list.
	 */
    
    /*First, we create a ListNode that stores a reference to p. Then we print it out once to account for the fact that there
    may be only one node in the list. We then advance p. Then, we have a while loop that runs while p != store. We keep printing
    and advancing p in this loop. Once this loop is finished, we will have printed out all nodes, so we do  System.out.println()
    to go to the next line.*/
   public static void print(ListNode p)
   {
      ListNode store = p;
      System.out.print(p.getValue() + " ");
      p = p.getNext();
      while(p != store)
      {
         System.out.print(p.getValue() + " ");
         p = p.getNext();
      }
      System.out.println();
   }
	
   /* replaces the value (the string) at the winning node.
	 */
    
    /*We use a for loop that goes until the pos specified as an argument. In this loop we keep doing
    p = p.getNext() to advance the loop. Then, once we get to the right node, we set its value to te value
    specified in the argument.*/
   public static void replaceAt(ListNode p, Object obj, int pos)
   {
      for(int x = 1; x < pos; x++)
      {
         p = p.getNext();
      }
      p.setValue(obj);
   }
}


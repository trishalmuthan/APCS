// Name: S2-17
// Date: 11/13/19

/*****************************************
Demonstrates many ways to reverse a list made of ListNodes.
******************************************/
public class ListLabReverse
{
   public static void main(String[] args)
   {
      ListNode head = new ListNode("hello", null);
      head = new ListNode("foo", head);
      head = new ListNode("boo", head);
      head = new ListNode("nonsense", head);
      head = new ListNode("computer",
         new ListNode("science",
         new ListNode("java",
         new ListNode("coffee", head))));
         
      System.out.print("print the original: \t\t\t\t");
      print(head);
         
      System.out.print("recur and print: \t\t\t\t\t");
      recurAndPrint(head);
      
      System.out.println();
      System.out.print("original is unchanged: \t\t\t\t");
      print(head);
      
      System.out.print("reverse by building a new list: \t");
      head = reverseBuildNew(head);
      print(head);      
      	
      System.out.print("iterate with 3 pointers:\t\t\t");
      head = iterateThreePointers(head);
      print(head);
      	
      System.out.print("recur with 2 pointers: \t\t\t\t");
      head = recurTwoPointers(null, head);
      print(head);
              
      System.out.print("recur with pointers and append: \t");
      head = recurPointersAppend(head);
      print(head);
      	
      System.out.print("Mind Bender reverse:\t\t\t\t\t");
      head = mindBender(head);
      print(head);
   }
   
   public static void print(ListNode head)
   {
      System.out.print("[");
      while(head != null)
      {
         System.out.print(head.getValue());
         head = head.getNext();
         if(head != null)
            System.out.print(", ");
      }
      System.out.println("]");
   }
   
	/*********************************************
	1. This approach doesn't actually reverse the list.  It only prints
	the list in reverse order.  recurAndPrint() prints the square 
	brackets and calls helper().  helper() is recursive.
	********************************************************/
   
   /*Print out the beginning and ending bracket and call helper for the section in between.*/
   public static void recurAndPrint(ListNode h)
   {
      System.out.print("[");
      helper(h);
      System.out.print("]");
   }
   
   /*We check if p is not equal to null, and if it isn't we recursively call helper with the next node.
   What each call will end up doing is check if the next value is not equal to null, and will print out a comma
   before, because it wouldn't be the last one. Then we just print out the value of the node. This effectively
   prints out the entire list.*/
   private static void helper(ListNode p)
   {
      if(p!= null)
      {
         helper(p.getNext());
         if(p.getNext() != null)
         {
            System.out.print(", ");
         }
         System.out.print(p.getValue());
      }
   }
   
   /*********************************************
	2. This iterative method (for or while) produces a copy of the 
	reversed list.	 For each node going forward, make a new node and 
	link it to the list.	The list will naturally be in reverse. 
	***********************************************************/
   
   /*We create two ListNodes, one sent to null, and the other set to head, but with the next as null,
   indicating it is at the end of the list. Then, we have a while, that runs while the next node is not 
   null. We set temp to store and we create a new ListNode object with the next object's value and temp.
   This makes a new ListNode object that is at the beginning of all the nodes already created because we set
   the new object's next to that other object. Then, we set head to the next object in the original list.
   Once all of this executes, the list will be reversed with store at the beginning so we just return store.*/
   public static ListNode reverseBuildNew(ListNode head)
   {
      ListNode temp = null;
      ListNode store = new ListNode(head.getValue(), temp);
      while(head.getNext() != null)
      {
         temp = store;
         store = new ListNode(head.getNext().getValue(), temp);
         head = head.getNext();
      }
      return store;
   }

   /*******************************************
	3a. This iterative method (while) uses 3 pointers to reverse 
	the list in place.   The two local pointers are called
	prev and next.
   ********************************************************/
   
   /*First, we check if head is null and return null if it is. Then, two ListNodes are created, prev and next.
   Prev is set to null while head is set to head.getNext(). I'll explain the next 3 lines after the while loop. The
   while loop will keep running while head is not equal to null. In the while loop, we move next forward one. Then we
   set the next of head to prev so it's next is the one behind it. Then, we set prev to head and we set head to next, so
   both pointers get moved forward one. This basically goes through the list and sets everything's next to the one behind it.
   This puts the list in reverse order. Going back to the 3 lines above loop, those are the same as the code in the loop
   except the next = next.getNext() is already given to us so we can't include that in the loop, otherwise an item will be skipped*/
   public static ListNode iterateThreePointers(ListNode head)
   {
      if(head == null) 
         return null;
      ListNode prev = null, next = head.getNext();
      head.setNext(prev);
      prev = head;
      head = next;
      while(head != null)
      {
         next = next.getNext();
         head.setNext(prev);
         prev = head;
         head = next;
      }
      /*  enter your code here   */
   
      return prev;
   }
   	
	/**************************************************
	3b. This recursive method uses two pointers as arguments to reverse 
	the list in place. Each level creates and uses a third pointer, called "next".
   ********************************************************/
   
   /*First, we check if the head is equal to null and if it is, we return prev because that would be
   the beginning of the reversed list. After this base case, we set a new ListNode next to head. Then, we move
   next forward one and set the next of head to prev, the node behind it. Then, we recursively call with head, next
   because we want the next object to be the head on the next call. When we get back to the top of the stack, we will have
   the same list, but the next values will be switched so now the list is in reverse order*/
   public static ListNode recurTwoPointers(ListNode prev, ListNode head)
   {
      if(head == null)
      {
         return prev;
      }
      ListNode next = head;
      next = next.getNext();
      head.setNext(prev);
      return recurTwoPointers(head, next);
   } 
   
   /**********************************************
	3c. On each recursive level, find pointerToLast() and 
	nextToLast(). Make a new last. On way back, append() 
	one level to the other. 
	********************************************************/
   
   /*First, we have the base case, which is if the next of head is null, and if it is, we return head.
   Next, we have 2 ListNode objects that store both the last node and the 2nd to last node. We set the next of
   the second to last node to null, which shortens the list. Then we append the last to the beginning of the recursive call
   of the shortened list. The recursive calls will each add the last item to the beginning of the list, and we will
   eventually have a reversed list.*/
   public static ListNode recurPointersAppend(ListNode head)
   {
      if(head.getNext() == null)
      {
         return head;
      }
      ListNode last = pointerToLast(head);
      ListNode nextToLast = nextToLast(head);
      nextToLast.setNext(null);
      return append(last, recurPointersAppend(head));
   }
   
/*First, we have a pair of base cases. The first is for if the list is empty, so we check if it is null and return null
   if it is. The next base case is for we find the last node in the list, so we check if the value next is null and if it is,
   it means we are at our final element in the list so we return head (a reference to the current ListNode). Lastly, we have the 
   recursive call, which will be reached if there are more ListNodes that follow. If we reach this line, we return 
   pointerToLast(head.getNext()) which is the ListNode after the current ListNode. This continues on recursively until the 
   reference to the last ListNode is returned*/
   private static ListNode pointerToLast(ListNode head)
   {
      if(head == null)
         return null;
      if(head.getNext() == null)
         return head;
      else
         return pointerToLast(head.getNext());
   }
   
/*First, we have a pair of base cases. The first is for if the list is empty, so we check if it is null and return null
   if it is. The next base case is for we find the node next to the last last node in the list, so we check if the value next to the next
   is null and if it is, it means we are next to our final element in the list so we return head (a reference to the current ListNode).
   Lastly, we have the recursive call, which will be reached if there are more ListNodes that follow. If we reach this line, we return 
   pointerToLast(head.getNext()) which is the ListNode after the current ListNode. This continues on recursively until the 
   reference to the ListNode next to the last ListNode is returned*/
   private static ListNode nextToLast(ListNode head)
   {
      if(head == null)
         return null;
      if(head.getNext().getNext() == null)
         return head;
      else
         return nextToLast(head.getNext());
   }
   
   /*This just sets the next of h1 to h2, adding h2 to a list*/
   private static ListNode append(ListNode h1, ListNode h2)
   {
      h1.setNext(h2);
      return h1;
   }

   /**********************************************
   3d. This difficult method reverses the list in place, using one
   local pointer. Start with pointerToLast(). The helper method
   is recursive.
	********************************************************/
   
   /*We create a new ListNode object that stores the pointerToLast of head. Then we call the helper method which
   basically makes the list start at the end and rewrites it backwards starting there. Then we set head to null and return
   temp as the head of the list.*/
   public static ListNode mindBender(ListNode head)
   {
      ListNode temp = pointerToLast(head);
      mindBenderHelper(head);
      head.setNext(null);
      return temp;
   }
   
   /*First, we have a base case which is if either head or the next of head is null. Then, we have the recursive
   call of head.getNext(). Then, we create a new ListNode which stores the next of head. We set head to null and we
   set the next of store to head which puts head at the end of the list. Every recursive call does this, so as we return
   up the stack, the nodes are getting placed in the correct order. This reverses the list.*/
   public static void mindBenderHelper(ListNode head)
   {
      if(head == null || head.getNext() == null)
      {
         return;
      }
      mindBenderHelper(head.getNext());
      ListNode store = head.getNext();
      head.setNext(null);
      store.setNext(head);
   }
}

/********************************************
 print the original: 				[computer, science, java, coffee, nonsense, boo, foo, hello]
 recur and print: 					[hello, foo, boo, nonsense, coffee, java, science, computer]
 
 original is unchanged: 				[computer, science, java, coffee, nonsense, boo, foo, hello]
 reverse by building a new list: 	[hello, foo, boo, nonsense, coffee, java, science, computer]
 iterate with 3 pointers:			   [computer, science, java, coffee, nonsense, boo, foo, hello]
 recur with 2 pointers: 				[hello, foo, boo, nonsense, coffee, java, science, computer]
 recur with pointers and append: 	[computer, science, java, coffee, nonsense, boo, foo, hello]
 Mind Bender reverse:					[hello, foo, boo, nonsense, coffee, java, science, computer]

**************************************/
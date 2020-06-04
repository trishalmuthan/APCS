// Name: S2-17  
// Date: 11/7/19
import java.util.*;
public class ListLab1
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
         			new ListNode("coffee", head)
         		)
         	)
         );
      print(head);
      print(head);
      
      /**** uncomment the code below for ListLab1 Assignment  ****/
      
      ListNode a = copyNode(head);
      System.out.println("The head has a value \"" + head.getValue() + "\" at "+ head);
      System.out.println("The copy of head has a value of \"" + a.getValue() + "\" at "+ a);
   // 
      System.out.print("Copy the list: ");
      ListNode copy = copyList(head);
      print(copy);
   // 
      System.out.print("The rest of the list: ");
      ListNode theRest = rest(copy);
      print(theRest);
   // 
      System.out.println("First of the rest = " + first(theRest));
      System.out.println("Second of the rest = " + second(theRest));
      ListNode p = pointerToLast(theRest);
      System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);
      ListNode c = copyOfLast(theRest);
      System.out.println("Copy of Last =    " + c.getValue()+ " at " + c);
   // 
      Scanner in = new Scanner(System.in);
      System.out.print("Insert what? ");
      String x = in.next();
      theRest = insertFirst(theRest, x);
      theRest = insertLast(theRest, x);
      print(theRest);
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
   
   /* enter your code here */
   
   /*We return a new ListNode object that has the same values as the argument, so it is now a copy of it*/
   public static ListNode copyNode(ListNode arg)
   {
      return new ListNode(arg.getValue(), arg.getNext());
   }
   
   /*The base case is if the argument is null, because if it is null, we will have reached the end of the list
   Next, we create a new ListNode object that is the same as the argument, creating a new ListNode for a new list.
   We set the next of this ListNode object to the recursive call of arg.getNext() so that we can call it for the object
   following the argument. After this, we will have a connected list, and we can return the first object.*/
   public static ListNode copyList(ListNode arg)
   {
      if(arg == null)
      {
         return null;
      }
      ListNode store = copyNode(arg);
      store.setNext(copyList(arg.getNext()));
      return store;
   }
   
   /*We first check if the next value is null which would mean we have reached the end of the list so we just return null.
   We create a new ListNode object that stores copyNode(h.getNext()) which is just the next value in the original list (reaching
   this for the first time will allow us to skip the first node). Then, we set the next of that node to the recursive call
   rest(h.getNext()) which will keep assigning it to the correct next node and will reach the end once null gets returned by
   the recursive call. Lastly, we return the ListNode object we created.*/
   public static ListNode rest(ListNode h)
   {
      if(h.getNext() == null)
      {
         return null;
      }
      ListNode store = copyNode(h.getNext());
      store.setNext(rest(h.getNext()));
      return store;
   }
   
   /*We return the head's value by calling the getValue() method*/
   public static Object first(ListNode head)
   {
      return head.getValue();
   }
   
   /*We return the value by calling the getValue() method on head.getNext(), which returns the object after head*/
   public static Object second(ListNode head)
   {
      return head.getNext().getValue();
   }
   
   /*First, we have a pair of base cases. The first is for if the list is empty, so we check if it is null and return null
   if it is. The next base case is for we find the last node in the list, so we check if the value next is null and if it is,
   it means we are at our final element in the list so we return head (a reference to the current ListNode). Lastly, we have the 
   recursive call, which will be reached if there are more ListNodes that follow. If we reach this line, we return 
   pointerToLast(head.getNext()) which is the ListNode after the current ListNode. This continues on recursively until the 
   reference to the last ListNode is returned*/
   public static ListNode pointerToLast(ListNode head)
   {
      if(head == null)
      {
         return null;
      }
      if(head.getNext() == null)
      {
         return head;
      }
      return pointerToLast(head.getNext());
   }
   
   /*First, we have a pair of base cases. The first is for if the list is empty, so we check if it is null and return null
   if it is. The next base case is for we find the last node in the list, so we check if the value next is null and if it is,
   it means we are at our final element in the list so we return a new ListNode object, passed with the same values that head stores 
   (returning an entirely new object instead of a reference to the already created object). Lastly, we have the recursive call, which 
   will be reached if there are more ListNodes that follow. If we reach this line, we return copyOfLast(head.getNext()) which is 
   the ListNode after the current ListNode. This continues on recursively until a ListNode is returned*/
   public static ListNode copyOfLast(ListNode head)
   {
      if(head == null)
      {
         return null;
      }
      if(head.getNext() == null)
      {
         return new ListNode(head.getValue(), head.getNext());
      }
      return copyOfLast(head.getNext());
   }
   
   /*We return a new ListNode object that has the arguments of this method as it's arguments. 
   This allows the new ListNode to be attached at the beginning of the list, as it has the original
   head as it's next*/
   public static ListNode insertFirst(ListNode head, Object arg)
   {
      return new ListNode(arg, head);
   }
  
   /*We create a new ListNode object that has the same value as defined in the arguments of the method, but with 
   the next as null because it is at the end of the list. Then, we pointerToLast(head) to get a reference to the last
   value in the original list and set that value's next to the ListNode object we just created instead of null. Then, we
   return head.*/
   public static ListNode insertLast(ListNode head, Object arg)
   {
      ListNode store = new ListNode(arg, null);
      pointerToLast(head).setNext(store);
      return head;
   }
}

/*****************************************
 
 [computer, science, java, coffee, nonsense, boo, foo, hello]
 [computer, science, java, coffee, nonsense, boo, foo, hello]
 The head has a value "computer" at ListNode@15db9742
 The copy of head has a value of "computer" at ListNode@6d06d69c
 Copy the list: [computer, science, java, coffee, nonsense, boo, foo, hello]
 The rest of the list: [science, java, coffee, nonsense, boo, foo, hello]
 First of the rest = science
 Second of the rest = java
 Pointer to Last = hello at ListNode@7852e922
 Copy of Last =    hello at ListNode@4e25154f
 Insert what? p
 [p, science, java, coffee, nonsense, boo, foo, hello, p]
    
  **********************************************/

import java.util.*;
public class Bruh
{
   public static void main(String[] args)
   {
Queue<String> queue3 = new LinkedList<String>();
queue3.add("Bob");
queue3.add("bobby");
queue3.add("Bob");
System.out.println("" + count(queue3));
      while(!queue3.isEmpty())
      {
         System.out.println(queue3.remove());
      }
   }
   
   public static int count(Queue<String> queue)
   {
      int count = 0;
      Queue<String> queue2 = new LinkedList<String>();
      while(!queue.isEmpty())
      {
         if(queue.peek().equals("Bob"))
         {
            count++;
            queue2.add(queue.remove());    
         }
         else
         {
            queue2.add(queue.remove());
         }
         
      }
      while(!queue2.isEmpty())
      {
         queue.add(queue2.remove());
      }
      return count;
   }
}

import java.util.*;
public class TJPQ <E extends Comparable<E>>
{
   private LinkedList list;
   
   public TJPQ()
   {
      list = new LinkedList<>();
   }
   
   public boolean isEmpty()//big(o) = O(1)
   {
      if(list.size() == 0)
      {
         return true;
      }
      return false;
   }
   
   public void add(E entry)//big o = O(1)
   {
      list.add(entry);
   }
   
   public E peek()// big(o) = O(n^2)
   {
      if(isEmpty())
      {
         return null;
      }
      int minIndex = 0;
      for(int x = 0; x  < list.size(); x++)
      {
         if(list.get(x).compareTo(list.get(minIndex)) < 0)
         {
            minIndex = x;
         }
      }
      list.get(minIndex);
   }
   
   public E remove()// big(o) = O(n^2)
   {
      if(isEmpty())
      {
         return null;
      }
      int minIndex = 0;
      for(int x = 0; x  < list.size(); x++)
      {
         if(data.get(x).compareTo(data.get(minIndex)) < 0)
         {
            micIndex = x;
         }
      }
      data.remove(minIndex);
   }
}
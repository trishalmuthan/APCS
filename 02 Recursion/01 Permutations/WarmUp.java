public class WarmUp
{
   public static void main(String[] args)
   {
      String thing = new String("ABCDdcbaF");
      thing = inverse(thing);
      System.out.println(thing);
   }
   
   public static String inverse(String s)
   {
      for(int x = 0; x < s.length()-1; x++)
      {
         if(Math.abs(s.charAt(x) - s.charAt(x+1)) == 32)
         {
            s = inverse(s.substring(0, x) + s.substring(x+2));
         }
      }
      return s;
   }

}
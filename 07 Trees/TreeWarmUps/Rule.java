public class Rule
{
   private double threshold; //field that stores the threshold of the class
   private String decision;
   private boolean isLeaf;
   public Rule(double thresh)//constructor takes a double threshold
   {
      threshold = thresh;
      decision = "";
      isLeaf = false;
   }
   public Rule(String s)
   {
      threshold = 0;
      decision = s;
      isLeaf = true;
   }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
   
   public String decide(double input)//decides whether to go left or right depending on input
   {
      if(isLeaf)
      {
         return decision;
      }
      else
      {
         if(threshold < input)
         {
            return null;
         }
         else
         {
            return "";
         }
      
      }
   }

   public double getThresh()//decides whether to go left or right depending on input
   {
      return threshold;
   }
}
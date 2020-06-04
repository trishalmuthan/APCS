import java.util.*;
import java.io.*;

public class TreeLabDriver
{
   public static void main(String[] args) throws Exception
   {
      DecisionTree lol = new DecisionTree(new File("Day2.csv"));
      TreeNode returned = lol.returnRoot();
      //System.out.println(display(returned, 0));
   }
   
  /* private static String display(TreeNode t, int level)
   {
      // turn your head towards left shoulder visualize tree
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += ((Rule)t.getValue()).getThresh() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }*/

}
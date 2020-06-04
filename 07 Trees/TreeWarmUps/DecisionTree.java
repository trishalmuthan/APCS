import java.util.*;
import java.io.*;
public class DecisionTree
{
   private TreeNode<Rule> root; //field 
   
   public DecisionTree(File f) throws Exception//constructor takes 
   {
      ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
      ArrayList<Integer> leftChildren = new ArrayList<Integer>();
      ArrayList<Integer> rightChildren = new ArrayList<Integer>();
      
      Scanner infile = new Scanner(f);
   
      while(infile.hasNextLine())
      {
         String[] splitter = infile.nextLine().split(",");
         nodes.add(new TreeNode(new Rule(Double.parseDouble(splitter[1]))));
         if(!splitter[2].equals("null"))
            leftChildren.add(Integer.parseInt(splitter[2]));
         else
            leftChildren.add(null);
         if(!splitter[3].equals("null"))
            rightChildren.add(Integer.parseInt(splitter[3]));
         else
         
            rightChildren.add(null);
      }  
      
      infile.close();
      int index = 0;
      for(TreeNode t : nodes)
      {
         if(leftChildren.get(index) != null)
         {
            t.setLeft(nodes.get(leftChildren.get(index)));
         }
         else
            t.setLeft(null);
         if(rightChildren.get(index) != null)
         {
            t.setRight(nodes.get(rightChildren.get(index)));
         }
         else
            t.setRight(null);
         index++;
      }
      
      root = nodes.get(nodes.size() - 1);
   }
   
   public TreeNode returnRoot()
   {
      return root;
   }

}
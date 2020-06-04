// Name: S2-17
// Date: 2/17/20
import java.util.*;

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   //public void addBalanced(String obj);
   public void remove(String obj);
   public String min();
   public String max();
   public String display();
   public String toString();
}

/*******************
Copy your BST code.  Implement the remove() method.
Test it with BST_Delete.java
**********************/
public class BST implements BSTinterface
{
   private TreeNode root;
   private int size;
   public BST()
   {
      root = null;
      size = 0;
   }
   public int size()
   {
      return size;
   }
   
   public TreeNode getRoot()
   {
      return root;
   }

   //Calls the remove method with the root field and the String argument. Then we decrease size by 1.
   public void remove(String target)
   {
      root = remove(root, target);
      size--;
   }
   
   private TreeNode remove(TreeNode current, String target)
   {
      /*Our first goal is to actually find the node we want to remove. First, we check if the current is null and just return current if it is.
      Then, we check if target.compareTo(current.getValue()) < 0. This would mean that the target is less than the current value and the target is
      within the left subtree of current. So we set the left of current to the new subtree that would be returned once the correct node is found 
      and removed. We then check if the target is greater than the current value using compareTo. If it is, we do the same thing as before but 
      with the node to the right of current instead of the left. If neither of these if-statements are true, then it means that we have found 
      the correct node, so we resort to the else.*/
      if(current == null)
      {
         return current;
      }
      
      if(target.compareTo((String)current.getValue()) < 0)
      {
         current.setLeft(remove(current.getLeft(), target));
      }
      
      else if(target.compareTo((String)current.getValue()) > 0)
      {
         current.setRight(remove(current.getRight(), target));
      }
      
      /*Within this else statement, we hae 3 different cases. The first case is if the current node to be removed
      is a leaf node. In this case, we just return null, which means once the current recursive call recurs up, either the right or left of the parent
      node will be set to null, removing the current node from the tree. The second case is if there is one child. In this case, we check to find
      which one is not null, and return the opposite one. This means that once the current recursive call recurs up, either the right or left of
      parent node will be set to the child of the current node. This gets rid of the node to be removed and preserves the BST nature of the tree.
      The last case is if there are 2 children.*/
      else
      {
         if(current.getLeft() == null && current.getRight() == null)
         {
            return null;
         }
         
         else if((current.getLeft() != null && current.getRight() == null) || (current.getLeft() == null && current.getRight() != null))
         {
            if(current.getLeft() == null)
            {
               return current.getRight();
            }
            else
            {
               return current.getLeft();
            }
         }
         
         /*In order to preserve the BST nature of the tree, we effectively remove the current node by replacing it with another value that 
         keeps the lower nodes to the left and the higher nodes to the right. The value we replace it with is the lowest value that is 
         greater than the current value. This would be the minimum value of the right subtree so we set the current node's value to the call 
         of min on the right subtree. Then, to remove the duplicate node, we call remove on the right subtree with the duplicate value. At the 
         end we return the current node. Once all the recursive calls have finished, the desired node will have been removed and the tree will 
         still be a BST.*/
         else
         {
            current.setValue(min(current.getRight()));
            current.setRight(remove(current.getRight(), (String)current.getValue()));
         }
      }
      
      return current;
   }

   /******
   @param s -- one string to be inserted
   ********/
   
   public void add(String s) 
   {
      root = add(root, s);
      size++;
   }
   
   private TreeNode add(TreeNode t, String s) 
   {     
      if(t == null)
      {
         t = new TreeNode(s);
         return t;
      }
      if(s.compareTo((String)t.getValue()) <= 0)
      {
         t.setLeft(add(t.getLeft(), s));
      }
      else
      {
         t.setRight(add(t.getRight(), s));
      }
      return t;
   
   }
   
   public String display()
   {
      return display(root, 0);  
   }
   
   private String display(TreeNode t, int level)
   {
            // turn your head towards left shoulder visualize tree
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
   
   public boolean contains( String obj)
   {
      return contains(root, obj);
   }
   
   public boolean contains(TreeNode t, String x)
   {
      boolean found = false;
      if(t == null)
      {
         return false;
      }
      if(((String)t.getValue()).equals(x))
      {
         return true;
      }
      if(x.compareTo((String)t.getValue()) <= 0)
      {
         found = contains(t.getLeft(), x);
      }
      else if(x.compareTo((String)t.getValue()) > 0)
      {
         found = contains(t.getRight(), x);
      }
      return found;
   }
   
   public String min()
   {
      return min(root);
   }
   

   private String min(TreeNode t)  //use iteration
   {
      if(t == null)
      {
         return null;
      }
      while(t.getLeft() != null)
      {
         t = t.getLeft();
      }
      return (String)t.getValue();
   }

   public String max()
   {
      return max(root);
   }

   private String max(TreeNode t)  //use recursion
   {
      if(t == null)
      {
         return null;
      }
      if(t.getRight() == null)
      {
         return (String)t.getValue();
      }  
      return max(t.getRight());
      
   }
   
   public String toString()
   {
      return toString(root);
   }
   
   private String toString(TreeNode t)  //an in-order traversal
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += toString(t.getLeft());
      toReturn += t.getValue() + " "; 
      toReturn += toString(t.getRight());
      return toReturn;
   }
}
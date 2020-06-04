//Name: S2-17
//Date: 2/10/20
import java.util.*;

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   //public void addBalanced(String obj);
   //public boolean remove(String obj);
   public String min();
   public String max();
   public String toString();
}

/*******************
Represents a binary search tree holding Strings. 
Implements (most of) BSTinterface, above. 
The recursive methods all have a public method calling a private helper method. 
Copy the display() method from TreeLab. 
**********************/
class BST implements BSTinterface
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

   /******
   @param s -- one string to be inserted
   ********/
   
   //Call add with the root and a string to add into the tree. Also increase size by 1 since we are adding a new node to the tree
   public void add(String s) 
   {
      root = add(root, s);
      size++;
   }
   
   /*First, we check if t == null. This is the base case, and t is equal to null, we create a new TreeNode and return this node. Then, we check
   if s.compareTo(t.getValue()) is less than or equal to 0. This would mean that the value belongs to the left of the current node. Inside this if statement,
   we call add on t.getLeft(). Whatever TreeNode this call returns will be the node that belongs to the left of the current node, with the new 
   node accurately placed within the tree. We do the same when s.compareTo(t.getValue()) would end up being greater than 0. Here, we go right
   instead of left and set the current node's right to the call of add on t.getRight(). Then we return t.*/
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
   
   //Call display on the root field and the level 0
   public String display()
   {
      return display(root, 0);  
   }
   
   /*Recursively calls display through the tree, adding \t and\n so that the tree that gets outputted actualy kind of looks like a tree.*/
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
   
   //Call contains with the root field and the object passed in the argument to search for
   public boolean contains( String obj)
   {
      return contains(root, obj);
   }
   
   /*First we create a boolean to store whether or not the boolean has been found. Then, we check if t == null and we return false if it is. We
   have our base case which is if t.getValue() is equal to x. If it is, we return true since we know the string is contained within the tree. 
   Then we check whether to go to the left or right based on the compareTo and set the boolean we created to the recursive call of either left
   or right. This boolean will be equal to true if found or false if not found, from the initial call. Then we return this variable.*/
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
   
   //Call min on the root field
   public String min()
   {
      return min(root);
   }
   
   /*In a binary search tree, the min is going to be the node that is all the way to the left. First, we check if t==null and return null if it is. 
   Then, we use a while loop that goes while t.getLeft() is not equal null. In this while loop, we continually set t to t.getLeft(). Once 
   this while loop has finished, we will have the left most leaf as t. So we cast it's value as a string, and return it. */
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

  //Call max on the root field
   public String max()
   {
      return max(root);
   }
   
   /*In a binary search tree, the max is going to be the node all the way to the right. First, we check if t==null and return null if it is. Then
   we have an if statement base case that checks if t.getRight() == null. If this is true, it means we have found the max since it would be the 
   right most node, so we cast the current nodes value as a String and return it. After the base case, we return the call of max on t.getRight().
   This call will return the max of the subtree below it, so once the initial call has been finished, we will have returned the max of the entire
   tree.*/
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
   
   //Call toString on the root field
   public String toString()
   {
      return toString(root);
   }
   
/*We first create a blank String. Then, we have our base case which is if t is equal to null, and if it is, we return an empty String.
   Since it is an inorder traversal, we first add the left node's string, then the current node's, and then the right node's. We recursively 
   call inorderTraverse on both the left and right nodes of the current node so that we reach every node in the entire tree and everything
   is printed in the correct order. After adding all these strings we return the string, which based off of the initial call, will eventually
   hold the letters obtained from an inorder traversal.*/
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

// Name: S2-17
// Date: 2/19/20
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
   /*Sets the root field to the call of addBalanced on the root field and the String given as an argument. Then we increase size by 1 because
   we are adding a node.*/
   public void addBalanced(String item)
   {
      root = addBalanced(root, item);
      size++;
   }
   
   /*First, we normally add the note to the BST. We check if t == null. This is the base case, and t is equal to null, we create a new TreeNode and
   return this node. Then, we check if s.compareTo(t.getValue()) is less than or equal to 0. This would mean that the value belongs to the left of 
   the current node. Inside this if statement, we call add on t.getLeft(). Whatever TreeNode this call returns will be the node that belongs to the 
   left of the current node, with the new node accurately placed within the tree. We do the same when s.compareTo(t.getValue()) would end up being 
   greater than 0. Here, we go right instead of left and set the current node's right to the call of add on t.getRight(). Once we add the node, as
   we go back up the recursive stack, we check to see if the tree is balanced. We create a new variable called balanceFactor and set to the call
   of getBalanceFactor on the current node t. Next, we must determine whether we must rotate and how to rotate. First, we check if the tree is
   right heavy (balanceFactor > 1). If it is, we check if the right subtree is left heavy and if it is, we perform a double left rotation on the
   tree, and return the new balanced tree. A double left rotation is one left rotation then one right rotation. We first set t to the call of
   leftRotate on t then return just the call of rightRotate on t. If it is right heavy, then we perform a single left rotation and return this new balanced tree. Next,
   we have an else if that checks if it is a left heavy tree (balanceFactor < -1). If it is, we check if the left subtree is right heavy, and if
   it is, we perform a double right rotation on the tree, and return the new balanced tree. A double right rotation is one right rotation then
   one left rotation. We first set t to the call of rightRotate on t then return just the call of leftRotate on t. If it is left heavy, then we perform a single right 
   rotation and return this new balanced tree. If the tree isn't left heavy or right heavy, it means that the tree is balanced as it is, so we
   just return the current node. This method will balance the tree during each recursive call and will always ensure that the tree is balanced.*/
   private TreeNode addBalanced(TreeNode t, String item)
   {
      if(t == null)
      {
         t = new TreeNode(item);
         return t;
      }
      if(item.compareTo((String)t.getValue()) <= 0)
      {
         t.setLeft(addBalanced(t.getLeft(), item));
      }
      else
      {
         t.setRight(addBalanced(t.getRight(), item));
      }
      int balanceFactor = getBalanceFactor(t);
      
      if(balanceFactor > 1 )
      {
         if(getBalanceFactor(t.getRight()) < -1)
         {
            t = leftRotate(t);
            return rightRotate(t);
         }
         else
         {
            return leftRotate(t);
         }
      }
      
      else if(balanceFactor < -1)
      {
         if(getBalanceFactor(t.getLeft()) > 1)
         {
            t = rightRotate(t);
            return leftRotate(t);
         }
         else
         {
            return rightRotate(t);
         }
      }
      
      return t;
      /*IF t*/
   }
   
   /*This method returns the balance factor, which is the difference in height between the right and left subtrees. We check if t isn't null
   and return the height of the right node minus the height of the left node. If t is null, we return 0.*/
   public int getBalanceFactor(TreeNode t)
   {
      if(t != null)
      {
         return height(t.getRight()) - height(t.getLeft());
      }
      return 0;
   }
   
   /*First, we check if t is equal to null, and if it is, we return -1. Then we create two variables to store the height of the left and right
    side individually. Our base case is if both the left and right are equal null and if it is, it means that there are no node under it to create
    a height so we just return 0. If the code continues, it means that there are more nodes remaining below, so we make sure left and right aren't
    null and if they aren't, we set the respective variable to the recursive call of height() on either left or right. Then, we check to see
    which one, left or right, is greater than the other, so we can find the greatest height so far. We add 1 because when we checked if both left
    and right were null we returned 0, so we have to add 1 to recompensate and make everything correct. From the initial call, we will have the
    final and correct height for the entire tree.*/
   public int height(TreeNode t)
   {  
      if(t == null)
      {
         return -1;
      }
      int left = 0;
      int right = 0;
      if(t.getLeft() == null && t.getRight() == null)
      {
         return 0;
      }
      if(t.getLeft() != null)
      {
         left = height(t.getLeft());
      }
      if(t.getRight() != null)
      {
         right = height(t.getRight());
      }
      
      if(left > right)
      {
         return left + 1;
      }
      return right + 1;
   }
   
   /*This method will right rotate the tree and will return the new root of the tree. First, we store the node to the left of t. Then we
   store the node to the right of this node. Then we set the left of t to the right of its former left. Then we set the former left's right
   to t. This means leftOfParent is the new root, this node's former right is now the left of t, and leftOfParent's right is now t. This rotates
   the tree to right, and, lastly, we return leftOfParent, the new root.*/
   public TreeNode rightRotate(TreeNode t)
   {
      TreeNode leftOfParent = t.getLeft();
      TreeNode rightOfLeftOfParent = leftOfParent.getRight();
      t.setLeft(rightOfLeftOfParent);
      leftOfParent.setRight(t);
      return leftOfParent;
   }
   
   /*This method will left rotate the tree and will return the new root of the tree. First, we store the node to the right of t. Then we
   store the node to the left of this node. Then we set the right of t to the left of its former right. Then we set the former right's left
   to t. This means rightOfParent is the new root, this node's former left is now the right of t, and rightOfParents's left is now t. This rotates
   the tree to left, and, lastly, we return rightOfParent, the new root.*/
   public TreeNode leftRotate(TreeNode t)
   {
      TreeNode rightOfParent = t.getRight();
      TreeNode leftOfRightOfParent = rightOfParent.getLeft();
      t.setRight(leftOfRightOfParent);
      rightOfParent.setLeft(t);
      return rightOfParent;
   }
   
   public void remove(String target)
   {
      root = remove(root, target);
      size--;
   }
   
   private TreeNode remove(TreeNode current, String target)
   {
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
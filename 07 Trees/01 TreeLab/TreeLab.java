// Name: S2-17
// Date: 1/30/2020

import java.util.*;

public class TreeLab
{
   public static TreeNode root = null;
   public static String s = "XCOMPUTERSCIENCE";
   //public static String s = "XThomasJeffersonHighSchool"; 
   //public static String s = "XAComputerScienceTreeHasItsRootAtTheTop";
   //public static String s = "XA";   //comment out lines 44-46 below
   //public static String s = "XAF";  //comment out lines 44-46 below
   //public static String s = "XAFP";  //comment out lines 44-46 below
   //public static String s = "XDFZM";  //comment out lines 44-46 below 
   
   public static void main(String[] args)
   {
      root = buildTree( root, s );
      System.out.print( display( root, 0) );
   
      System.out.print("\nPreorder: " + preorderTraverse(root));
      System.out.print("\nInorder: " + inorderTraverse(root));
      System.out.print("\nPostorder: " + postorderTraverse(root));
   
      System.out.println("\n\nNodes = " + countNodes(root));
      System.out.println("Leaves = " + countLeaves(root));
      System.out.println("Only children = " + countOnlys(root));
      System.out.println("Grandparents = " + countGrandParents(root));
   
      System.out.println("\nHeight of tree = " + height(root));
      System.out.println("Longest path = " + longestPath(root));
      System.out.println("Min = " + min(root));
      System.out.println("Max = " + max(root));	
   
      System.out.println("\nBy Level: ");
      System.out.println(displayLevelOrder(root));
   }
 
   public static TreeNode buildTree(TreeNode root, String s)
   {
      root = new TreeNode("" + s.charAt(1), null, null);
      for(int pos = 2; pos < s.length(); pos++)
         insert(root, "" + s.charAt(pos), pos, 
            (int)(1 + Math.log(pos) / Math.log(2)));
      insert(root, "A", 17, 5); 
      insert(root, "B", 18, 5); 
      insert(root, "C", 37, 6); //B's right child
      return root;
   }

   public static void insert(TreeNode t, String s, int pos, int level)
   {
      TreeNode p = t;
      for(int k = level - 2; k > 0; k--)
      {
         if((pos & (1 << k)) == 0)
            p = p.getLeft();
         else
            p = p.getRight();
      }
      if((pos & 1) == 0)
         p.setLeft(new TreeNode(s, null, null));
      else
         p.setRight(new TreeNode(s, null, null));
   }
   
   private static String display(TreeNode t, int level)
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
   
   /*We first create a blank String. Then, we have our base case which is if t is equal to null, and if it is, we return an empty String.
   Since it is a preorder traversal, we first add the current node's string, then the left node's, and then the right node's. We recursively 
   call preorderTraverse on both the left and right nodes of the current node so that we reach every node in the entire tree and everything
   is printed in the correct order. After adding all these strings we return the string, which based off of the initial call, will eventually
   hold the letters obtained from a preorder traversal.*/
   public static String preorderTraverse(TreeNode t)
   { 
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";              //preorder visit
      toReturn += preorderTraverse(t.getLeft());   //recurse left
      toReturn += preorderTraverse(t.getRight());  //recurse right
      return toReturn;
   }
   
   /*We first create a blank String. Then, we have our base case which is if t is equal to null, and if it is, we return an empty String.
   Since it is an inorder traversal, we first add the left node's string, then the current node's, and then the right node's. We recursively 
   call inorderTraverse on both the left and right nodes of the current node so that we reach every node in the entire tree and everything
   is printed in the correct order. After adding all these strings we return the string, which based off of the initial call, will eventually
   hold the letters obtained from an inorder traversal.*/
   public static String inorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += inorderTraverse(t.getLeft());
      toReturn += t.getValue() + " "; 
      toReturn += inorderTraverse(t.getRight());
      return toReturn;
   }
   
   /*We first create a blank String. Then, we have our base case which is if t is equal to null, and if it is, we return an empty String.
   Since it is an postorder traversal, we first add the left node's string, then the right node's, and then the current node's. We recursively 
   call postorderTraverse on both the left and right nodes of the current node so that we reach every node in the entire tree and everything
   is printed in the correct order. After adding all these strings we return the string, which based off of the initial call, will eventually
   hold the letters obtained from an postorder traversal.*/
   public static String postorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += postorderTraverse(t.getLeft());
      toReturn += postorderTraverse(t.getRight());
      toReturn += t.getValue() + " "; 
      return toReturn;
   }
   
   /*First, we create a count variable that will store the number of nodes in the current call. Then, we have our base case which is if t is
   null, and if it is, we just return 0 because there would be no nodes there. Then, we call countNodes on both the left and right of the current
   node (which counts up all the nodes below the current node) and add these numbers to count. Then, we have to add 1 for the current node and 
   we return count.*/
   public static int countNodes(TreeNode t)
   {
      int count = 0;
      if(t == null)
      {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
         return 0;
      }
      count += countNodes(t.getLeft());
      count += countNodes(t.getRight());
      count++;
      return count;
   }
   
   /*We create a count variable. Then, we check if both left and right are null which would mean that it is a leaf. If it is a leaf, then we add
   1 to count and return count because there would be no nodes to recur more for since there are no nodes under a leaf. If it is not a leaf, we
   proceed with 2 if statements that check if left and right are null. In each of these cases, we recursively call countLeaves on the left or right
   and add the number that it returns to count. Once these 2 if statements have finished we will have all the leaves that are contained under the 
   current node. Then, we return count. From the initial call, we would return all the leaves in the entire tree.*/
   public static int countLeaves(TreeNode t)
   {
      int count = 0;
      if(t.getLeft() == null && t.getRight() == null)
      {
         count++;
         return count;
      }
      if(t.getLeft() != null)
      {
         count += countLeaves(t.getLeft());
      }
      if(t.getRight() != null)
      {
         count += countLeaves(t.getRight());
      }
      return count;
   }
   
   /*  there are clever ways and hard ways to count grandparents  */ 
   
   /*We create a count variable. Then, we check if the height of the current node is greater than or equal to 2. If the height of the current
   node greater than or equal to 2, then it means that the node is a grandparent, so we increase count by 1. If it is not a grandparent, we 
   proceed with 2 if statements that check if left and right are null. In each of these cases, we recursively call countGrandParents on the 
   left or right and add the number that it returns to count. Once these 2 if statements have finished we will have all the grandparents
   that are contained under the current node. Then, we return count. From the initial call, we would return all the leaves in the entire tree.*/
   public static int countGrandParents(TreeNode t)
   {
  
      int count = 0;
      if(height(t) >= 2)
      {
         count++;
      }
      if(t.getLeft() != null)
      {
         count += countGrandParents(t.getLeft());
      }
      if(t.getRight() != null)
      {
         count += countGrandParents(t.getRight());
      }
      return count;
      
   }
   
   /*We create a count variable. We check if the current node either has a child in left and no child in right, or if it has a child in right
   and no child in left. If this is true, it means there is an only child, and we add 1 to count. Then we check if left is null and if right is
   null and in each of these if statements we add the number that the recursive call returns to count. Then, once all the recursive calls have 
   returned, we will have the number of only children that the subtree under the current node contains, and we return this value. From the initial
   call, we will have the only children that the entire tree contains.*/
   public static int countOnlys(TreeNode t)
   {
      int count = 0; 
      if((t.getLeft() != null && t.getRight() == null) || (t.getLeft() == null && t.getRight() != null))
      {
         count++;
      }
      if(t.getLeft() != null)
      {
         count += countOnlys(t.getLeft());
      }
      if(t.getRight() != null)
      {
         count += countOnlys(t.getRight());
      }
      return count;
   }
   
  /* returns the max of the heights to the left and the heights to the right  
     returns -1 in case the tree is null
    */
    
    /*First, we check if t is equal to null, and if it is, we return -1. Then we create two variables to store the height of the left and right
    side individually. Our base case is if both the left and right are equal null and if it is, it means that there are no node under it to create
    a height so we just return 0. If the code continues, it means that there are more nodes remaining below, so we make sure left and right aren't
    null and if they aren't, we set the respective variable to the recursive call of height() on either left or right. Then, we check to see
    which one, left or right, is greater than the other, so we can find the greatest height so far. We add 1 because when we checked if both left
    and right were null we returned 0, so we have to add 1 to recompensate and make everything correct. From the initial call, we will have the
    final and correct height for the entire tree.*/
   public static int height(TreeNode t)
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
   
 /* return the max of the sum of the heights to the left and the heights to the right  
 */
 
 /*We find the height of the left and right nodes individually using the height method on t.getRight() and t.getLeft(). This will
 give us the longest path on the left and right sides. Then, we add 1 to each of these because of the path from both of these nodes to the 
 root node. Then, once we add these 2 numbers together, we would get the length of the connected longest path around the entire tree. Then we
 return the sum of these 2 numbers.*/
   public static int longestPath(TreeNode t)
   {
      int rightHeight = height(t.getRight()) + 1;
      int leftHeight = height(t.getLeft()) + 1;
      return rightHeight + leftHeight;
   }
   
   /*  Object must be cast to Comparable in order to call .compareTo  
    */
    
    /*First, we have our base case which is if both the right and left are null which would mean that the current node is a leaf. If it is a leaf,
    then we just return the current value, since there is no other node below us to compare to, so that we can return the min. Then, we create 3
    Comparable variables one to store the current node's value, and two to store for the mins from the left and right side. We set the current
    node's value to t.getValue() but we cast it as a Comparable because we have to use compareTo(). Then, to get the left min, we make sure
    the left isn't null, and set the Comparable variable we created and set it to the recursive call of min on t.getLeft(), and if it is null,
    then we set leftNum to the same thing as t.getValue(). Setting it to the same thing as the other variable makes no difference as when we
    compare them, the same value would get produced either way. The same thing is done with the right side and we get a value for the right side
    variable. Then, we compare all of these to figure out which one is lower than both of the others, and we return this value.*/
   @SuppressWarnings("unchecked")
   public static Object min(TreeNode t)
   {
      if(t.getLeft() == null && t.getRight() == null) 
      {
         return t.getValue(); 
      }
      
      Comparable current = (Comparable)t.getValue(); 
      Comparable leftNum;
      Comparable rightNum;
      if(t.getLeft() != null)
      {
         leftNum = (Comparable)min(t.getLeft()); 
      }
      else
      {
         leftNum = (Comparable)t.getValue();
      }
      
      if(t.getRight() != null)
      {
         rightNum = (Comparable)min(t.getRight()); 
      }
      else
      {
         rightNum = (Comparable)t.getValue();
      } 
   
      if(leftNum.compareTo(rightNum) < 0 && leftNum.compareTo(current) < 0)
      { 
         return leftNum;
      }
      if(rightNum.compareTo(leftNum) < 0 && rightNum.compareTo(current) < 0)
      { 
         return rightNum;
      }
   
      return current; 
   }
   
   /*  Object must be cast to Comparable in order to call .compareTo  
    */
    /*First, we have our base case which is if both the right and left are null which would mean that the current node is a leaf. If it is a leaf,
    then we just return the current value, since there is no other node below us to compare to, so that we can return the max. Then, we create 3
    Comparable variables one to store the current node's value, and two to store for the maxes from the left and right side. We set the current
    node's value to t.getValue() but we cast it as a Comparable because we have to use compareTo(). Then, to get the left max, we make sure
    the left isn't null, and set the Comparable variable we created and set it to the recursive call of max on t.getLeft(), and if it is null,
    then we set leftNum to the same thing as t.getValue(). Setting it to the same thing as the other variable makes no difference as when we
    compare them, the same value would get produced either way. The same thing is done with the right side and we get a value for the right side
    variable. Then, we compare all of these to figure out which one is higher than both of the others, and we return this value.*/
   @SuppressWarnings("unchecked")
   public static Object max(TreeNode t)
   {
      if(t.getLeft() == null && t.getRight() == null) 
      {
         return t.getValue(); 
      }
      
      Comparable current = (Comparable)t.getValue(); 
      Comparable leftNum;
      Comparable rightNum;
      if(t.getLeft() != null)
      {
         leftNum = (Comparable)max(t.getLeft()); 
      }
      else
      {
         leftNum = (Comparable)t.getValue();
      }
      
      if(t.getRight() != null)
      {
         rightNum = (Comparable)max(t.getRight()); 
      }
      else
      {
         rightNum = (Comparable)t.getValue();
      } 
   
      if(leftNum.compareTo(rightNum) > 0 && leftNum.compareTo(current) > 0)
      { 
         return leftNum;
      }
      if(rightNum.compareTo(leftNum) > 0 && rightNum.compareTo(current) > 0)
      { 
         return rightNum;
      }
   
      return current; 
   }
      
   /* This method is not recursive.  Use a local queue
    * to store the children of the current TreeNode.
    */
    
    /*First we create a temporary TreeNode that is equal to t, a queue to store the children of the current TreeNode, and a blank String. 
    Then, we add t to the queue. We use a while loop to iterate while the q is not empty. In this while, we set temp to q.remove(), then we
    add this node to the string. We have an if statement that checks if the left is null and if it isn't it adds it to the queue, and then it
    does the same for the right. The next time through, it will print the left node that was in the queue, and then adds the children of that
    left node to the queue. Then the next time through it will print the right node and add the children of the right node to the queue. Since 
    it is a queue, it maintains the order of when we add it to the queue, so in the end, everything will be printed in the order that we add
    them, and since we add nodes from left to right, the final queue ends up being in the order thatn we want. After the while loop finishes, we
    return the string.*/
   public static String displayLevelOrder(TreeNode t)
   {
      TreeNode temp = t;
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      String toReturn = "";
      q.add(temp);
      while(!q.isEmpty())
      {
         temp = q.remove();
         toReturn += temp.getValue();
         if(temp.getLeft() != null)
         {
            q.add(temp.getLeft());
         }
         if(temp.getRight() != null)
         {
            q.add(temp.getRight());
         }
      }
      return toReturn;
   }
}

/***************************************************
    ----jGRASP exec: java TreeLab
 		  	E
 		E
 			C
 	M
 			N
 		T
 			E
 C*
 			I
 		U
 			C
 	O*
 			S*
 					C
 				B
 		P*
 				A
 			R
 
 Preorder: C O P R A S B C U C I M T E N E C E 
 Inorder: R A P B C S O C U I C E T N M C E E 
 Postorder: A R C B S P C I U O E N T C E E M C 
 
 Nodes = 18
 Leaves = 8
 Only children = 3
 Grandparents = 5
 
 Height of tree = 5
 Longest path = 8
 Min = A
 Max = U
 
 By Level: 
 COMPUTERSCIENCEABC    
 *******************************************************/

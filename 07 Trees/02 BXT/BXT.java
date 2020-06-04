// Name: S2-17
// Date: 2/8/20

import java.util.*;

public class BXT
{
   private TreeNode root;
   
   public BXT()
   {
      root = null;
   }
    
    /*First, we call split based on the spaces between the operands and then store it in a String array. Then we create a stack that stores
    TreeNodes. We use a for each loop to iterate through the String array and in this for each, we first check if it isn't an operator (it is
    a number). If it is, we add a new TreeNode that stores the current String to the stack. If it is an operator, then we pop 2 items off the
    stack. These will be the children of the new TreeNode we create. We push onto the stack a new TreeNode that stores the current String, and
    has the 2 items we popped off the stack as the left and right. Once the for each loop has finished, there will be one TreeNode left
    on the stack which will be the root of the tree, so we pop it off and set root equal to this node.*/
   public void buildTree(String str)
   {
      String[] strArray = str.split(" ");
      Stack<TreeNode> stack = new Stack<TreeNode>();
      for(String s: strArray)
      {
         if(!isOperator(s))
         {
            stack.push(new TreeNode(s));
         }
         else
         {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            stack.push(new TreeNode(s, left, right));
         }
      }    
      root = stack.pop(); 	
   }
   
   public double evaluateTree()
   {
      return evaluateNode(root);
   }
   
   /*We create a double variable that will store the value of the tree below the current node, based off of the operators. The base case of 
   this recursive method is if the current value is not an operator. If it isn't we convert the number to a double and return it. If it wasn't
   a number, it is an operator, so to the variable we created we add the call of the computeTerm method with the current node as the operator 
   string, and we recursively call evaluateNode on the left and right node as the values we are performing the operations on. These calls will 
   return the values of the subtree to the left and right of the current node. Then we return the variable we created. When all the recursion is 
   finished, in the initial call we will have the variable we created be equal to the answer of the entire expression tree.*/
   private double evaluateNode(TreeNode t)  //recursive
   {
      double value = 0;
      if(!isOperator((String)t.getValue()))
      {
         value = Double.parseDouble((String)t.getValue());
         return value;
      }
      else
      {
         value += computeTerm((String)t.getValue(), evaluateNode(t.getLeft()), evaluateNode(t.getRight()));
      }
      return value;
   }
   
   /*We check which type of operator it is, and perform the appropriate operation by using the operator.*/
   private double computeTerm(String s, double a, double b)
   {
      if(s.equals("+"))
      {
         return a + b;
      }
      else if(s.equals("-"))
      {
         return a - b;
      }
      else if(s.equals("*"))
      {
         return a * b;
      }
      else
      {
         return a / b;
      }
   }
   
   /*If it s is equal to a +, -, *, or /, we return true, otherwise we return false.*/
   private boolean isOperator(String s)
   {
      if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
         return true;
      return false;
   }
   
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
   
   
   public String inorderTraverse()
   {
      return inorderTraverse(root);
   }
   
   /*We first create a blank String. Then, we have our base case which is if t is equal to null, and if it is, we return an empty String.
   Since it is an inorder traversal, we first add the left node's string, then the current node's, and then the right node's. We recursively 
   call inorderTraverse on both the left and right nodes of the current node so that we reach every node in the entire tree and everything
   is printed in the correct order. After adding all these strings we return the string, which based off of the initial call, will eventually
   hold the letters obtained from an inorder traversal.*/
   private  String inorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += inorderTraverse(t.getLeft());
      toReturn += t.getValue() + " "; 
      toReturn += inorderTraverse(t.getRight());
      return toReturn;
   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);
   }
   
      /*We first create a blank String. Then, we have our base case which is if t is equal to null, and if it is, we return an empty String.
   Since it is a preorder traversal, we first add the current node's string, then the left node's, and then the right node's. We recursively 
   call preorderTraverse on both the left and right nodes of the current node so that we reach every node in the entire tree and everything
   is printed in the correct order. After adding all these strings we return the string, which based off of the initial call, will eventually
   hold the letters obtained from a preorder traversal.*/
   private String preorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";              //preorder visit
      toReturn += preorderTraverse(t.getLeft());   //recurse left
      toReturn += preorderTraverse(t.getRight());  //recurse right
      return toReturn;
   }
   
  /* extension */
   // public String inorderTraverseWithParentheses()
   // {
      // return inorderTraverseWithParentheses(root);
   // }
//    
   // private String inorderTraverseWithParentheses(TreeNode t)
   // {
      // return "";
   // }
}

/***************************************

 Postfix Exp: 14 -5 /
 	-5
 /
 	14
 Infix order:  14 / -5 
 Prefix order:  / 14 -5 
 Evaluates to -2.8
 ------------------------
 Postfix Exp: 20.0 3.0 -4.0 + *
 		-4.0
 	+
 		3.0
 *
 	20.0
 Infix order:  20.0 * 3.0 + -4.0 
 Prefix order:  * 20.0 + 3.0 -4.0 
 Evaluates to -20.0
 ------------------------
 Postfix Exp: 2 3 + 5 / 4 5 - *
 		5
 	-
 		4
 *
 		5
 	/
 			3
 		+
 			2
 Infix order:  2 + 3 / 5 * 4 - 5 
 Prefix order:  * / + 2 3 5 - 4 5 
 Evaluates to -1.0
 ------------------------
 Postfix Exp: 5.6
 5.6
 Infix order:  5.6 
 Prefix order:  5.6 
 Evaluates to 5.6
 ------------------------
 
 *******************************************/
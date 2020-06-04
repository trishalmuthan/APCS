// Name: S2-17
// Date: 2/27/20
import java.util.*;

interface BSTinterface<E>
{
   public int size();
   public boolean contains(E element);
   public E add(E element);
   public E addBalanced(E element);
   public E remove(E element);
   public String min();
   public String max();
   public String display();
   public String toString();
   public ArrayList<E> toList();  //returns an in-order list of E
}

/*******************
  Copy your BST code.  Implement generics.
**********************/
public class BST_Generic<E extends Comparable<E>> implements BSTinterface<E>
{

}

/*******************
  Copy your TreeNode code.  Implement generics.
**********************/
class TreeNode<E>
{
    
   private E value; 
   private TreeNode<E> left, right;
   
   public TreeNode(E initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }
   
   public TreeNode(E initValue, TreeNode<E> initLeft, TreeNode<E> initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   }
   
   public E getValue()
   { 
      return value; 
   }
   
   public TreeNode<E> getLeft() 
   { 
      return left; 
   }
   
   public TreeNode<E> getRight() 
   { 
      return right; 
   }
   
   public void setValue(E theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode<E> theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode<E> theNewRight)
   { 
      right = theNewRight;
   }
   

}
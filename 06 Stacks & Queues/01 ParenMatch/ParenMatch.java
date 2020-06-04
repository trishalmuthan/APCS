// Name: S2-17
// Date: 1/6/2020

import java.util.*;

public class ParenMatch
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   
   public static void main(String[] args)
   {
      System.out.println("Parentheses Match");
      ArrayList<String> parenExp = new ArrayList<String>();
      /* enter test cases here */
      
      parenExp.add("5+7");
      parenExp.add("(5+7)");
      parenExp.add(")5+7(");
      parenExp.add("((5+7)*3)");
      parenExp.add("<{5+7}*3>");
      parenExp.add("[(5+7)*]3");
      parenExp.add("(5+7)*3");
      parenExp.add("5+(7*3)");
      parenExp.add("((5+7)*3");
      parenExp.add("[(5+7]*3)");
      parenExp.add("[(5+7)*3])");
      parenExp.add("([(5+7)*3]");  
      parenExp.add("()5+7[{}]");    
   
      for( String s : parenExp )
      {
         boolean good = checkParen(s);
         if(good)
            System.out.println(s + "\t good!");
         else
            System.out.println(s + "\t BAD");
      }
   }
   
   /*First, we create a new Stack that stores String objects. We use a for loop to loop through the String given in the
   argument. First, we check if RIGHT contains the char, but the stack is empty. This would mean there are extra right 
   grouping symbols so we return false. If this is not true, we go to the next else if which checks if RIGHT contains the
   char. Inside here, we check if the index of that char in RIGHT is the same as the index of the left type of char in LEFT. If they are the 
   same index, it means that the type of grouping symbol is the same. We use the peek method to look at the top item in the
   stack to find the index of the left type of symbol. If this is true, we pop off the top item in the stack and we will have
   found the left grouping symbol that matches the right one. If this is not true, we return false because it means the grouping symbols
   are out of order. In the last else if, we check if LEFT contains the char (which means it is a left grouping symbol), and if it does, 
   we add that char to the top of the stack. After this loop is done, we will either have an empty stack, which
   means every left grouping symbol has been matched to a right one, we could have returned false, which either means that there is an extra right 
   symbol but no left symbol to match it or that the grouping symbols are out of order, or we would end with a filled stack, which means there 
   is an unmatched left symbol. We check if the stack is empty, and if it is, we return true, and if not, we return false.*/
   public static boolean checkParen(String exp)
   {
      Stack<String> stack = new Stack<String>();
      for(int x = 0; x < exp.length(); x++)
      {
         if(RIGHT.contains("" + exp.charAt(x)) && stack.isEmpty())
         {
            return false;
         }
         
         else if(RIGHT.contains("" + exp.charAt(x)))
         {
            if(RIGHT.indexOf("" + exp.charAt(x)) == LEFT.indexOf("" + stack.peek()))
            {
               stack.pop();
            }
            else
            {
               return false;
            }
         }
         
         else if(LEFT.contains("" + exp.charAt(x)))
         {
            stack.push("" +exp.charAt(x));
         }
      }
      
      if(stack.isEmpty())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}

/*
 Parentheses Match
 5+7	 good!
 (5+7)	 good!
 )5+7(	 BAD
 ((5+7)*3)	 good!
 <{5+7}*3>	 good!
 [(5+7)*]3	 good!
 (5+7)*3	 good!
 5+(7*3)	 good!
 ((5+7)*3	 BAD
 [(5+7]*3)	 BAD
 [(5+7)*3])	 BAD
 ([(5+7)*3]	 BAD
 */

// Name: S2-17
// Date: 1/13/20

import java.util.*;

public class Infix
{
   public static void main(String[] args)
   {
      System.out.println("Infix  \t-->\tPostfix\t\t-->\tEvaluate");
     /*build your list of Infix expressions here  */
      ArrayList<String> infixExp = new ArrayList<String>();
      infixExp.add("3 + 4 * 5");
      infixExp.add("3 * 4 + 5");
      infixExp.add("( -5 + 15 ) - 6 / 3");
      infixExp.add("( 3 + 4 ) * ( 5 + 6 )");
      infixExp.add("( 3 * ( 4 + 5 ) - 2 ) / 5");
      infixExp.add("8 + -1 * 2 - 9 / 3");
      infixExp.add("3 * ( 4 * 5 + 6 )");
      infixExp.add("3 * ( 4 * 5 - 6 + 2 )");
      infixExp.add("2 * 2 ^ 3");
      infixExp.add("( 2 * 2 ) ^ ( 3 + 10 )");
      infixExp.add("( 2 * ( 2 + 3 ) ) ^ ( 1 + 1 )");
      for( String infix : infixExp )
      {
         String pf = infixToPostfix(infix);  //get this to work first
         System.out.println(infix + "\t\t\t" + pf + "\t\t\t" + Postfix.eval(pf));  //Postfix must work!
      }
   }
   
   /*First, we create a String toReturn and a stack to store operators. Then we use a for each loop to loop through every String in
   infixParts. First, we check if it is an open parentheses, and if it is we just add it to the stack. Next, we check if it is a
   close parentheses and if it is we use a while to keep popping and adding operators from the stack until we reach the open
   parentheses. Then we discard both parentheses. This groups together all the operators between the parentheses so the same order
   of operations is maintained as the infix expression. The next else if uses Postfix to check if the string is an operator. If it
   is, we first check if the stack is empty. Since there would be nothing to pop, you just add the operator to the stack. Then we check
   if the current ch is lower or equal precedence to the top item on the stack. If it is lower or equal precedence, we pop and add the
   top item on the stack to the string and add the current ch to the top of the stack. If it wasn't lower or equal precedence, we just
   add the item to the top of the stack since that operator would have to be done first. This allows the code to function properly
   with order of operations. The final else statement in the loop would be run if ch is a number so we would just add it to toReturn.
   Once the loop is over, we will have looped through the whole expression, and anything else left in the stack would just be added to
   the end of toReturn. Then we return toReturn.*/
   
   public static String infixToPostfix(String infix)
   {
      List<String> infixParts = new ArrayList<String>(Arrays.asList(infix.split(" ")));
      /* enter your code here  */
      String toReturn = "";
      Stack<String> stack = new Stack<String>();
      for(String ch : infixParts)
      {
         if(ch.equals("("))
         {
            stack.push("(");
         }
         else if(ch.equals(")"))
         {
            while(!stack.peek().equals("("))
            {
               toReturn += " " + stack.pop();
            }
            stack.pop();
         }
         else if(Postfix.isOperator(ch))
         {
            if(stack.size() == 0)
            {
               stack.push(ch);
            }
            
            else if(isLowerOrEqual(ch.charAt(0), stack.peek().charAt(0)))
            {
               toReturn += " " + stack.pop();
               stack.push(ch);
            }
            else
            {
               stack.push(ch);
            }
         }
         else
         {
            toReturn += " " + ch;
         } 
      }
      
      
      while(!stack.isEmpty())
      {
         toReturn += " " + stack.pop();
      }
      return toReturn;
    
    
   }
   
   /*First, we check if c2 is some sort of parentheses and since no matter what c1 is, if you find a parentheses at the top of the stack
   you just push on top of the stack. Then, we check if c1 is a + or - and because we already checked for parentheses and + and - is 
   not higher precedence than anything else, you would just return true for both. Next, we check if c1 is a * or a /. If it is, we 
   check if c2 is a *, /, ^ because all of those operators are equal or higher precedence. If c2 is not one of those, it means c1 is 
   higher precedence than c2 so we return false. Then, we have an if statement that checks if c1 is a ^ and because nothing is higher
   precedence than exponents, we return false. Then we just return false in an else statement.*/
   
	//returns true if c1 has lower or equal precedence than c2
   public static boolean isLowerOrEqual(char c1, char c2)
   {
      if(c2 == '(' || c2 == ')')
      {
         return false;
      } 
      else if(c1 == '+')
      {
         return true;
      }    
      
      else if(c1 == '-')
      {
         return true;
      } 
      
      else if(c1 == '*')
      {
         if(c2 == '/' || c2 == '*' || c2 == '^')
         {
            return true;
         }
         else
         {
            return false;
         }
      }    
      
      else if(c1 == '/')
      {
         if(c2 == '/' || c2 == '*' || c2 == '^')
         {
            return true;
         }
         else
         {
            return false;
         }
      }   
      
      else if(c1 == '^')
      {
         return false;
      }
      
      else
      {
         return true;
      } 
      
      
   }
}
	
/********************************************

 Infix  	-->	Postfix		-->	Evaluate
 3 - 4 + 5			3 4 - 5 +			4
 3 + 4 * 5			3 4 5 * +			23
 3 * 4 + 5			3 4 * 5 +			17
 ( -5 + 15 ) - 6 / 3			-5 15 + 6 3 / -			8
 ( 3 + 4 ) * ( 5 + 6 )			3 4 + 5 6 + *			77
 ( 3 * ( 4 + 5 ) - 2 ) / 5			3 4 5 + * 2 - 5 /			5
 8 + -1 * 2 - 9 / 3			8 -1 2 * + 9 3 / -			3
 3 * ( 4 * 5 + 6 )			3 4 5 * 6 + *			78
 3 * ( 4 * 5 - 6 + 2 )			3 4 5 * 6 - 2 + *			48
  
***********************************************/
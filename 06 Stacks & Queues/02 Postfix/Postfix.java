// Name: S2-17
// Date: 1/9/2020

import java.util.*;

public class Postfix
{
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postfixExp = new ArrayList<String>();
      /*  build your list of expressions here  */
      postfixExp.add("3 4 5 * +");
      postfixExp.add("3 4 * 5 +");
      postfixExp.add("10 20 + -6 6 * +");
      postfixExp.add("3 4 + 5 6 + *"); 
      postfixExp.add("3 4 5 + * 2 - 5 /");
      postfixExp.add("8 1 2 * + 9 3 / -");   
      postfixExp.add("2 3 ^");
      postfixExp.add("20 3 %");
      postfixExp.add("21 3 %");
      postfixExp.add("22 3 %");
      postfixExp.add("23 3 %");
      postfixExp.add("5 !");
      postfixExp.add("1 1 1 1 1 + + + + !");
      
      for( String pf : postfixExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   
   /* First, we create a stack that stores Strings. Then we loop through the list using a for each with each String in the list.
   We first check if the String is not an operator (meaning it is a number) and we push this value into the stack. Next, we have
   an else if that checks indvidually if the String is a factorial operator because the way the code runs is different for this
   case compared to all the others. Here, we just take one number by popping the number from the stack, calculating the 
   factorial of this number using the factorial method, and pushing it back on the stack. The last else is for if the String is
   neither a number, nor a !. We pop the top 2 numbers on the stack, and call the eval method on these 2 numbers along with the
   string. The method will evaluate the String, perform the correct operation, and return the correct number. We push this number
   onto the top of the stack. At the end of this method, we will have only one number remaining in the stack, which is the final
   answer, so we parse this String for an Integer, and return it.*/
   
   
   public static int eval(String pf)
   {
      List<String> postfixParts = new ArrayList<String>(Arrays.asList(pf.split(" ")));
      /*  enter your code here  */
      Stack<String> stack = new Stack<String>();
      for(String str : postfixParts)
      {
         if(!isOperator(str))
         {
            stack.push(str);
         } 
         else if(str.equals("!"))
         {
            int n1 = Integer.parseInt(stack.pop());
            stack.push("" + factorial(n1));
         }
         else
         {
            int n1 = Integer.parseInt(stack.pop());
            int n2 = Integer.parseInt(stack.pop());
            stack.push("" + eval(n1, n2, str));
         } 
      }
      return Integer.parseInt(stack.pop());
      
   }
   
   /*First, we create an int variable and just set it to 0 because we know it will be changed later. We have a bunch of if
   statements which check for the type of operator (excluding factorial) and performs the operation. Subtraction, divison, 
   modulus, and exponents, have the b value coming before the a because that is the order in which you perform the operation
   for those cases. For exponents, we have to cast the output of the pow method to an int since the method returns a double.
   At the end, we just return the final value.*/
   public static int eval(int a, int b, String ch)
   {
      int toReturn = 0;
      if(ch.equals("+"))
      {
         toReturn = a+b;
      }
      if(ch.equals("-"))
      {
         toReturn = b-a;
      }
      if(ch.equals("/"))
      {
         toReturn = b/a;
      }
      if(ch.equals("*"))
      {
         toReturn = a*b;
      }
      if(ch.equals("%"))
      {
         toReturn = b%a;
      }
      if(ch.equals("^"))
      {
         toReturn = (int) Math.pow(b, a);
      }
      return toReturn;
      
   }
   /*This factorial method calculates the factorial of the argument. This method is separate from eval because factorial only
   uses 1 argument rather than 2. We create a variable that stores 1, then we loop through while less than the argument and 
   keep multiply by x. Then we return the value. This returns the factorial of the argument inputted.*/
   public static int factorial(int a)
   {
      int toReturn = 1;
      for ( int x = 1; x <= a; x++ ) 
      {
         toReturn*=x;
      }
      return toReturn;
   }
   
   /*We just use an if statement to check the String for whether or not it is one of the special operator symbols. We return
   true if it is, and false if it is not.*/
   public static boolean isOperator(String op)
   {
      if(op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*") || op.equals("^") || op.equals("%") || op.equals("!"))
      {
         return true;
      }
      return false;
   }
}

/**********************************************
Postfix  -->  Evaluate
 3 4 5 * +		23
 3 4 * 5 +		17
 10 20 + -6 6 * +		-6
 3 4 + 5 6 + *		77
 3 4 5 + * 2 - 5 /		5
 8 1 2 * + 9 3 / -		7
 2 3 ^		8
 20 3 %		2
 21 3 %		0
 22 3 %		1
 23 3 %		2
 5 !		120
 1 1 1 1 1 + + + + !		120
 
 
 *************************************/
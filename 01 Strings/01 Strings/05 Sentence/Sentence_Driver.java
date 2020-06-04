// Name: S2-17
// Date: 09/14/19
  
public class Sentence_Driver
{
   public static void main(String[] args)
   {
      System.out.println("PALINDROME TESTER");
      Sentence s = new Sentence( "\"Hello there!\" she said." );
      System.out.println( s.getSentence() );
      System.out.println( s.getNumWords() );
      System.out.println( s.isPalindrome() );
      System.out.println();
      
      s = new Sentence( "A Santa lived as a devil at NASA." );
      System.out.println( s.getSentence() );
      System.out.println( s.getNumWords() );
      System.out.println( s.isPalindrome() );
      System.out.println();
     
      s = new Sentence( "Flo, gin is a sin! I golf." );
      System.out.println( s.getSentence() );
      System.out.println( s.getNumWords() );
      System.out.println( s.isPalindrome() );
      System.out.println();
      
      s = new Sentence( "Lots! Of! Changes!?)]}" );
      System.out.println( s.getSentence() );
      System.out.println( s.getNumWords() );
      System.out.println( s.isPalindrome() );
      System.out.println();
   
      s = new Sentence( "Madam, I'm Adam." );
      System.out.println( s.getSentence() );
      System.out.println( s.getNumWords() );
      System.out.println( s.isPalindrome() );
      System.out.println();
      
   // Lots more test cases.  Test every line of code.  Test
   // the extremes, test the boundaries.  How many test cases do you need?
   

    
   //This test case makes sure it works with a lot of punctuation  
      s = new Sentence( "(re)qrt_trq(er)" );
      System.out.println( s.getSentence() );
      System.out.println( s.getNumWords() );
      System.out.println( s.isPalindrome() );
      System.out.println();
   
   //This test case makes sure it works when there is a space at the beginning
      s = new Sentence( " typewriterretirwepyt" );
      System.out.println( s.getSentence() );
      System.out.println( s.getNumWords() );
      System.out.println( s.isPalindrome() );
      System.out.println();
      
   //This test case makes sure it works with when there is only one misplaced letter   
      s = new Sentence( "rrrrrrrrrrerrrrrrrrr" );
      System.out.println( s.getSentence() );
      System.out.println( s.getNumWords() );
      System.out.println( s.isPalindrome() );
      System.out.println();
      
   }
}

class Sentence
{
   private String mySentence;
   private int myNumWords;
   
   //Precondition:  str is not empty.
   //               Words in str separated by exactly one blank.
   
   //First we, set the mySentence field equal to the argument. To find the number
   //of word, we first use a while loop to replace every back to back space with
   //a single space so that we don't get extra words. We, also get rid of a space at the beginning of the word 
   //if there is one. Then, we split the string into an array by its blank space so that we only get the words 
   //and no blank space at all. To find the actual number, just set myNumWords to the length of the array.
   public Sentence( String str )
   { 
      mySentence = str;
      String[] wordCountArray = str.split(" ");
      myNumWords = wordCountArray.length;
   }
   
   public int getNumWords()
   {  
      return myNumWords;  
   }
   
   public String getSentence()
   {
      return mySentence; 
   }
   
   //Returns true if mySentence is a palindrome, false otherwise.
   
   //First, we make a string finalSentence that is equal to the lowercase version of mySentence
   //Then, we use that same string and remove both the punctuation and the blanks
   //Then we return the boolean that the method isPalindrome returns with the arguments
   //finalSentence (the edited string), 0 (the first index of the string), and finalSentence.length()-1
   //(the last index of the string).
   public boolean isPalindrome()
   {
      String finalSentence = lowerCase(mySentence);
      finalSentence = removeBlanks(finalSentence);
      finalSentence = removePunctuation(finalSentence);
      System.out.println(finalSentence);
      return isPalindrome(finalSentence, 0, finalSentence.length()-1);
   }
   //Precondition: s has no blanks, no punctuation, and is in lower case.
   //Returns true if s is a palindrome, false otherwise.
   
   //First, we make a boolean finalBool and set it to false. Then, we check if the start argument
   //is greater than or equal to end , because if it is, then we will have checked both halves of
   //the string for similarity, and will set finalBool to true since both sides would be the same.
   //If start isn't greater or equal, then we check if the character at the start index is equal
   //to the character at the end index. If it is, then we change both start and end move one character inward
   //and set finalBool to isPalindrome with arguments of s, start, and end. This restarts the process, continuosly 
   //testing the inner letters. This aspect of the code uses recursion to idenify if the string is a palindrome. 
   //Eventually, boolean values will be returned through the method, and you will get a final, encompassing boolean, 
   //stating cuzwhether its a palindrome or not. Again, this is set to finalBool and returned.
   public static boolean isPalindrome( String s, int start, int end )
   {
      boolean finalBool = false;
      if(start >= end)
         finalBool = true;
      else if(s.charAt(start) == s.charAt(end))
      {
         start++;
         end--;
         finalBool = isPalindrome(s, start, end);
      }
      return finalBool;
   }
   //Returns copy of String s with all blanks removed.
   //Postcondition:  Returned string contains just one word.
   
   //This method uses the replaceAll() method and replaces every " " (blank space)
   //with an empty string.
   public static String removeBlanks( String s )
   {  
      s = s.replaceAll(" ", "");
      return s;
   }
   
   //Returns copy of String s with all letters in lowercase.
   //Postcondition:  Number of words in returned string equals
   //						number of words in s.
   
   //Pretty straight forward. You take the string and make it lowercase and then return it.
   public static String lowerCase( String s )
   {  
      s = s.toLowerCase();
      return s;
   }
   
   //Returns copy of String s with all punctuation removed.
   //Postcondition:  Number of words in returned string equals
   //						number of words in s.
   
   //We go through the each letter in the word and if the punct string contains
   //the letter, that means it is punctuation. If it is, then we replace the 
   //letter with an empty string so it goes away.
   public static String removePunctuation( String s )
   { 
      String punct = ".,'?!:;\"(){}[]<>"; 
      for(int x = 0; x < s.length(); x++)
      {
         if(punct.contains(s.charAt(x) + ""))
         {
            s = s.replace(""+ s.charAt(x), "");
         }
      }
      return s;
   }
}

 /*****************************************
   
 PALINDROME TESTER
 "Hello there!" she said.
 4
 false
 
 A Santa lived as a devil at NASA.
 8
 true
 
 Flo, gin is a sin! I golf.
 7
 true
 
 Eva, can I stab bats in a cave?
 8
 true
 
 Madam, I'm Adam.
 3
 true

 **********************************************/


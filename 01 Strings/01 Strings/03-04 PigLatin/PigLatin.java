// Name: S2-17
// Date: 09/10/19
import java.util.*;
import java.io.*;
public class PigLatin
{
   public static void main(String[] args) 
   {
      //part_1_using_pig();
      part_2_using_piglatenizeFile();
      
      /*  extension only    */
      String str = pig("What!?");
      System.out.print(str + "\t\t" + pigReverse(str));
      str = pig("{(Hello!)}");
      System.out.print("\n" + str + "\t\t" + pigReverse(str));
      str = pig("\"McDonald???\"");
      System.out.println("\n" + str + "  " + pigReverse(str));
   }

   public static void part_1_using_pig()
   {
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("\nWhat word? ");
         String s = sc.next();
         if(s.equals("-1"))
         {
            System.out.println("Goodbye!"); 
            System.exit(0);
         }
         String p = pig(s);
         System.out.println( p );
      }		
   }

   public static final String punct = ",./;:'\"?<>[]{}|`~!@#$%^&*()";
   public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   public static final String vowels = "AEIOUaeiou";
   public static String pig(String s)
   {
      if(s.length() == 0)
         return "";
   
   /*The code below will find the beginning punctuation. We create a string begPunct which will store the
   punctuation to be added later to the final word. We use a for loop to go through the word. If the character at the index 
   0 is contained in the string of letters, this means that it is a letter, meaning there is no remaining beginning 
   punctuation. It will then break out of the for loop. If the character is not contained in the string of letters it will go 
   to the else if where it will go through only if the string of punctuation contains that character. If it does,
   we add it to the begPunct string and remove the first character from s. All the charAt methods in this portion has an argument
   of 0 because the string s keeps getting shortened by the substring method, meaning that it will always check a new first letter.*/
   
      String begPunct = "";
      for(int x = 0; x < s.length(); x++)
      {
         if(letters.contains("" + s.charAt(0)))
         {
            break;
         }
         
         else if(punct.contains("" + s.charAt(0)))
         {
            begPunct += s.charAt(0);
            s = s.substring(1);
         }
      }
       
    /*The code below will find the ending punctuation. The code is very similar to the beginning punctuation code but includes a few
    changes and additions. This portion of code has a for loop that runs from the end of the string. Inside the else if, the character will get
    added to the string backwardsEndPunct and the string will be shortened from the end, with a substring that has arguments of 0 and one less 
    than the length of the string (meaning the last letter won't be included).*/
           
      String backwardsEndPunct = "";
      for(int x = s.length()-1; x >= 0; x--)
      {
         if(letters.contains("" + s.charAt(x)))
         {
            break;
         }
         
         else if(punct.contains("" + s.charAt(x)))
         {
            backwardsEndPunct += s.charAt(x);
            s = s.substring(0, s.length() - 1);
         }
      } 
      
      /*After this part, you will have backwardsEndPunct which will contain all the punctuation at the end but backwards since we started 
      from the end of the string. To correct this, we reverse the string by making it an array and reading it backwards into another 
      string, endPunct, which will contain the proper punctuation.*/
      
      char[] letterArray = backwardsEndPunct.toCharArray();
      String endPunct = "";
      for(int x = letterArray.length - 1; x >= 0; x--)
      {
         endPunct += letterArray[x];
      }
         
    /*The code below will find whether there is a vowel, the index of the vowel (if there is one), if the y case is used, and if the qu case is used.
     We have 3 variables, vowelIndex (stores index), vowelFound (a boolean indicating that there is a vowel), and quFound 
     (a boolean indicating that we have found the qu case). First, there is a loop that goes through all the letters in s.*/
         
      int vowelIndex = -1;
      boolean vowelFound = false;
      boolean quFound = false;
      
      for(int x = 0; x < s.length(); x++)
      {
      
      /*In this loop, we first check whether the qu case is used. To do this, we check if the current character is a type of q, if the next
      character was a type of u, and if the letter after that is a vowel. If all of these are true, then we set the vowelIndex = x, and both the booleans
      equal to true. Then we proceed to break out of the loop. */
      
         if((s.charAt(x) == 'q' || s.charAt(x) == 'Q') && (s.charAt(x+1) == 'u' || s.charAt(x+1) == 'U') && vowels.contains("" + s.charAt(x+2)))
         {
            vowelIndex = x;
            vowelFound = true;
            quFound = true;
            break;
         }
         
         /*The next else if checks if the y case is used by checking if the current character is a type of y, and making sure that that
         it isn't the first character in the word. If these are both true, then we set vowelIndex = x and the vowelFound variable to true. 
         Then we break out of the loop.*/
         
         else if(s.charAt(x) == 'y' || s.charAt(x) == 'Y')
         {
            if(x != 0)
            {
               vowelIndex = x;
               vowelFound = true;
               break;
            }
         }
            
         /*The final else if will check if its just a regular vowel by checking if the vowels string contains the current character. 
         If true, vowelIndex = x, vowelFound is set to true, and we break out of the loop. */
         
         else if(vowels.contains("" + s.charAt(x)))
         { 
            vowelIndex = x;
            vowelFound = true;
            break;
         }
      }
      
     /*We then check if the vowelFound variable has been set to true. If it hasn't, then it means that there was no
     vowel and we return the message telling the user there is no vowel.*/ 
      
      if(!vowelFound)
      {
         return "**** NO VOWEL ****";
      }
      
      /*This section takes care of capitalization. There is a boolean upperLetter that will be set to false if a new string
      which I have created (which contains all capital letters) contains the first letter, meaning it begins with a capital letter*/
                
      boolean upperLetter = false;
      String upperLetters = "ABCEDFGHIJKLMNOPQRSTUVWXYZ";
      if(upperLetters.contains("" + s.charAt(0)))
      {
         upperLetter = true;
      }
      
     /*This next section will do the assembly of the final word. We make 3 new strings to be used in the combination process.
     The first if is for if the first letter is a vowel. If it is a vowel, then all we do is add "way" to the end of the word along with
     punctuation, and then return that, with no other changes.*/ 
      
      String finalString = "";
      String storageString = "";
      String firstLetterString = "";
      if(vowels.contains("" + s.charAt(0)))
      {
         finalString = begPunct + s + "way" + endPunct;
         return finalString;
      }
      
      else
      {
      
      /*This else statement is for if the first letter is not a vowel. First, it will check for if the qu case is used which is dependent upon
      the quFound variable we set before. If it is found, then the string storageString will be set to a substring of s, which goes from
      the beginning to the vowelIndex + 2, since we that qu is 2 letters and functions as a consonant in this case. In the next else,
      storageString is just equal to the substring of s from the beginning to the vowel, not including the vowel. Now, storageString will
      be equal to everything before the first vowel.*/
      
         if(quFound)
         {
            storageString = s.substring(0, vowelIndex + 2);
         }
         else
         {
            storageString = s.substring(0, vowelIndex);
         }
         
         //Then, we use the replaceFirst method to get rid of this first part from the word.  
         
         s = s.replaceFirst(storageString, "");
         
         /* Then, we have another if that checks if the first letter of the word was capital, which is true if the boolean we had set before
         was set equal to true. If it is, then the string firstLetterString is set equal to the uppercase letter of the first letter of the new,
         updated word. Then we set s back to what it was, except with a capitalized first letter, if necessary. Then, we set the first letter of
         storageString to lowercase because the directions say to make it lowercase. */
         
         if(upperLetter)
         {
            firstLetterString = ("" + s.charAt(0)).toUpperCase();
            s = firstLetterString + s.substring(1); 
            storageString = (("" + storageString.charAt(0)).toLowerCase()) + storageString.substring(1);
         }
         
        /*After all of this, we just combine the punctuation at the beginning, 
         the word without the part before the vowel, the part before the vowel, "ay", and the end punctuation in that order. Lastly, we return the
         finalized word*/
      
         
         finalString = begPunct + s + storageString + "ay" + endPunct;
         return finalString;
      }
      
   }


   public static void part_2_using_piglatenizeFile() 
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("input filename including .txt: ");
      String fileNameIn = sc.next();
      System.out.print("output filename including .txt: ");
      String fileNameOut = sc.next();
      piglatenizeFile( fileNameIn, fileNameOut );
      System.out.println("Piglatin done!");
   }


/****************************** 
*  piglatinizes each word in each line of the input file
*    precondition:  both fileNames include .txt
*    postcondition:  output a piglatinized .txt file 
******************************/
   public static void piglatenizeFile(String fileNameIn, String fileNameOut) 
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File(fileNameIn));  
      }
      catch(IOException e)
      {
         System.out.println("oops");
         System.exit(0);   
      }
   
      PrintWriter outfile = null;
      try
      {
         outfile = new PrintWriter(new FileWriter(fileNameOut));
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
      
      
      /* We have a while loop that checks if there is another line in infile. If there is, the string fullLine will be set to that line
      It will then be split based on the spaces in between the words and put into a String array. Then we have a for loop that goes
      through the array and will print the piglatinized current word in outfile. Then, it will check to make sure that this isn't the
      last item of the array and prints a space afterwards. If it is the last item, then we will send it to the next line and break out
      of the for loop.*/
      
      String fullLine = "";
      while(infile.hasNextLine())
      {
         fullLine = infile.nextLine();
         String[] wordStoreArray = fullLine.split(" ");
         for(int x = 0; x < wordStoreArray.length; x++)
         {
            outfile.print(pig(wordStoreArray[x]));
            if(x != wordStoreArray.length-1)
            {
               outfile.print(" ");
            }
            else
            {
               outfile.println();
               break;
            }
         }
      }
      
      outfile.close();
      infile.close();
   }
   
   
   
   /** EXTENSION: Output each PigLatin word in reverse, preserving before-and-after 
       punctuation.  
   */
   public static String pigReverse(String s)
   {
      if(s.length() == 0)
         return "";
         
     /*The code below will find the beginning punctuation. We create a string begPunct which will store the
   punctuation to be added later to the final word. We use a for loop to go through the word. If the character at the index 
   0 is contained in the string of letters, this means that it is a letter, meaning there is no remaining beginning 
   punctuation. It will then break out of the for loop. If the character is not contained in the string of letters it will go 
   to the else if where it will go through only if the string of punctuation contains that character. If it does,
   we add it to the begPunct string and remove the first character from s. All the charAt methods in this portion has an argument
   of 0 because the string s keeps getting shortened by the substring method, meaning that it will always check a new first letter.*/
   
     
      String begPunct = "";
      for(int x = 0; x < s.length(); x++)
      {
         if(letters.contains("" + s.charAt(0)))
         {
            break;
         }
         
         else if(punct.contains("" + s.charAt(0)))
         {
            begPunct += s.charAt(0);
            s = s.substring(1);
         }
      }
      
    /*The code below will find the ending punctuation. The code is very similar to the beginning punctuation code but includes a few
    changes and additions. This portion of code has a for loop that runs from the end of the string. Inside the else if, the character will get
    added to the string backwardsEndPunct and the string will be shortened from the end, with a substring that has arguments of 0 and one less 
    than the length of the string (meaning the last letter won't be included).*/
           
      String backwardsEndPunct = "";
      for(int x = s.length()-1; x >= 0; x--)
      {
         if(letters.contains("" + s.charAt(x)))
         {
            break;
         }
         
         else if(punct.contains("" + s.charAt(x)))
         {
            backwardsEndPunct += s.charAt(x);
            s = s.substring(0, s.length() - 1);
         }
      }
      
      /*After this part, you will have backwardsEndPunct which will contain all the punctuation at the end but backwards since we started 
      from the end of the string. To correct this, we reverse the string by making it an array and reading it backwards into another 
      string, endPunct, which will contain the proper punctuation.*/
      
      char[] letterArray = backwardsEndPunct.toCharArray();
      String endPunct = "";
      for(int x = letterArray.length - 1; x >= 0; x--)
      {
         endPunct += letterArray[x];
      }
         
         
     /*We first check if the word's first letter is in a string of uppercase letters. If it is, that means it is uppercase as well.
     We set the uppercase boolean to true and proceed to get rid of that uppercase from the first letter, by using the 
     toLowerCase metho dand adding them back together.*/
         
      String firstLetterString = "";   
      boolean upperLetter = false;
      String upperLetters = "ABCEDFGHIJKLMNOPQRSTUVWXYZ";
      if(upperLetters.contains("" + s.charAt(0)))
      {
         upperLetter = true;
         firstLetterString = ("" + s.charAt(0)).toLowerCase();
         s = firstLetterString + s.substring(1);
      }
   
     /*We then reverse the word by turning it into a charArray with the toCharArray() method. Then we go through
     the array from the end, and add each letter to a new string. This process will read the original word
     into the new string backwards giving us a backwards word.*/ 
         
      char[] finalLetterArray = s.toCharArray();
      String finalString = "";
      for(int x = finalLetterArray.length - 1; x >= 0; x--)
      {
         finalString += finalLetterArray[x];
      }
      
      /*Lastly, we check if the uppercase boolean was set to true by the if statement we made previously. 
      If it is true, we make the new first letter uppercase in the same manner that we did before, but now
      using the toUpperCase() method rather than its counterpart, toLowerCase(). Then we combine the punctuation
      with the final word and return it all.*/
      
      if(upperLetter)
      {
         firstLetterString = ("" + finalString.charAt(0)).toUpperCase();
         finalString = firstLetterString + finalString.substring(1); 
      }
   
      return begPunct + finalString + endPunct;
         
   }
}

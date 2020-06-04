// Name: S2-17
// Date: 3/6/2020

import java.util.*;
import java.io.*;

public class SetsOfLetters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      String fileName = "declarationLast.txt";
      fillTheSets(fileName);
   }
   
   public static void fillTheSets(String fn) throws FileNotFoundException
   {
      Scanner infile = new Scanner(new File(fn));
      /*First, we create an ArrayList of LinkedLists. This ArrayList, that I will call storage, has one LinkedList per line of the doc.
      In these LinkedLists, we will store the line itself, then the lowercase letters, then the uppercase letters, and lastly the other
      characters. We create an int arrayListIndex that will let us know which index in storage has the LinkedList we currently want to add
      to. Then, we create a new TreeSet that contains Characters that will hold every character we encounter.*/
      ArrayList<LinkedList<String>> storage = new ArrayList<LinkedList<String>>();
      int arrayListIndex = 0;
      Set<Character> container = new TreeSet<Character>();
      //We use a while that runs while infile as a next line. This allows us to iterate through the doc.
      while(infile.hasNextLine())
      {
         //We create 3 new TreeSets (because we want to keep the characters in order) for lowercase, uppercase, and other.
         Set<Character> lCase = new TreeSet<Character>();
         Set<Character> uCase = new TreeSet<Character>();
         Set<Character> nonCase = new TreeSet<Character>();
         /*We store the next line in a variable. Then we a newLinkedList object to storage. Then, to this LinkedList, we add this
         variable that stores the line.*/
         String line = infile.nextLine();
         storage.add(new LinkedList<String>());
         storage.get(arrayListIndex).add(line);
         /*We use a for each loop to loop through the charArray version of the line. We hae 3 if and else-if statements. First, we make
         sure it is not a space, and then we check if it is not a letter. If it isn't, it means that it goes into the the other character 
         set. We also add it to container. We do the same thing for lowecaser and uppercase and add it to their respective sets and also
         container.*/
         for(char ch : line.toCharArray())
         {
            if(!(ch == ' ') && !Character.isLetter(ch))
            {
               nonCase.add(ch);
               container.add(ch);
            }
            else if(!(ch == ' ') && Character.isLowerCase(ch))
            {
               lCase.add(ch);
               container.add(ch);
            }
            else if(!(ch == ' ') && Character.isUpperCase(ch))
            {
               uCase.add(ch);
               container.add(ch);
            }
         }
         /*At this point, we will have a set of all the lowercase, uppercase, and other characters. We get the LinkedList at arrayListIndex
         then add all of these sets the to LinkedList. Since we have finished working with the current line, we increase arrayListIndex by 1
         so info will get added to another LinkedList.*/
         storage.get(arrayListIndex).add(lCase.toString());
         storage.get(arrayListIndex).add(uCase.toString());
         storage.get(arrayListIndex).add(nonCase.toString());
         arrayListIndex++;
      }
      /*We use a for each to loop through each LinkedList in storage. In this loop, we create an iterator on the current LinkedList.
      The LinkedList will contain, the line, the lowercase set, the uppercase set, and the other set in that order, so we just print out
      everything in the LinkedList with the appropriate formatting in that order.*/
      for(LinkedList<String> curList : storage)
      {
         Iterator<String> it = curList.iterator();
         System.out.println(it.next());
         System.out.println("Lower Case: " + it.next());
         System.out.println("Upper Case: " + it.next());
         System.out.println("Other: " + it.next());
         System.out.println();
      }
      //We create an iterator on the container TreeSet. We also create 3 new TreeSets to store the characters that are in common.
      Iterator<Character> it2 = container.iterator();
      Set<Character> lCommon = new TreeSet<Character>();
      Set<Character> uCommon = new TreeSet<Character>();
      Set<Character> nonCommon = new TreeSet<Character>();
      //We use a while to run while there is another character in the TreeSet container.
      while(it2.hasNext())
      {
         //We store the current character in a variable and create a boolean found that is set to true.
         char currentChar = it2.next();
         boolean found = true;
         /*We loop through every LinkedList in storage like before. For every LinkedList, we check if the first item (the actual line)
         contain the current character, and if it doesn't we set found to false. After this for each loop, if any of the lines don't
         contain the current character, found is set to false.*/
         for(LinkedList<String> curList : storage)
         {
            if(!curList.getFirst().contains("" + currentChar))
            {
               found = false;
            }
         }
         
         /*For all of the following ifs and else ifs, we first check if found is true and, if it is, we check to see whether it belongs
         in the other, lowercase, or uppercase set, and we add it to the correct one.*/
         if(found && !Character.isLetter(currentChar))
         {
            nonCommon.add(currentChar);
         }
         else if(found && Character.isLowerCase(currentChar))
         {
            lCommon.add(currentChar);
         }
         else if(found && Character.isUpperCase(currentChar))
         {
            uCommon.add(currentChar);
         }
      
         
      }
      
      /*We print out all the common character sets with proper formatting.*/
      System.out.println("Common Lower Case: " + lCommon.toString());
      System.out.println("Common Upper Case: " + uCommon.toString());
      System.out.println("Common Other: " + nonCommon.toString());
   
   }
   
   
}

/***********************************
  ----jGRASP exec: java SetsOfLetters_teacher
 
 We, therefore, the Representatives of the united States of 
 Lower Case: [a, d, e, f, h, i, n, o, p, r, s, t, u, v]
 Upper Case: [R, S, W]
 Other: [ , ,]
 
 America, in General Congress, Assembled, appealing to the 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, p, r, s, t]
 Upper Case: [A, C, G]
 Other: [ , ,]
 
 Supreme Judge of the world for the rectitude of our intentions,
 Lower Case: [c, d, e, f, g, h, i, l, m, n, o, p, r, s, t, u, w]
 Upper Case: [J, S]
 Other: [ , ,]
 
 do, in the Name, and by the Authority of the good People of 
 Lower Case: [a, b, d, e, f, g, h, i, l, m, n, o, p, r, t, u, y]
 Upper Case: [A, N, P]
 Other: [ , ,]
 
 these Colonies, solemnly publish and declare, That these United 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, u, y]
 Upper Case: [C, T, U]
 Other: [ , ,]
 
 Colonies are, and of Right ought to be Free and Independent 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, p, r, s, t, u]
 Upper Case: [C, F, I, R]
 Other: [ , ,]
 
 States; that they are Absolved from all Allegiance to the 
 Lower Case: [a, b, c, d, e, f, g, h, i, l, m, n, o, r, s, t, v, y]
 Upper Case: [A, S]
 Other: [ , ;]
 
 British Crown, and that all political connection between them 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, w]
 Upper Case: [B, C]
 Other: [ , ,]
 
 and the State of Great Britain, is and ought to be totally 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, r, s, t, u, y]
 Upper Case: [B, G, S]
 Other: [ , ,]
 
 dissolved; and that as Free and Independent States, they have 
 Lower Case: [a, d, e, h, i, l, n, o, p, r, s, t, v, y]
 Upper Case: [F, I, S]
 Other: [ , ,, ;]
 
 full Power to levy War, conclude Peace, contract Alliances, 
 Lower Case: [a, c, d, e, f, i, l, n, o, r, s, t, u, v, w, y]
 Upper Case: [A, P, W]
 Other: [ , ,]
 
 establish Commerce, and to do all other Acts and Things which 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, r, s, t, w]
 Upper Case: [A, C, T]
 Other: [ , ,]
 
 Independent States may of right do. And for the support of this 
 Lower Case: [a, d, e, f, g, h, i, m, n, o, p, r, s, t, u, y]
 Upper Case: [A, I, S]
 Other: [ , .]
 
 Declaration, with a firm reliance on the protection of divine 
 Lower Case: [a, c, d, e, f, h, i, l, m, n, o, p, r, t, v, w]
 Upper Case: [D]
 Other: [ , ,]
 
 Providence, we mutually pledge to each other our Lives, our 
 Lower Case: [a, c, d, e, g, h, i, l, m, n, o, p, r, s, t, u, v, w, y]
 Upper Case: [L, P]
 Other: [ , ,]
 
 Fortunes and our sacred Honor.
 Lower Case: [a, c, d, e, n, o, r, s, t, u]
 Upper Case: [F, H]
 Other: [ , .]
 
 Common Lower Case: [d, e, n, o, r, t]
 Common Upper Case: []
 Common Other: [ ]
  ----jGRASP: operation complete.
  ************************************/
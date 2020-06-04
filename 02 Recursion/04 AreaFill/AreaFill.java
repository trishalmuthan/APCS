// Name: S2-17
// Date: 10/01/19

import java.util.*;
import java.io.*;

public class AreaFill
{
   private static char[][] grid = null;
   private static String filename = null;

   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in);
      while(true)  // what does this do?
      {
         System.out.print("Fill the Area of (-1 to exit): ");
         filename = sc.next();
         if(filename.equals("-1"))
         {
            sc.close();
            System.out.println("Good-bye");
            //System.exit(0); 
            return;  
         }
         grid = read(filename);
         String theGrid = display(grid);
         System.out.println( theGrid );
         System.out.print( "1-Fill or 2-Fill-and-Count: ");
         int choice = sc.nextInt();
         switch(choice)
         {
            case 1:
               {
                  System.out.print("\nEnter ROW COL to fill from: ");
                  int row = sc.nextInt();
                  int col = sc.nextInt(); 
                  //add grid[row][col] as the last argument on the following line
                  fill(grid, row, col, grid[row][col] );
                  System.out.println( display(grid) );
                  break;
               }
            case 2:
               {
                  System.out.print("\nEnter ROW COL to fill from: ");
                  int row = sc.nextInt();
                  int col = sc.nextInt();
                  int count = fillAndCount(grid, row, col, grid[row][col]);
                  System.out.println( display(grid) );
                  System.out.println("count = " + count);
                  System.out.println();
                  break;
               }
            default:
               System.out.print("\nTry again! ");
         }
      }
   }
   
   /**
    * Reads the contents of the file into a matrix.
    * Uses try-catch.
    * @param filename The string representing the filename.
    * @returns A 2D array of chars.
    */
   public static char[][] read(String filename)
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File(filename));
      }
      catch (Exception e)
      {
         System.out.println("File not found");
         return null;
      }
      /* enter your code here */
      
      /*First, I used infile.nextLine() to get the first line which contained the row and column size. I split that first line,
      based on the space, into an array, and set those 2 integers to variables. Then, I created a matrix using those 2 variables.
      After that, I used a for loop to go through the rows and another to go through the columns. Every time we had a new row, I 
      used a string variable to store the next line in the file. Then, I used charAt() to assign each character in the string to an
      index in the matrix. Then, I returned the matrix.*/
      
      String s = infile.nextLine();
      String[] sarray = s.split(" ");
      int rows = Integer.parseInt(sarray[0]);
      int cols = Integer.parseInt(sarray[1]);
      char[][] matrix = new char[rows][cols];
      for(int x = 0; x < rows; x++)
      {
         String storage = infile.nextLine();
         for(int y = 0; y < cols; y++)
         {
            matrix[x][y] = storage.charAt(y);
            
         }
      }
      return matrix;
   }
   
   /**
    * @param g A 2-D array of chars.
    * @returns A string representing the 2D array.
    */
    
      /*First, I created an empty string. Then, I looped through the matrix, and for each index, I added the character at that index
      to the storage string. After every row, I added the new line indication/character (\n), so that it would go to the next line.
      After that< I just returned storage.*/
   public static String display(char[][] g)
   {
      String storage = "";
      for(int x = 0; x < g.length; x++)
      {
         for(int y = 0; y < g[0].length; y++)
         {
            storage += g[x][y];
         }
         storage += "\n";
      }
      return storage;
   
   }
   
   /**
    * Fills part of the matrix with a different character.
    * @param g A 2D char array.
    * @param r An int representing the row of the cell to be filled.
    * @param c An int representing the column of the cell to be filled.
    * @param ch A char representing the replacement character.
    */
    
      /*First, I checked if r or c are out of bounds of the array, and if it was, I would just return and not run the rest of the method
      After this, I would set the current index to an asterisk. Then, I had to call the recursive methods. I did four if-statements where
      I would first check if moving in that direction would take me out of bounds. Along with this, I would also check if the character
      in that position was equal to the character I want to change which is ch. If both of these requirements are true, I call fill again,
      with the same arguments, except for r or c which is shifted in a certain direction. After all four of these if statements are run, we will
      have an array with the correct characters replaced */
      
   public static void fill(char[][] g, int r, int c, char ch)
   {
     
      if(r < 0 || r > g.length || c < 0 || c > g[0].length )
      {
         return;
      }
   
      g[r][c] = '*';
      
      if((r-1 >= 0) && (g[r-1][c] == ch))
      {
        
         fill(g, r-1, c, ch);
         
      }
      
      if((r+1 < g.length) && (g[r+1][c] == ch))
      {
      
         fill(g, r+1, c, ch);
         
      }
      
      if((c-1 >= 0) && (g[r][c-1] == ch))
      {
      
         fill(g, r, c-1, ch);
         
      }
      
      if((c+1 < g[0].length) && (g[r][c+1] == ch))
      {
      
         fill(g, r, c+1, ch);
         
      }      
      
   }
   
   /**
    * Fills part of the matrix with a different character.
    * Counts as you go.  Does not use a static variable.
    * @param g A 2D char array.
    * @param r An int representing the row of the cell to be filled.
    * @param c An int representing the column of the cell to be filled.
    * @param ch A char representing the replacement character.
    * @return An int representing the number of characters that were replaced.
    */
    
         /*This code is similar to fill. First, I made a count variable. Then, I checked if r or c are out of bounds of the array, 
         and if it was, I would just return 0, indicating that we didn't replace anything and that nothing should be added to count.
      After this, I would set the current index to an asterisk. Then, I had to call the recursive methods. I did four if-statements where
      I would first check if moving in that direction would take me out of bounds. Along with this, I would also check if the character
      in that position was equal to the character I want to change which is ch. If both of these requirements are true, I call fill again,
      with the same arguments, except for r or c which is shifted in a certain direction. I would add the value that this returns to the 
      count variable. After all four of these if statements are run, we will have an array with the correct characters replaced. We will 
      also have a count variable with the correct amount of replaced characters throughout all the recursions. We then return count + 1 
      because we have to account for the first character we replaced*/

   public static int fillAndCount(char[][] g, int r, int c, char ch)
   {
      int count = 0;
      if(r < 0 || r > g.length || c < 0 || c > g[0].length )
      {
         return 0;
      }
   
      g[r][c] = '*';
      
      if((r-1 >= 0) && (g[r-1][c] == ch))
      {
        
         count += fillAndCount(g, r-1, c, ch);
         
      }
      
      if((r+1 < g.length) && (g[r+1][c] == ch))
      {
      
         count += fillAndCount(g, r+1, c, ch);
         
      }
      
      if((c-1 >= 0) && (g[r][c-1] == ch))
      {
      
         count += fillAndCount(g, r, c-1, ch);
         
      }
      
      if((c+1 < g[0].length) && (g[r][c+1] == ch))
      {
      
         count += fillAndCount(g, r, c+1, ch);
         
      } 
      return count + 1;      
   }
}
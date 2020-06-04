// Name: S2-17
// Date: 10/14/19

import java.util.*;
import java.io.*;

public class MazeMaster
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename (no .txt): ");
      Maze m = new Maze(sc.next());
      // Maze m = new Maze();    //extension
      m.display();      
      System.out.println("Options: ");
      System.out.println("1: Mark all dots.");
      System.out.println("2: Mark all dots and display the number of recursive calls.");
      System.out.println("3: Mark only the correct path.");
      System.out.println("4: Mark only the correct path. If no path exists, say so.");
      System.out.println("5: Mark only the correct path and display the number of steps.\n\tIf no path exists, say so.");
      System.out.print("Please make a selection: ");
      m.solve(sc.nextInt());
      m.display();      //display solved maze
   } 
}

class Maze
{
   //constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char TEMP = 'o';
   private final char PATH = '*';
   //instance fields
   private char[][] maze;
   private int startRow, startCol;
  
   //constructors
	
	/* 
	 * EXTENSION 
	 * This is a no-arg constructor that generates a random maze
	 */
   public Maze()
   {
   
   }
	
	/* 
	 * Copy Constructor  
	 */
   public Maze(char[][] m)  
   {
      maze = m;
      for(int r = 0; r < maze.length; r++)
      {
         for(int c = 0; c < maze[0].length; c++)
         { 
            if(maze[r][c] == START)      //identify start location
            {
               startRow = r;
               startCol = c;
            }
         }
      }
   } 
	
	/* 
	 * Use a try-catch block
	 * Use next(), not nextLine()  
	 */
    
    /*First, we use a try-catch to create a scanner and go through the textfile with a .txt added to it. We catch a FileNotFoundException in case there is one.
    Still within the try, we get the number of rows and columns and instantiate the maze matrix with this row number and column number. Then, we use a nested
    for loop to go through every index and set the index equal to the current character. We get the new line each time through the first for loop and check
    for each individual character through the charAt method in the second for loop. Every time we get a new character, we check if it is equal to 'S' and if it is
    , we set it's coordinates in the matrix to startRow and startCol.*/
    
   public Maze(String filename)    
   {
   
      try
      {
         filename += ".txt";
         Scanner infile = new Scanner(new File(filename));
         int rows = infile.nextInt();
         int cols = infile.nextInt();
         maze = new char[rows][cols];
         for(int x = 0; x < rows; x++)
         {
            String storage = infile.next();
            for(int y = 0; y < cols; y++)
            {
               maze[x][y] = storage.charAt(y);
               if(storage.charAt(y) == START)
               {
                  startRow = x;
                  startCol = y;
               }
            
            }
         }
      }  
      catch(FileNotFoundException e)
      {
         System.out.println("file not found");
         System.exit(0);
      }           
   }
   
   public char[][] getMaze()
   {
      return maze;
   }
   
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]);
         }
         System.out.println();
      }
      System.out.println();
   }
   
   public void solve(int n)
   {
      switch(n)
      {
         case 1:
            {
               markAll(startRow, startCol);
               break;
            }
         case 2:
            {
               int count = markAllAndCountRecursions(startRow, startCol);
               System.out.println("Number of steps = " + count);
               break;
            }
         case 3:
            {
               markTheCorrectPath(startRow, startCol);
               break;
            }
         case 4:         //use mazeNoPath.txt 
            {
               if( !markTheCorrectPath(startRow, startCol) )
                  System.out.println("No path exists."); 
               break;
            }
         case 5:
            {
               if( !markCorrectPathAndCountSteps(startRow, startCol, 0) )
                  System.out.println("No path exists."); 
               break;
            }
         default:
            System.out.println("File not found");   
      }
   }
   
	/* 
	 * From handout, #1.
	 * Fill the maze, mark every step.
	 * This is a lot like AreaFill.
	 */ 
    
    /*First, I checked if r or c are out of bounds of the array, and if it was, I would just return and not run the rest of the method
      After this, I would set the current index to an asterisk if it wasn't start but if it was, we would just leave it alone so that the S doesn't get replaced.
      Then, I had to call the recursive methods. I did four if-statements where I would first check if moving in that direction would take me out of bounds. Along with this, I would also check if the character
      in that position was equal to the character I want to change which is DOT. If both of these requirements are true, I call markAll() again,
      with the same arguments, except for r or c which is shifted in a certain direction. After all four of these if statements are run, we will
      have an array with the correct characters replaced */

   public void markAll(int r, int c)
   {
      if(r < 0 || r > maze.length || c < 0 || c > maze[0].length )
      {
         return;
      }
   
      if(maze[r][c] != START)
      {
         maze[r][c] = PATH;
      }
   
      
      if((r-1 >= 0) && (maze[r-1][c] == DOT))
      {
        
         markAll(r-1, c);      
      }
      
      if((r+1 < maze.length) && (maze[r+1][c] == DOT))
      {
         markAll(r+1, c);   
      }
      
      if((c-1 >= 0) && (maze[r][c-1] == DOT))
      {
      
         markAll(r, c-1);
         
      }
      
      if((c+1 < maze[0].length) && (maze[r][c+1] == DOT))
      {
      
         markAll(r, c+1);
         
      }      
   
   }

	/* 
	 * From handout, #2.
	 * Fill the maze, mark and count every step as you go.
	 * Like AreaFill's counting without a static variable.
	 */ 
    
      /*First, I made a count variable and a startcount variable. Then, I checked if r or c are out of bounds of the array, 
      and if it was, I would just return 0, indicating that we didn't replace anything and that nothing should be added to count.
      After this, I would set the current index to an asterisk if it wasn't start but if it was, we would set startcount equal to 1 
      so that we don't change S and so that we can add an extra 1 to the amount of recursions. Then, I had to call the recursive methods. 
      I did four if-statements where I would first check if moving in that direction would take me out of bounds. Along with this, I would 
      also check if the character in that position was equal to the character I want to change which is DOT. If both of these requirements
       are true, I call markAll() again, with the same arguments, except for r or c which is shifted in a certain direction. I would add the value 
       that this returns to the count variable. After all four of these if statements are run, we will have an array with the correct characters 
      replaced. We will also have a count variable with the correct amount of replaced characters throughout all the recursions. We then return 
      count + startcount + 1 because we have to account for the start character we checked, and the first character we replace.
      */
   public int markAllAndCountRecursions(int r, int c)
   {
      int count = 0;
      int startcount = 0;
      if(r < 0 || r > maze.length || c < 0 || c > maze[0].length )
      {
         return 0;
      }
      if(maze[r][c] != START)
      {
         maze[r][c] = PATH;
      }
      else
      {
         startcount = 1;  
      }
      
      if((r-1 >= 0) && (maze[r-1][c] == DOT))
      {
        
         count += markAllAndCountRecursions(r-1, c);
         
      }
      
      if((r+1 < maze.length) && (maze[r+1][c] == DOT))
      {
      
         count += markAllAndCountRecursions(r+1, c);
         
      }
      
      if((c-1 >= 0) && (maze[r][c-1] == DOT))
      {
      
         count += markAllAndCountRecursions(r, c-1);
         
      }
      
      if((c+1 < maze[0].length) && (maze[r][c+1] == DOT))
      {
      
         count += markAllAndCountRecursions(r, c+1);
         
      } 
      return count + 1 + startcount;  
   
   }

   /* 
	 * From handout, #3.
	 * Solve the maze, OR the booleans, and mark the path through it with a “*” 
	 * Recur until you find E, then mark the True path.
	 */ 	
    
    /*First, we make sure that r and c are within our constraints. Then, we check if r and c are equal to the character which represents the open path
    which is DOT. If it is equal to DOT, then we set that location equal to the TEMP variable. Then, we check all around if there are any open paths around
    the current location. If there are then we know we aren't at a dead end yet so we set that location equal to the PATH character and return true. If
    the if statement isn't fulfilled, it means we are at a dead end, so we set it back to DOT and return false. If the current location was never an open
    space (aka DOT, meaning it was either a wall, start, or end), then we check if it is a start. The same thing happens again, but instead of changing 
    the character to PATH, we change it back to START so the S remains. Lastly, we check if it is END which means we would just return true. If we are
    outside the constraints, we return false.*/
    
   public boolean markTheCorrectPath(int r, int c)
   {
      if(r >= 0 && r < maze.length && c >= 0 && c < maze[0].length )
      {
         if(maze[r][c] == DOT)
         {
            maze[r][c] = TEMP;
            if(markTheCorrectPath(r+1, c) == true || markTheCorrectPath(r-1, c) == true || markTheCorrectPath(r, c-1) == true || markTheCorrectPath(r, c+1) == true)
            {
               maze[r][c] = PATH;
               return true;
            }
            else
            {
               maze[r][c] = DOT;
               return false;
            }
         }
         
         if(maze[r][c] == START)
         {
            maze[r][c] = TEMP;
            if(markTheCorrectPath(r+1, c) == true || markTheCorrectPath(r-1, c) == true || markTheCorrectPath(r, c-1) == true || markTheCorrectPath(r, c+1) == true)
            {
               maze[r][c] = START;
               return true;
            }
            else
            {
               maze[r][c] = START;
               return false;
            }
         }
      
         if(maze[r][c] == EXIT)
         {
            return true;
         }
      }
      return false;
   }
	
	
   /*  4   Mark only the correct path. If no path exists, say so.
           Hint:  the method above returns the boolean that you need.  */
      

   /* 
	 * From handout, #5.
	 * Solve the maze, mark the path, count the steps. 	 
	 * Mark only the correct path and display the number of steps.
	 * If no path exists, say so.
	 */ 	
   
    /*First, we make sure that r and c are within our constraints. Then, we check if r and c are equal to the character which represents the open path
    which is DOT. If it is equal to DOT, then we set that location equal to the TEMP variable. Then, we check all around if there are any open paths around
    the current location, increasing count by 1 during the process. If there are, then we know we aren't at a dead end yet so we set that location equal to the 
    PATH character and return true. If the if statement isn't fulfilled, it means we are at a dead end, so we set it back to DOT and return false. If the 
    current location was never an open space (aka DOT, meaning it was either a wall, start, or end), then we check if it is a start. The same thing happens 
    again, but instead of changing  the character to PATH, we change it back to START so the S remains. Lastly, we check if it is END which means we would
    just print the number of steps and return true. If we are outside the constraints, we return false.*/
 
   public boolean markCorrectPathAndCountSteps(int r, int c, int count)
   {
      if(r >= 0 && r < maze.length && c >= 0 && c < maze[0].length )
      {
         if(maze[r][c] == DOT)
         {
            maze[r][c] = TEMP;
            if(markCorrectPathAndCountSteps(r+1, c, count+1) == true || markCorrectPathAndCountSteps(r-1, c, count + 1) == true || markCorrectPathAndCountSteps(r, c-1, count + 1) == true || markCorrectPathAndCountSteps(r, c+1, count+1 ) == true)
            {
               maze[r][c] = PATH;
               return true;
            }
            else
            {
               maze[r][c] = DOT;
               return false;
            }
         }
         
         if(maze[r][c] == START)
         {
            maze[r][c] = TEMP;
            if(markCorrectPathAndCountSteps(r+1, c, count+1) == true || markCorrectPathAndCountSteps(r-1, c, count+1) == true || markCorrectPathAndCountSteps(r, c-1, count+1) == true || markCorrectPathAndCountSteps(r, c+1, count+1) == true)
            {
               maze[r][c] = START;
               return true;
            }
            else
            {
               maze[r][c] = START;
               return false;
            }
         }
      
         if(maze[r][c] == EXIT)
         {
            System.out.println("num steps: " + count);
            return true;
         }
      }
      return false;
   
   }
}

/*****************************************
 
 ----jGRASP exec: java MazeMaster_teacher
 Enter the maze's filename (no .txt): maze1
 WWWWWWWW
 W....W.W
 WW.WW..W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 WW.....W
 WWWWWWWW
 
 Options: 
 1: Mark all dots.
 2: Mark all dots and display the number of recursive calls.
 3: Mark only the correct path.
 4: Mark only the correct path. If no path exists, say so.
 5: Mark only the correct path and display the number of steps.
 	If no path exists, say so.
 Please make a selection: 1
 WWWWWWWW
 W****W*W
 WW*WW**W
 W****W*W
 W*W*WW*E
 S*W*WW*W
 WW*****W
 WWWWWWWW
 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java MazeMaster_teacher
 Enter the maze's filename (no .txt): maze1
 WWWWWWWW
 W....W.W
 WW.WW..W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 WW.....W
 WWWWWWWW
 
 Options: 
 1: Mark all dots.
 2: Mark all dots and display the number of recursive calls.
 3: Mark only the correct path.
 4: Mark only the correct path. If no path exists, say so.
 5: Mark only the correct path and display the number of steps.
 	If no path exists, say so.
 Please make a selection: 2
 Number of recursions = 26
 WWWWWWWW
 W****W*W
 WW*WW**W
 W****W*W
 W*W*WW*E
 S*W*WW*W
 WW*****W
 WWWWWWWW
 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java MazeMaster_teacher
 Enter the maze's filename (no .txt): maze1
 WWWWWWWW
 W....W.W
 WW.WW..W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 WW.....W
 WWWWWWWW
 
 Options: 
 1: Mark all dots.
 2: Mark all dots and display the number of recursive calls.
 3: Mark only the correct path.
 4: Mark only the correct path. If no path exists, say so.
 5: Mark only the correct path and display the number of steps.
 	If no path exists, say so.
 Please make a selection: 3
 WWWWWWWW
 W....W.W
 WW.WW..W
 W***.W.W
 W*W*WW*E
 S*W*WW*W
 WW.****W
 WWWWWWWW
 
 
  ----jGRASP: operation complete.
 
     
  ----jGRASP exec: java MazeMaster_teacher
 Enter the maze's filename (no .txt): mazeNoPath
 WWWWWWWW
 W....W.W
 WW.WW..E
 W..WW.WW
 W.W.W..W
 S.W.WW.W
 WWW....W
 WWWWWWWW
 
 Options: 
 1: Mark all dots.
 2: Mark all dots and display the number of recursive calls.
 3: Mark only the correct path.
 4: Mark only the correct path. If no path exists, say so.
 5: Mark only the correct path and display the number of steps.
 	If no path exists, say so.
 Please make a selection: 4
 No path exists.
 WWWWWWWW
 W....W.W
 WW.WW..E
 W..WW.WW
 W.W.W..W
 S.W.WW.W
 WWW....W
 WWWWWWWW
 
 
  ----jGRASP: operation complete.
 
  ----jGRASP exec: java MazeMaster_teacher
 Enter the maze's filename (no .txt): maze1
 WWWWWWWW
 W....W.W
 WW.WW..W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 WW.....W
 WWWWWWWW
 
 Options: 
 1: Mark all dots.
 2: Mark all dots and display the number of recursive calls.
 3: Mark only the correct path.
 4: Mark only the correct path. If no path exists, say so.
 5: Mark only the correct path and display the number of steps.
 	If no path exists, say so.
 Please make a selection: 5
 Number of steps = 14
 WWWWWWWW
 W....W.W
 WW.WW..W
 W***.W.W
 W*W*WW*E
 S*W*WW*W
 WW.****W
 WWWWWWWW
 
 
  ----jGRASP: operation complete.
  ********************************************/
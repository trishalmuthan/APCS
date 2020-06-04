//Name: S2-17      DAte: 10/07/19
//
// 
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.display.GridDisplay;

/**
 *  Environment-Based Applications:<br>
 *
 *    The NQueens class implements the N Queens problem.
 *
 *  @author Your Name (based on a template provided by Alyce Brady)
 *  @version 1 September 2002
 **/

public class NQueens
{
   // Instance Variables: Encapsulated data for EACH NQueens problem
   private Grid board;
   private GridDisplay display;

 // constructor

   /** Constructs an object that solves the N Queens Problem.
    *    @param n the number of queens to be placed on an
    *              <code>n</code> x <code>n</code> board
    *    @param d an object that knows how to display an 
    *              <code>n</code> x <code>n</code> board and
    *              the queens on it
    **/
   public NQueens(int n, GridDisplay d)
   {
      board = new BoundedGrid(n, n);
      display = d;
      display.setGrid(board);
      display.showGrid();
   }

 // methods

   /** Returns the number of queens to be placed on the board. **/
   
   /*We return the number of columns in the grid because the number of columns/rows is how many pieces get placed*/
   public int numQueens()
   {
      int count = board.numCols();
      return count;   // replace this with something more useful
   }

   /** Solves (or attempts to solve) the N Queens Problem. **/
   public boolean solve()
   {
      if(placeQueen(0)) 
      {
         display.showGrid();
         return true;
      }
      else 
         //If this specific size doesn't work, we output the message
         System.out.println("it doesn't work");
         return false; 
   }

   /** Attempts to place the <code>q</code>th queen on the board.
    *  (Precondition: <code>0 <= q < numQueens()</code>)
    *    @param q index of next queen to place
    **/
    
    /* First, we have our base case which is if q (the current row/number of queens already placed) is greater than or equal to the number of queens that
    must be placed in entirety. Next, we had a for loop that goes until just less than the number of columns. Then, we create a new Location object that
    at the specified row and the current column. Then, we check if this location is safe, and if it is, then we add a queen to this spot and update the grid.
    Then, we recursively call placeQueen() with the row changing to one row below the current row. If this doesn't work out, we know that it isn't possible
    to make it work with a queen at the current position, so we remove a queen and again update the display. If it does work, then we can just return true.
    Lastly, we have a false that gets returned if nothing worked.*/
    
   private boolean placeQueen(int q)
   {
      if(q >= numQueens())
      {
         return true;
      }
      for(int x = 0; x < board.numCols(); x++)
      {
         Location myLoc = new Location(q, x);   
         if(locationIsOK(myLoc))
         {
            addQueen(myLoc);
            display.showGrid();
            if(!placeQueen(q+1))
            {
               removeQueen(myLoc);
               display.showGrid();
            }
            else
            {
               return true;
            }
         }
      }
      // Queen q is placed in row q.  The only question is
      // which column she will be in.  Try them in turn.
      // Whenever we find a column that could work, put her
      // there and see if we can place the rest of the queens.
      
      
      return false;
   }

   /** Determines whether a queen can be placed at the specified
    *  location.
    *    @param loc  the location to test
    **/
    
    /*First, we get the row and column of the specified Location object. Then, we begin to check for the 3 cases. The first of these,
    is if there is a queen located above the specified location. To do this, we make a for loop that starts at 0 (the top) and goes until 
    the currentRow. Then, we create a new Location object at the current row and the preset column. Then, we use objectAt() to check if there
    is anything at each location as we go through the loop. If there ever is one, we return false. The next case is to check the left upwards diagonal.
    To do this, we set 2 new variables equal to the already preset currentRow and currentCol. Then, we have a while loop, that runs while both are
    greater than 0 (there is already a queen in the first row) so that it doesn't go out of bounds. Each time, we decrease both variables by 1 and create
    a new Location object with the new contents of these 2 variables. Then, we do the same thing and check if any of these contain an object and return
    false if they do. The last case, which the right upwards diagonal, is almost the exact same thing. The only difference is that the column
    restriction for the while loop is that it is less than the number of columns - 1, so it doesn't go out of bounds to the right. The other difference
    is that we increase the column variable instead of decrease so that we end up moving right instead of left.*/
   private boolean locationIsOK(Location loc)
   {
      int currentRow = loc.row();
      int currentCol = loc.col(); 
      
      for(int x = 0; x < currentRow; x++)
      {
         Location newLoc = new Location(x, currentCol);
         if(board.objectAt(newLoc) != null)
         {
            return false;
         }
      }
      
      int changeRow = currentRow;
      int changeCol = currentCol;
      
      while(changeRow > 0 && currentCol > 0)
      {
         changeRow--;
         changeCol--;
         Location myLoc = new Location(changeRow, changeCol);
         if(board.objectAt(myLoc) != null)
         {
            return false;   
         }
      }
      
      changeRow = currentRow;
      changeCol = currentCol;
      while(changeRow > 0 && currentCol < board.numCols() - 1)
      {
         changeRow--;
         changeCol++;
         Location myLoc = new Location(changeRow, changeCol);
         if(board.objectAt(myLoc) != null)
         {
            return false;   
         }
      }  
      return true;    
   }

   /** Adds a queen to the specified location.
    *    @param loc  the location where the queen should be placed
    **/
   private void addQueen(Location loc)
   {
      new Queen(board, loc);      // queens add themselves to the board
   }

   /** Removes a queen from the specified location.
    *    @param loc  the location where the queen should be removed
    **/
    
    /*Use the remove method of board to remove the object that is located at Location loc*/
   private void removeQueen(Location loc)
   {
      board.remove(loc);
   }

}

// Name:   S2-17
// Date: 4/21/20
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graph0 AdjMat_0_Driver,
 *              Graph1 WarshallDriver,
 *          and Graph2 FloydDriver
 */

interface AdjacencyMatrix
{
   void addEdge(int source, int target);
   void removeEdge(int source, int target);
   boolean isEdge(int from, int to);
   String toString();   //returns the grid as a String
   int edgeCount();
   List<Integer> getNeighbors(int source);
   //public List<String> getReachables(String from);  //Warshall extension
}

interface Warshall      //User-friendly functionality
{
   boolean isEdge(String from, String to);
   Map<String, Integer> getVertices();     
   void readNames(String fileName) throws FileNotFoundException;
   void readGrid(String fileName) throws FileNotFoundException;
   void displayVertices();
   void allPairsReachability();  // Warshall's Algorithm
}

interface Floyd
{
   int getCost(int from, int to);
   int getCost(String from, String to);
   void allPairsWeighted(); 
}

public class AdjMat implements AdjacencyMatrix, Warshall//,Floyd 
{
   private int[][] grid = null;   //adjacency matrix representation
   private Map<String, Integer> vertices = null;   // name maps to index (for Warshall & Floyd)
   /*for Warshall's Extension*/  ArrayList<String> nameList = null;  //reverses the map, index-->name
	  
   /*This constructor instantiates grid as a new int matrix with the argument val as the length and width.*/
   public AdjMat(int val) {
      grid = new int[val][val];
      vertices = new TreeMap<String, Integer>();
   }
   
   /*We set the value at the position specified by the arguments to 1, indicating there is an edge between that source and target.*/
   public void addEdge(int source, int target){
      grid[source][target] = 1;
   }
   
   /*We set the value at the position specified by the arguments to 0, indicating there is no longer an edge between that source and target.*/
   public void removeEdge(int source, int target){
      grid[source][target] = 0;
   }
   
   /*We return the boolean returned by checking if the specified position in grid is less than 9999 and greater than 0, 
   meaning there is an edge there.*/
   public boolean isEdge(int from, int to){
      return grid[from][to] < 9999 && grid[from][to] != 0;
   }
   
   /*We create a new String toReturn. Then we use a nested for loop to loop through the entire matrix and we add the value in addition to a space for every 
   value in the matrix. After every row we add a \n to go to the next line. At the end we substring off the last \n so there isn't an unnecessary line after.
   Then we return toReturn.*/
   public String toString(){
      String toReturn = "";
      for(int j = 0; j < grid.length; j++){
         for(int k = 0; k < grid[0].length; k++){
            toReturn += grid[j][k] + "  ";
         }
         toReturn += "\n";
      }
      toReturn = toReturn.substring(0, toReturn.length()-2);
      return toReturn;
   }
   
   /*We create a new int variable edgeCount. We use a nested for loop to loop through the matrix and for every value in the matrix, we check if it is an edge.
   If it is, it means there is an edge located between the two vertices so we increase edgeCount by 1. Then we return edgeCount at the end.*/
   public int edgeCount(){
      int edgeCount = 0;
      for(int j = 0; j < grid.length; j++){
         for(int k = 0; k < grid[0].length; k++){
            if(isEdge(j, k)){
               edgeCount++;
            }
         }
      }
      return edgeCount;
   }
   
   /*We create a new ArrayList of Integers called list. We use a for loop to loop through every column in the row specified in the argument. We check every 
   value in this row for if it is equal to 1. If it is, it means that the specified column vertex is a neighbor of the specified row vertex so we add the current
   index of the for loop to the list. Then, at the end, we return list.*/
   public List<Integer> getNeighbors(int source){
      List<Integer> list = new ArrayList<Integer>();
      for(int x = 0; x < grid[source].length; x++){
         if(grid[source][x] == 1){
            list.add(x);
         }
      }
      return list;
   }
   
   /*We return the boolean whether the value at the specified position is equal to 1. This position is given by the index value associated with the from and to
   city specified in the arguments.*/
   public boolean isEdge(String from, String to){
      return grid[vertices.get(from)][vertices.get(to)] == 1;
   }
   
   /*Return vertices*/
   public Map<String, Integer> getVertices(){
      return vertices;
   }
      
   /*We create a scanner with the given filename and store infile.nextInt() in a variable so we know the number of vertices. We use a for loop to go while
   x is less than num. In this loop, we put the string along with x, which numbers each string through the for loop. */
   public void readNames(String fileName) throws FileNotFoundException{
      Scanner infile = new Scanner(new File(fileName));
      int num = infile.nextInt();
      for(int x = 0; x < num; x++){
         vertices.put(infile.next(), x);
      }
   }
   
   /*We create a scanner with the given filename and store infile.nextInt() in a variable so we know the number of vertices. We use a for loop to go while
   x is less than num. In this loop, we split each line from the spaces and store it in an array. Then we use another for loop to go through every value in this
   array and store it in its corresponding location in the grid matrix.*/
   public void readGrid(String fileName) throws FileNotFoundException{
      Scanner infile = new Scanner(new File(fileName));
      int num = infile.nextInt();
      infile.nextLine();
      for(int x = 0; x < num; x++){
         String[] curRow = infile.nextLine().split(" ");
         for(int y = 0; y < num; y++){
            grid[x][y] = Integer.parseInt(curRow[y]);
         }
      }
   }
   
   /*We use a for each loop to loop through all the strings in the vertices key set. For each of these strings, we print the index value associated with this
   string, a dash, and then the string itself.*/
   public void displayVertices(){
      for(String s: vertices.keySet()){
         System.out.println(vertices.get(s) + "-" + s);
      }
      System.out.println();
   }
   
   /*Use 3 for loops to reach every possible combination of cities and check if there is an edge between v and i and then i and j. If there is,
   it means there is also an edge between v and j so we set that position on the grid to 1.*/
   public void allPairsReachability(){
      for(int i = 0; i < grid.length; i++){
         for(int v = 0; v < grid.length; v++){
            for(int j = 0; j < grid.length; j++){
               if(isEdge(v, i) && isEdge(i, j)){
                  grid[v][j] = 1;
               }
            }
         }
      }
   }
   
   /*Return the value at the position [from][to].*/
   public int getCost(int from, int to){
      return grid[from][to];
   }
  
  /*Converts the strings into values and returns the value at that position.*/
   public int getCost(String from, String to){
      return grid[vertices.get(from)][vertices.get(to)];
   }
  
 /*Use 3 for loops to reach every possible combination of cities and check if the cost from v to j is greater than the cost from v to i then i to j.
 We then set the position at v to j to the new smaller cost.*/
   public void allPairsWeighted(){
      for(int i = 0; i < grid.length; i++){
         for(int v = 0; v < grid.length; v++){
            for(int j = 0; j < grid.length; j++){
               if(grid[v][j] > grid[v][i] + grid[i][j]){
                  grid[v][j] = grid[v][i] + grid[i][j];
               }
            }
         }
      }
   
   }
}


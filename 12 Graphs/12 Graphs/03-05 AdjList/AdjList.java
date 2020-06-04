// Name: S2-17  
// Date: 5/1/20
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graphs3: EdgeList,
 *              Graphs4: DFS-BFS
 *          and Graphs5: EdgeListCities
 */

/* Graphs 3: EdgeList 
 */
interface VertexInterface
{
   String toString(); // Don't use commas in the list.  Example: "C [C D]"
   String getName();
   ArrayList<Vertex> getAdjacencies();
   void addEdge(Vertex v);
} 

class Vertex implements VertexInterface 
{
   private final String name;
   private ArrayList<Vertex> adjacencies;
  
   public Vertex(String s){
      name = s;
      adjacencies = new ArrayList<Vertex>();
   }
  
   public String toString(){
      String toReturn = "";
      toReturn += getName();
      toReturn += " [";
      for(int x = 0; x < adjacencies.size(); x++){
         toReturn += (adjacencies.get(x).getName() + " ");
      }
      if(adjacencies.size() != 0){
         toReturn = toReturn.substring(0, toReturn.length()-1);
      }
      toReturn += "]";
      return toReturn;
   }
  
   public String getName(){
      return name;
   }
  
   public ArrayList<Vertex> getAdjacencies(){
      return adjacencies;
   }
  
   public void addEdge(Vertex v){
      adjacencies.add(v);
   }
  
}   

interface AdjListInterface 
{ 
   List<Vertex> getVertices();
   Vertex getVertex(int i) ;
   Vertex getVertex(String vertexName);
   Map<String, Integer> getVertexMap();
   void addVertex(String v);
   void addEdge(String source, String target);
   String toString();  //returns all vertices with their edges (omit commas)
}

  
/* Graphs 4: DFS and BFS 
 */
interface DFS_BFS
{
   List<Vertex> depthFirstSearch(String name);
   List<Vertex> depthFirstSearch(Vertex v);
   List<Vertex> breadthFirstSearch(String name);
   List<Vertex> breadthFirstSearch(Vertex v);
   /*  three extra credit methods */
   /*List<Vertex> depthFirstRecur(String name);
   List<Vertex> depthFirstRecur(Vertex v);
   void depthFirstRecurHelper(Vertex v, ArrayList<Vertex> reachable);*/
}

/* Graphs 5: Edgelist with Cities 
 */
interface EdgeListWithCities
{
   void graphFromEdgeListData(String fileName) throws FileNotFoundException;
   int edgeCount();
   int vertexCount(); //count the vertices in the object
   boolean isReachable(String source, String target);
   boolean isConnected();
}


public class AdjList implements AdjListInterface, DFS_BFS //,EdgeListWithCities
{
   private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
   private Map<String, Integer> nameToIndex = new TreeMap<String, Integer>();
   
   public AdjList(){}
  
   public List<Vertex> getVertices(){
      return vertices;
   }
   
   public Vertex getVertex(int i){
      return vertices.get(i);
   }
   
   public Vertex getVertex(String vertexName){
      return getVertex(nameToIndex.get(vertexName));
   }
   
   public Map<String, Integer> getVertexMap(){
      return nameToIndex;
   }
   
   public void addVertex(String v){
      if(nameToIndex.containsKey(v)){
         return;
      }
      nameToIndex.put(v, vertices.size());
      vertices.add(new Vertex(v));
   }
   
   public void addEdge(String source, String target){
      if(!nameToIndex.containsKey(source)){
         addVertex(source);
      }
      if(!nameToIndex.containsKey(target)){
         addVertex(target);
      }
      vertices.get(nameToIndex.get(source)).addEdge(vertices.get(nameToIndex.get(target)));
   }
   
   public String toString(){
      String toReturn = "";
      for(Vertex v: vertices){
         toReturn += v.toString() + "\n";
      }
      return toReturn;
   }
   
   public List<Vertex> depthFirstSearch(String name){
      return depthFirstSearch(vertices.get(nameToIndex.get(name)));
   }
   
   public List<Vertex> depthFirstSearch(Vertex v){
      ArrayList<Vertex> reachable  = new ArrayList<Vertex>();
      Stack<Vertex> stack = new Stack<Vertex>();
      stack.add(v);
      while(!stack.isEmpty()){
         Vertex first = stack.pop();
         if(!reachable.contains(first)){
            for(Vertex second: first.getAdjacencies()){
               if(!stack.contains(second)){
                  stack.add(second);
               }
            }
            reachable.add(first);
         }
      } 
      return reachable; 
   }
   
   public List<Vertex> breadthFirstSearch(String name){
      return breadthFirstSearch(vertices.get(nameToIndex.get(name)));
   }
   
   public List<Vertex> breadthFirstSearch(Vertex v){
      ArrayList<Vertex> reachable  = new ArrayList<Vertex>();
      Queue<Vertex> queue = new LinkedList<Vertex>();
      queue.add(v);
      while(!queue.isEmpty()){
         Vertex first = queue.remove();
         if(!reachable.contains(first)){
            for(Vertex second: first.getAdjacencies()){
               if(!queue.contains(second)){
                  queue.add(second);
               }
            }
            reachable.add(first);
         }
      } 
      return reachable;
   } 
   
   public void graphFromEdgeListData(String fileName) throws FileNotFoundException{
      Scanner s = new Scanner(new File(fileName));
      while(s.hasNext()){
         addEdge(s.next(), s.next());
      }
   }
  
   public int edgeCount(){
      int edgeCount = 0;
      for(Vertex v: vertices){
         for(Vertex v2: v.getAdjacencies()){
            edgeCount++;
         }
      }
      return edgeCount;
   }
   
   public int vertexCount(){  //count the vertices in the object
      return vertices.size();
   }
   
   public boolean isReachable(String source, String target){
      if(depthFirstSearch(source).contains(vertices.get(nameToIndex.get(target))))
      {
         return true;
      }
      return false;
   }
   
   public boolean isConnected(){
      for(Vertex v: vertices){
         if(depthFirstSearch(v.getName()).size() < vertices.size())
         {
            return false;
         }
      }
      return true;
   }
}



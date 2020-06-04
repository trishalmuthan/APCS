// Name: S2-17
// Date: 11-4-19

public class Widget implements Comparable<Widget>
{
   //fields
   /*There are 2 fields, one for cubits and another for hands*/
   private int cubits;
   private int hands;
   //constructors
   
   /*This is a default constructor that just sets the fields to 0*/
   public Widget()
   {
      cubits = 0;
      hands = 0;
   }

   /*This is a 2-arg constructor that sets the fields to the 2 ints passed*/   
   public Widget(int c, int h)
   {
      cubits = c;
      hands = h;
   }
   
   /*This is a copy constructor that uses the same fields as another widget*/
   public Widget(Widget b)
   {
      cubits = b.getCubits();
      hands = b.getHands();
   }

   
   //accessors and modifiers
   
   /*This returns the number of cubits*/
   public int getCubits()
   {
      return cubits;
   }
   
   /*This sets the private field cubits to the int passed*/
   public void setCubits(int c)
   {
      cubits = c;
   }
   
   /*This returns the number of hands*/
   public int getHands()
   {
      return hands;
   }
   
   /*This sets the private field hands to the int passed*/
   public void setHands(int h)
   {
      hands = h;
   }
   //compareTo and equals
   
   /*This first checks if either of the cubits are greater than the other Widget's cubits, and returns either 1 or -1. If
   the number of cubits is equal then we check the same for the hands. If the hands are also equal, we return 0.*/
   public int compareTo(Widget other)
   {
      if(cubits > other.cubits)
      {
         return 1;
      }
      
      if(cubits < other.cubits)
      {
         return -1;
      }
      
      if(hands > other.hands)
      {
         return 1;
      }
      
      if(hands < other.hands)
      {
         return -1;
      }
      
      return 0;
   }
   /*This checks if the toString of both objects are equal to each other*/
   public boolean equals(Widget other)
   {
      boolean equal = this.toString().equals(other.toString());
      return equal;
   }
   
   //toString
   /*This returns the cubits and hands in String form*/
   public String toString()
   {
      return cubits + " cubits " + hands + " hands";
   }
   
}

// Name: S2-17
// Date: 08-29-19
 
import java.text.DecimalFormat;
public class SmartCard_Driver
{
   public static void main(String[] args) 
   {
      Station downtown = new Station("Downtown", 1);
      Station center = new Station("Center City", 1);
      Station uptown = new Station("Uptown", 2);
      Station suburbia = new Station("Suburb", 4);
   
      SmartCard jimmy = new SmartCard(20.00); 
      jimmy.board(center);                    //Boarded at Center City.  SmartCard has $20.00
      jimmy.disembark(suburbia);              //From Center City to Suburb costs $2.75.  SmartCard has $17.25
      jimmy.disembark(uptown);				//Error:  did not board?!
      System.out.println();
   			
      SmartCard susie = new SmartCard(1.00); 
      susie.board(uptown);            		//Boarded at Uptown.  SmartCard has $1.00
      susie.disembark(suburbia);				//Insuffient funds to exit. Please add more money.
      System.out.println();
   
      SmartCard kim = new SmartCard(.25);    
      kim.board(uptown);            		    //Insuffient funds to board. Please add more money.
      System.out.println();
   
      SmartCard b = new SmartCard(10.00);   
      b.board(center);            		    //Boarded at Center City.  SmartCard has $10.00
      b.disembark(downtown);					//From Center City to Downtown costs $0.50.  SmartCard has $9.50
      System.out.println();
        
      SmartCard mc = new SmartCard(10.00);  
      mc.board(suburbia);            		    //Boarded at Suburbia.  SmartCard has $10.00
      mc.disembark(downtown);					//From Suburbia to Downtown costs $2.75.  SmartCard has $7.25
      System.out.println();
    
      //Make more test cases.  What else needs to be tested?
      System.out.println("EXTRA RUNS");
      System.out.println();
      System.out.println("$10 added Test:");
      SmartCard testAdd = new SmartCard(10.00);  
      testAdd.board(suburbia);
      testAdd.addMoney(10.00);
      testAdd.disembark(uptown);
      System.out.println();
      
      System.out.println("Already Boarded Test:");
      SmartCard alreadyBoard = new SmartCard(10.00);  
      alreadyBoard.board(suburbia);
      alreadyBoard.board(suburbia);
      System.out.println();
      
   }
} 	

//Note SmartCard is not denoted as public.  Why?
class SmartCard 
{
   public final static DecimalFormat df = new DecimalFormat("$0.00");
   public final static double MIN_FARE = 0.5;
   private double money;
   private boolean presented;
   private Station entryStation;
   //create private fields of SmartCard class
   
   
   public SmartCard(double load)
   {
      money = load;
      presented = false;
      entryStation = null;
   }
   
   
   public void addMoney(double d) 
   {
      money += d;
   }
   
   
   public String getBalance()
   {
      return df.format(money);
   }
   
   
   public boolean isBoarded()
   {
      if(presented)
      {
         return true;
      }
      return false;
   }
   
   
   public void board(Station s)
   {
      entryStation = s;
      
      if(isBoarded())
      {
         System.out.println("Error! already boarded?!");
         return;
      }
      
      if(money < 0.50)
      {
         System.out.println("Insufficient funds to board. Please add more money." );
         return;
      }
      
      //if they are already boarded or don't have enough money, then a message will be outputted
      presented = true;
      //set presented to true since they have boarded
      System.out.println("Boarded at " + entryStation.getString() + ". SmartCard has " + getBalance());
   }
   
   
   public double cost(Station s)
   {
      int zoneDifference = 0;
      double finalPrice = 0;
      
      if(entryStation.getZone() > s.getZone())
      {
         zoneDifference = entryStation.getZone() - s.getZone();
         finalPrice = (zoneDifference * 0.75) + 0.50;
         return finalPrice;
      }
      // if the zone they entered at is greater than the current zone then the current zone will be subtracted from the entry zone
      // this way we won't have to deal with negative numbers
      // we multiply the difference by 0.75 for each extra zone and then add 0.50 for the same zone fee
      
      if(s.getZone() > entryStation.getZone())
      {
         zoneDifference = s.getZone() - entryStation.getZone();
         finalPrice = (zoneDifference * 0.75) + 0.50;
         return finalPrice;
      }
      //the same thing is done as before except here, if the zone they entered at 
      //is less than the current zone then the entry zone will be subtracted from the current zone

      return 0.50;
      //if we reach this line, then it means that the ride is within the same zone
   }
   
   
   public void disembark(Station s)
   {
      String exitStation = s.getString();
      // 1 variable is created and stores string name of the exit location
      if(!isBoarded())
      {
         System.out.println("Error! did not board?!");
         return;
      }
      //if presented is marked as false that means they were never on the train in the first place
      if(money < cost(s))
      {
         System.out.println("Insufficient funds to board. Please add more money." );
         return;
      }
      //if they don't have enough money to get off then a message is outputted
      money -= cost(s);
      //the smartcard balance is changed based on the cost
      presented = false;
      //we set presented to false because they are no longer on the train
      System.out.println("From " + entryStation.getString() + " to " + exitStation + " costs " + df.format(cost(s)) + " SmartCard has " + getBalance());
   }
   
   
   //the next 3 methods are for use ONLY by Grade-It
   //these accessor methods only return your private data
   //they do not make any changes to your data
   double getMoneyRemaining()
   {
      return money;
   }
   
   Station getBoardedAt()
   {
      return entryStation;   
   }
  
   boolean getIsOnBoard()
   {
      return presented;
   }
}
   
   
//Note Station is not a public class.  Why?
class Station
{
   private String myName;
   private int myZone;
   
   public Station(String name, int zone)
   {
      myName = name;
      myZone = zone;
   }
   
   public int getZone()
   {
      return myZone;
   }
   
   public String getString()
   {
      return myName;
   }
}

 /*******************  Sample Run ************

 Boarded at Center City.  SmartCard has $20.00
 From Center City to Suburb costs $2.75.  SmartCard has $17.25
 Error: did not board?!
 
 Boarded at Uptown.  SmartCard has $1.00
 Insufficient funds to exit. Please add more money.
 
 Insufficient funds to board. Please add more money.
 
 Boarded at Center City.  SmartCard has $10.00
 From Center City to Downtown costs $0.50.  SmartCard has $9.50
 
 Boarded at Suburb.  SmartCard has $10.00
 From Suburb to Downtown costs $2.75.  SmartCard has $7.25
 
 ************************************************/
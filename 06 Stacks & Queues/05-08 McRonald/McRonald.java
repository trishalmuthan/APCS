// Name: S2-17 
// Date: 1/25/20

import java.util.*;
import java.lang.*;
public class McRonald
{
   public static final int TIME = 1080;  //18 hrs * 60 min
   
   public static void main(String[] args)
   {
      
      /*First, we create statistic variables for both regular customers and VIPs. We have a total customers, total wait time, average wait time,
      longest wait time, and longest queue for both VIPs and regular customers.*/
      int regCustomers = 0;
      double regTotalWaitTime = 0.0;
      double regAvgTime = 0.0;
      int regLongestTime = 0;
      int regLongestQueue = 0;
      
      int vipCustomers = 0;
      double vipTotalWaitTime = 0.0;
      double vipAvgTime = 0.0;
      int vipLongestTime = 0;
      int vipLongestQueue = 0;
      
      /*We create 3 queues, one for regular customers, one for VIP customers, and one for all customers so that we can do the customer by customer
      output at the end.*/
      Queue<Customer> q = new LinkedList<Customer>();
      Queue<Customer> qvip = new LinkedList<Customer>();
      Queue<Customer> allCustomers = new LinkedList<Customer>();
     
     /*First we create a random serviceTime from 2 to 7 minutes. Then we have a for loop that goes from 0 to 1080, the store's open minutes.
     In this for loop, we use the numEntered() method (commented more later on) to randomly give us the number of people who entered. We have
     4 if statements to check what number it is and add a certain number of people based on this number. In each of these if statements we check
     each time whether each person should be a VIP using the isVIP() method. If the person is a VIP, we add to the VIP queue and otherwise, we
     add to the regular queue, and the customer added takes the minute, the random service time, and the size of the queue before they enter. 
     For both VIPs and regular customers, we add to the allCustomers queue. Another thing we do is, if there are multiple people being added to a
     queue, we calculate a new random service time after we add each new person.*/ 
      int serviceTime =  (int) (Math.random() * 6) + 2;
      for(int x = 0; x < TIME; x++)
      {
        
         int newPeople = numEntered();
         if(newPeople == 4)
         {
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
            serviceTime =  (int) (Math.random() * 6) + 2;
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
            serviceTime =  (int) (Math.random() * 6) + 2;
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
            serviceTime =  (int) (Math.random() * 6) + 2;
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
         }
         
         if(newPeople == 3)
         {
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
            serviceTime =  (int) (Math.random() * 6) + 2;
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
            serviceTime =  (int) (Math.random() * 6) + 2;
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
         }
         
         if(newPeople == 2)
         {
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
            serviceTime =  (int) (Math.random() * 6) + 2;
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
         }
         
         if(numEntered() == 1)
         {
            if(isVIP())
            {
               Customer toAdd = new Customer(x, serviceTime, qvip.size());
               qvip.add(toAdd);
               allCustomers.add(toAdd);
            }
            else
            {
               Customer toAdd = new Customer(x, serviceTime, q.size());
               q.add(toAdd);
               allCustomers.add(toAdd);
            }
         }
         
         /*Here, we check if either of the longest queue variables should be updated based on the current length of the queue. If either of
         the current queues are longer than their respective variables, then we update the variables. Then we display both queues along with 
         the current minute.*/
            
         if(vipLongestQueue < qvip.size())
         {
            vipLongestQueue = qvip.size();
         } 
         
         if(regLongestQueue < q.size())
         {
            regLongestQueue = q.size();
         } 
          
         display(qvip, q, x);
         
         /*Next, becase of the VIP priotity, we have an if statement that checks if the VIP queue is empty, since the regular queue only gets served if the VIP queue has nobody in it. 
         If it is empty, then we ensure that the regular queue isn't also empty, beacuse we can't serve if there is nobody to be served. If it isn't then we check if there is still time
         remaining on the regular customer at the front of the line's service time and if there is, then we decrease this service time. If this isn't the case, then we go to the else if, 
         which would mean the service time remaining is equal to 0. Within this, we remove the first customer and store it in a variable. We update this customer's timeServed field with
         the current minute x. Then we calculate the currentWaitTime by subtracting the current minute from the minute that they entered at. This is added to the statistic for total wait
         time for the regular customer. Then, we increase the variable for number of regular customers by one. Lastly, we check if the current wait time is longer than the variable for 
         regular customer longest wait time. If it is longer, you set that variable to currentWaitTime. Then we just set serviceTime to something new from 2-7.*/
         if(qvip.isEmpty())
         {
            if(!q.isEmpty())
            {
               if(q.peek().getServe() != 0)
               {
                  q.peek().decreaseServe();
               }
               else if(q.peek().getServe() == 0)
               {
                  Customer store = q.remove();
                  store.setTimeServed(x);
                  int currentWaitTime = x - store.getEntry();
                  regTotalWaitTime += currentWaitTime;
                  regCustomers++;
                  if(currentWaitTime > regLongestTime)
                  {
                     regLongestTime = currentWaitTime;
                  }
                  serviceTime = (int) (Math.random() * 6) + 2;    
               }
            
            }
         }
         /*This else statement would be run if the VIP queue isn't empty, which would mean this queue would have to be served first. The exact same step happen here as what happened with the regular
         customer queue, except here, we remove from the VIP queue rather than the regular queue, and update the VIP statistics rather than the regular customer statistics.*/
         else
         {
            if(!qvip.isEmpty())
            {
               if(qvip.peek().getServe() != 0)
               {
                  qvip.peek().decreaseServe();
               }
               else if(qvip.peek().getServe() == 0)
               {
                  Customer store = qvip.remove();
                  store.setTimeServed(x);
                  int currentWaitTime = x - store.getEntry();
                  vipTotalWaitTime += currentWaitTime;
                  vipCustomers++;
                  if(currentWaitTime > vipLongestTime)
                  {
                     vipLongestTime = currentWaitTime;
                  }
                  serviceTime = (int) (Math.random() * 6) + 2;    
               }
            
            }
         
         }
      } 
      
      /*This section is the same as before except I removed the addition of new customers and we use a new variable tempTime to denote the current minute since it goes over the
      original 1080 minutes. This allows all the customers remaining in the store to be served, while preserving the accurate timings.*/
      int tempTime = TIME-1;
      while(!qvip.isEmpty() || !q.isEmpty())
      {
         tempTime++;
         display(qvip, q, tempTime);
         if(qvip.isEmpty())
         {
            if(!q.isEmpty())
            {
               if(q.peek().getServe() != 0)
               {
                  q.peek().decreaseServe();
               }
               else if(q.peek().getServe() == 0)
               {
                  Customer store = q.remove();
                  store.setTimeServed(tempTime);
                  int currentWaitTime = tempTime - store.getEntry();
                  regTotalWaitTime += currentWaitTime;
                  regCustomers++;
                  if(currentWaitTime > regLongestTime)
                  {
                     regLongestTime = currentWaitTime;
                  }
                  serviceTime = (int) (Math.random() * 6) + 2;    
               }
            
            }
         }
         else
         {
            if(!qvip.isEmpty())
            {
               if(qvip.peek().getServe() != 0)
               {
                  qvip.peek().decreaseServe();
               }
               else if(qvip.peek().getServe() == 0)
               {
                  Customer store = qvip.remove();
                  store.setTimeServed(tempTime);
                  int currentWaitTime = tempTime - store.getEntry();
                  vipTotalWaitTime += currentWaitTime;
                  vipCustomers++;
                  if(currentWaitTime > vipLongestTime)
                  {
                     vipLongestTime = currentWaitTime;
                  }
                  serviceTime = (int) (Math.random() * 6) + 2;    
               }
            
            }
         }
         
      }
   
      /*This part first calculates the average times for both regular customers and VIPs, and then outputs all the statistics, most updated
      throughout the simulation and the average being recently calculated.*/
      regAvgTime = regTotalWaitTime/regCustomers;
      vipAvgTime = vipTotalWaitTime/vipCustomers;
      System.out.println("Total Regular Customers Served = " + regCustomers);
      System.out.println("Regular Average Wait Time = " + regAvgTime);                         
      System.out.println("Regular Longest Wait Time: " + regLongestTime);
      System.out.println("Regular Longest Queue: " + regLongestQueue);
      System.out.println("Total VIP Customers Served = " + vipCustomers);
      System.out.println("VIP Average Wait Time = " + vipAvgTime);                         
      System.out.println("VIP Longest Wait Time: " + vipLongestTime);
      System.out.println("VIP Longest Queue: " + vipLongestQueue);
      
      /*This section does the final part of the output. First we use the toTime method to get the actual time that they entered at. Then we
      calulate the wait time by subtracting the minute they entered at from the minute they were served at. Then we get the actual time that
      they were served at by using toTime on the entry minute, plus the wait time. Then we get the size of the queue at entry by using the method
      from the Customer class. Then we compile all this into one String using \t to format properly. Then we print this out at increase count by 1
      since we are now on the next customer.*/
      int count = 1;
      for(Customer c: allCustomers)
      {
         String timeEntry = c.toTime(c.getEntry());
         int waitTime = c.getTimeServed() - c.getEntry();
         String timeServed = c.toTime(c.getEntry() + waitTime);
         int sizeAtEntry = c.getSizeAtEntry();
         String toReturn = "Customer " + count + ": t in q- " + timeEntry + "\tt served- " + timeServed + "\ttotal wait- " + waitTime + " min\tlen of q when enter- " + sizeAtEntry;
         System.out.println(toReturn);
         count++;
      }
      
   }
   
   /*First, we create a String that first has the minute and then the words VIP: . The method takes in a vip queue, a regular queue, and the minute
   . After creating the String, we use a for each to go through the VIP queue and add a + to the String for every person in this queue. Then we add
   the words REG for regular customers, and do the same thing but adding a * this time. Then we print out this String. This output will have the
   correct number of VIPs and then the correct number of regular customers as +'s or *'s. */
   public static void display(Queue<Customer> qvip, Queue<Customer> q, int min) //if you have a Customer class
   {
      String toReturn = min + ": VIP - ";
      for(Customer s: qvip)
      {
         toReturn += "+ ";
      }
      toReturn += " REG - ";
      for(Customer s: q)
      {
         toReturn += "* ";
      }
      System.out.println(toReturn);
   }
   
   /*There is a 5% chance of someone being a VIP so we do if Math.random is less than 0.05, true is returned, otherwise we return false.*/
   public static boolean isVIP()
   {
      if(Math.random() < 0.05)
      {
         return true;
      }
      return false;
   }
   
   /*We first calculate a Math.random. Then we check if this value is less than the value that is returned by the probablity formula when
   we input 4. If this is the case, then we return 4 because 4 people are added to the line. We do this for each number until 1. Here, the order
   would matter because the probablities keep increasing as we go up, and if we maintain this order, it doesn't matter if the probabilities
   overlap. If none of the if statements return anything, we just return 0.*/
   public static int numEntered()
   {
      double value = Math.random();
      if(value < (Math.pow(0.2, 4) * Math.exp(-0.2))/factorial(4))
      {
         return 4;
      }
      
      else if(value < (Math.pow(0.2, 3) * Math.exp(-0.2))/factorial(3))
      {
         return 3;
      }
      
      else if(value < (Math.pow(0.2, 2) * Math.exp(-0.2))/factorial(2))
      {
         return 2;
      }
      
      else if(value < (Math.pow(0.2, 1) * Math.exp(-0.2))/factorial(1))
      {
         return 1;
      }
      return 0;
   }
   
   /*This just iteratively calculates the factorial and returns it*/
   public static int factorial(int n)
   {
      int result=1,i=1;
      while(i<=n)
      {
         result=result*i;
         i++;
      }	
      return result;
   }

}

/*A customer class with various useful fields, and getters and setters for these fields. timeOfEntry is the minute that they entered at.
curServeTime is the serveTime that keeps getting changed through the simulation. ogServeTime doesn't change and keeps the serveTime
given to it in the beginning. sizeAtEntry is the size of the queue when they enter.  timeServed is the minute they are served at.*/
class Customer      // if you want a Customer class
{
   private int timeOfEntry;
   private int curServeTime;
   private int ogServeTime;
   private int sizeAtEntry;
   private int timeServed;
   public Customer(int time, int serveMin, int len)
   {
      curServeTime = serveMin;
      ogServeTime = serveMin;
      timeOfEntry = time;
      sizeAtEntry = len;
      timeServed = 0;
   }
   
   public int getEntry()
   {
      return timeOfEntry;
   }
   public int getServe()
   {
      return curServeTime;
   }
   public void setTimeServed(int n)
   {
      timeServed = n;
   }
   
   public int getTimeServed()
   {
      return timeServed;
   }
   
   public int getSizeAtEntry()
   {
      return sizeAtEntry;
   }
   public int getOGServe()
   {
      return ogServeTime;
   }
   
   public int getLength()
   {
      return sizeAtEntry;
   }
    
   public void decreaseServe()
   {
      curServeTime--;
   }
   
   /*This first calculates the hours by dividing by 60 and the minutes by modulusing by 60. Then, we have to add 6 hours because the store opens
   at 6. Then, we check if finalHours is equal to 12 or 24 because then we wouldn't modulus by 12 to get rid of military time, and we would just
   set it to 12 hours. If this is not the case, we do modulus by 12 to get it out of military time. Then, we check if minutes is 0 and add a 0 
   in front of the digit if it is, because we want to prevent formatting errors. Then, we return a String with the hours:minutes.*/
   public String toTime(int minutes)
   {
      int hours = minutes / 60;
      int min = minutes % 60;
      
      int finalHours = (6 + hours);
      if(finalHours == 12 || finalHours == 24)
      {
         finalHours = 12;
      }
      else
      {
         finalHours = finalHours % 12;
      }
      String stringMin = "" + min;
      if(min < 10)
      {
         stringMin = "0" + min;
      }
      return finalHours + ":" + stringMin;
     
   }
}


/**********************  Sample output
     
 0: []
 1: []
 2: [2]
 3: [2]
 4: [2]
 5: [2]
 6: [2, 6]
 7: [6, 7]
 8: [6, 7]
 9: [6, 7]
 10: [6, 7, 10]
 11: [6, 7, 10]
 12: [7, 10, 12]
 13: [7, 10, 12]
 14: [7, 10, 12]
 15: [7, 10, 12]
 16: [10, 12]
 17: [10, 12]
 18: [10, 12]
 19: [10, 12]
 20: [10, 12]
 21: [10, 12]
 22: [10, 12]
 23: [12]
 24: [12]
 25: [12]
 26: []
 27: []
 28: []
 29: []
 30: []
 31: []
 32: []
 33: []
 34: []
 35: []
 36: []
 37: []
 38: []
 39: []
 40: [40]
 41: [40, 41]
 42: [40, 41]
 43: [41]
 44: [41]
 45: [41]
 46: [41]
 47: []
 48: [48]
 49: [48]
 50: [48]
 51: []
 52: [52]
 53: [52, 53]
 54: [52, 53, 54]
 55: [52, 53, 54]
 56: [52, 53, 54]
 57: [52, 53, 54]
 58: [53, 54, 58]
 59: [53, 54, 58]
 60: [53, 54, 58]
 61: [53, 54, 58]
 62: [54, 58]
 63: [54, 58]
 64: [54, 58]
 65: [58, 65]
 66: [58, 65]
 67: [58, 65]
 68: [58, 65]
 69: [58, 65]
 70: [65]
 71: [65]
 72: [65, 72]
 73: [65, 72]
 74: [65, 72, 74]
 75: [65, 72, 74]
 76: [65, 72, 74]
 77: [72, 74]
 78: [72, 74, 78]
 79: [72, 74, 78]
 80: [72, 74, 78]
 81: [74, 78]
 82: [74, 78]
 83: [74, 78, 83]
 84: [74, 78, 83]
 85: [74, 78, 83, 85]
 86: [74, 78, 83, 85]
 87: [78, 83, 85]
 88: [78, 83, 85]
 89: [78, 83, 85]
 90: [78, 83, 85]
 91: [78, 83, 85]
 92: [78, 83, 85]
 93: [83, 85]
 94: [83, 85, 94]
 95: [83, 85, 94]
 96: [83, 85, 94]
 97: [85, 94]
 98: [85, 94, 98]
 99: [85, 94, 98, 99]
 100: [85, 94, 98, 99, 100]
 101: [85, 94, 98, 99, 100]
 102: [85, 94, 98, 99, 100]
 103: [85, 94, 98, 99, 100]
 104: [94, 98, 99, 100]
 105: [94, 98, 99, 100, 105]
 106: [94, 98, 99, 100, 105, 106]
 107: [98, 99, 100, 105, 106]
 108: [98, 99, 100, 105, 106]
 109: [98, 99, 100, 105, 106, 109]
 110: [99, 100, 105, 106, 109]
 111: [99, 100, 105, 106, 109, 111]
 112: [99, 100, 105, 106, 109, 111]
 113: [100, 105, 106, 109, 111, 113]
 114: [100, 105, 106, 109, 111, 113]
 115: [100, 105, 106, 109, 111, 113]
 116: [100, 105, 106, 109, 111, 113]
 117: [100, 105, 106, 109, 111, 113]
 118: [100, 105, 106, 109, 111, 113]
 119: [100, 105, 106, 109, 111, 113]
 120: [105, 106, 109, 111, 113]
 121: [105, 106, 109, 111, 113]
 122: [105, 106, 109, 111, 113]
 123: [106, 109, 111, 113]
 124: [106, 109, 111, 113]
 125: [106, 109, 111, 113]
 126: [106, 109, 111, 113]
 127: [106, 109, 111, 113]
 128: [106, 109, 111, 113]
 129: [106, 109, 111, 113]
 130: [109, 111, 113, 130]
 131: [109, 111, 113, 130]
 132: [109, 111, 113, 130]
 133: [109, 111, 113, 130]
 134: [111, 113, 130, 134]
 135: [111, 113, 130, 134]
 136: [111, 113, 130, 134]
 137: [111, 113, 130, 134]
 138: [111, 113, 130, 134]
 139: [111, 113, 130, 134]
 140: [111, 113, 130, 134]
 141: [113, 130, 134]
 142: [113, 130, 134, 142]
 143: [113, 130, 134, 142, 143]
 144: [113, 130, 134, 142, 143]
 145: [130, 134, 142, 143]
 146: [130, 134, 142, 143]
 147: [130, 134, 142, 143]
 148: [130, 134, 142, 143]
 149: [130, 134, 142, 143]
 150: [130, 134, 142, 143]
 151: [130, 134, 142, 143, 151]
 152: [134, 142, 143, 151]
 153: [134, 142, 143, 151]
 154: [134, 142, 143, 151]
 155: [142, 143, 151]
 156: [142, 143, 151, 156]
 157: [142, 143, 151, 156]
 158: [142, 143, 151, 156]
 159: [142, 143, 151, 156]
 160: [142, 143, 151, 156]
 161: [142, 143, 151, 156, 161]
 162: [143, 151, 156, 161]
 163: [143, 151, 156, 161, 163]
 164: [143, 151, 156, 161, 163]
 165: [151, 156, 161, 163, 165]
 166: [151, 156, 161, 163, 165, 166]
 167: [151, 156, 161, 163, 165, 166]
 168: [151, 156, 161, 163, 165, 166]
 169: [156, 161, 163, 165, 166]
 170: [156, 161, 163, 165, 166]
 171: [156, 161, 163, 165, 166]
 172: [156, 161, 163, 165, 166]
 173: [156, 161, 163, 165, 166]
 174: [161, 163, 165, 166]
 175: [161, 163, 165, 166]
 176: [161, 163, 165, 166]
 177: [161, 163, 165, 166]
 178: [161, 163, 165, 166, 178]
 179: [161, 163, 165, 166, 178]
 180: [163, 165, 166, 178, 180]
 181: [163, 165, 166, 178, 180, 181]
 182: [163, 165, 166, 178, 180, 181]
 183: [163, 165, 166, 178, 180, 181]
 184: [165, 166, 178, 180, 181]
 185: [165, 166, 178, 180, 181, 185]
 186: [165, 166, 178, 180, 181, 185]
 187: [166, 178, 180, 181, 185, 187]
 188: [166, 178, 180, 181, 185, 187]
 189: [166, 178, 180, 181, 185, 187]
 190: [166, 178, 180, 181, 185, 187]
 191: [166, 178, 180, 181, 185, 187]
 192: [178, 180, 181, 185, 187]
 193: [178, 180, 181, 185, 187]
 194: [178, 180, 181, 185, 187]
 195: [178, 180, 181, 185, 187]
 196: [178, 180, 181, 185, 187, 196]
 197: [178, 180, 181, 185, 187, 196, 197]
 198: [178, 180, 181, 185, 187, 196, 197]
 199: [180, 181, 185, 187, 196, 197, 199]
 200: [180, 181, 185, 187, 196, 197, 199]
 201: [180, 181, 185, 187, 196, 197, 199]
 202: [180, 181, 185, 187, 196, 197, 199, 202]
 203: [181, 185, 187, 196, 197, 199, 202]
 204: [181, 185, 187, 196, 197, 199, 202, 204]
 205: [181, 185, 187, 196, 197, 199, 202, 204]
 206: [185, 187, 196, 197, 199, 202, 204]
 207: [185, 187, 196, 197, 199, 202, 204]
 208: [185, 187, 196, 197, 199, 202, 204]
 209: [185, 187, 196, 197, 199, 202, 204]
 210: [185, 187, 196, 197, 199, 202, 204]
 211: [185, 187, 196, 197, 199, 202, 204]
 212: [185, 187, 196, 197, 199, 202, 204]
 213: [187, 196, 197, 199, 202, 204, 213]
 214: [187, 196, 197, 199, 202, 204, 213]
 215: [187, 196, 197, 199, 202, 204, 213]
 216: [187, 196, 197, 199, 202, 204, 213]
 217: [187, 196, 197, 199, 202, 204, 213]
 218: [196, 197, 199, 202, 204, 213]
 219: [196, 197, 199, 202, 204, 213, 219]
 220: [196, 197, 199, 202, 204, 213, 219, 220]
 221: [196, 197, 199, 202, 204, 213, 219, 220, 221]
 222: [197, 199, 202, 204, 213, 219, 220, 221]
 223: [197, 199, 202, 204, 213, 219, 220, 221, 223]
 224: [197, 199, 202, 204, 213, 219, 220, 221, 223, 224]
 225: [197, 199, 202, 204, 213, 219, 220, 221, 223, 224]
 226: [197, 199, 202, 204, 213, 219, 220, 221, 223, 224]
 227: [197, 199, 202, 204, 213, 219, 220, 221, 223, 224]
 228: [197, 199, 202, 204, 213, 219, 220, 221, 223, 224]
 229: [199, 202, 204, 213, 219, 220, 221, 223, 224]
 230: [199, 202, 204, 213, 219, 220, 221, 223, 224]
 231: [199, 202, 204, 213, 219, 220, 221, 223, 224]
 232: [199, 202, 204, 213, 219, 220, 221, 223, 224]
 233: [199, 202, 204, 213, 219, 220, 221, 223, 224]
 234: [199, 202, 204, 213, 219, 220, 221, 223, 224]
 235: [199, 202, 204, 213, 219, 220, 221, 223, 224, 235]
 236: [202, 204, 213, 219, 220, 221, 223, 224, 235]
 237: [202, 204, 213, 219, 220, 221, 223, 224, 235]
 238: [202, 204, 213, 219, 220, 221, 223, 224, 235]
 239: [202, 204, 213, 219, 220, 221, 223, 224, 235]
 240: [202, 204, 213, 219, 220, 221, 223, 224, 235]
 241: [204, 213, 219, 220, 221, 223, 224, 235]
 242: [204, 213, 219, 220, 221, 223, 224, 235]
 243: [204, 213, 219, 220, 221, 223, 224, 235]
 244: [213, 219, 220, 221, 223, 224, 235, 244]
 245: [213, 219, 220, 221, 223, 224, 235, 244, 245]
 246: [213, 219, 220, 221, 223, 224, 235, 244, 245]
 247: [213, 219, 220, 221, 223, 224, 235, 244, 245]
 248: [213, 219, 220, 221, 223, 224, 235, 244, 245]
 249: [213, 219, 220, 221, 223, 224, 235, 244, 245]
 250: [219, 220, 221, 223, 224, 235, 244, 245, 250]
 251: [219, 220, 221, 223, 224, 235, 244, 245, 250]
 252: [219, 220, 221, 223, 224, 235, 244, 245, 250]
 253: [219, 220, 221, 223, 224, 235, 244, 245, 250]
 254: [219, 220, 221, 223, 224, 235, 244, 245, 250]
 255: [220, 221, 223, 224, 235, 244, 245, 250]
 256: [220, 221, 223, 224, 235, 244, 245, 250]
 257: [220, 221, 223, 224, 235, 244, 245, 250]
 258: [220, 221, 223, 224, 235, 244, 245, 250]
 259: [220, 221, 223, 224, 235, 244, 245, 250]
 260: [220, 221, 223, 224, 235, 244, 245, 250]
 261: [221, 223, 224, 235, 244, 245, 250]
 262: [221, 223, 224, 235, 244, 245, 250]
 263: [221, 223, 224, 235, 244, 245, 250, 263]
 264: [221, 223, 224, 235, 244, 245, 250, 263]
 265: [221, 223, 224, 235, 244, 245, 250, 263]
 266: [221, 223, 224, 235, 244, 245, 250, 263]
 267: [223, 224, 235, 244, 245, 250, 263]
 268: [223, 224, 235, 244, 245, 250, 263]
 269: [223, 224, 235, 244, 245, 250, 263]
 270: [224, 235, 244, 245, 250, 263]
 271: [224, 235, 244, 245, 250, 263]
 272: [224, 235, 244, 245, 250, 263, 272]
 273: [224, 235, 244, 245, 250, 263, 272]
 274: [235, 244, 245, 250, 263, 272]
 275: [235, 244, 245, 250, 263, 272]
 276: [235, 244, 245, 250, 263, 272]
 277: [235, 244, 245, 250, 263, 272]
 278: [244, 245, 250, 263, 272]
 279: [244, 245, 250, 263, 272]
 280: [244, 245, 250, 263, 272]
 281: [244, 245, 250, 263, 272]
 282: [245, 250, 263, 272]
 283: [245, 250, 263, 272, 283]
 284: [245, 250, 263, 272, 283]
 285: [245, 250, 263, 272, 283, 285]
 286: [245, 250, 263, 272, 283, 285]
 287: [245, 250, 263, 272, 283, 285]
 288: [250, 263, 272, 283, 285, 288]
 289: [250, 263, 272, 283, 285, 288]
 290: [250, 263, 272, 283, 285, 288]
 291: [250, 263, 272, 283, 285, 288]
 292: [250, 263, 272, 283, 285, 288]
 293: [250, 263, 272, 283, 285, 288]
 294: [263, 272, 283, 285, 288]
 295: [263, 272, 283, 285, 288]
 296: [263, 272, 283, 285, 288, 296]
 297: [263, 272, 283, 285, 288, 296]
 298: [272, 283, 285, 288, 296]
 299: [272, 283, 285, 288, 296]
 300: [272, 283, 285, 288, 296]
 301: [272, 283, 285, 288, 296]
 302: [272, 283, 285, 288, 296]
 303: [272, 283, 285, 288, 296]
 304: [283, 285, 288, 296]
 305: [283, 285, 288, 296, 305]
 306: [283, 285, 288, 296, 305, 306]
 307: [283, 285, 288, 296, 305, 306]
 308: [285, 288, 296, 305, 306]
 309: [285, 288, 296, 305, 306]
 310: [285, 288, 296, 305, 306]
 311: [285, 288, 296, 305, 306]
 312: [285, 288, 296, 305, 306]
 313: [288, 296, 305, 306]
 314: [288, 296, 305, 306, 314]
 315: [288, 296, 305, 306, 314]
 316: [288, 296, 305, 306, 314]
 317: [288, 296, 305, 306, 314, 317]
 318: [288, 296, 305, 306, 314, 317, 318]
 319: [296, 305, 306, 314, 317, 318]
 320: [296, 305, 306, 314, 317, 318]
 321: [296, 305, 306, 314, 317, 318]
 322: [296, 305, 306, 314, 317, 318]
 323: [296, 305, 306, 314, 317, 318]
 324: [305, 306, 314, 317, 318]
 325: [305, 306, 314, 317, 318, 325]
 326: [305, 306, 314, 317, 318, 325, 326]
 327: [305, 306, 314, 317, 318, 325, 326]
 328: [305, 306, 314, 317, 318, 325, 326]
 329: [306, 314, 317, 318, 325, 326]
 330: [306, 314, 317, 318, 325, 326]
 331: [306, 314, 317, 318, 325, 326]
 332: [314, 317, 318, 325, 326]
 333: [314, 317, 318, 325, 326]
 334: [314, 317, 318, 325, 326]
 335: [314, 317, 318, 325, 326]
 336: [314, 317, 318, 325, 326]
 337: [314, 317, 318, 325, 326]
 338: [317, 318, 325, 326]
 339: [317, 318, 325, 326]
 340: [317, 318, 325, 326]
 341: [318, 325, 326]
 342: [318, 325, 326]
 343: [318, 325, 326]
 344: [318, 325, 326, 344]
 345: [318, 325, 326, 344]
 346: [325, 326, 344]
 347: [325, 326, 344, 347]
 348: [325, 326, 344, 347]
 349: [325, 326, 344, 347]
 350: [325, 326, 344, 347]
 351: [325, 326, 344, 347]
 352: [326, 344, 347]
 353: [326, 344, 347]
 354: [326, 344, 347]
 355: [326, 344, 347]
 356: [344, 347]
 357: [344, 347]
 358: [344, 347]
 359: [344, 347, 359]
 360: [344, 347, 359, 360]
 361: [344, 347, 359, 360, 361]
 362: [347, 359, 360, 361]
 363: [347, 359, 360, 361]
 364: [347, 359, 360, 361, 364]
 365: [359, 360, 361, 364]
 366: [359, 360, 361, 364]
 367: [359, 360, 361, 364]
 368: [359, 360, 361, 364, 368]
 369: [359, 360, 361, 364, 368, 369]
 370: [359, 360, 361, 364, 368, 369]
 371: [359, 360, 361, 364, 368, 369]
 372: [360, 361, 364, 368, 369]
 373: [360, 361, 364, 368, 369]
 374: [360, 361, 364, 368, 369]
 375: [360, 361, 364, 368, 369]
 376: [361, 364, 368, 369]
 377: [361, 364, 368, 369]
 378: [361, 364, 368, 369]
 379: [361, 364, 368, 369]
 380: [361, 364, 368, 369]
 381: [364, 368, 369]
 382: [364, 368, 369]
 383: [364, 368, 369, 383]
 384: [368, 369, 383]
 385: [368, 369, 383]
 386: [368, 369, 383]
 387: [368, 369, 383]
 388: [369, 383]
 389: [369, 383]
 390: [369, 383]
 391: [369, 383]
 392: [369, 383, 392]
 393: [369, 383, 392]
 394: [383, 392]
 395: [383, 392]
 396: [383, 392]
 397: [383, 392]
 398: [383, 392]
 399: [392]
 400: [392, 400]
 401: [392, 400]
 402: [392, 400]
 403: [400]
 404: [400]
 405: [400]
 406: [400]
 407: [407]
 408: [407]
 409: [407, 409]
 410: [407, 409]
 411: [407, 409, 411]
 412: [409, 411, 412]
 413: [409, 411, 412]
 414: [409, 411, 412]
 415: [409, 411, 412, 415]
 416: [409, 411, 412, 415]
 417: [409, 411, 412, 415]
 418: [409, 411, 412, 415]
 419: [411, 412, 415]
 420: [411, 412, 415]
 421: [411, 412, 415]
 422: [411, 412, 415]
 423: [411, 412, 415]
 424: [411, 412, 415, 424]
 425: [412, 415, 424]
 426: [412, 415, 424, 426]
 427: [412, 415, 424, 426, 427]
 428: [415, 424, 426, 427]
 429: [415, 424, 426, 427, 429]
 430: [415, 424, 426, 427, 429]
 431: [415, 424, 426, 427, 429]
 432: [415, 424, 426, 427, 429]
 433: [415, 424, 426, 427, 429]
 434: [415, 424, 426, 427, 429]
 435: [424, 426, 427, 429]
 436: [424, 426, 427, 429, 436]
 437: [424, 426, 427, 429, 436]
 438: [424, 426, 427, 429, 436, 438]
 439: [424, 426, 427, 429, 436, 438]
 440: [426, 427, 429, 436, 438, 440]
 441: [426, 427, 429, 436, 438, 440]
 442: [426, 427, 429, 436, 438, 440]
 443: [426, 427, 429, 436, 438, 440]
 444: [427, 429, 436, 438, 440]
 445: [427, 429, 436, 438, 440]
 446: [427, 429, 436, 438, 440]
 447: [427, 429, 436, 438, 440]
 448: [429, 436, 438, 440]
 449: [429, 436, 438, 440]
 450: [429, 436, 438, 440]
 451: [429, 436, 438, 440]
 452: [429, 436, 438, 440]
 453: [429, 436, 438, 440, 453]
 454: [436, 438, 440, 453]
 455: [436, 438, 440, 453]
 456: [436, 438, 440, 453, 456]
 457: [436, 438, 440, 453, 456, 457]
 458: [436, 438, 440, 453, 456, 457, 458]
 459: [438, 440, 453, 456, 457, 458]
 460: [438, 440, 453, 456, 457, 458]
 461: [438, 440, 453, 456, 457, 458]
 462: [438, 440, 453, 456, 457, 458]
 463: [438, 440, 453, 456, 457, 458]
 464: [438, 440, 453, 456, 457, 458, 464]
 465: [440, 453, 456, 457, 458, 464]
 466: [440, 453, 456, 457, 458, 464]
 467: [440, 453, 456, 457, 458, 464]
 468: [440, 453, 456, 457, 458, 464, 468]
 469: [440, 453, 456, 457, 458, 464, 468]
 470: [440, 453, 456, 457, 458, 464, 468]
 471: [453, 456, 457, 458, 464, 468]
 472: [453, 456, 457, 458, 464, 468, 472]
 473: [453, 456, 457, 458, 464, 468, 472]
 474: [453, 456, 457, 458, 464, 468, 472, 474]
 475: [456, 457, 458, 464, 468, 472, 474]
 476: [456, 457, 458, 464, 468, 472, 474]
 477: [456, 457, 458, 464, 468, 472, 474]
 478: [456, 457, 458, 464, 468, 472, 474]
 479: [456, 457, 458, 464, 468, 472, 474]
 480: [457, 458, 464, 468, 472, 474]
 481: [457, 458, 464, 468, 472, 474]
 482: [457, 458, 464, 468, 472, 474]
 483: [457, 458, 464, 468, 472, 474]
 484: [457, 458, 464, 468, 472, 474, 484]
 485: [457, 458, 464, 468, 472, 474, 484]
 486: [458, 464, 468, 472, 474, 484]
 487: [458, 464, 468, 472, 474, 484]
 488: [458, 464, 468, 472, 474, 484]
 489: [458, 464, 468, 472, 474, 484]
 490: [458, 464, 468, 472, 474, 484]
 491: [458, 464, 468, 472, 474, 484]
 492: [464, 468, 472, 474, 484]
 493: [464, 468, 472, 474, 484]
 494: [464, 468, 472, 474, 484]
 495: [464, 468, 472, 474, 484, 495]
 496: [464, 468, 472, 474, 484, 495]
 497: [468, 472, 474, 484, 495, 497]
 498: [468, 472, 474, 484, 495, 497, 498]
 499: [468, 472, 474, 484, 495, 497, 498, 499]
 500: [468, 472, 474, 484, 495, 497, 498, 499]
 501: [468, 472, 474, 484, 495, 497, 498, 499, 501]
 502: [468, 472, 474, 484, 495, 497, 498, 499, 501]
 503: [468, 472, 474, 484, 495, 497, 498, 499, 501]
 504: [472, 474, 484, 495, 497, 498, 499, 501]
 505: [472, 474, 484, 495, 497, 498, 499, 501]
 506: [472, 474, 484, 495, 497, 498, 499, 501, 506]
 507: [472, 474, 484, 495, 497, 498, 499, 501, 506, 507]
 508: [472, 474, 484, 495, 497, 498, 499, 501, 506, 507]
 509: [472, 474, 484, 495, 497, 498, 499, 501, 506, 507]
 510: [472, 474, 484, 495, 497, 498, 499, 501, 506, 507, 510]
 511: [474, 484, 495, 497, 498, 499, 501, 506, 507, 510]
 512: [474, 484, 495, 497, 498, 499, 501, 506, 507, 510]
 513: [474, 484, 495, 497, 498, 499, 501, 506, 507, 510]
 514: [474, 484, 495, 497, 498, 499, 501, 506, 507, 510]
 515: [474, 484, 495, 497, 498, 499, 501, 506, 507, 510]
 516: [474, 484, 495, 497, 498, 499, 501, 506, 507, 510, 516]
 517: [484, 495, 497, 498, 499, 501, 506, 507, 510, 516]
 518: [484, 495, 497, 498, 499, 501, 506, 507, 510, 516]
 519: [484, 495, 497, 498, 499, 501, 506, 507, 510, 516]
 520: [495, 497, 498, 499, 501, 506, 507, 510, 516]
 521: [495, 497, 498, 499, 501, 506, 507, 510, 516]
 522: [495, 497, 498, 499, 501, 506, 507, 510, 516]
 523: [495, 497, 498, 499, 501, 506, 507, 510, 516, 523]
 524: [497, 498, 499, 501, 506, 507, 510, 516, 523]
 525: [497, 498, 499, 501, 506, 507, 510, 516, 523]
 526: [497, 498, 499, 501, 506, 507, 510, 516, 523]
 527: [497, 498, 499, 501, 506, 507, 510, 516, 523]
 528: [497, 498, 499, 501, 506, 507, 510, 516, 523]
 529: [497, 498, 499, 501, 506, 507, 510, 516, 523]
 530: [498, 499, 501, 506, 507, 510, 516, 523, 530]
 531: [498, 499, 501, 506, 507, 510, 516, 523, 530]
 532: [498, 499, 501, 506, 507, 510, 516, 523, 530]
 533: [498, 499, 501, 506, 507, 510, 516, 523, 530]
 534: [499, 501, 506, 507, 510, 516, 523, 530, 534]
 535: [499, 501, 506, 507, 510, 516, 523, 530, 534, 535]
 536: [499, 501, 506, 507, 510, 516, 523, 530, 534, 535]
 537: [501, 506, 507, 510, 516, 523, 530, 534, 535]
 538: [501, 506, 507, 510, 516, 523, 530, 534, 535]
 539: [501, 506, 507, 510, 516, 523, 530, 534, 535]
 540: [501, 506, 507, 510, 516, 523, 530, 534, 535]
 541: [506, 507, 510, 516, 523, 530, 534, 535, 541]
 542: [506, 507, 510, 516, 523, 530, 534, 535, 541, 542]
 543: [506, 507, 510, 516, 523, 530, 534, 535, 541, 542, 543]
 544: [506, 507, 510, 516, 523, 530, 534, 535, 541, 542, 543]
 545: [506, 507, 510, 516, 523, 530, 534, 535, 541, 542, 543]
 546: [506, 507, 510, 516, 523, 530, 534, 535, 541, 542, 543]
 547: [507, 510, 516, 523, 530, 534, 535, 541, 542, 543]
 548: [507, 510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 549: [507, 510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 550: [507, 510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 551: [507, 510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 552: [507, 510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 553: [510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 554: [510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 555: [510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 556: [510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 557: [510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 558: [510, 516, 523, 530, 534, 535, 541, 542, 543, 548]
 559: [516, 523, 530, 534, 535, 541, 542, 543, 548]
 560: [516, 523, 530, 534, 535, 541, 542, 543, 548]
 561: [516, 523, 530, 534, 535, 541, 542, 543, 548]
 562: [516, 523, 530, 534, 535, 541, 542, 543, 548]
 563: [516, 523, 530, 534, 535, 541, 542, 543, 548]
 564: [516, 523, 530, 534, 535, 541, 542, 543, 548]
 565: [523, 530, 534, 535, 541, 542, 543, 548, 565]
 566: [523, 530, 534, 535, 541, 542, 543, 548, 565, 566]
 567: [523, 530, 534, 535, 541, 542, 543, 548, 565, 566]
 568: [530, 534, 535, 541, 542, 543, 548, 565, 566]
 569: [530, 534, 535, 541, 542, 543, 548, 565, 566]
 570: [530, 534, 535, 541, 542, 543, 548, 565, 566]
 571: [530, 534, 535, 541, 542, 543, 548, 565, 566]
 572: [530, 534, 535, 541, 542, 543, 548, 565, 566, 572]
 573: [530, 534, 535, 541, 542, 543, 548, 565, 566, 572, 573]
 574: [534, 535, 541, 542, 543, 548, 565, 566, 572, 573]
 575: [534, 535, 541, 542, 543, 548, 565, 566, 572, 573]
 576: [534, 535, 541, 542, 543, 548, 565, 566, 572, 573]
 577: [534, 535, 541, 542, 543, 548, 565, 566, 572, 573]
 578: [535, 541, 542, 543, 548, 565, 566, 572, 573, 578]
 579: [535, 541, 542, 543, 548, 565, 566, 572, 573, 578]
 580: [535, 541, 542, 543, 548, 565, 566, 572, 573, 578]
 581: [535, 541, 542, 543, 548, 565, 566, 572, 573, 578]
 582: [535, 541, 542, 543, 548, 565, 566, 572, 573, 578]
 583: [541, 542, 543, 548, 565, 566, 572, 573, 578, 583]
 584: [541, 542, 543, 548, 565, 566, 572, 573, 578, 583]
 585: [541, 542, 543, 548, 565, 566, 572, 573, 578, 583]
 586: [542, 543, 548, 565, 566, 572, 573, 578, 583]
 587: [542, 543, 548, 565, 566, 572, 573, 578, 583]
 588: [542, 543, 548, 565, 566, 572, 573, 578, 583]
 589: [542, 543, 548, 565, 566, 572, 573, 578, 583]
 590: [543, 548, 565, 566, 572, 573, 578, 583]
 591: [543, 548, 565, 566, 572, 573, 578, 583]
 592: [543, 548, 565, 566, 572, 573, 578, 583]
 593: [543, 548, 565, 566, 572, 573, 578, 583]
 594: [543, 548, 565, 566, 572, 573, 578, 583]
 595: [543, 548, 565, 566, 572, 573, 578, 583, 595]
 596: [548, 565, 566, 572, 573, 578, 583, 595]
 597: [548, 565, 566, 572, 573, 578, 583, 595, 597]
 598: [548, 565, 566, 572, 573, 578, 583, 595, 597]
 599: [548, 565, 566, 572, 573, 578, 583, 595, 597]
 600: [548, 565, 566, 572, 573, 578, 583, 595, 597]
 601: [548, 565, 566, 572, 573, 578, 583, 595, 597]
 602: [565, 566, 572, 573, 578, 583, 595, 597, 602]
 603: [565, 566, 572, 573, 578, 583, 595, 597, 602, 603]
 604: [565, 566, 572, 573, 578, 583, 595, 597, 602, 603]
 605: [565, 566, 572, 573, 578, 583, 595, 597, 602, 603]
 606: [565, 566, 572, 573, 578, 583, 595, 597, 602, 603, 606]
 607: [566, 572, 573, 578, 583, 595, 597, 602, 603, 606, 607]
 608: [566, 572, 573, 578, 583, 595, 597, 602, 603, 606, 607]
 609: [566, 572, 573, 578, 583, 595, 597, 602, 603, 606, 607]
 610: [572, 573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 611: [572, 573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 612: [572, 573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 613: [572, 573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 614: [572, 573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 615: [572, 573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 616: [572, 573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 617: [573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 618: [573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 619: [573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 620: [573, 578, 583, 595, 597, 602, 603, 606, 607, 610]
 621: [573, 578, 583, 595, 597, 602, 603, 606, 607, 610, 621]
 622: [578, 583, 595, 597, 602, 603, 606, 607, 610, 621, 622]
 623: [578, 583, 595, 597, 602, 603, 606, 607, 610, 621, 622]
 624: [578, 583, 595, 597, 602, 603, 606, 607, 610, 621, 622]
 625: [578, 583, 595, 597, 602, 603, 606, 607, 610, 621, 622]
 626: [578, 583, 595, 597, 602, 603, 606, 607, 610, 621, 622]
 627: [583, 595, 597, 602, 603, 606, 607, 610, 621, 622]
 628: [583, 595, 597, 602, 603, 606, 607, 610, 621, 622]
 629: [583, 595, 597, 602, 603, 606, 607, 610, 621, 622]
 630: [595, 597, 602, 603, 606, 607, 610, 621, 622]
 631: [595, 597, 602, 603, 606, 607, 610, 621, 622]
 632: [595, 597, 602, 603, 606, 607, 610, 621, 622, 632]
 633: [595, 597, 602, 603, 606, 607, 610, 621, 622, 632]
 634: [597, 602, 603, 606, 607, 610, 621, 622, 632]
 635: [597, 602, 603, 606, 607, 610, 621, 622, 632]
 636: [597, 602, 603, 606, 607, 610, 621, 622, 632, 636]
 637: [597, 602, 603, 606, 607, 610, 621, 622, 632, 636]
 638: [597, 602, 603, 606, 607, 610, 621, 622, 632, 636]
 639: [602, 603, 606, 607, 610, 621, 622, 632, 636]
 640: [602, 603, 606, 607, 610, 621, 622, 632, 636]
 641: [602, 603, 606, 607, 610, 621, 622, 632, 636]
 642: [602, 603, 606, 607, 610, 621, 622, 632, 636]
 643: [602, 603, 606, 607, 610, 621, 622, 632, 636, 643]
 644: [602, 603, 606, 607, 610, 621, 622, 632, 636, 643]
 645: [602, 603, 606, 607, 610, 621, 622, 632, 636, 643]
 646: [603, 606, 607, 610, 621, 622, 632, 636, 643, 646]
 647: [603, 606, 607, 610, 621, 622, 632, 636, 643, 646]
 648: [603, 606, 607, 610, 621, 622, 632, 636, 643, 646, 648]
 649: [603, 606, 607, 610, 621, 622, 632, 636, 643, 646, 648, 649]
 650: [603, 606, 607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650]
 651: [603, 606, 607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651]
 652: [603, 606, 607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651]
 653: [606, 607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651]
 654: [606, 607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651]
 655: [606, 607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651]
 656: [607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 657: [607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 658: [607, 610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 659: [610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 660: [610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 661: [610, 621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 662: [621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 663: [621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 664: [621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 665: [621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 666: [621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 667: [621, 622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 668: [622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 669: [622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 670: [622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 671: [622, 632, 636, 643, 646, 648, 649, 650, 651, 656]
 672: [622, 632, 636, 643, 646, 648, 649, 650, 651, 656, 672]
 673: [622, 632, 636, 643, 646, 648, 649, 650, 651, 656, 672]
 674: [632, 636, 643, 646, 648, 649, 650, 651, 656, 672]
 675: [632, 636, 643, 646, 648, 649, 650, 651, 656, 672]
 676: [632, 636, 643, 646, 648, 649, 650, 651, 656, 672, 676]
 677: [632, 636, 643, 646, 648, 649, 650, 651, 656, 672, 676]
 678: [632, 636, 643, 646, 648, 649, 650, 651, 656, 672, 676, 678]
 679: [636, 643, 646, 648, 649, 650, 651, 656, 672, 676, 678]
 680: [636, 643, 646, 648, 649, 650, 651, 656, 672, 676, 678]
 681: [636, 643, 646, 648, 649, 650, 651, 656, 672, 676, 678]
 682: [636, 643, 646, 648, 649, 650, 651, 656, 672, 676, 678]
 683: [636, 643, 646, 648, 649, 650, 651, 656, 672, 676, 678]
 684: [636, 643, 646, 648, 649, 650, 651, 656, 672, 676, 678]
 685: [643, 646, 648, 649, 650, 651, 656, 672, 676, 678]
 686: [643, 646, 648, 649, 650, 651, 656, 672, 676, 678, 686]
 687: [643, 646, 648, 649, 650, 651, 656, 672, 676, 678, 686]
 688: [643, 646, 648, 649, 650, 651, 656, 672, 676, 678, 686, 688]
 689: [643, 646, 648, 649, 650, 651, 656, 672, 676, 678, 686, 688]
 690: [643, 646, 648, 649, 650, 651, 656, 672, 676, 678, 686, 688]
 691: [646, 648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691]
 692: [646, 648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692]
 693: [646, 648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692]
 694: [646, 648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692]
 695: [648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695]
 696: [648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695]
 697: [648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695]
 698: [648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695]
 699: [648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699]
 700: [648, 649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699]
 701: [649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699]
 702: [649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702]
 703: [649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702]
 704: [649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702]
 705: [649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702]
 706: [649, 650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 707: [650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 708: [650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 709: [650, 651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 710: [651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 711: [651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 712: [651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 713: [651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 714: [651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 715: [651, 656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 716: [656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 717: [656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706]
 718: [656, 672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718]
 719: [672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718]
 720: [672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718]
 721: [672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718]
 722: [672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718]
 723: [672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718]
 724: [672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718]
 725: [672, 676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718, 725]
 726: [676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718, 725]
 727: [676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718, 725]
 728: [676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718, 725]
 729: [676, 678, 686, 688, 691, 692, 695, 699, 702, 706, 718, 725]
 730: [678, 686, 688, 691, 692, 695, 699, 702, 706, 718, 725]
 731: [678, 686, 688, 691, 692, 695, 699, 702, 706, 718, 725, 731]
 732: [678, 686, 688, 691, 692, 695, 699, 702, 706, 718, 725, 731]
 733: [686, 688, 691, 692, 695, 699, 702, 706, 718, 725, 731]
 734: [686, 688, 691, 692, 695, 699, 702, 706, 718, 725, 731]
 735: [686, 688, 691, 692, 695, 699, 702, 706, 718, 725, 731, 735]
 736: [686, 688, 691, 692, 695, 699, 702, 706, 718, 725, 731, 735]
 737: [688, 691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737]
 738: [688, 691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737]
 739: [688, 691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739]
 740: [688, 691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740]
 741: [688, 691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740]
 742: [688, 691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740]
 743: [691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740]
 744: [691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 745: [691, 692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 746: [692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 747: [692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 748: [692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 749: [692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 750: [692, 695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 751: [695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 752: [695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 753: [695, 699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 754: [699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 755: [699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 756: [699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 757: [699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744]
 758: [699, 702, 706, 718, 725, 731, 735, 737, 739, 740, 744, 758]
 759: [702, 706, 718, 725, 731, 735, 737, 739, 740, 744, 758]
 760: [702, 706, 718, 725, 731, 735, 737, 739, 740, 744, 758]
 761: [702, 706, 718, 725, 731, 735, 737, 739, 740, 744, 758]
 762: [702, 706, 718, 725, 731, 735, 737, 739, 740, 744, 758]
 763: [702, 706, 718, 725, 731, 735, 737, 739, 740, 744, 758, 763]
 764: [702, 706, 718, 725, 731, 735, 737, 739, 740, 744, 758, 763]
 765: [702, 706, 718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765]
 766: [706, 718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765]
 767: [706, 718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765]
 768: [706, 718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768]
 769: [706, 718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768]
 770: [706, 718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768]
 771: [718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 772: [718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 773: [718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 774: [718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 775: [718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 776: [718, 725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 777: [725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 778: [725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 779: [725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771]
 780: [725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780]
 781: [725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780]
 782: [725, 731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780]
 783: [731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780]
 784: [731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780]
 785: [731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780]
 786: [731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780]
 787: [731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780]
 788: [731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 789: [731, 735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 790: [735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 791: [735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 792: [735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 793: [735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 794: [735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 795: [735, 737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 796: [737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 797: [737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 798: [737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 799: [737, 739, 740, 744, 758, 763, 765, 768, 771, 780, 788]
 800: [739, 740, 744, 758, 763, 765, 768, 771, 780, 788, 800]
 801: [739, 740, 744, 758, 763, 765, 768, 771, 780, 788, 800]
 802: [739, 740, 744, 758, 763, 765, 768, 771, 780, 788, 800]
 803: [739, 740, 744, 758, 763, 765, 768, 771, 780, 788, 800]
 804: [740, 744, 758, 763, 765, 768, 771, 780, 788, 800]
 805: [740, 744, 758, 763, 765, 768, 771, 780, 788, 800]
 806: [740, 744, 758, 763, 765, 768, 771, 780, 788, 800]
 807: [740, 744, 758, 763, 765, 768, 771, 780, 788, 800, 807]
 808: [740, 744, 758, 763, 765, 768, 771, 780, 788, 800, 807]
 809: [744, 758, 763, 765, 768, 771, 780, 788, 800, 807]
 810: [744, 758, 763, 765, 768, 771, 780, 788, 800, 807, 810]
 811: [744, 758, 763, 765, 768, 771, 780, 788, 800, 807, 810, 811]
 812: [758, 763, 765, 768, 771, 780, 788, 800, 807, 810, 811]
 813: [758, 763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813]
 814: [758, 763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813]
 815: [758, 763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813]
 816: [758, 763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813]
 817: [758, 763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813]
 818: [758, 763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813]
 819: [763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813]
 820: [763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813]
 821: [763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821]
 822: [763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821]
 823: [763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823]
 824: [763, 765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823]
 825: [765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823]
 826: [765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823]
 827: [765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823]
 828: [765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828]
 829: [765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828]
 830: [765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828]
 831: [765, 768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828]
 832: [768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832]
 833: [768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832]
 834: [768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832]
 835: [768, 771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832]
 836: [771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832]
 837: [771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832]
 838: [771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832]
 839: [771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832]
 840: [771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840]
 841: [771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840]
 842: [771, 780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840]
 843: [780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840]
 844: [780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 845: [780, 788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 846: [788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 847: [788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 848: [788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 849: [788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 850: [788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 851: [788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 852: [788, 800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844]
 853: [800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853]
 854: [800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853]
 855: [800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855]
 856: [800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856]
 857: [800, 807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856]
 858: [807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856]
 859: [807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856]
 860: [807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 861: [807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 862: [807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 863: [807, 810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 864: [810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 865: [810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 866: [810, 811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 867: [811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 868: [811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 869: [811, 813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 870: [813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 871: [813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 872: [813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860]
 873: [813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873]
 874: [813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873]
 875: [813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873]
 876: [813, 821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873]
 877: [821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873]
 878: [821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873, 878]
 879: [821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873, 878]
 880: [821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873, 878]
 881: [821, 823, 828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881]
 882: [823, 828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881]
 883: [823, 828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883]
 884: [823, 828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883]
 885: [823, 828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883]
 886: [828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883]
 887: [828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 888: [828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 889: [828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 890: [828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 891: [828, 832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 892: [832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 893: [832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 894: [832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 895: [832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 896: [832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887]
 897: [832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897]
 898: [832, 840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897]
 899: [840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897]
 900: [840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897]
 901: [840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901]
 902: [840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901]
 903: [840, 844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903]
 904: [844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904]
 905: [844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905]
 906: [844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905]
 907: [844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905]
 908: [844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908]
 909: [844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908]
 910: [844, 853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908]
 911: [853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911]
 912: [853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911]
 913: [853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911]
 914: [853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911]
 915: [853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911]
 916: [853, 855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911]
 917: [855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911]
 918: [855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918]
 919: [855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 920: [855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 921: [855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 922: [855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 923: [855, 856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 924: [856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 925: [856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 926: [856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 927: [856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 928: [856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 929: [856, 860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 930: [860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 931: [860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919]
 932: [860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932]
 933: [860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932]
 934: [860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934]
 935: [860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934]
 936: [860, 873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934]
 937: [873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934]
 938: [873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938]
 939: [873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938]
 940: [873, 878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940]
 941: [878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940]
 942: [878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940]
 943: [878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940]
 944: [878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940]
 945: [878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940]
 946: [878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 947: [878, 881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 948: [881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 949: [881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 950: [881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 951: [881, 883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 952: [883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 953: [883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 954: [883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 955: [883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946]
 956: [883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956]
 957: [883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957]
 958: [883, 887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957]
 959: [887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957]
 960: [887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957]
 961: [887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957]
 962: [887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957]
 963: [887, 897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 964: [897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 965: [897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 966: [897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 967: [897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 968: [897, 901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 969: [901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 970: [901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 971: [901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 972: [901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963]
 973: [901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973]
 974: [901, 903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974]
 975: [903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974]
 976: [903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976]
 977: [903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976]
 978: [903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 979: [903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 980: [903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 981: [903, 904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 982: [904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 983: [904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 984: [904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 985: [904, 905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 986: [905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 987: [905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 988: [905, 908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 989: [908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 990: [908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 991: [908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 992: [908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 993: [908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978]
 994: [908, 911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994]
 995: [911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994]
 996: [911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994]
 997: [911, 918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994]
 998: [918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994]
 999: [918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999]
 1000: [918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999]
 1001: [918, 919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001]
 1002: [919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001]
 1003: [919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001]
 1004: [919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004]
 1005: [919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004]
 1006: [919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004]
 1007: [919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007]
 1008: [919, 932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1009: [932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1010: [932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1011: [932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1012: [932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1013: [932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1014: [932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1015: [932, 934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1016: [934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1017: [934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1018: [934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1019: [934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1020: [934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1021: [934, 938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1022: [938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1023: [938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1024: [938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008]
 1025: [938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1026: [938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1027: [938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1028: [938, 940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1029: [940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1030: [940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1031: [940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1032: [940, 946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1033: [946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1034: [946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1035: [946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025]
 1036: [946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036]
 1037: [946, 956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036]
 1038: [956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038]
 1039: [956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038]
 1040: [956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038]
 1041: [956, 957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038]
 1042: [957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042]
 1043: [957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042]
 1044: [957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044]
 1045: [957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044]
 1046: [957, 963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046]
 1047: [963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046]
 1048: [963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046]
 1049: [963, 973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046]
 1050: [973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050]
 1051: [973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050]
 1052: [973, 974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052]
 1053: [974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053]
 1054: [974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054]
 1055: [974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054]
 1056: [974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054]
 1057: [974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057]
 1058: [974, 976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057]
 1059: [976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057]
 1060: [976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060]
 1061: [976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060]
 1062: [976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060]
 1063: [976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063]
 1064: [976, 978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064]
 1065: [978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064]
 1066: [978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066]
 1067: [978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067]
 1068: [978, 994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067]
 1069: [994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067]
 1070: [994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067]
 1071: [994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067]
 1072: [994, 999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067]
 1073: [999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067]
 1074: [999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067]
 1075: [999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075]
 1076: [999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075]
 1077: [999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075]
 1078: [999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1079: [999, 1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1080: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1081: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1082: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1083: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1084: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1085: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1086: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1087: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1088: [1001, 1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1089: [1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1090: [1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1091: [1004, 1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1092: [1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1093: [1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1094: [1007, 1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1095: [1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1096: [1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1097: [1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1098: [1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1099: [1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1100: [1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1101: [1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1102: [1008, 1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1103: [1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1104: [1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1105: [1025, 1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1106: [1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1107: [1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1108: [1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1109: [1036, 1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1110: [1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1111: [1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1112: [1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1113: [1038, 1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1114: [1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1115: [1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1116: [1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1117: [1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1118: [1042, 1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1119: [1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1120: [1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1121: [1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1122: [1044, 1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1123: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1124: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1125: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1126: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1127: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1128: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1129: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1130: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1131: [1046, 1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1132: [1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1133: [1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1134: [1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1135: [1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1136: [1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1137: [1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1138: [1050, 1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1139: [1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1140: [1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1141: [1052, 1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1142: [1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1143: [1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1144: [1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1145: [1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1146: [1053, 1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1147: [1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1148: [1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1149: [1054, 1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1150: [1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1151: [1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1152: [1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1153: [1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1154: [1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1155: [1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1156: [1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1157: [1057, 1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1158: [1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1159: [1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1160: [1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1161: [1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1162: [1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1163: [1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1164: [1060, 1063, 1064, 1066, 1067, 1075, 1078]
 1165: [1063, 1064, 1066, 1067, 1075, 1078]
 1166: [1063, 1064, 1066, 1067, 1075, 1078]
 1167: [1063, 1064, 1066, 1067, 1075, 1078]
 1168: [1063, 1064, 1066, 1067, 1075, 1078]
 1169: [1063, 1064, 1066, 1067, 1075, 1078]
 1170: [1063, 1064, 1066, 1067, 1075, 1078]
 1171: [1064, 1066, 1067, 1075, 1078]
 1172: [1064, 1066, 1067, 1075, 1078]
 1173: [1064, 1066, 1067, 1075, 1078]
 1174: [1064, 1066, 1067, 1075, 1078]
 1175: [1064, 1066, 1067, 1075, 1078]
 1176: [1064, 1066, 1067, 1075, 1078]
 1177: [1064, 1066, 1067, 1075, 1078]
 1178: [1064, 1066, 1067, 1075, 1078]
 1179: [1066, 1067, 1075, 1078]
 1180: [1066, 1067, 1075, 1078]
 1181: [1066, 1067, 1075, 1078]
 1182: [1066, 1067, 1075, 1078]
 1183: [1066, 1067, 1075, 1078]
 1184: [1066, 1067, 1075, 1078]
 1185: [1066, 1067, 1075, 1078]
 1186: [1066, 1067, 1075, 1078]
 1187: [1067, 1075, 1078]
 1188: [1067, 1075, 1078]
 1189: [1067, 1075, 1078]
 1190: [1067, 1075, 1078]
 1191: [1067, 1075, 1078]
 1192: [1067, 1075, 1078]
 1193: [1067, 1075, 1078]
 1194: [1067, 1075, 1078]
 1195: [1067, 1075, 1078]
 1196: [1075, 1078]
 1197: [1075, 1078]
 1198: [1075, 1078]
 1199: [1075, 1078]
 1200: [1075, 1078]
 1201: [1078]
 1202: [1078]
 1203: [1078]
 1204: [1078]
 1205: []
 Total customers served = 234
 Average wait time = 48.36752136752137
 Longest wait time = 129
 Longest queue = 22
 
  ----jGRASP: operation complete.
  **************************************/

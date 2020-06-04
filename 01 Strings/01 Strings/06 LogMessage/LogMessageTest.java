// Name: S2-17
// Date: 09/16/19
import java.util.*;

public class LogMessageTest
{
   public static void main(String[] args)
   {
      String[] messages = {
         "CLIENT3:security alert - repeated login failures",
         "Webserver:disk offline",
         "SERVER1:file not found",
         "SERVER2:read error on disk DSK1",
         "SERVER1:write error on disk DSK2",
         "Webserver:error on /dev/disk",
         "True:disk",
         "True:error on disk",
         "True:error on /dev/disk disk",
         "True:error on disk DSK1",
         "False:DISK",
         "False:error on disk3",
         "False:error on /dev/disk",
         "False:diskette"};
   
    // Parts A and B
    
      for (String s : messages)
      {
         LogMessage msg = new LogMessage(s);
         System.out.println(msg.getMachineId() + ":" + msg.getDescription() + " ==> " + msg.containsWord("disk"));
      }
    
   // Part C
      /*SystemLog theLog  = new SystemLog(messages);
      LogMessage[] removed = theLog.removeMessages("disk");
        
      System.out.println();
    
      System.out.println("Removed messages:\n");
      for (LogMessage msg : removed)
         System.out.println(msg);
      System.out.println();
    
      System.out.println("Remaining messages:\n");
      System.out.println(theLog);
    */
   }
}
   
class LogMessage
{
   private String machineId;
   private String description;
      
      /* Part (a) */
      
   //Sets machineId equal to the substring of the beginning to the index of the colon, but not including the colon itself
   //Sets the description to the substring of the index after the colon to the end of the string, also not including the colon itself
   
   public LogMessage(String message)
   {
      machineId = message.substring(0, message.indexOf(':'));
      description = message.substring(message.indexOf(':') + 1, message.length());
   }
      
      /* Part (b) */
      //We first make a string that will hold the original description because we change the description in the method.
      //Next, do a while loop that will be run while description contains the keyword. This is so that we will be able to get check
      //all instances of the keyword. The first if statement checks if the character before the index of keyword is a space (checks
      //if it is preceeded by a space) or if the description starts with the keyword. The if statement within the first if checks if
      //the character after the index of the word plus the length equals a space (checks if it is followed by a space), or if the
      //the description ends with the keyword. If all of this ends up being true, then we return true, because it would be contained
      //properly. We also set the description back to what it orignally was (it may have been changed, as you will see later. 
      //Outside of the if statements but inside the while, we set description equal to the substring of the beginning
      //to the description to the index of the keyword plus the substring of the index of the keyword plus the length to the end, effectively
      //removing the first instance of disk. Now, if there are 2 instances of disk in the description, we can check if the other instance satisfies
      //the conditions. Then after all of this, we set description back to what it was before and return false.
   public boolean containsWord(String keyword)
   {
      String original = description;
      while(description.contains(keyword))
      {
         if((description.startsWith(keyword) || description.charAt(description.indexOf(keyword) - 1) == ' '))
         {
            if(description.endsWith(keyword) || description.charAt(description.indexOf(keyword) + keyword.length()) == ' ')
            {
               description = original;
               return true;
            }
         }
         description = description.substring(0, description.indexOf(keyword)) +  description.substring(description.indexOf(keyword) + keyword.length()) ; 
      }
      description = original;
      return false;
   }
      
   public String getMachineId()
   { 
      return machineId; 
   }
      
   public String getDescription()
   { 
      return description; 
   }
      
   public String toString()
   {
      return getMachineId() + ":" + getDescription();
   }
}
   
class SystemLog
{
   private LogMessage[] messageList;
      
   public SystemLog(String[] messages)
   {
      messageList = new LogMessage[messages.length];
      for (int i=0;i<messages.length; i++)
         messageList[i]=(new LogMessage(messages[i]));
   }
      
      /* Part (c) */
      /*
      public LogMessage[] removeMessages(String keyword)
      {
      int amount = 0;
      for(int x = 0; x < messageList.length; x++)
      {
         if(messageList[x].containsWord(keyword))
         {
            amount++;
         }
      }
      int currentFinal = -1;
      int currentStorage = -1;
      LogMessage[] finalArray = new LogMessage[amount];
      LogMessage[] storageArray = new LogMessage[messageList.length - amount];
      for(int x = 0; x < messageList.length; x++)
      {
         if(messageList[x].containsWord(keyword))
         {
            currentFinal++;
            finalArray[currentFinal] = messageList[x];    
         }
         else
         {
            currentStorage++;
            storageArray[currentStorage] = messageList[x];
         }
      }
      messageList = storageArray;
      return finalArray;   
       
      }    */
      
      
   public String toString()
   {
      String s = "";
      for (LogMessage msg : messageList)
         s += msg + "\n";
      return s;
   }
}
      
      /**************** Sample output:
      
      // Parts a and b   
      
      CLIENT3:security alert - repeated login failures ==> false
      Webserver:disk offline ==> true
      SERVER1:file not found ==> false
      SERVER2:read error on disk DSK1 ==> true
      SERVER1:write error on disk DSK2 ==> true
      Webserver:error on /dev/disk ==> false
      True:disk ==> truet
      True:error on disk ==> true
      True:error on /dev/disk disk ==> true
      True:error on disk DSK1 ==> true
      False:DISK ==> false
      False:error on disk3 ==> false
      False:error on /dev/disk ==> false
      False:diskette ==> false
      
      
      // Part c  
      
      Removed messages:
      
      Webserver:disk offline
      SERVER2:read error on disk DSK1
      SERVER1:write error on disk DSK2
      True:disk
      True:error on disk
      True:error on /dev/disk disk
      True:error on disk DSK1
      
      Remaining messages:
      
      CLIENT3:security alert - repeated login failures
      SERVER1:file not found
      Webserver:error on /dev/disk
      False:DISK
      False:error on disk3
      False:error on /dev/disk
      False:diskette
      
      ********************************************/    
      /**********************************************/
      
   

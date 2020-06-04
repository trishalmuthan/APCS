// Name: Trishal Muthan
// Date: 08-27-2019

public class Modes
{
    public static void main(String[] args)
    {
        int[] tally = {0,0,10,5,10,0,7,1,0,6,0,10,3,0,0,1};
        display(tally);
        int[] modes = calculateModes(tally);
        display(modes);
        int sum = 0;
        for(int k = 0; k < tally.length; k++)
            sum += tally[k];
        System.out.println("kth \tindex"); 
        for(int k = 1; k <= sum; k++)
            System.out.println(k + "\t\t" + kthDataValue(tally, k));
}
      
   /**
    * precondition: tally.length > 0
    * postcondition: returns an int array that contains the modes(s);
    *                the array's length equals the number of modes.
    */
    public static int[] calculateModes(int[] tally)
    {
    int numberOfSlots = 0;
    //initializes the variable used to keep track of the number of slots
    int maxVal = findMax(tally);
    //finds the max value
        for(int x = 0; x < tally.length; x++)
        {
            if(tally[x] == maxVal)
            {
               numberOfSlots++;
            }  
        }
    //this for-loop goes through the array and finds the indices where there is a mode and increases
    //numberOfSlots whenever it finds a mode
    
        int banana[] = new int[numberOfSlots];
    //a new array is created with that specific number of slots
        int current = 0;
        for(int x = 0; x < tally.length; x++)
        {
            if(tally[x] == maxVal)
            {
               banana[current] = x;
               current++;
            }  
        }
        //this for-loop goes through the array and if a mode is found, it adds its index to the new array banana
        //current increases the index so that every new value is added into a separate index in the new array banana

        return banana;
    }
      
   /**  
    * precondition:  tally.length > 0
    * 	             0 < k <= total number of values in data collection
    * postcondition: returns the kth value in the data collection
    *                represented by tally
    */
    public static int kthDataValue(int[] tally, int k)
    {
        int sum = 0;
        int value = 0;
        //2 new variables are initialized for use later on
        for(int r = 0; r < tally.length; r++)
        {
           sum += tally[r];
        //the entire array is summed up
           if(sum >= k)
           {
        //if the value the user inputs is less than or equal to the sum that means that they are at the correct current index
            value = r;
        //the index is stored into a separate variable called value so it can be returned later on
            break;
        //the loop is stopped
           } 
        }
        return value;
        
    }
      
   /**
    * precondition:  nums.length > 0
    * postcondition: returns the maximal value in nums
    */
    public static int findMax(int[] nums)
    {
        int pos = 0;
        for(int k = 1; k < nums.length; k++)
            if(nums[k] > nums[pos])
                pos = k;
            return nums[pos];
    }
    
    public static void display(int[] args)
    {
        for(int k = 0; k < args.length; k++)
            System.out.print(args[k] + " ");
        System.out.println();
        System.out.println();
    }
}

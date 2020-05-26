package Stack_Queue;
/*
 * http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * http://codingrecipies.blogspot.com/2013/10/petrol-pump-problem.html
 *  Time complexity is O(n).
 *  Auxiliary Space: O(1)
 */
public class Q9_FirstCircularTourThatVisitsAllPetrolPumps {

	public static int getStartIndex(int[] dist , int[] petrol){
		// Consider first petrol pump as a starting point
	    int start = 0;
	    int end =  1;
	    int n = dist.length;
	    int curr_petrol = petrol[start] - dist[start];
	 
	    /* Run a loop while all petrol pumps are not visited.
	      And we have reached first petrol pump again with 0 or more petrol */
	    while (end != start || curr_petrol < 0){
	        // If curremt amount of petrol in truck becomes less than 0, then
	        // remove the starting petrol pump from tour
	        while (curr_petrol < 0 && start != end){
	            // Remove starting petrol pump. Change start
	            curr_petrol -= petrol[start] - dist[start];
	            start = (start + 1)%n;
	 
	            // If 0 is being considered as start again, then there is no
	            // possible solution
	            if (start == 0)
	               return -1;
	        }
	 
	        // Add a petrol pump to current tour
	        curr_petrol += petrol[end] - dist[end];
	 
	        end = (end + 1)%n;
	    }
	 
	    // Return starting point
	    return start;
	}

	public static void main(String[] args) {
		int [] petrol =  {6, 3, 7};
		int [] dist =  {4, 6, 3};

		int index= getStartIndex(dist, petrol);

		if(index == -1)
			System.out.println("Solution Does not exist");
		else
			System.out.println("Petrol Pump Number : " +(index + 1));
	}
}

package Strings;
/*
 * http://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
 * Time complexity of above solution is O(n) and extra space required is O(CHAR_MAX)
 * where CHAR_MAX is total number of possible characters in given sequence.
 */
public class S044_FindNumberOfCustomersWhoCouldNotGetComputer {

	// n is number of computers in cafe.
	// 'seq' is given sequence of customer entry, exit events
	public int runCustomerSimulation(int n, String seq){
	    // seen[i] = 0, indicates that customer 'i' is not in cafe
	    // seen[1] = 1, indicates that customer 'i' is in cafe but
	    //              computer is not assigned yet.
	    // seen[2] = 2, indicates that customer 'i' is in cafe and
	    //              has occupied a computer.
	    int[] seen = new int[26];
	 
	    // Initialize result which is number of customers who could
	    // not get any computer.
	    int res = 0;
	 
	    int occupied = 0;  // To keep track of occupied computers
	 
	    // Travers the input sequence
	    for (int i=0; i<seq.length(); i++){
	        // Find index of current character in seen[0...25]
	        int ind = seq.charAt(i) - 'A';
	 
	        // If First occurrence of 'seq[i]'
	        if (seen[ind] == 0){
	            // set the current character as seen
	            seen[ind] = 1;
	 
	            // If number of occupied computers is less than
	            // n, then assign a computer to new customer
	            if (occupied < n){
	                occupied++;
	 
	                // Set the current character as occupying a computer
	                seen[ind] = 2;
	            }
	 
	            // Else this customer cannot get a computer,
	            // increment result
	            else
	                res++;
	        }
	 
	        // If this is second occurrence of 'seq[i]'
	        else{
	           // Decrement occupied only if this customer
	           // was using a computer
	           if (seen[ind] == 2)
	               occupied--;
	           seen[ind] = 0;
	        }
	    }
	    return res;
	}
	public static void main(String[] args) {
		S044_FindNumberOfCustomersWhoCouldNotGetComputer obj = new S044_FindNumberOfCustomersWhoCouldNotGetComputer();
		System.out.println(obj.runCustomerSimulation(2, "ABBAJJKZKZ"));
		System.out.println(obj.runCustomerSimulation(3, "GACCBDDBAGEE"));
	    System.out.println(obj.runCustomerSimulation(3, "GACCBGDDBAEE"));
	    System.out.println(obj.runCustomerSimulation(1, "ABCBCA"));
	    System.out.println(obj.runCustomerSimulation(1, "ABCBCADEED"));
	}
}

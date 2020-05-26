package Strings;
/*
 * http://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
 */
public class LongestEvenLengthSubstringSuchThatSumOfFirstAndSecondHalfIsSame {

	public static int findLength(String str){
		
	    int ans = 0; // Initialize result
	    int n = str.length();
	    // Consider all possible midpoints one by one
	    for (int i = 0; i <= n-2; i++){
	        /* For current midpoint 'i', keep expanding substring on
	           both sides, if sum of both sides becomes equal update ans 
	         */
	        int l = i, r = i + 1;
	 
	        /* initialize left and right sum */
	        int lsum = 0, rsum = 0;
	 
	        /* move on both sides till indexes go out of bounds */
	        while (r < n && l >= 0){
	            lsum += str.charAt(l) - '0';
	            rsum += str.charAt(r) - '0';
	            if (lsum == rsum)
	                ans = Math.max(ans, r-l+1);
	            l--;
	            r++;
	        }
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(findLength("123123"));
	}
}

package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * https://www.youtube.com/watch?v=cETfFsSTGJI
 * Given array A = {2,3,1,1,4} 
	possible ways to reach the end (index list) 
	i) 0,2,3,4 (jump 2 to index 2, then jump 1 to index 3 then 1 to index 4) 
	ii) 0,1,4 (jump 1 to index 1, then jump 3 to index 4)
	
	Time Complexity: O(n^2)
 */

public class A051_MinimumNumberOfJumpsToReachEnd {

	// In this method, we build a jumps[] array from left to right such that jumps[i] indicates the minimum number of jumps needed 
	// to reach arr[i] from arr[0]. Finally, we return jumps[n-1].
	public static int minJumpDP(int[] arr){
		// arr to store the number of jumps
		int[] jump = new int[arr.length];
		// arr to store the path you took to reach the final index
		int[] result = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
            	// check if jump is even possible or not, take the arr value(ie count of jumps that can be taken)+ the index of the elem
            	// and compare it with the destination index
                if(arr[j] + j >= i){
                	// if jump is possible we check if there is already a path or not if so and its value(jump[i]) is greater then the 
                	// new path we have found if so we update it to the new lesser value.
                    if(jump[i] > jump[j] + 1){
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }
        
        return jump[jump.length-1];
	}
	public int minJump(int[] A){
	
		if (A == null || A.length==0) return -1;
		if (A.length==1) return 0;

		int minStep = 0, start = 0;
		// current longest distance the jump can reach
		int end = A[start];

		// if current longest distance plus current postion passed the length of array then return current minStep + 1;
		if (start+end >= A.length-1){
			return minStep+1;
		}
		if((end == 0) && (start < A.length-1)) return -1;
		
		while(end < A.length-1){
			minStep++;
			// record farest position can be reached by jump from position within current farest position
			int max = 0;
			for (int i = start; i <= end; i++){
				int current = i+A[i];
				// pass the total length, return minStep+1, 
				if (current >= A.length-1){
					return minStep+1;
				}
				max = Math.max(max,current);
			}
			// update start position(items in array are not negative, so end+1 exist)
			start = end+1;
			// update the most far position can reached for next jump
			end = max;
			if((end == 0) && (start < A.length-1)) return -1;
		}
		return minStep;
	}
	
	
	
	public static void main(String[] args) {
		A051_MinimumNumberOfJumpsToReachEnd obj = new A051_MinimumNumberOfJumpsToReachEnd();
		int[] arr = {1, 3, 6, 1, 0, 9};
		//int result = obj.minJump(arr);
		//System.out.println("Min jumps needed:"+result);
		int result = obj.minJumpDP(arr);
		System.out.println("Min jumps needed dp:"+result);
	}
}

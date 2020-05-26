package Easy;
/*
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class E_0941_ValidMountainArray {

	public boolean validMountainArray(int[] A) {

			int len = A.length, i = 1;
	
	    	while(i < len && A[i-1] <= A[i]) {
	    		if(A[i-1] == A[i]) return false;
	    		i++;
	    	}
	    	
	    	if(i == len || i == 1) return false;
	    	
	    	while(i < len) {
	    		if(A[i-1] <= A[i]) return false;
	    		i++;
	    	}
	    	return true;
    }
	public static void main(String[] args) {
		E_0941_ValidMountainArray obj = new E_0941_ValidMountainArray();
		System.out.println(obj.validMountainArray(new int[] {2,1}));
		System.out.println(obj.validMountainArray(new int[] {1,2,3, 2}));
	}

}

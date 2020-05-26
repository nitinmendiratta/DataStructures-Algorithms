package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/duplicate-zeros/
 */
public class E_1089_DuplicateZeros {

	// 2 pointers
	public void duplicateZeros(int[] arr) {
        int len = arr.length, i = 0, j = len-1, countZero = 0;
        
        // decr j to make space for starting zero's
        for(i = 0; i < j; i++) {
        	if(arr[i] == 0) {
        		j--;
        		countZero++;
        	}
        }
        
        // special case if above loop break for i < j condition we didn't consider the last zero like for 1010010
        // i amd j will point to 2nd last zero at the end of above loop
        if(i == j && arr[j] == 0) countZero++;
        
        // j still pointing to last arr element means no zero
        if(j == len-1) return;

        int extraSpace = len-1-j;
        
        // lets make i point to end of original array and j is pointing to number of elements we can accomodate after duplicating
        for(i = len-1; j >=0; i--,j--) {
        	
        	arr[i] = arr[j];
        	// copy twice
        	if(arr[j] == 0) {
        		// we will not start duplicating end zeros until we can accomodate all zeros from start which happens in case of 1010010 which end with last elt as zero
        		if(countZero > extraSpace) countZero--;
        		else{
        			i--;
        			arr[i] = 0;
        		}
        	}
        }
    }
	public static void main(String[] args) {
		E_1089_DuplicateZeros obj = new E_1089_DuplicateZeros();
		int[] input  = new int[] {1,5,2,0,6,8,0,6,0};
		int[] input2  = new int[] {0,1,0,1,0,1,0};
		int[] input3  = new int[] {0,0,0,0,0,0};
		
		obj.duplicateZeros(input);
		System.out.println(Arrays.toString(input));
		
		obj.duplicateZeros(input2);
		System.out.println(Arrays.toString(input2));
		
		obj.duplicateZeros(input3);
		System.out.println(Arrays.toString(input3));
	}
}

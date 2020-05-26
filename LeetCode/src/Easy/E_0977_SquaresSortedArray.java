package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class E_0977_SquaresSortedArray {
	
	
	public int[] sortedSquares(int[] A) {
        int k = 0, len = A.length, j = 0, i = 0;
        int[] res = new int[len];
        
        while (j < len && A[j] < 0) j++; // j now points to first +ve number
        i = j-1;
        
        while(i >= 0 || j < len){
            
            if(j == len || i > 0 && Math.abs(A[i]) < A[j]){
                res[k] = A[i]*A[i];
                i--;
            }else if(i < 0 || Math.abs(A[i]) > A[j]){
                res[k] = A[j]*A[j];
                j++;
            }else{
                res[k] = A[i]*A[i];
                res[++k] = A[j]*A[j];
                i--;
                j++;
            }
            k++;
        }
        return res;
    }	
	
	// my approach using binary search to find first +ve index
	public int[] sortedSquaresBinarySearch(int[] A) {
        int k = 0, len = A.length, j = 0, i = 0;
        int[] res = new int[len];
        
        if(A[len-1] < 0) {
        	j = len; // all are -ve numbers
        }else if(A[0] < 0) {
        	j = searchFirstPositive(A); // we have some +ve some -ve
        } 
        // if j = 0 all are +ve
        
        i = j-1;
        
        while(i >= 0 || j < len){
            
            if(j == len || i > 0 && Math.abs(A[i]) < A[j]){
                res[k] = A[i]*A[i];
                i--;
            }else if(i < 0 || Math.abs(A[i]) > A[j]){
                res[k] = A[j]*A[j];
                j++;
            }else{
                res[k] = A[i]*A[i];
                res[++k] = A[j]*A[j];
                i--;
                j++;
            }
            k++;
        }
        return res;
    }
    
    public int searchFirstPositive(int[] A) {
        
        int start = 0, end = A.length - 1, mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(mid > 0 && A[mid-1] < 0 && A[mid] >= 0){
                return mid;
            }else if(A[mid] < 0){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
		return -1;
    }
	public static void main(String[] args) {
		E_0977_SquaresSortedArray obj = new E_0977_SquaresSortedArray();
		System.out.println(Arrays.toString(obj.sortedSquares(new int[] {-4,-1,0,3,10})));
		System.out.println(Arrays.toString(obj.sortedSquares(new int[] {0,1,3,10})));
		System.out.println(Arrays.toString(obj.sortedSquares(new int[] {-4,-3,-1})));
		
		
		System.out.println(Arrays.toString(obj.sortedSquares(new int[] {-2,-1,0})));
		System.out.println(Arrays.toString(obj.sortedSquares(new int[] {0, 1})));
	}
}

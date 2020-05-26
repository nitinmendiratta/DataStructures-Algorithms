package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
 * Algorithm 
1) Sort all the elements of the input array.
2) Use two index variables l and r to traverse from left and right ends respectively. Initialize l as 0 and r as n-1.
3) sum = a[l] + a[r]
4) If sum is -ve, then l++
5) If sum is +ve, then r–
6) Keep track of abs min sum.
7) Repeat steps 3, 4, 5 and 6 while l < r
 */
public class A017_TwoElementsWhoseSumIsClosestToZero {

	public int[] sum(int[] arr){
		int n = arr.length;
		Arrays.sort(arr);
		int[] result = new int[2];
		int i = 0,j = n-1,sum = 0,minSum = 0,newDiff = Math.abs(arr[0]),oldDiff = Math.abs(arr[0]);

		while(i < j){
			sum = arr[i] + arr[j];
			newDiff = Math.abs(sum);
			if(oldDiff > newDiff){
				oldDiff = newDiff;
				result[0] = arr[i];
				result[1] = arr[j];
			}
			if(sum > 0){	
				j--;
			}
			else if(sum < 0){
				i++;
			}
			else{
				result[0] = arr[i];
				result[1] = arr[j];
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		A017_TwoElementsWhoseSumIsClosestToZero obj = new A017_TwoElementsWhoseSumIsClosestToZero();
		int[] arr = {1, 60, -10, 70, -80,85};
		int[] result = obj.sum(arr);
		System.out.print(result[0]+","+result[1]);
	}
}

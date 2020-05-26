package Array_Matrix;

import java.util.Arrays;


public class ThreeElemInArraySumToZeroRepetitionAllowed {

	public static boolean sumZero(int[] arr){
		if(arr.length < 1) return false;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length-1;i++){
			int start = i;
			int end = arr.length -1;
			
			while(start <= end){
				if((arr[start] + arr[end] + arr[i]) == 0)	return true;
				else if((arr[start] + arr[end] + arr[i]) < 0)	start++;
				else	end--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {-6,-4,1};
		System.out.println(sumZero(arr));
	}
}

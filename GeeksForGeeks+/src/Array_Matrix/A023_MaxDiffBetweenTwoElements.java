package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * 
 * Instead of taking difference of the picked element with every other element, we take the difference with the minimum element found so far. 
 * So we need to keep track of 2 things:
		1) Maximum difference found so far (max_diff).
		2) Minimum number visited so far (min_element).
 */
public class A023_MaxDiffBetweenTwoElements {

	public int maxDiff(int[] arr){
		int n = arr.length;
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for(i = 1; i < n; i++){       
			if(arr[i] - min_element > max_diff)                               
				max_diff = arr[i] - min_element;
			if(arr[i] < min_element)
				min_element = arr[i];                     
		}
		return max_diff;
	}

	public static void main(String[] args) {
		A023_MaxDiffBetweenTwoElements obj = new A023_MaxDiffBetweenTwoElements();
		int[] arr = {7, 9, 10,11,12,1};
		int result = obj.maxDiff(arr);
		System.out.print("Max diff is:"+result);
	}
}

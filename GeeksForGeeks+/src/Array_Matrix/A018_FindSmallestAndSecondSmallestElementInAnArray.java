package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
 */
public class A018_FindSmallestAndSecondSmallestElementInAnArray {

	public int[] small(int[] arr){
		int n = arr.length;
		int i, first, second;
		int[] result = new int[2];
		/* There should be atleast two elements */
		if (n < 2)	return arr;

		first = second = Integer.MAX_VALUE;
		for (i = 0; i < n ; i ++){
			/* If current element is smaller than first then update both first and second */
			if (arr[i] < first){
				second = first;
				first = arr[i];
			}
			/* If arr[i] is in between first and second then update second  */
			else if (arr[i] < second && arr[i] != first)	second = arr[i];
		}
		
		if (second == Integer.MAX_VALUE)
			System.out.println("There is no second smallest element");
		else{
			result[0] = first;
			result[1] = second;
		}
		return result;
	}

	public static void main(String[] args) {
		A018_FindSmallestAndSecondSmallestElementInAnArray obj = new A018_FindSmallestAndSecondSmallestElementInAnArray();
		int[] arr = {1, 60, -10, 70, -80, 80};
		int[] result = obj.small(arr);
		System.out.print(result[0]+","+result[1]);
	}
}

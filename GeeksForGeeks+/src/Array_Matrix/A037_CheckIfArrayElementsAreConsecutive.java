package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
 * The solution provided on gfg will not work for -ve numbers, below solution works for -ve too
 * Time Complexity: O(n)
 * Extra Space: O(1)
 */
public class A037_CheckIfArrayElementsAreConsecutive {

	public boolean isConsequtive(int[] arr){
		int n = arr.length;
		int min = getMin(arr);
		int a = 0, b = 0;
		System.out.println(min);
		
		for(int i = 0;i < n;i++){
			b ^= arr[i];
		}

		for(int i = min; i < (min + n);i++){
			a ^= i;
		}

		if((a^b) == 0 ) return true;
		else return false;
	}
	public int getMin(int[] arr){
		int n = arr.length, min = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] < min)
				min = arr[i];
		return min;
	}

	public static void main(String[] args) {
		A037_CheckIfArrayElementsAreConsecutive obj = new A037_CheckIfArrayElementsAreConsecutive();
		int[] arr = {2, 1, 0, -3, -1, -2};
		System.out.println("is Consequtive:"+obj.isConsequtive(arr));
	}
}

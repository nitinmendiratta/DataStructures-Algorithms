package Easy;
/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 */
public class E_0167_TwoSumSorted {
	
	public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
	    }
        return null;
    }
     public int[] twoSumApproach2(int[] numbers, int target) {
         int len = numbers.length;
         int[] res = new int[]{};
         if(len == 0 || len == 1){
             return res;
         }
         for(int i = 0; i < len; i++){
             if(numbers[i] + numbers[i+1] > target){
                 return res;
             }
             int index = search(numbers, target - numbers[i], i+1, len-1);
             if(index != -1){
                 return new int[]{i+1, index+1};
             }
         }
         return res;
     }
     public int search(int[] numbers, int target, int start, int end){
             if (start > end) {
                 return -1;
             }
             int mid = (end - start) / 2 + start;
             if (numbers[mid] == target) {
                 return mid;
             }
             if (numbers[mid] > target) {
                 return search(numbers, target, start, mid - 1);
             }    
             return search(numbers, target, mid + 1, end);
         }
	public static void main(String[] args) {
		E_0167_TwoSumSorted obj = new E_0167_TwoSumSorted();
		int[] numbers = new int[] {2,7,11,15};
		int[] res= obj.twoSum(numbers, 9);
		System.out.println(res[0] + " "+ res[1]);

	}
}

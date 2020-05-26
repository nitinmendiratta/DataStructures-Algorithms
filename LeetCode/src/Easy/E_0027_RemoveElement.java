package Easy;
/*
 * https://leetcode.com/problems/remove-element/
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class E_0027_RemoveElement {

	public int removeElement(int[] nums, int val) {
		int len = nums.length;
        int i = 0,j = 0;
        while(i < len && nums[i] != val){
            i++;
        }
        for(j=i+1;j<len;j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
	}

	public static void main(String[] args) {
		E_0027_RemoveElement obj = new E_0027_RemoveElement();
		int arr[] = {4,5};
		System.out.println("New Length:"+obj.removeElement(arr,4));
		for(int i = 0;i < arr.length;i++) System.out.print(arr[i]+",");
	}
}

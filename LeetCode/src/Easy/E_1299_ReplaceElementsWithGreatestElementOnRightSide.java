package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class E_1299_ReplaceElementsWithGreatestElementOnRightSide {

	public int[] replaceElements(int[] arr) {
		
        int len = arr.length, ge = -1, temp;
        
		for(int i = len-1; i >= 0; i--) {
			temp = arr[i];
			arr[i] = ge;
			ge = Math.max(ge, temp);
		}
		return arr;
    }
	public static void main(String[] args) {
		E_1299_ReplaceElementsWithGreatestElementOnRightSide obj = new E_1299_ReplaceElementsWithGreatestElementOnRightSide();
		int[] nums = new int[] {17,18,5,4,6,1};
		System.out.println(Arrays.toString(obj.replaceElements(nums)));
	}
}

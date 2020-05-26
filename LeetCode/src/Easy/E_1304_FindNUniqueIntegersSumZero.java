package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 */
public class E_1304_FindNUniqueIntegersSumZero {

	public int[] sumZero(int n) {
		
		int[] res = new int[n];
		int j = 1, i = 0;
		
        if(n%2 != 0) {
        	res[i] = 0;
        	i++;
        }
        while(i < n) {
    		res[i] = j;
    		res[++i] = -j;
    		i++;
    		j++;
    	}
        return res;
    }
	public static void main(String[] args) {
		E_1304_FindNUniqueIntegersSumZero obj = new E_1304_FindNUniqueIntegersSumZero();
		System.out.println(Arrays.toString(obj.sumZero(5)));
	}
}

package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
public class E_1346_CheckNandDoubleExist {

	public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++) {
        	if(hs.contains(2*arr[i]) || (arr[i]%2 == 0 && hs.contains(arr[i]/2)))  return true;
        	hs.add(arr[i]);
        }
        return false;
    }
	public static void main(String[] args) {
		E_1346_CheckNandDoubleExist obj = new E_1346_CheckNandDoubleExist();
		System.out.println(obj.checkIfExist(new int[] {7,1,14,11}));
	}
}

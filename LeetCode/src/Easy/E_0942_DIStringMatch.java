package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/di-string-match/
 */
public class E_0942_DIStringMatch {


	public int[] diStringMatch(String S) {

		int len = S.length(), i = 0, j = len;
		int[] res = new int[len+1];

		for(int k = 0; k < len; k++){

			if(S.charAt(k) == 'I'){
				res[k] = i;
				i++;
			}else{
				res[k] = j;
				j--;
			}
		}

		res[len] = i;
		return res;
	}
	public static void main(String[] args) {
		E_0942_DIStringMatch obj = new E_0942_DIStringMatch();
		System.out.println(Arrays.toString(obj.diStringMatch("IDID")));
	}
}

package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class E_0459_RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String str) {
		//This is the kmp issue
		int[] kmpPrefixArr = kmp(str);
		int maxMatch = kmpPrefixArr[str.length()-1];
		int len = str.length();
		return (len > 0 && maxMatch%(maxMatch-len) == 0);
	}
	// KMP video https://www.youtube.com/watch?v=GTJr8OvyEVQ
	private int[] kmp(String s){
		int len = s.length();
		int[] res = new int[len];
		char[] ch = s.toCharArray();
		int i = 0, j = 1;
		res[0] = 0;
		while(i < ch.length && j < ch.length){
			if(ch[j] == ch[i]){
				res[j] = i+1;
				i++;
				j++;
			}else{
				if(i == 0){
					res[j] = 0;
					j++;
				}else{
					i = res[i-1];
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		E_0459_RepeatedSubstringPattern obj = new E_0459_RepeatedSubstringPattern();
		System.out.println(obj.repeatedSubstringPattern("abab"));
	}
}

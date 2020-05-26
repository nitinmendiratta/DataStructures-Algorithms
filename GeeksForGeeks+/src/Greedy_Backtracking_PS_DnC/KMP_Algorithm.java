package Greedy_Backtracking_PS_DnC;

import java.util.ArrayList;

/*
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * http://www.youtube.com/watch?v=iZ93Unvxwtw
 * http://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
 * Learn it tough
 */
public class KMP_Algorithm {

	public ArrayList KMPSearch(String txt, String pat){
		ArrayList result = new ArrayList();
		int M = pat.length();
		int N = txt.length();
		if(txt == null || pat == null || N < M) return result;

		// create lps[] that will hold the longest prefix suffix values for pattern
		int[] lps = new int[M];
		int j  = 0;  // index for pat[]
		computeLPSArray(pat,lps);// Preprocess the pattern (calculate lps[] array)
		
		int i = 0;  // index for txt[]
		for(i = 0; i < M;i++) System.out.print(lps[i]+",");i = 0;
		while (i < N){
			if (pat.charAt(j) == txt.charAt(i)){
				j++;
				i++;
			}
			if (j == M){
				result.add(i-j);
				j = lps[j-1];
			}

			// mismatch after j matches
			else if (i < N && pat.charAt(j) != txt.charAt(i)){
				// Do not match lps[0..lps[j-1]] characters, they will match anyway
				if (j != 0)
					j = lps[j-1];
				else
					i = i+1;
			}
		}
		return result;
	}

	public void computeLPSArray(String pat, int[] lps){
		int len = 0;  // length of the previous longest prefix suffix
		int i = 1, M = pat.length();

		lps[0] = 0; // lps[0] is always 0
		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M){
			if (pat.charAt(i) == pat.charAt(len)){
				len++;
				lps[i] = len;
				i++;
			}
			else{ // (pat[i] != pat[len])
				if (len != 0){
					// This is tricky. Consider the example AAACAAAA and i = 7.
					len = lps[len-1];
					// Also, note that we do not increment i here
				}
				else{ // if (len == 0)
					lps[i] = 0;
					i++;
				}
			}
		}
	}
	public static void main(String[] args) {
		KMP_Algorithm obj = new KMP_Algorithm();
		String text = "AABAACAADAABAAABAA";
		String pat = "AABA";
		System.out.println("pattern found at index: "+obj.KMPSearch(text,pat));
	}
}

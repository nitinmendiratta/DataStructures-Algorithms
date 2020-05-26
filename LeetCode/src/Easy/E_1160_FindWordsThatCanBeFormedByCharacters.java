package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class E_1160_FindWordsThatCanBeFormedByCharacters {

	// optimized
    public int countCharacters(String[] words, String chars) {
		int[] arr = new int[26];
        int res = 0, i = 0, j = 0;
        
        for(i = 0; i < chars.length(); i++){
            arr[chars.charAt(i) - 'a']++;
        }
        
        for(i = 0; i < words.length; i++){
            String curr = words[i];
            int[] arrClone  = Arrays.copyOf(arr, arr.length);
            
            for(j = 0; j < curr.length(); j++){
                  if(arrClone[curr.charAt(j) - 'a'] == 0) break;
                  arrClone[curr.charAt(j) - 'a']--;
            }
            if(j == curr.length()) res += j;
        }
        return res;
    }
    
    // create char array for each string
    public int countCharactersApproach2(String[] words, String chars) {
        int[] arr = new int[26];
        int res = 0, i = 0, j = 0;
        
        for(i = 0; i < chars.length(); i++){
            arr[chars.charAt(i) - 'a'] += 1;
        }
        
        for(i = 0; i < words.length; i++){
            String curr = words[i];
            int[] temp  = new int[26];
            
            for(j = 0; j < curr.length(); j++){
                temp[curr.charAt(j) - 'a'] += 1;
            }
            for(j = 0; j < curr.length(); j++){
                if(temp[curr.charAt(j) - 'a'] > arr[curr.charAt(j) - 'a']) break;
            }
            if(j == curr.length()) res += j;
        }
        return res;
    }
	public static void main(String[] args) {
		E_1160_FindWordsThatCanBeFormedByCharacters obj = new E_1160_FindWordsThatCanBeFormedByCharacters();
		System.out.println(obj.countCharacters(new String[] {"cat","bt","hat","tree"}, "atach"));
		System.out.println(obj.countCharacters(new String[] {"hello","world","leetcode"}, "welldonehoneyr"));
	}
}

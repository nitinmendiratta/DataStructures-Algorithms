package Easy;
/*
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class E_0953_VerifyingAlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {
		int[] arr = new int[26];
        for(int i = 0; i < order.length(); i++){
            arr[order.charAt(i)- 'a'] = i;
        }
        
        for(int j = 1; j < words.length; j++){
            String curr = words[j];
            String prev = words[j-1];
            
            // get shorter length of 2 strings
            int len = Math.min(curr.length(), prev.length());
            int k = 0;
            
            // run to a point where chars are diff like app, apple
            while(k < len && prev.charAt(k) == curr.charAt(k)) k++;
            
            // if we reached end of 1 string and still 2nd string is left, means case of apple, app
            if(k == len && k < prev.length()) return false;
            
            // if prev char is greater then current order is not lexicographical
            if(arr[prev.charAt(k) - 'a'] > arr[curr.charAt(k) - 'a']) return false;
            else continue;
        }
        return true;
    }
	public static void main(String[] args) {
		E_0953_VerifyingAlienDictionary obj = new E_0953_VerifyingAlienDictionary();
		System.out.println(obj.isAlienSorted(new String[] {"leet", "hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
		System.out.println(obj.isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
		System.out.println(obj.isAlienSorted(new String[] {"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
	}
}

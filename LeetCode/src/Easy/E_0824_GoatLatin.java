package Easy;
/*
 * https://leetcode.com/problems/goat-latin/
 */
public class E_0824_GoatLatin {
	
	/*
	 * Time Complexity: O(N^2), where N is the length of S. This represents
	 * the complexity of rotating the word and adding extra "a" characters.
	 * 
	 * Space Complexity: O(N^2), the space added to the answer by adding
	 * extra "a" characters.
	 */
	public String toGoatLatin(String S) {
		String[] input = S.split("\\s+");
		String ans = "";
        
		for(int i = 0; i < input.length; i++){
			String current = input[i];
			char firstChar = current.charAt(0);
			if(!isVowel(firstChar)){
				current = current.substring(1, current.length());
				current += firstChar;
			}
			current += "ma";
			for(int j = 0; j <= i; j++){
				current += "a";
			}
			ans += current+ " ";
		}
		return ans.substring(0, ans.length()-1);
	}
    
	public boolean isVowel(char ch) {
		if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'||ch == 'A' || ch == 'E'|| ch == 'I' ||ch == 'O' ||ch == 'U'){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		E_0824_GoatLatin obj = new E_0824_GoatLatin();
		System.out.println(obj.toGoatLatin("I speak Goat Latin"));
	}
}

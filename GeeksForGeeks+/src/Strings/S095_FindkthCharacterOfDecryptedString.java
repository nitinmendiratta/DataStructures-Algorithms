package Strings;
/*
 * http://www.geeksforgeeks.org/find-kth-character-of-decrypted-string/
 */
public class S095_FindkthCharacterOfDecryptedString {

	static void getkthChar(String s,int k){
		String n = "";
		int i = 0, start = -1,end = -1;

		while(i < s.length()){
			// if its a char
			if(s.charAt(i) < '0'|| s.charAt(i) > '9'){
				if(start == -1)
					start=i;
				i++;
			}
			else {
				if(end == -1)
					end = i-1;
				n += s.charAt(i);
				i++;
				// check for special case like 12
				if(i < s.length()&& (s.charAt(i) < '0'|| s.charAt(i) > '9')){
					int t = Integer.parseInt(n);
					t *= (end-start+1);
					if(k > t){
						k -= t; 
						n = "";       
						start = -1;
						end = -1;
					}
					else {
						System.out.println(s.substring(start, end + 1).charAt(k - 1));
						return;
					}
				}
			}
		}

		System.out.println(s.substring(start,end+1).charAt(k-1));
	}
	public static void main(String[] args) {
		
		getkthChar("a2b2c3",5);
		getkthChar("ab4c2ed3",9);
		getkthChar("ab4c12ed3",21);
	}
}

package Strings;
/*
 * http://www.geeksforgeeks.org/vigenere-cipher/
 */
public class S099_VigenèreCipher {

	// This function generates the key in a cyclic manner until it's length is'nt
	// equal to the length of original text
	public static String generateKey(String str, String key){
	    int x = str.length();
	 
	    for (int i = 0; ; i++){
	        if (x == i)
	            i = 0;
	        if (key.length() == str.length())
	            break;
	        key += key.charAt(i);
	    }
	    return key;
	}
	 
	// This function returns the encrypted text generated with the help of the key
	public static String cipherText(String str, String key){
	    String cipher_text = "";
	 
	    for (int i = 0; i < str.length(); i++){
	        // converting in range 0-25
	        int x = (str.charAt(i) + key.charAt(i)) %26;
	 
	        // convert into alphabets(ASCII)
	        x += 'A';
	 
	        cipher_text += (char)x;
	    }
	    return cipher_text;
	}
	 
	// This function decrypts the encrypted text and returns the original text
	public static String originalText(String cipher_text, String key){
	    String orig_text = "";
	 
	    for (int i = 0 ; i < cipher_text.length(); i++){
	        // converting in range 0-25
	        int x = (cipher_text.charAt(i) - key.charAt(i) + 26) %26;
	 
	        // convert into alphabets(ASCII)
	        x += 'A';
	        orig_text += (char)x;
	    }
	    return orig_text;
	}
	
	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
	    String keyword = "AYUSH";
	 
	    String key = generateKey(str, keyword);
	    String cipher_text = cipherText(str, key);
	 
	    System.out.println("Ciphertext : "+cipher_text );
	 
	    System.out.println("Original/Decrypted Text : "+originalText(cipher_text, key));
	}
}

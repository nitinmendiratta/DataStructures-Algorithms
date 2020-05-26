package Strings;
/*
 * http://www.geeksforgeeks.org/xor-cipher/
 */
public class S108_XORCipher {

	// The same function is used to encrypt and decrypt
	public static String encryptDecrypt(String inpString){
	    // Define XOR key
	    // Any character value will work
	    char xorKey = 'P';
	 
	    // calculate length of input string
	    int len = inpString.length();
	    StringBuilder sb =  new StringBuilder();
	    // perform XOR operation of key
	    // with every character in string
	    for (int i = 0; i < len; i++){
	         sb.append((char)(inpString.charAt(i) ^ xorKey));
	        
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		String sampleString = "GeeksforGeeks";
		 
	    // Encrypt the string
	    System.out.println("Encrypted String: ");
	    String res = encryptDecrypt(sampleString);
	    System.out.println(res);
	 
	    // Decrypt the string
	    System.out.println("Decrypted String: ");
	    System.out.println(encryptDecrypt(res));
	}
}

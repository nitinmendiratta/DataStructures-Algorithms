package Strings;
/*
 * http://www.geeksforgeeks.org/implementation-affine-cipher/
 * http://www.centaurarrow.com/2017/03/what-is-affine-cipher.html
 */
public class S138_ImplementationOfAffineCipher {

	private int a ;
	private int b ; 
	private int m ;
	
	public S138_ImplementationOfAffineCipher(int a,int b, int m){
		this.a=a;
		this.b=b;
		this.m=m;
	}
		
	// This function handles the Encryption of the input text
	private String doEncryption(String input){
		char[] charArray = input.toCharArray();
		char[] retCharArray = new char[charArray.length];
		for(int i=0;i<charArray.length;i++ ){
			if(charArray[i] != ' '){
				// Applying the formula, E(x) = ( ax + b ) mod m. Adding 'A' to get it in the range of 'A'
				retCharArray[i] = (char)(( a* (charArray[i] -'A') + b ) % m + 'A');
				// System.out.println(retCharArray[i] );
			} else {
				retCharArray[i] = charArray[i];
			}
		}
		
		return String.valueOf(retCharArray);
	}
	
	// This function handles the Decryption of the Encrypted text
	private String doDecryption(String input){
		// Find the multiplicative inverse of a.
		// i is called a^-1 if (a * i) mod m = 1
		char[] charArray = input.toCharArray();
		char[] retCharArray = new char[charArray.length];
		
		int a_inverse = 0;
		for(int i=0;i<m;i++){
			if( (a * i) % m ==1 ){
				a_inverse = i;
			}
		}

		for(int i=0;i<charArray.length;i++){
			if(charArray[i] != ' '){
				    // Applying the formula, D(x) = a^-1 (x-b) mod m. Adding 'A' to get it in the range of 'A'
					retCharArray[i] = (char) ((a_inverse * (charArray[i] + 'A' - b)) % m + 'A');
			} else {
				retCharArray[i] = charArray[i];
			}
		}
		return String.valueOf(retCharArray);
	}
	
	public static void main(String args[]){
		int m = 26; 
		int a = 25;  // m-1 and m are always co-prime numbers. 
		int b = 20;
		S138_ImplementationOfAffineCipher ac = new S138_ImplementationOfAffineCipher(a,b,m);
		String inputText = "This is the input that will be encrypted and decrypted using Affine Cipher";
		System.out.println("Value before encryption is: "+inputText.toUpperCase());
		String encryptionText = ac.doEncryption(inputText.toUpperCase());
		System.out.println("Value after encryption is: "+encryptionText);
		System.out.println("Value after decryption is: "+ac.doDecryption(encryptionText));
	}
}

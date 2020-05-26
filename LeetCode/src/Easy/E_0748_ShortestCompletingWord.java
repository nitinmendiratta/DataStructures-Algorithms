package Easy;
/*
 * https://leetcode.com/problems/shortest-completing-word/
 */
public class E_0748_ShortestCompletingWord {

	private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}; 

	/*
	 * Idea: assign each letter a prime number and compute the product for the
	 * license plate. Then, compute the product for each word in wordlist. We know
	 * if the char product for a word is divisible by the license plate char
	 * product, it contains all the characters.
	 */
	public String shortestCompletingWord(String licensePlate, String[] words) {
		long charProduct = getCharProduct(licensePlate.toLowerCase());
		String shortest = "zzzzzzzzzzzzzzzz"; // 16 a's
		for(String word : words)
			if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
				shortest = word;
		return shortest;
	}

	private long getCharProduct(String plate) {
		long product = 1L;
		for(char c : plate.toCharArray()) {
			int index = c - 'a';
			if (0 <= index && index <= 25) 
				product *= primes[index];
		}
		return product;
	}

	// using 2 arrays
	public String shortestCompletingWordApproach2(String licensePlate, String[] words) {
		String target = licensePlate.toLowerCase();
		int [] charMap = new int[26];
		// Construct the character map
		for(int i = 0 ; i < target.length(); i++){
			if(Character.isLetter(target.charAt(i))) charMap[target.charAt(i) - 'a']++;
		}
		int minLength = Integer.MAX_VALUE;
		String result = null;
		for (int i = 0; i < words.length; i++){
			String word = words[i].toLowerCase();
			if(matches(word, charMap) && word.length() < minLength) {
				minLength = word.length();
				result  = words[i];
			}
		}
		return result;
	}
	private boolean matches(String word, int[] charMap){
		int [] targetMap = new int[26];
		for(int i = 0; i < word.length(); i++){
			if(Character.isLetter(word.charAt(i))) targetMap[word.charAt(i) - 'a']++;
		}

		for(int i = 0; i < 26; i++){
			if(charMap[i] != 0 && targetMap[i] < charMap[i]) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		E_0748_ShortestCompletingWord obj = new E_0748_ShortestCompletingWord();
		System.out.println(obj.shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"}));
		System.out.println(obj.shortestCompletingWord("z", new String[] {"zzzzzzzzzzzzzzz", "step", "steps", "stripe", "stepple"}));
	}
}

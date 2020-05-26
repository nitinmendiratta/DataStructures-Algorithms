package Easy;
import java.util.HashMap;
/*
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class E_0299_BullsAndCows {

	public String getHint(String secret, String guess) {
		// number in string can be in range 0-9
        int[] counts = new int[10];
		int len = guess.length(), bullCount = 0, cowCount = 0;

		for(int i = 0; i < len; i++){
			char currGuess = guess.charAt(i);
			char currSecret = secret.charAt(i);
			// if both char match
			if(currGuess == currSecret){
				bullCount++;
				continue;
			}
			// approach is to always keep -ve count for guess char and +ve count for secret char
			
			// if guess char count is 0 we haven't seen it yet in secret so set the count to -1
			// if the count is > 0 we have seen it before in secret string
			if(counts[currGuess -'0'] > 0){
				cowCount++;
            }
			// reduce the count as the char we are processing is guess char
            counts[currGuess - '0']--;
			
            // if count is < 0 that means you have seen it in guess string before
			if(counts[currSecret -'0'] < 0){
				cowCount++;
            }
			// increase the count as the char we are processing is secret char
			counts[currSecret - '0']++;
		}
		return bullCount+"A"+cowCount+"B";
    }
	
	public String getHintWithHashmap(String secret, String guess) {
		HashMap<Character, Integer> hm = new HashMap();
		int len = guess.length(), bullCount = 0, cowCount = 0;

		for(int i = 0; i < len; i++){
			char currGuess = guess.charAt(i);
			char currSecret = secret.charAt(i);
			int guessCount = 0, secretCount = 0;
			if(currGuess == currSecret){
				bullCount++;
				continue;
			}

			if(hm.get(currGuess) != null){
				guessCount = hm.get(currGuess);
			}
			if(guessCount > 0){
				hm.put(currGuess, --guessCount);
				cowCount++;
			}else {
				hm.put(currGuess, --guessCount);
			}
			
			if(hm.get(currSecret) != null){
				secretCount = hm.get(currSecret);
			}
			if(secretCount < 0){
				hm.put(currSecret, ++secretCount);
				cowCount++;
			}else {
				hm.put(currSecret, ++secretCount);
			}
		}
		return bullCount+"A"+cowCount+"B";
	}
	public static void main(String[] args) {
		E_0299_BullsAndCows obj = new E_0299_BullsAndCows();
		System.out.println(obj.getHint("1123", "0111"));
		System.out.println(obj.getHint("1807", "7810"));
	}
}

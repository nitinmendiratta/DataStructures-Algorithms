package Easy;

/*
 * https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */
public class E_1455_CheckIfPrefix {

	public int isPrefixOfWord(String sentence, String searchWord) {

		boolean startNewWord = true;
		
		for (int i = 0, j = 0, spaceCount = 1; i < sentence.length(); i++) {

			if (startNewWord && sentence.charAt(i) == searchWord.charAt(j)) {
				j++;
				if (searchWord.length() == j)
					return spaceCount;
			} else {
				j = 0; // reset search word
				startNewWord = false;

				if (sentence.charAt(i) == ' ') {
					spaceCount++;
					startNewWord = true;
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		E_1455_CheckIfPrefix obj = new E_1455_CheckIfPrefix();
		System.out.println(obj.isPrefixOfWord("i love eating burger", "burg"));
		System.out.println(obj.isPrefixOfWord("this problem is an easy problem", "pro"));
		System.out.println(obj.isPrefixOfWord("i am tired", "you"));
		System.out.println(obj.isPrefixOfWord("i use triple pillow", "pill"));
		System.out.println(obj.isPrefixOfWord("hello from the other side", "they"));
		System.out.println(obj.isPrefixOfWord("hellohello hellohellohello", "ell"));
	}
}

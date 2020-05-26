package Medium;
/*
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */
public class M_0318_MaximumProductWordLengths {

	/*
	 * int has 32bits,but lower case letters only has 26 .we can use the lowest 26
	 * bit of int indicates that the word has how many kinds of lower case letters
	 * .If the lowest bit of int is 1,it indicates the word has lower case letter
	 * 'a'.......the order of lower case letter is from right to left,like
	 * zyx.....cba.so value[i] indicates the condition of the word i having how many
	 * kinds of lower case letters
	 * 
	 * a 1->1 
	 * b 2->10 
	 * c 4->100 
	 * ab 3->11 
	 * ac 5->101 
	 * abc 7->111 
	 * az 33554433->10000000000000000000000001
	 * 
	 */
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int len = words.length;
		int[] value = new int[len];
		
		for (int i = 0; i < len; i++) {
			String tmp = words[i];
			value[i] = 0;
			for (int j = 0; j < tmp.length(); j++) {
				value[i] |= 1 << (tmp.charAt(j) - 'a');
			}
		}
		int maxProduct = 0;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++) {
				// and of 2 numbers with no char in common will be 0
				if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
					maxProduct = words[i].length() * words[j].length();
			}
		return maxProduct;
	}

	public static void main(String[] args) {
		M_0318_MaximumProductWordLengths obj = new M_0318_MaximumProductWordLengths();
		System.out.println(obj.maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }));
	}
}

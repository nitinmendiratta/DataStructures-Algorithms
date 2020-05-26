package Medium;
/*
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class M_0151_ReverseWordsInString {

	// two-pointers solution (no trim( ), no split( ), no StringBuilder)
	public String reverseWords(String s) {
		if (s == null)
			return null;

		char[] a = s.toCharArray();
		int n = a.length;

		// step 1. reverse the whole string
		reverse(a, 0, n - 1);
		// step 2. reverse each word
		reverseWords(a, n);
		// step 3. clean up spaces
		return cleanSpaces(a, n);
	}

	void reverseWords(char[] a, int n) {
		int i = 0, j = 0;

		while (i < n) {
			while (i < j || i < n && a[i] == ' ')
				i++; // skip spaces
			while (j < i || j < n && a[j] != ' ')
				j++; // skip non spaces
			reverse(a, i, j - 1); // reverse the word
		}
	}

	// trim leading, trailing and multiple spaces
	String cleanSpaces(char[] a, int n) {
		int i = 0, j = 0;

		while (j < n) {
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			while (j < n && a[j] != ' ')
				a[i++] = a[j++]; // keep non spaces
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			if (j < n)
				a[i++] = ' '; // keep only one space
		}

		return new String(a).substring(0, i);
	}

	// reverse a[] from a[i] to a[j]
	private void reverse(char[] a, int i, int j) {
		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}

	// my approach
	public String reverseWordsApproach2(String s) {
		String[] split = s.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();

		for (int i = split.length - 1; i > 0; i--) {
			sb.append(split[i] + " ");
		}
		sb.append(split[0]);
		return sb.toString();
	}

	public static void main(String[] args) {
		M_0151_ReverseWordsInString obj = new M_0151_ReverseWordsInString();
		System.out.println(obj.reverseWords("the sky is blue"));
		System.out.println(obj.reverseWords("  hello world!  "));
		System.out.println(obj.reverseWords("a good   example"));
		System.out.println(obj.reverseWords("a  b"));
	}
}

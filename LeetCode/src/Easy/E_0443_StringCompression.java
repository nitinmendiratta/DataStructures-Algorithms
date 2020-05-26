package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/string-compression/
 */
public class E_0443_StringCompression {

	public int compress(char[] chars) {
        if (chars.length == 0){
            return 0;
        }
        int indexAns = 0;
        int index = 0;
        while(index < chars.length){
            // set the current char and count
            char currentChar = chars[index];
            int count = 0;
            // keep incrementing if they're the same
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            // once you hit a different char set the new currChar
            chars[indexAns++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray())
                    // now in place add the number to the array
                    // this works because indexAns++will increment indexAns as you go
                    chars[indexAns++] = c;
            }
        }
        // simply return the spot where you're currently at
        // don't need to + 1 because indexAns is always 1 step ahead after the while loop
        return indexAns;
    }
	public static void main(String[] args) {
		E_0443_StringCompression obj = new E_0443_StringCompression();
		char[] chars = new char[] {'a','a','a','b','b','c','d'};
		System.out.println(obj.compress(chars));
		char[] chars1 = new char[] {'a','b','b','c'};
		System.out.println(obj.compress(chars1));
		char[] chars2 = new char[] {'a','a','a','b','b','c','d', 'd', 'd'};
		System.out.println(obj.compress(chars2));

		char[] chars3 = new char[] {'a','c','d'};
		System.out.println(obj.compress(chars3));
		char[] chars4 = new char[] {'a','a','a','b','b','b'};
		System.out.println(obj.compress(chars4));

	}
}

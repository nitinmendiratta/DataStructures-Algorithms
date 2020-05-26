package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/occurrences-after-bigram/
 */
public class E_1078_OccurrencesAfterBigram {

	
	// KMP
	public String[] findOcurrences(String text, String first, String second) {
        // transform inputs into array of characters
        char[] textArray = text.toCharArray();
        char[] needleArray = (first + " " + second).toCharArray();
        // create table
        int[] auxArray = generateTable(needleArray);
        // create list from inputs and generated table
        return generateOutput(textArray, needleArray, auxArray);
    }
    
    private String[] generateOutput(char[] textArray, char[] needleArray, int[] auxArray) {
        List<String> list = new ArrayList();
        int i = 0;
        int len = 0;
        while (i < textArray.length) {
            if (textArray[i] == needleArray[len]) {
                ++i;
                ++len;
            } else {
                if (len != 0) {
                    len = auxArray[len - 1];
                } else {
                    ++i;
                }
            }
            // Attempt to get string after needle
            if (len == needleArray.length) {
                String nextString = getNextString(textArray, i, len);
                if (nextString != null) {
                    list.add(nextString);
                }
                len = auxArray[len - 1];
            }
        }
        return list.toArray(new String[list.size()]);
    }
    
    // Returns string after needle if valid
    // Validity: Character before needle is not a letter
    //           There is a word after needle
    // If conditions not met, return null
    private String getNextString(char[] textArray, int start, int len) {
        StringBuilder sb = new StringBuilder();
        if ((start - len - 1 < 0 || textArray[start - len - 1] == ' ') && (start < textArray.length && textArray[start] == ' ')) {
            ++start;
            while (start < textArray.length && textArray[start] != ' ') {
                sb.append(textArray[start++]);
            }
        }
        return sb.length() != 0 ? sb.toString() : null;
    }
    
    private int[] generateTable(char[] needleArray) {
        int[] auxArray = new int[needleArray.length];
        int len = 0;
        int i = 1;
        while (i < needleArray.length) {
            if (needleArray[i] == needleArray[len]) {
                auxArray[i++] = ++len;
            } else {
                if (len != 0) {
                    --len;
                } else {
                    ++i;
                }
            }
        }
        return auxArray;
    }

	public static void main(String[] args) {
		E_1078_OccurrencesAfterBigram obj = new E_1078_OccurrencesAfterBigram();
		System.out.println(Arrays.toString(obj.findOcurrences("alice is a goodgood girl she is a good student", "a", "good")));
		System.out.println(Arrays.toString(obj.findOcurrences("we will we will rock you we will .", "we", "will")));
		System.out.println(Arrays.toString(obj.findOcurrences("obo jvezipre obo jnvavldde jvezipre jvezipre jnvavldde jvezipre jvezipre jvezipre y jnvavldde jnvavldde obo jnvavldde jnvavldde obo jnvavldde jnvavldde jvezipre", 
				"jnvavldde", "y")));

	}
}

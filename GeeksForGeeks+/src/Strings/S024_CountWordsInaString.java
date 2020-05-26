package Strings;
import java.util.ArrayList;
/*
 * http://www.geeksforgeeks.org/count-words-in-a-given-string/
 * http://www.quickprogrammingtips.com/java/find-number-of-words-in-a-string-in-java.html
 */
public class S024_CountWordsInaString {

	public ArrayList<String> words(String str){
		ArrayList<String> result = new ArrayList<String>();
		String[] words = str.split("\\s+"); // match one or more spaces       
        for(int i =0;i<words.length;i++) {
            result.add(words[i]);
        }
        return result;
	}
	
	public static void main(String[] args) {
		S024_CountWordsInaString obj = new S024_CountWordsInaString();
		String text = "This     is a       test";
		System.out.println("words are: "+obj.words(text));
	}
}

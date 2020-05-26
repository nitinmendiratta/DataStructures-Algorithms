package Strings;
import java.util.ArrayList;
/*
 * http://www.geeksforgeeks.org/print-list-items-containing-all-characters-of-a-given-word/
 * Time Complexity: O(n + m) where n is total number of characters in the list of items. 
 * And m = (number of items in list) * (number of characters in the given word)
 */
public class S010_PrintItemsContainingAllCharactersOfaGivenWord {

	public ArrayList<String> contains(ArrayList<String> input, String word){
		ArrayList<String> result = new ArrayList<String>();
		boolean arr[] = new boolean[256];
		int word_size = word.length();
		int count = 0,i = 0,j = 0,k = 0;

		for(k = 0; k < word_size;k++){			
			arr[word.charAt(k)] = true;
		}

		for (i = 0; i < input.size(); i++){
			// get each string
			String str = input.get(i);
			for (j = 0, count = 0; j < str.length(); j++){
				if (arr[str.charAt(j)]){
					count++;

					/* unset the bit so that strings like sss not printed*/
					arr[str.charAt(j)] = false;
				}
			}
			if (count == word_size)
				result.add(str);

			/*Set the values in map for next item*/
			for (j = 0; j < word_size; j++)
				arr[word.charAt(j)] = true;
		}
		return result;
	}

	public static void main(String[] args) {
		S010_PrintItemsContainingAllCharactersOfaGivenWord obj = new S010_PrintItemsContainingAllCharactersOfaGivenWord();
		ArrayList<String> input = new ArrayList<String>();
		input.add("geeksforgeeks");
		input.add("unsorted");
		input.add("sunday");
		input.add("just");
		input.add("utensils");
		ArrayList<String> result = obj.contains(input,"sun");
		System.out.println(result);
	}
}

package Strings;
/*
 * http://www.geeksforgeeks.org/check-given-sentence-given-set-simple-grammer-rules/
 * Time complexity – O(n), worst case as we have to traverse the full sentence where n is the length of the sentence.
 * Auxiliary space – O(1)
 */
public class S038_CheckaSentenceForGivenSetOfSimpleGrammerRules {

	public boolean isValid(String str){
		System.out.println("Processing: "+str);
		if(str == null) return false;
		int n = str.length();
		if(str.charAt(0) < 'A' && str.charAt(0) > 'Z') System.out.println("First char shud be upper case");
		if(str.charAt(n-1) != '.') System.out.println("Sentence shud end with full stop");

		// Maintain 2 states. Previous and current state based on which vertex state you are. Initialise both with 0 = start state.
		int prev_state = 0, curr_state = 0;

		//Keep the index to the next character in the string.
		int index = 1;

		//Loop to go over the string.
		while (index < n){
			// Set states according to the input characters in the  string and the rule defined in the description.
			// If current character is [A-Z]. Set current state as 0.
			if (str.charAt(index) >= 'A' && str.charAt(index) <= 'Z')		curr_state = 0;

			// If current character is a space. Set current state as 1.
			else if (str.charAt(index) == ' ')		curr_state = 1;

			// If current character is [a-z]. Set current state as 2.
			else if (str.charAt(index) >= 'a' && str.charAt(index) <= 'z')	curr_state = 2;

			// If current state is a dot(.). Set current state as 3.
			else if (str.charAt(index) == '.')		curr_state = 3;

			// Validates all current state with previous state for the rules in the description of the problem.
			if (prev_state == curr_state && curr_state != 2){
				System.out.println("Not a valid word");
				return false;
			}

			if (prev_state == 2 && curr_state == 0){
				System.out.println("A space shud be after a word and not a capital char");
				return false;
			}

			// If we have reached last state and previous state is not 1, then check next character. 
			//	If next character is '\0', then return true, else false
			if (curr_state == 3 && prev_state != 1){
				if(index == n-1) return true;
				else{
					System.out.println("After full stop sentence shud end");
					return false;
				}
			}
			index++;
			// Set previous state as current state before going over to the next character.
			prev_state = curr_state;
		}
		return false;
	}

	public static void main(String[] args) {
		S038_CheckaSentenceForGivenSetOfSimpleGrammerRules obj = new S038_CheckaSentenceForGivenSetOfSimpleGrammerRules();
		String str[] = { 
				"I love cinema.",
				"The vertex is S.",
				"I am single.",
				"My name is KG.",
				"I lovE cinema.",
				"GeeksQuiz. is a quiz site.",
				"I love Geeksquiz and Geeksforgeeks.",
				"  You are my friend.", "I love cinema"
		};
		for (int i = 0; i < str.length; i++){
			System.out.println();
			System.out.println(obj.isValid(str[i]));
		}
	}
}

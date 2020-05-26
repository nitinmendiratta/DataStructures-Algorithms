package Strings;
import java.util.HashSet;
/*
 * http://www.geeksforgeeks.org/check-for-palindrome-after-every-character-replacement-query/
 * Time Complexity : O(Q + n) under the assumption that set insert, delete and find operations take O(1) time.
 */
class Query2{
	int i1, i2;
	char ch;
	Query2(int a, int b, char c){
		i1 = a;
		i2 = b;
		ch = c;
	}
}
public class S117_CheckForPalindromeAfterEveryCharacterReplacementQuery {

	
	// This function makes sure that set S contains
	// unequal characters from first half. This is called
	// for every character.
	public static void addRemoveUnequal(char str[], int index, int n, HashSet<Integer> S){
	    // If character becomes equal after query
	    if (str[index] == str[n-1-index]){
	        // Remove the current index from set if it is present
	        if (S.contains(index))
	            S.remove(index);
	    }
	    // If not equal after query, insert it into set
	    else
	        S.add(index);
	}
	 
	// Takes two inputs for Q queries. For every query, it
	// prints Yes if String becomes palindrome and No if not.
	public static void EvaluateQuery(String inStr, Query2 Q[]){
		char[] str = inStr.toCharArray();
	    int n = str.length;
	 
	    // create an empty set that store indexes of
	    // unequal location in palindrome
	    HashSet<Integer> S = new HashSet<Integer>();
	 
	    // we store indexes that are unequal in palindrome
	    // traverse only first half of String
	    for (int i=0; i<n/2; i++)
	        if (str[i] != str[n-1-i])
	            S.add(i);
	 
	    // traversal the query
	    for (int i=0; i<Q.length; i++){
	        // query 1: i1 = 3, i2 = 0, ch = 'e'
	        // query 2: i1 = 0, i2 = 2, ch = 's'
	        int i1 = Q[i].i1, i2 = Q[i].i2;
	        char ch = Q[i].ch;
	        System.out.println(i1+", "+i2+", "+ch);
	 
	        // Replace characters at indexes i1 & i2 with new char 'ch'
	        str[i1] = str [i2] = ch;
	 
	        // If i1 and/or i2 greater than n/2
	        // then convert into first half index
	        if (i1 > n/2)
	            i1 = n- 1 -i1;
	        if (i2 > n/2)
	            i2 = n -1 - i2;
	 
	        // call addRemoveUnequal function to insert and remove
	        // unequal indexes
	        addRemoveUnequal(str, i1 , n, S );
	        addRemoveUnequal(str, i2 , n, S );
	 
	        // if set is not empty then String is not palindrome
	        System.out.println(S.isEmpty()? "YES" : "NO");
	    }
	}
	public static void main(String[] args) {
		String str = "geeks";
	    Query2 Q[] = { new Query2(3, 0 ,'e'), new Query2(0, 2 , 's')};
	    EvaluateQuery(str, Q);
	}
}

package Strings;
/*
 * http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-atleast-d-distance-away/
 *  time complexity is O(n) where n is length of input string.
 */
public class S070_RearrangeStringSoThatAllSameCharBecomeAtleastdDistanceAway {

	int MAX_CHAR = 256;
	// The function returns next eligible character
	// with maximum frequency (Greedy!!) and zero or negative distance
	public int nextChar(int freq[], int dist[]){
	    int max = Integer.MIN_VALUE;
	    for (int i = 0; i < MAX_CHAR; i++)
	        if (dist[i] <= 0 && freq[i] > 0 &&
	        (max == Integer.MIN_VALUE || freq[i] > freq[max]))
	                max = i;
	 
	    return max;
	}
	 
	// The main function that rearranges input string 'str'
	// such that two same characters become atleast d distance away
	public int rearrange(String str, char out[], int d){
	    // Find length of input string
	    int n = str.length();
	 
	    // Create an array to store all characters and their
	    // frequencies in str[]
	    int freq[] = new int[MAX_CHAR];
	 
	    // Traverse the input string and store frequencies
	    // of all characters in freq[] array.
	    for (int i = 0; i < n; i++)
	        freq[str.charAt(i)]++;
	 
	    // Create an array for inserting the values at
	    // correct distance dist[j] stores the least distance
	    // between current position and the next position we
	    // can use character 'j'
	    int dist[] = new int[MAX_CHAR];
	 
	    for (int i = 0; i < n; i++){
	        // find next eligible character
	        int j = nextChar(freq, dist);
	 
	        // return 0 if string cannot be rearranged
	        if (j == Integer.MIN_VALUE)
	            return 0;
	 
	        // Put character j at next position
	        //System.out.println((char) j);
	        out[i] = (char) j;
	 
	        // decrease its frequency
	        freq[j]--;
	 
	        // set distance as d
	        dist[j] = d;
	 
	        // decrease distance of all characters by 1
	        for (int k = 0; k < MAX_CHAR; k++)
	            dist[k]--;
	    }
	 
	    // null terminate output string
	    //out[n] = '\0';
	 
	    // return success
	    return 1;
	}
	
	public static void main(String[] args) {
		S070_RearrangeStringSoThatAllSameCharBecomeAtleastdDistanceAway obj = new S070_RearrangeStringSoThatAllSameCharBecomeAtleastdDistanceAway();
		String str = "geeksforgeeks";
	    int n = str.length();
	 
	    // To store output
	    char out[] = new char[n];
	 
	    if (obj.rearrange(str, out, 3) == 1)
	        System.out.println(out);
	    else
	        System.out.println("Cannot be rearranged");
	}
}

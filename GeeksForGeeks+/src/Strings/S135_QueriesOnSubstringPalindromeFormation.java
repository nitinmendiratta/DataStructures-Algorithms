package Strings;
/*
 * http://www.geeksforgeeks.org/queries-substring-palindrome-formation/
 */
public class S135_QueriesOnSubstringPalindromeFormation {
	
	static int max = 1000;
	// Return the frequency of the character in the i-th prefix.
	public static int getFrequency(int tree[][], int idx, int i){
		
		int sum = 0;
		while (idx > 0){
			sum += tree[idx][i];
			idx -= (idx & -idx);
		}
		return sum;
	}

	// Query to update the character in the string.
	public static void qType1(int tree[][], int l, char x, String intStr){
		char[] str = intStr.toCharArray();
		// Adding -1 at L position
		update(tree, l, -1, str[l-1]-97+1);

		// Updating the character
		str[l-1] = x;

		// Adding +1 at R position
		update(tree, l, 1, str[l-1]-97+1);
	}

	// Query to find if rearrangement of charcater in range L...R can form palindrome
	public static void qType2(int tree[][], int l, int r, String str){
		int count = 0;

		for (int i = 1; i <= 26; i++){
			// Checking on the first charcter of the string S.
			if (l == 1){
				if (getFrequency(tree, r, i)%2 == 1)
					count++;
			}
			else{
				// Checking if frequency of character is even or odd.
				if ((getFrequency(tree, r, i) -
						getFrequency(tree, l-1, i))%2 == 1)
					count++;
			}
		}

		if(count<=1){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
	// Updating the BIT
	public static void update(int tree[][], int idx, int val, int i){

		while (idx <= max){
			tree[idx][i] += val;
			idx += (idx & -idx);
		}
	}
	// Creating the Binary Index Tree of all aphabet
	public static void buildBIT(int tree[][], String str){
		int n = str.length();
		for (int i = 0; i < n; i++)
			update(tree, i+1, 1, str.charAt(i)-97+1);
	}

	public static void main(String[] args) {
		
		String str = "geeksforgeeks";
		int tree[][] = new int[max][27];
		buildBIT(tree, str);
		qType1(tree, 4, 'g', str);
		qType2(tree, 1, 4, str);
		qType2(tree, 2, 3, str);
		qType1(tree, 10, 't', str);
		qType2(tree, 10, 11, str);
	}
}

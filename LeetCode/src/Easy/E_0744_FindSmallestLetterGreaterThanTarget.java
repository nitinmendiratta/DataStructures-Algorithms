package Easy;
/*
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */
public class E_0744_FindSmallestLetterGreaterThanTarget {

	public char nextGreatestLetter(char[] letters, char target) {
		
		//end starts at 'n' rather than the usual 'n - 1'. 
        //It is because the terminal condition is 'start < end' and if end starts from 'n - 1', 
        //we can never consider value at index 'n - 1'
		int start = 0, end = letters.length;
		
		// end of this loop start will point to where we should insert target in this sorted array
		//Terminal condition is 'start < end', to avoid infinite loop when target is smaller than the first element
		while(start < end) {
			int mid = start + (end-start)/2;
			
			if(target >= letters[mid]) {
				start = mid+1;
			}else {
				end = mid;
			}
		}
		// if our insertion position says to insert target into the last position letters.length, we return letters[0] instead. 
		// This is what the modulo operation does.
		return letters[start % letters.length];
	}
	public static void main(String[] args) {
		E_0744_FindSmallestLetterGreaterThanTarget obj = new E_0744_FindSmallestLetterGreaterThanTarget();
		System.out.println(obj.nextGreatestLetter(new char[]{'a', 'b'}, 'z')); // returns 'a'
		System.out.println(obj.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')); // returns 'c'
		System.out.println(obj.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')); // returns 'f'
		System.out.println(obj.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd')); // returns 'f'
		System.out.println(obj.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g')); // returns 'j'
		System.out.println(obj.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j')); // returns 'c'
		System.out.println(obj.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k')); // returns 'c'
		
		System.out.println(obj.nextGreatestLetter(new char[]{'e','e','e','e','e','e','n','n','n','n'}, 'e')); // returns 'n'
	}
}

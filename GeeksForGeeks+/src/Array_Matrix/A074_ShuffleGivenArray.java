package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/shuffle-a-given-array/
 * A theoritical algo read it
 */
public class A074_ShuffleGivenArray {

/*Let the given array be arr[]. A simple solution is to create an auxiliary array temp[] which is initially a copy of arr[]. 
* Randomly select an element from temp[], copy the randomly selected element to arr[0] and remove the selected element from temp[]. 
* Repeat the same process n times and keep copying elements to arr[1], arr[2], â€¦ . The time complexity of this solution will be O(n^2).
* Fisher–Yates shuffle Algorithm works in O(n) time complexity. The assumption here is, we are given a function rand() that generates random
* number in O(1) time.
* The idea is to start from the last element, swap it with a randomly selected element from the whole array (including last). 
* Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the first element.
* 
* Following is the detailed algorithm

	To shuffle an array a of n elements (indices 0..n-1):
	  	for i from n - 1 downto 1 do
	       j = random integer with 0 <= j <= i
	       exchange a[j] and a[i]

*/

	public static void main(String[] args){

	}
}

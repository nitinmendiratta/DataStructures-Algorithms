package Sorting_Searching;

/*http://en.wikipedia.org/wiki/Interpolation_search
 * Interpolation search works better than Binary Search for a sorted and uniformly distributed array.

On average the interpolation search makes about log(log(n)) comparisons (if the elements are uniformly distributed), where n is the 
number of elements to be searched. In the worst case (for instance where the numerical values of the keys increase exponentially) it 
can make up to O(n) comparisons.
 */
public class InterpolationSearch {

	public static int interpolationSearch(int[] sortedArray, int toFind){
		// Returns index of toFind in sortedArray, or -1 if not found
		int low = 0;
		int high = sortedArray.length - 1;
		int mid;

		while (sortedArray[low] <= toFind && sortedArray[high] >= toFind) {
			mid = low +	((toFind - sortedArray[low]) * (high - low)) /
					(sortedArray[high] - sortedArray[low]);  //out of range is possible  here

			if (sortedArray[mid] < toFind)
				low = mid + 1;
			else if (sortedArray[mid] > toFind)
				// Repetition of the comparison code is forced by syntax limitations.
				high = mid - 1;
			else
				return mid;
		}

		if (sortedArray[low] == toFind)
			return low;
		else
			return -1; // Not found
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(interpolationSearch(arr,3));
	}
}

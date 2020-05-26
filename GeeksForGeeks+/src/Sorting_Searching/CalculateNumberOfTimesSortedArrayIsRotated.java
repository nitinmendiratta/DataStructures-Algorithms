package Sorting_Searching;
import java.util.*;
/*
 * Here if are able to find out the index the min element then we can tell how many times times the array has been rotated.
 * As the original array was sorted so if we move the min element by 2 pos then the array is rotated by 2 pos anticlockwise.
 * So, No of rotations = index of min elem
 * Now to find the min element we can do a linear scan which would give the complexity of
 * the problem as O(n) but if we choose binary search and the property that the array is
 * rotated we can easily find index of the min elem in O(log n)
 * Pseudo Code:
 * case 1: If the array is already sorted 
 *  if A[start] <= A[end] return start;
 * case 2: Pivot property: prev and next both are greater
 *  next = (mid+1)%N //this is done because if mid is the last index in the array
 *  prev = (mid+N-1)%N
 *  A[mid] < A[prev] && A[mid] < A[next]
 *  this thing can only happen if the A[mid] is the pivot element that is the start of the original array so return mid.
 * case:3
 *  If A[mid] <= A[end] then pivot elem lies in on the left of mid.
 *  so end = mid-1
 * case 4:
 * 	If A[mid] >= A[start] then pivot elem lies in on the right of mid
 * 	So start = mid+1
 */
public class CalculateNumberOfTimesSortedArrayIsRotated{

	public static int getNumberOfRotation(List<Integer> inputArrayList, int N){
		int startIndx = 0;
		int endIndx = N-1;
		while(startIndx <= endIndx){
			int midIndx = (startIndx+endIndx)/2;
			int midElem = inputArrayList.get(midIndx);
			int prevIndx = (midIndx+N-1)%N;
			int prevElem = inputArrayList.get(prevIndx);
			int nextIndx = (midIndx+1)%N;
			int nextElem = inputArrayList.get(nextIndx);
			int startElem = inputArrayList.get(startIndx);
			int endElem = inputArrayList.get(endIndx);
			
			if(startElem <= endElem)	return startIndx;
			else if((midElem <= prevElem) && (midElem <= nextElem)){
				return midIndx;
			}
			else if(midElem <= endElem){
				endIndx = midIndx-1;
			}
			else if(midElem >= startElem)
				startIndx = midIndx+1;
		}
		return -1;
	}

	public static void main(String[] args){
		/*BinarySearch input = new BinarySearch();
		List<Integer> arrList = input.getInputArray();

		Sorting sort = new Sorting();
		List<Integer> sortedList = sort.quickSort(arrList,0,arrList.size()-1);
		System.out.println("Sorted list is:"+sortedList);
		System.out.println("How many times u wanna rotate the array");
		Scanner in = new Scanner(System.in);
		int rotationCount = in.nextInt();

		int listSize = sortedList.size();
		Collections.rotate(sortedList, rotationCount);
		System.out.println("Rotated list is:"+sortedList);
		int count = -1;
		count = getNumberOfRotation(sortedList,listSize);
		if(count !=-1) System.out.println("List is rotated:"+count+" times");
		else System.out.println("Invalid");*/
	}
}

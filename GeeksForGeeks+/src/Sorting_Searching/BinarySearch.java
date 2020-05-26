package Sorting_Searching;

/*
 * The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Logn). 
 * We basically ignore half of the elements just after one comparison.
1) Compare x with the middle element.
2) If x matches with middle element, we return the mid index.
3) Else If x is greater than the mid element, then x can only lie in right half subarray after the mid element. So we recur for right half.
4) Else (x is smaller) recur for the left half.

“m = (l+r)/2″. It fails for large values of l and r. Specifically, it fails if the sum of low and high is greater than the maximum positive 
int value (231 – 1). The sum overflows to a negative value, and the value stays negative when divided by two. In C this causes an array index out of bounds with unpredictable results.

What is the way to resolve this problem?
Following is one way:
        int mid = low + ((high - low) / 2); 
Probably faster, and arguably as clear is (works only in Java, refer this):
        int mid = (low + high) >>> 1; 
In C and C++ (where you don’t have the >>> operator), you can do this:
        mid = ((unsigned int)low + (unsigned int)high)) >> 1 
 */
import java.util.*;

public class BinarySearch{    

	public static int recursiveBinarySearch(List<Integer> inputArrayList, int start, int end, int elem){
		int mid = (start + end)/2;
		//its better to have mid = low + (high-low)/2 becoz sumtimes low+high 
		//can exceed the max value that an integer can store
		if(start > end) return -1;
		if(elem == inputArrayList.get(mid))return mid;
		else if(elem < inputArrayList.get(mid))
			return recursiveBinarySearch(inputArrayList,start,mid-1,elem);
		else
			return recursiveBinarySearch(inputArrayList,mid+1,end,elem);
	}

	public static int iterativeBinarySearch(List<Integer> inputArrayList, int start, int end, int elem){
		while(start <= end){
			int mid = (start + end)/2;
			if(elem == inputArrayList.get(mid))return mid;
			else if(elem < inputArrayList.get(mid))
				end = mid-1;
			else
				start = mid+1;
		}
		return -1;
	}
	
	public static List<Integer> getInputArray(){

		List<Integer> arrList = new ArrayList<Integer>();
		System.out.println("Enter the number of elements in the array");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int input = 0;
		System.out.println("Enter the elements");
		for(int i = 0; i < n; i++){
			in = new Scanner(System.in);
			input = in.nextInt();
			arrList.add(input);
		}
		return arrList;
	}

	public static void main(String[] args){
		/*List<Integer> arrList = getInputArray();
		int n = arrList.size();
		Sorting sort = new Sorting();
		List<Integer> sortedList = sort.quickSort(arrList,0,arrList.size()-1);
		System.out.println("Enter the element you wanna search");
		Scanner in = new Scanner(System.in);
		in = new Scanner(System.in);
		int element = in.nextInt();
		System.out.println("Enter method for binary search\n"+
				"1.Recursive\n"+
				"2.Iterative\n");
		in = new Scanner(System.in);
		int input = in.nextInt();
		int index = -1;
		switch(input){
		case 1: index = recursiveBinarySearch(sortedList,0,n-1,element);break;
		case 2: index = iterativeBinarySearch(sortedList,0,n-1,element);break;
		default: index = recursiveBinarySearch(sortedList,0,n-1,element);
		}
		if(index != -1) System.out.println("Elemment is at index:"+index);
		else System.out.println("Element not found");*/
	}
}

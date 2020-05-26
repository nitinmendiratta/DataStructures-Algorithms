package Array_Matrix;
import java.util.*;

import Sorting_Searching.Helper;
/*
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * 
 * Here we have a circular sorted aray and we need to find a given elem in it. THis could
 * easily done using lenear search in O(n) but using binary search and taking advantage of
 * array being sorted we can achieve this in O(logn).
 *
 * The logic here is to first divide the array into 2 parts as in a circular sorted array
 * there would be a pivot elem(which has prev and next elem both greater). So when we 
 * divide the array into 2 halfs the pivot element would be present in one of the halfs
 * and the other half would have all its elements sorted. So everytime we try to find 
 * that sorted part and check for the elem in that part if it is present we discard the 
 * other half if not we discard this sorted part.
 */

public class A006_SearchElemInSortedAndPivotedArray{

	public static int search(List<Integer> inputArrayList, int N, int elem){
		int startIndx = 0;
		int endIndx = N-1;
		while(startIndx <= endIndx){
			int midIndx = (startIndx+endIndx)/2;
			int midElem = inputArrayList.get(midIndx);
			int startElem = inputArrayList.get(startIndx);
			int endElem = inputArrayList.get(endIndx);
			if(midElem == elem) 
				return midIndx;
			else if(midElem <= endElem){
				if((elem > midElem) && (elem <= endElem)) startIndx = midIndx+1;
				else endIndx = midIndx-1;
			}
			else if(startElem <= midElem){
				if((elem >= startElem) && (elem < midElem)) endIndx = midIndx-1;
				else startIndx = midIndx+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		Helper input = new Helper();
		List<Integer> arrList = input.getInputArray();
		List<Integer> sortedList = input.quickSort(arrList,0,arrList.size()-1);
		System.out.println("Sorted list is:"+sortedList);
		Collections.rotate(sortedList,2);
		System.out.println("Rotated list is:"+sortedList);
		System.out.println("Enter element you wanna seach");
		Scanner in = new Scanner(System.in);
		int elem = in.nextInt();

		int index = -1;
		index = search(sortedList,sortedList.size(),elem);
		if(index != -1) System.out.println("Element is at index:"+index);
		else System.out.println("Element not found");
	}
}

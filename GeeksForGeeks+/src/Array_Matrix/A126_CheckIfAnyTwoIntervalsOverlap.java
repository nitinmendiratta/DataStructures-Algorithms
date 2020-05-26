package Array_Matrix;
import java.util.*;

/*
 * http://quiz.geeksforgeeks.org/check-if-any-two-intervals-overlap-among-a-given-set-of-intervals/
 * Time complexity is O(nLogn)
 */
//An interval has start time and end time


public class A126_CheckIfAnyTwoIntervalsOverlap {
	
	class Interval{
	  int start;
	  int end;
	  Interval(int s, int e){
	  	start = s;
	  	end = e;
	  }
	}
	// Compares two intervals according to their staring time.
	// This is needed for sorting the intervals using library
	class CompareInterval implements Comparator<Interval>{
		
		public int compare(Interval i1, Interval i2){
			return (i1.start - i2.start); 
		}
	}

	// Function to check if any two intervals overlap
	public boolean isOverlap(Interval arr[]){
	    // Sort intervals in increasing order of start time
	    Arrays.sort(arr,  new CompareInterval());

	    // In the sorted array, if start time of an interval
	    // is less than end of previous interval, then there
	    // is an overlap
	    for (int i=1; i<arr.length; i++)
	        if (arr[i-1].end > arr[i].start)
	            return true;
	    
	    // If we reach here, then no overlap
	    return false;
	}
	
	public static void main(String[] args) {
		A126_CheckIfAnyTwoIntervalsOverlap obj = new A126_CheckIfAnyTwoIntervalsOverlap();

		Interval[] arr1 = new Interval[4];
		arr1[0] = obj.new Interval(1,3);
		arr1[1] = obj.new Interval(7,9);
		arr1[2] = obj.new Interval(4,6);
		arr1[3] = obj.new Interval(10,13);

	    boolean res = obj.isOverlap(arr1);
	    System.out.println("Overlap:"+res);
	 
	    Interval[] arr2 = new Interval[4];
		arr2[0] = obj.new Interval(6,8);
		arr2[1] = obj.new Interval(1,3);
		arr2[2] = obj.new Interval(2,4);
		arr2[3] = obj.new Interval(4,7);

	    res = obj.isOverlap(arr2);
	    System.out.println("Overlap:"+res);
	}
}

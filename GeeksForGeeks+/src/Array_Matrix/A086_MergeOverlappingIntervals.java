package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/merging-intervals/
 */
// An interval has start time and end time
class Interval{
	int start;
	int end;
	Interval(int s, int e){
		start = s;
		end = e;
	}
}
public class A086_MergeOverlappingIntervals {

	// Time complexity of the method is O(nLogn)
	// The main function that takes a set of intervals, merges overlapping intervals and prints the result
	public void mergeIntervals(Vector<Interval> intervals){
		// Test if the given set has at least one interval
		if (intervals.size() <= 0)
			return;

		// Create an empty stack of intervals
		Stack<Interval> s = new Stack();

		// sort the intervals based on start time
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return (i1.start - i2.start);
			}
		});
		// push the first interval to stack
		s.push(intervals.firstElement());

		// Start from the next interval and merge if necessary
		for (int i = 1 ; i < intervals.size(); i++){
			// get interval from stack top
			Interval top = s.peek();

			// if current interval is not overlapping with stack top, push it to the stack
			if (top.end < intervals.get(i).start){
				s.push(intervals.get(i));
			}
			// Otherwise update the ending time of top if ending of current interval is more
			else if (top.end < intervals.get(i).end){
				top.end = intervals.get(i).end;
				//s.pop();
				//s.push(top);
			}
		}
		// Print contents of stack
		System.out.println("The Merged Intervals are: ");
		while (!s.empty()){
			Interval t = s.peek();
			System.out.println("["+t.start +"," +t.end + "]" + " ");
			s.pop();
		}
		return;
	}
	
	// O(n Log n) time and O(1) extra space.
	// not working for all inputs
	public void mergeIntervals2(Vector<Interval> intervals){
	    // Sort Intervals in decreasing order of
	    // start time
		// sort the intervals based on start time
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return (i1.start - i2.start);
			}
		});
	 
	    int index = 0; // Stores index of last element
	    // in output array (modified arr[])
	    int n = intervals.size();
	    // Traverse all input Intervals
	    for (int i=0; i<n; i++){
	        // If this is not first Interval and overlaps
	        // with the previous one
	        if (index != 0 && intervals.get(index-1).start <= intervals.get(i).end){
	            while (index != 0 && intervals.get(index-1).start <= intervals.get(i).end){
	                // Merge previous and current Intervals
	            	Interval prev = intervals.get(index-1);
	            	Interval current = intervals.get(i);
	            	
	            	prev.end = Math.max(prev.end, current.end);
	            	prev.start = Math.min(prev.start, current.start);
	                index--;
	            }
	        }
	        else // Doesn't overlap with previous, add to
	            // solution
	        	intervals.set(index, intervals.get(i));
	 
	        index++;
	    }
	 
	    // Now arr[0..index-1] stores the merged Intervals
	    System.out.println("The Merged Intervals2 are: ");
	    for (int i = 0; i < index; i++)
	        System.out.println("[" + intervals.get(i).start +", " + intervals.get(i).end +"] ");
	}
	public static void main(String[] args) {
		A086_MergeOverlappingIntervals obj  = new A086_MergeOverlappingIntervals();
		// Create a set of intervals
		Vector<Interval> v = new  Vector<Interval>();
		/*v.addElement(new Interval(6,8));
		v.addElement(new Interval(1,9));
		v.addElement(new Interval(2,4));
		v.addElement(new Interval(4,7));*/
		v.addElement(new Interval(1,3));
		v.addElement(new Interval(2,4));
		v.addElement(new Interval(5,7));
		v.addElement(new Interval(6,8));
		// Merge overlapping inervals and print result
		obj.mergeIntervals(v);
		obj.mergeIntervals2(v);
	}
}

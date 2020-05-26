package Array_Matrix;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * http://www.ardendertat.com/2011/11/03/programming-interview-questions-13-median-of-integer-stream/
 * https://gist.github.com/Vedrana/3675434
 * 
 * Order requirement: Max-heap contains the smallest half of the numbers and min-heap contains the largest half.
 * 					  So, the numbers in max-heap are always less than or equal to the numbers in min-heap.
 * Size requirement: The number of elements in max-heap is either equal to or 1 more than the number of elements in the min-heap. 
 * 					 So, if we received 2N elements (even) up to now, max-heap and min-heap will both contain N elements. 
 * 					 Otherwise, if we have received 2N+1 elements (odd), max-heap will contain N+1 and min-heap N.
 * O(N log N)
 * */

public class A046_MedianInAStreamOfIntegers {
	public Queue<Integer> minHeap;
	public Queue<Integer> maxHeap;
	public int numOfElements;

	public A046_MedianInAStreamOfIntegers() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparator()); 
		/* 10 is used above because if you want to provide a custom comparator for the PriorityQueue, you also need to provide the 
		initial capacity for it, so 10 is just a random number. The custom comparator is for changing the order of the heap. 
		The default order is min. To convert to max heap, custom comparator is used. */
		numOfElements = 0;
	}
	
	private class MaxHeapComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
	
	public void addNumberToStream(Integer num) {
		/*we insert all the elem first in maxHeap then check if the elem count is even or odd if its even that means max and min heap have 
		equal number of elem and the elem shud remain in max heap if its odd we shud take it out from max heap and put it in min heap.*/
		maxHeap.add(num);
		if (numOfElements%2 == 0) {
			if (minHeap.isEmpty()) {
				numOfElements++;
				return;
			}
			else if (maxHeap.peek() > minHeap.peek()) {
				Integer maxHeapRoot = maxHeap.poll();
				Integer minHeapRoot = minHeap.poll();
				maxHeap.add(minHeapRoot);
				minHeap.add(maxHeapRoot);
			} 
		} else {
			minHeap.add(maxHeap.poll());
		}
		numOfElements++;
	}

	public Double getMedian() {
		if (numOfElements%2 != 0)
			return new Double(maxHeap.peek());
		else
			return (maxHeap.peek() + minHeap.peek()) / 2.0; 
	}

	public static void main(String[] args) {
		A046_MedianInAStreamOfIntegers streamMedian = new A046_MedianInAStreamOfIntegers();

		streamMedian.addNumberToStream(1);
		System.out.println(streamMedian.getMedian()); // should be 1

		streamMedian.addNumberToStream(5);
		streamMedian.addNumberToStream(10);
		streamMedian.addNumberToStream(12);
		streamMedian.addNumberToStream(2);
		System.out.println(streamMedian.getMedian()); // should be 5

		streamMedian.addNumberToStream(3);
		streamMedian.addNumberToStream(8);
		streamMedian.addNumberToStream(9);
		System.out.println(streamMedian.getMedian()); // should be 6.5
	}
}


package Stack_Queue;

/*
 * http://www.geeksforgeeks.org/find-the-largest-number-multiple-of-3/
Following is a solution based on the above observation.
1. Sort the array in non-decreasing order.
2. Take three queues. One for storing elements which on dividing by 3 gives remainder as 0.
The second queue stores digits which on dividing by 3 gives remainder as 1. The third queue stores digits which on dividing by 3 gives remainder as 2. 
Call them as queue0, queue1 and queue2
3. Find the sum of all the digits.
4. Three cases arise:
……4.1 The sum of digits is divisible by 3. 
Dequeue all the digits from the three queues. Sort them in non-increasing order. Output the array.
……4.2 The sum of digits produces remainder 1 when divided by 3.
Remove one item from queue1. If queue1 is empty, remove two items from queue2. If queue2 contains less than two items, the number is not possible.
……4.3 The sum of digits produces remainder 2 when divided by 3.
Remove one item from queue2. If queue2 is empty, remove two items from queue1. If queue1 contains less than two items, the number is not possible.
5. Finally empty all the queues into an auxiliary array. Sort the auxiliary array in non-increasing order. Output the auxiliary array.

Example:
arr = 8,1,7,6,0
q1(a%3 == 0) = 6,0
q2(a%3 == 1) = 1,7
q3(a%3 == 2) = 8

case1: 4.1
case2: 4.2
case3: 4.3
 */
 
public class Q8_NC_FindLargestMultipleOf3FormedFromArrayElements {

	public static int getLargestMultiple(int[] arr){
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {8, 1, 7, 6, 0};
		System.out.println("Largest multiple of 3 is:"+getLargestMultiple(arr));
	}

}

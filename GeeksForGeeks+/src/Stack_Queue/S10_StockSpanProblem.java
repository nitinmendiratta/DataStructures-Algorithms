package Stack_Queue;
import java.util.*;
/*
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * https://www.youtube.com/watch?v=KukalT0U3Eg
 * http://ideone.com/uc6kfL
 */
public class S10_StockSpanProblem {

	// A stack based efficient method to calculate stock span values
	public static void calculateSpan(int price[], int n, int S[]){
	   // Create a stack and push index of first element to it
	   Stack<Integer> stack = new Stack<Integer>();
	   stack.push(0);
	 
	   // Span value of first element is always 1
	   S[0] = 1;
	 
	   // Calculate span values for rest of the elements
	   for (int i = 1; i < n; i++){
	      // Pop elements from stack while stack is not empty and top of
	      // stack is smaller than price[i]
	      while (!stack.empty() && price[stack.peek()] <= price[i])
	    	  stack.pop();
	 
	      // If stack becomes empty, then price[i] is greater than all elements
	      // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
	      // is greater than elements after top of stack
	      S[i] = (stack.empty())? (i + 1) : (i - stack.peek());
	 
	      // Push this element to stack
	      stack.push(i);
	   }
	}
	 
	// A utility function to print elements of array
	public static void printArray(int arr[], int n){
	    for (int i = 0; i < n; i++)
	     System.out.println(arr[i]+" ");
	}
	 
	// Driver program to test above function
	public static void main(String[] args) {
	    int price[] = {10, 4, 5, 90, 120, 80};
	    int n = price.length;
	    int S[] = new int[n];
	 
	    // Fill the span values in array S[]
	    calculateSpan(price, n, S);
	 
	    // print the calculated span values
	    printArray(S, n);
	}

}

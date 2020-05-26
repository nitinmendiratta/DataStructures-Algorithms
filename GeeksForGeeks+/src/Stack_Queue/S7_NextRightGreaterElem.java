// http://www.geeksforgeeks.org/next-greater-element/
package Stack_Queue;

/*
 * 1) Push the first element to stack.
2) Pick rest of the elements one by one and follow following steps in loop.
….a) Mark the current element as next.
….b) If stack is not empty, then pop an element from stack and compare it with next.
….c) If next is greater than the popped element, then next is the next greater element foR the popped element.
….d) Keep poppoing from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped 
elements
….g) If next is smaller than the popped element, then push the popped element back.
3) After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
 */
import java.util.Stack;
public class S7_NextRightGreaterElem {

	public static void nextGreater(int[] arr){
		int next = -1,peek;
		Stack stack = new Stack();
		stack.push(arr[0]);
		for(int i = 1;i < arr.length;i++){
			next = arr[i];
			peek = (Integer)stack.pop();
			while(next > peek){
				System.out.println("NGE of:"+peek+" is:"+next);
				if(stack.isEmpty()) break;
				peek = (Integer)stack.pop();
			}
			if(next < peek) stack.push(peek);
			stack.push(next);
		}
		while(!stack.isEmpty()){
			peek = (Integer)stack.pop();
			next = -1;
			System.out.println("NGE of:"+peek+" is:"+next);
		}
	}

	public static void main(String[] args) {
		int[] arr = {4, 5, 2, 25};
		nextGreater(arr);
	}
}

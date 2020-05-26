// http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
package Stack_Queue;

import java.util.*;

public class S9_SortStackUsingRecursion {

	public static void sort(Stack stack){
		
		if(!stack.isEmpty()){
			int temp = (int) stack.pop();
			sort(stack);
			sortedInsert(stack, temp);
		}
	}
	
	public static void sortedInsert(Stack stack, int data){
		
		if(!stack.isEmpty() && (int)stack.peek() > data){
			int temp = (int) stack.pop();
			sortedInsert(stack, data);
			stack.push(temp);
		}else{
			stack.push(data);
		}
	}
	public static void main(String[] args) {
		Stack myStack = new Stack();
        myStack.push(-3);
        myStack.push(14);
        myStack.push(18);
        myStack.push(-5);
        myStack.push(30);
        
        System.out.println("Original Stack : " + myStack);
        S9_SortStackUsingRecursion.sort(myStack);
        System.out.println("Revered Stack : " + myStack);

	}

}

// http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
package Stack_Queue;
import java.util.*;
/*
 * You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
	isEmpty(S)
	push(S)
	pop(S)
 */

public class S8_ReverseStackUsingRecursion {

	public static void reverse(Stack<String> stack){
		if(!stack.isEmpty()){
			String elem = stack.pop();
			
			reverse(stack);
			insertAtBottom(stack,elem);
		}
	}

	public static void insertAtBottom(Stack<String> stack, String data){
		if(stack.isEmpty()){
			stack.push(data);
		}else{
			String elem = stack.pop();
			insertAtBottom(stack, data);
			stack.push(elem);
		}
	}
	
	public static void main(String[] args) {
		Stack<String> myStack = new Stack<String>();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        System.out.println("Original Stack : " + myStack);
        S8_ReverseStackUsingRecursion.reverse(myStack);
        System.out.println("Revered Stack : " + myStack);
	}
}

package Easy;
import java.util.Stack;

/*
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class E_0232_ImplementQueueUsingStacks {
	Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
	public static void main(String[] args) {
		E_0225_ImplementStackUsingQueues obj = new E_0225_ImplementStackUsingQueues();
		obj.push(1);
		System.out.println((int)obj.pop());
	}
}

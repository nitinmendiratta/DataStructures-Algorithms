package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class E_0225_ImplementStackUsingQueues {
	Queue<Integer> q = new LinkedList();

	/** Push element x onto stack. */
	public void push(int x) {
		q.add(x);
		int size = q.size();
		while(size > 1){
			q.add(q.poll());
			size--;
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return q.poll();
	}

	/** Get the top element. */
	public int top() {
		return q.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return q.isEmpty();
	}
	
	public static void main(String[] args) {
		E_0225_ImplementStackUsingQueues obj = new E_0225_ImplementStackUsingQueues();
		obj.push(1);
		System.out.println((int)obj.pop());
	}
}

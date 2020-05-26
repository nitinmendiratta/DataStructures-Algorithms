package Stack_Queue;
import java.util.Stack;

// https://www.geeksforgeeks.org/queue-using-stacks/

public class Q6_ImplementQueueUsingStacks {

	Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> value = new Stack<Integer>();
	 
    // Push element x to the back of queue.
    public void enqueue(int x) {
    	value.push(x);
    }
 
    // Removes the element from in front of queue.
    public int dequeue() throws IllegalStateException{
    	if(temp.isEmpty() && value.isEmpty()){
    		System.out.println("Queue is empty");
    		throw new IllegalStateException();
    	}
    	if(temp.isEmpty()){
            while(!value.isEmpty()){
                temp.push(value.pop());
            }    
    	}    	
		return temp.pop();
    }
 
    // Get the front element.
    public int peek() {
        return value.peek();
    }
 
    // Return whether the queue is empty.
    public boolean empty() {
        return value.isEmpty();
    }
    
    public static void main(String[] args){
		Q6_ImplementQueueUsingStacks obj = new Q6_ImplementQueueUsingStacks();
	    obj.enqueue(1);
	    obj.enqueue(2);
	    obj.enqueue(3);
	     
	    /* Dequeue items */
	    System.out.println(obj.dequeue());
	    System.out.println(obj.dequeue());
	    obj.enqueue(4);
	    System.out.println(obj.dequeue());
	}
}

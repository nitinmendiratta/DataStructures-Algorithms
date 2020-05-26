package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class S27_ImplementStackUsingSingleQueue {

	Queue<Integer> q = new LinkedList<Integer>();
	// Push operation
	public void push(int val){
	    //  Get previous size of queue
	    int s = q.size();
	 
	    // Push current element
	    q.add(val);
	 
	    // Pop (or Dequeue) all previous
	    // elements and put them after current
	    // element
	    for (int i=0; i<s; i++){
	        // this will add front element into
	        // rear of queue
	        q.add(q.peek());
	 
	        // this will delete front element
	        q.remove();
	    }
	}
	 
	// Removes the top element
	public void pop(){
	    if (q.isEmpty())
	        System.out.println("No elements\n");
	    else
	    	q.remove();
	}
	
	// Returns top of stack
	public int peek(){
	    return (q.isEmpty())? -1 : q.peek();
	}
	 
	// Returns true if Stack is empty else false
	public boolean empty(){
	    return (q.isEmpty());
	}
	
	public static void main(String[] args) {
		S27_ImplementStackUsingSingleQueue s = new S27_ImplementStackUsingSingleQueue();
	    s.push(10);
	    s.push(20);
	    System.out.println(s.peek());
	    s.pop();
	    s.push(30);
	    s.pop();
	    System.out.println(s.peek());

	}

}

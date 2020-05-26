package Stack_Queue;
import java.util.*;

/*
 * http://www.geeksforgeeks.org/implement-stack-using-queue/
 */
public class S12_ImplementStackUsingQueues {
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	public void push(int x){
		q1.add(x);
	}
	
	/*push(s,  x)
	  1) Enqueue x to q1 (assuming size of q1 is unlimited).

	pop(s)  
	  1) One by one dequeue everything except the last element from q1 and enqueue to q2.
	  2) Dequeue the last item of q1, the dequeued item is result, store it.
	  3) Swap the names of q1 and q2
	  4) Return the item stored in step 2.
	 Swapping of names is done to avoid one more movement of all elements 
	 from q2 to q1.*/
	public int pop() throws IllegalStateException{
		if(q1.size() == 0)throw new IllegalStateException("stack is empty"); 
		while(q1.size() != 1){
			int x = q1.remove();
			q2.add(x);
		}
		int result = q1.remove();
		
		Queue temp = q1;
		q1 = q2;
		q2 = temp;
		
//		while(q2.size() != 0){
//			int x = q2.remove();
//			q1.add(x);
//		}
		return result;
	}
	
	public static void main(String[] args) {
		S12_ImplementStackUsingQueues s1 = new S12_ImplementStackUsingQueues();
        try{
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.push(9);
        s1.push(10);
        // s1.push(6);
        System.out.println("1st = " + s1.pop());
        System.out.println("2nd = " + s1.pop());
        System.out.println("3rd = " + s1.pop());
        System.out.println("4th = " + s1.pop());
        System.out.println("5th = " + s1.pop());
        System.out.println("6th = " + s1.pop());
        System.out.println("7th = " + s1.pop());
        System.out.println("8th = " + s1.pop());
        System.out.println("9th = " + s1.pop());
        System.out.println("10th= " + s1.pop());
        }
        catch(Exception x){
        	System.out.println("Exception");
        }
	}

}

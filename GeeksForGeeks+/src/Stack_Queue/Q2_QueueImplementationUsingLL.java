package Stack_Queue;

//http://quiz.geeksforgeeks.org/queue-set-2-linked-list-implementation/

import LinkList.ListNode;
/*
 * In normal implementation of LL we have insertion at front in O(1) and
 * deletion at end takes O(n) but in case of queue all operations take constant
 * time. So we need to have 2 pointers like head ie front and rear
 */
public class Q2_QueueImplementationUsingLL{

    private ListNode front;
    private ListNode rear;

    public Q2_QueueImplementationUsingLL(){
        front = null;
        rear = null;
    }

    public void enqueue(int input){
        ListNode temp = new ListNode(input);
        if(front == null && rear == null){
            front = rear = temp;
            return;
        }
        else{
            rear.next = temp;
            rear = temp;
        }
    }

    public int dequeue() throws IllegalStateException{
        if(isEmpty()){
            System.out.println("Queue is empty");
            throw new IllegalStateException();
        }
        else if(front == rear){
            int data = front.data;
            front = rear = null;
            return data;
        }
        else{
            int data = front.data;
            front = front.next;
            return data;
        }
    }

    public int front() {
	    if(!isEmpty()) {
		    System.out.println("Queue is empty\n");
		    return -1;
	    }
	    return front.data;
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void printQueue(){
        ListNode ptr = front;
        while(ptr != null){
            System.out.print(ptr.data+"->");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Q2_QueueImplementationUsingLL queue = new Q2_QueueImplementationUsingLL();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printQueue();
        try{
            while(!queue.isEmpty()){
                int output = queue.dequeue();
                System.out.println("Dequeueing:"+output);
            }
            queue.enqueue(5);
            queue.enqueue(6);
            //queue.dequeue();
            queue.printQueue();
        }
        catch(IllegalStateException e){
            System.out.println("Underflow/Overflow condition");
        }
    }
}

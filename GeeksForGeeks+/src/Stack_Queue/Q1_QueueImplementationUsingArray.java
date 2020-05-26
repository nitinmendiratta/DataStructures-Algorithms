package Stack_Queue;

// http://quiz.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/

public class Q1_QueueImplementationUsingArray<E>{
    private int maxSize;
    private int front;
    private int rear;
    private E[] queueArray;

    public Q1_QueueImplementationUsingArray(int size){
        maxSize = size;
        queueArray = (E[])new Object[maxSize];
        front = -1;
        rear = -1;
    }

    public void enqueue(E input){
        if(isFull())
            return;
        else if(isEmpty())
            front = rear = 0;
        else
            rear = (rear+1)%maxSize;
        queueArray[rear] = input;
    }

    public E dequeue() throws IllegalStateException{
        if(isEmpty()){
            throw new IllegalStateException();
        }
        else if(front == rear){
            E out = queueArray[front];
            front = rear = -1;
            return out;
        }
        else{
            E out = queueArray[front];
            front = (front+1)%maxSize;
            return out;
        }
    }

    public E front() throws IllegalStateException{
        if(!isEmpty())
            return queueArray[front];
        else
            System.out.println("No element in queue");
        throw new IllegalStateException();
    }

    public boolean isEmpty(){
        return ((front == -1) && (rear == -1));
    }

    public boolean isFull(){
        return ((rear+1)%maxSize == front);
    }

    public void printQueue(){
        // Finding number of elements in queue
		int count = (rear+maxSize-front)%maxSize + 1;
		System.out.println("Queue is:\n");
		for(int i = 0; i < count; i++){
			int index = (front+i) % maxSize;
            // Index of element while travesing circularly from front
			System.out.print(queueArray[index]+"<-");
		}
        System.out.println();
    }

    public static void main(String[] args){
        Q1_QueueImplementationUsingArray<Integer> queue = new Q1_QueueImplementationUsingArray<Integer>(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        try{
            while(!queue.isEmpty()){
                int out = queue.dequeue();
                System.out.print(out);
            }
            queue.enqueue(5);
            queue.enqueue(6);
            queue.printQueue();
        }
        catch(IllegalStateException e){
            System.out.println("Underflow/Overflow condition");
        }
    }
}

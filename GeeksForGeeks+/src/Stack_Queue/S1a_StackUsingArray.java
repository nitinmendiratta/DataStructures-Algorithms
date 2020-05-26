package Stack_Queue;
// http://quiz.geeksforgeeks.org/stack-set-1/

public class S1a_StackUsingArray<E>{
        private int maxSize;
        private E[] stackArray;
        private int top;
        
        public S1a_StackUsingArray(int size){
            maxSize = size;
            stackArray = (E[])new Object[maxSize];
            top = -1;
        }
        public void push(E input){
            //over flow check
            if(top == maxSize){
                System.out.println("No more space to push");
                return;
            }
            stackArray[++top] = input;
        }

        public E pop() throws IllegalStateException {
            // underflow check
            if(top == -1){
                throw new IllegalStateException();
            }
            return stackArray[top--];
        }
        public E peek(){
            return stackArray[top];
        }

        public boolean isEmpty(){
            return (top == -1);
        }

        public boolean isFull(){
            return (top == maxSize -1);
        }

        public static void main(String[] args){
            S1a_StackUsingArray<Integer> stack = new S1a_StackUsingArray<Integer>(10);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            try{
                while(!stack.isEmpty()){
                    Integer value = stack.pop();
                    System.out.println("popped elem:"+value+"\n");
                }
                 Integer value = stack.pop();
            }catch(IllegalStateException e){
                System.out.println("Sorry, no element to pop");
                e.printStackTrace();
            }
        }
}

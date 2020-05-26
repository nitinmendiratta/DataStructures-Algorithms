package Stack_Queue;
// http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
// http://stackoverflow.com/questions/7134129/stack-with-find-min-find-max-more-efficient-than-on
import java.util.*;

public class S11_DesignImplementSpecialStack extends Stack<Integer>{
	
	private Stack<Integer> minStack;
	
	public S11_DesignImplementSpecialStack() {
		minStack = new Stack<Integer>();   
	}
	public void push(int input){
		//If input is smaller than minStack top then push input to the min stack.
        if(minStack.isEmpty()){
        	minStack.push(input);
        }else{
        	if(input <= minStack.peek()){
        		minStack.push(input);
        	}       	
        }
        	
        super.push(input);
    }

    public Integer pop(){
    	int top = super.pop();
    	if(!minStack.isEmpty() && minStack.peek() == top){
    		minStack.pop();   
        }
    	return top;
    }
    
	public int getMin(){
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		S11_DesignImplementSpecialStack specialStack = new S11_DesignImplementSpecialStack();
		specialStack.push(10);
		specialStack.push(20);
		specialStack.push(30);
	    System.out.println(specialStack.getMin());
	    specialStack.push(5);
	    System.out.println(specialStack.getMin());
	}
}

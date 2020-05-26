package Easy;
import java.util.Stack;
/*
 * https://oj.leetcode.com/problems/min-stack/
 */
public class E_0155_MinStack {
	
	Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();
    
    public void push(int x) {
        stack.push(x);
        int min;
        if(minStack.isEmpty()){
            min = Integer.MAX_VALUE;
        }else{
           min = minStack.peek();
        }
         
        if(x <= min){
            minStack.push(x);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int x = stack.pop();
            int min = minStack.peek();
            if(x == min){
                minStack.pop();
            }
        }
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return Integer.MAX_VALUE;
    }
    
    public int getMin() {
        if(!minStack.isEmpty()){
           return minStack.peek();
        }
        return Integer.MIN_VALUE;
    }
	
	public static void main(String[] args) {
		E_0155_MinStack obj = new E_0155_MinStack();
		obj.push(512);
		obj.push(-1024);
		obj.push(-1024);
		obj.push(512);
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
	}
}
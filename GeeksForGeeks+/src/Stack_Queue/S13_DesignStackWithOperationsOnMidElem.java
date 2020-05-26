package Stack_Queue;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/
 */
class DllNode{
	int data;
	DllNode next;
	DllNode prev;
	public DllNode(int x){
		this.data = x;
		this.next = null;
		this.prev = null;
	}
}

public class S13_DesignStackWithOperationsOnMidElem {

	DllNode list, mid;
	public static int count;

	S13_DesignStackWithOperationsOnMidElem(){
		count = 0;
		list = null;
		mid = null;
	}

	public void push(int x){
		count++;
		DllNode node = new DllNode(x);
		if(list == null){
			list = node;
		}
		list.next = node;
		node.prev = list;
		list = list.next;
		if(count == 1) mid  = list;
		if(count%2 != 0) mid = mid.next;
	}

	public int pop() throws IllegalStateException{
		if(count == 0) throw new IllegalStateException("stack empty");
		count--;
		int x = list.data;
		list = list.prev;
		list.next = null;
		if(count%2 == 0) mid = mid.prev;
		return x;
	}

	public int findMiddle(){
		return mid.data;
	}

	public void deleteMiddle() throws IllegalStateException{
		if(count == 0) throw new IllegalStateException("stack empty");
		count--;
		System.out.println("Deleting middle:"+mid.data);
		(mid.prev).next = mid.next;
		(mid.next).prev = mid.prev;
	}

	public static void main(String[] args) {
		S13_DesignStackWithOperationsOnMidElem stack = new S13_DesignStackWithOperationsOnMidElem();
		try{
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			stack.push(5);
			System.out.println("Middle:"+stack.findMiddle());
			stack.deleteMiddle();
			System.out.println("deleted:"+stack.pop());
			System.out.println("deleted:"+stack.pop());
			System.out.println("deleted:"+stack.pop());
			System.out.println("deleted:"+stack.pop());
			System.out.println("deleted:"+stack.pop());
			stack.deleteMiddle();
			stack.deleteMiddle();
			System.out.println(stack.findMiddle());
		}catch(Exception x){
			System.out.println("empty");
		}
	}

}

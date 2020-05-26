package Stack_Queue;

/*
 * http://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 */
public class S5_Implement_2_Stacks_Using_1_Array {

	int[] arr;
	int top1,top2,maxSize;

	public S5_Implement_2_Stacks_Using_1_Array(int size){
		maxSize = size;
		arr = new int[size];
		top1 = -1;
		top2 = size;
	}

	public void push1(int x){
		if(top1 < top2-1){
			top1++;	
			arr[top1] = x;
		}
		else{
			System.out.println("Overflow");
		}
	}

	public void push2(int x){
		if(top1 < top2-1){
			top2--;
			arr[top2] = x;
		}
		else{
			System.out.println("Overflow");
		}
	}

	public int pop1() throws Exception{
		if(top1 >= 0){
			int x = arr[top1];
			top1--;
			return x;
		}
		else{
			throw new Exception("Underflow");
		}
	}

	public int pop2() throws Exception{
		if(top2 < maxSize){
			int x = arr[top2];
			top2++;
			return x;
		}
		else{
			throw new Exception("Underflow");
		}
	}

	public static void main(String[] args) {
		S5_Implement_2_Stacks_Using_1_Array ts = new S5_Implement_2_Stacks_Using_1_Array(5);
		try{
			ts.push1(5);
			ts.push2(10);
			ts.push2(15);
			ts.push1(11);
			ts.push2(7);
			System.out.println("Popped element from stack1 is "+ts.pop1());
			ts.push2(40);
			System.out.println("Popped element from stack1 is "+ts.pop2());
		}
		catch(Exception e){
			System.out.println("Underflow");
		}
	}
}

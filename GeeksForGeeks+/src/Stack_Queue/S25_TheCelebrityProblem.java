package Stack_Queue;
// http://www.geeksforgeeks.org/the-celebrity-problem/

import java.util.Stack;

/*We can use stack to verify celebrity.

Push everybody into a stack.
Pop off top two persons from the stack, discard one person based on return status of HaveAcquaintance(A, B).
Push the remained person onto stack.
Repeat step 2 and 3 until only one person remains in the stack.
Check the remained person in stack doesn’t have acquaintance with anyone else.
We will discard N elements utmost. 
If the celebrity is present in the party, we will call HaveAcquaintance() 3(N-1) times. Here is code using stack.*/

public class S25_TheCelebrityProblem {

	// Person with 2 is celebrity
	boolean  MATRIX[][] = {{false, false, true, false},
	                      {false, false, true, false},
	                      {false, false, false, false},
	                      {false, false, true, false}};
	 
	boolean knows(int a, int b){
	    return MATRIX[a][b];
	}
	 
	// Returns -1 if celebrity is not present.
	// If present, returns id  (value from 0 to n-1).
	public int findCelebrity(int n){
	    // Handle trivial case of size = 2
	 
	    Stack<Integer> s = new Stack<Integer>();
	 
	    int C; // Celebrity
	 
	    // Push everybody to stack
	    for (int i=0; i<n; i++)
	        s.push(i);
	 
	    // Extract top 2
	    int A = s.pop();
	    int B = s.pop();
	     
	    // Find a potential celebrity
	    while (s.size() > 1){
	        if (knows(A, B)){
	            A = s.pop();
	        }
	        else{
	            B = s.pop();
	        }
	    }
	 
	    // Potential candidate?
	    C = s.pop();
	 
	    // Last candidate was not examined, it leads
	    // one excess comparison (optimize)
	    if (knows(C, B))
	        C = B;
	 
	    if (knows(C, A))
	        C = A;
	 
	    // Check if C is actually a celebrity or not
	    for (int i = 0; i < n; i++){
	        // If any person doesn't know 'a' or 'a'
	        // doesn't know any person, return -1
	        if ( (i != C) &&
	                (knows(C, i) || !knows(i, C)) )
	            return -1;
	    }
	 
	    return C;
	}
	 
	// Driver code
	public static void main(String[] args) {
		S25_TheCelebrityProblem obj = new S25_TheCelebrityProblem();
		int n = 4;
	    int id = obj.findCelebrity(n);
	    if(id == -1){
	    	System.out.println("No celebrity");
	    } else{
    		System.out.println("Celebrity ID "+id);
    	}
    }

}

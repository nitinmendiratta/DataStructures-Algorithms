package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/tug-of-war/
 * http://codefordummies.blogspot.com/2013/10/backtracking-tug-of-war.html
 */

public class A083_NC_TugOfWar {

	// function that tries every possible solution by calling itself recursively
	public void TOWUtil(int[] arr, int n, boolean[] curr_elements, int no_of_selected_elements,
	             boolean[] soln, int min_diff, int sum, int curr_sum, int curr_position){
	    // checks whether the it is going out of bound
	    if (curr_position == n)
	        return;
	 
	    // checks that the numbers of elements left are not less than the
	    // number of elements required to form the solution
	    if ((n/2 - no_of_selected_elements) > (n - curr_position))
	        return;
	 
	    // consider the cases when current element is not included in the solution
	    TOWUtil(arr, n, curr_elements, no_of_selected_elements,
	              soln, min_diff, sum, curr_sum, curr_position+1);
	 
	    // add the current element to the solution
	    no_of_selected_elements++;
	    curr_sum = curr_sum + arr[curr_position];
	    curr_elements[curr_position] = true;
	 
	    // checks if a solution is formed
	    if (no_of_selected_elements == n/2){
	        // checks if the solution formed is better than the best solution so far
	        if (Math.abs(sum/2 - curr_sum) < min_diff){
	            min_diff = Math.abs(sum/2 - curr_sum);
	            for (int i = 0; i<n; i++)
	                soln[i] = curr_elements[i];
	        }
	    }
	    else{
	        // consider the cases where current element is included in the solution
	        TOWUtil(arr, n, curr_elements, no_of_selected_elements, soln,
	                  min_diff, sum, curr_sum, curr_position+1);
	    }
	 
	    // removes current element before returning to the caller of this function
	    curr_elements[curr_position] = false;
	}
	 
	// main function that generate an arr
	public void tugOfWar(int[] arr){
		int n = arr.length;
	    // the boolen array that contains the inclusion and exclusion of an element
	    // in current set. The number excluded automatically form the other set
	    boolean[] curr_elements = new boolean[n];
	 
	    // The inclusion/exclusion array for final solution
	    boolean[] soln = new boolean[n];
	 
	    int min_diff = Integer.MAX_VALUE;
	    int sum = 0;
	    for (int i=0; i<n; i++){
	        sum += arr[i];
	        curr_elements[i] =  soln[i] = false;
	    }
	 
	    // Find the solution using recursive function TOWUtil()
	    TOWUtil(arr, n, curr_elements, 0, soln, min_diff, sum, 0, 0);
	 
	    // Print the solution
	    System.out.println("The first subset is: ");
	    for (int i=0; i<n; i++){
	        if (soln[i] == true)
	            System.out.println(arr[i] +" ");
	    }
	    System.out.println("\nThe second subset is: ");
	    for (int i=0; i<n; i++){
	        if (soln[i] == false)
	            System.out.println(arr[i] +" ");
	    }
	}

	public static void main(String[] args) {
		A083_NC_TugOfWar obj = new A083_NC_TugOfWar();
		int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		obj.tugOfWar(arr);
	}
}

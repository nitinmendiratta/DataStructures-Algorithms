package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 * https://www.youtube.com/watch?v=GdnpQY2j064
 */
public class A063_PartitionProblem {

	public boolean subset(int[] arr){
		int sum = 0,n = arr.length;
		int sumValue, itemCount; 

		// Caculcate sun of all elements
		for (sumValue = 0; sumValue < n; sumValue++)
			sum += arr[sumValue];

		if (sum%2 != 0)	return false;

		boolean part[][] = new boolean[sum/2+1][n+1];
		// initialize top row as true
		for (sumValue = 0; sumValue <= n; sumValue++)
			part[0][sumValue] = true;

		// initialize leftmost column, except part[0][0], as 0
		for (sumValue = 1; sumValue <= sum/2; sumValue++)
			part[sumValue][0] = false;     

		// Fill the partition table in botton up manner 
		for (sumValue = 1; sumValue <= sum/2; sumValue++){
			for (itemCount = 1; itemCount <= n; itemCount++){
				part[sumValue][itemCount] = part[sumValue][itemCount-1];
				if (sumValue >= arr[itemCount-1])
					part[sumValue][itemCount] = part[sumValue][itemCount] || part[sumValue - arr[itemCount-1]][itemCount-1];
			}        
		}    
		// uncomment this part to print table 
		/*for (sumValue = 0; sumValue <= sum/2; sumValue++){
			System.out.println("----------------------------");
			for (itemCount = 0; itemCount <= n; itemCount++)  
				System.out.print(part[sumValue][itemCount]+"|");
			System.out.println();
		}*/ 
		return part[sum/2][n];
	}

	public static void main(String[] args) {
		A063_PartitionProblem obj = new A063_PartitionProblem();
		int[] arr = {1, 5, 11, 5};
		System.out.println("can subset:"+obj.subset(arr));
	}
}

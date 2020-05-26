package Array_Matrix;
/*
  * Below prb is also same as activity selection prob
 * http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-ChainPairs/
*/
class ChainPair{
	int a;
	int b;
	ChainPair(int i, int j){
		a = i;
		b = j;
	}
}
public class A067_MaximumLengthChainOfPairs {

	public int maxChainLength(ChainPair arr[]){
		   int i, j, max = 0;
		   int n = arr.length;
		   int[] mcl = new int[n];
		 
		   /* Initialize MCL (max chain length) values for all indexes */
		   for ( i = 0; i < n; i++ )
		      mcl[i] = 1;
		 
		   /* Compute optimized chain length values in bottom up manner */
		   for ( i = 1; i < n; i++ )
		      for ( j = 0; j < i; j++ )
		         if (arr[i].a > arr[j].b)
		            mcl[i] = Math.max(mcl[i], mcl[j] + 1);
		 
		   // mcl[i] now stores the maximum chain length ending with ChainPair i
		 
		   /* Pick maximum of all MCL values */
		   for ( i = 0; i < n; i++ )
		      if ( max < mcl[i] )
		         max = mcl[i];

		   return max;
	}
	public static void main(String[] args) {
		A067_MaximumLengthChainOfPairs obj = new A067_MaximumLengthChainOfPairs();
		ChainPair ChainPair1 = new ChainPair(5, 24);
		ChainPair ChainPair2 = new ChainPair(15, 25);
		ChainPair ChainPair3 = new ChainPair(27, 40);
		ChainPair ChainPair4 = new ChainPair(50, 60);
		ChainPair[] arr = {ChainPair1, ChainPair2, ChainPair3, ChainPair4};
		System.out.println("Length of maximum size chain is: "+ obj.maxChainLength(arr));
	}
}

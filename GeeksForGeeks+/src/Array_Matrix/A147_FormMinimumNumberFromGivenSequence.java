package Array_Matrix;
import java.util.Vector;
/*
 * http://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
 * 
 */
public class A147_FormMinimumNumberFromGivenSequence {

	public void printLeast(String str){
		char[] arr = str.toCharArray();
	    // min_avail represents the minimum number which is
	    // still available for inserting in the output vector.
	    // pos_of_I keeps track of the most recent index
	    // where 'I' was encountered w.r.t the output vector
	    int min_avail = 1, pos_of_I = 0;
	 
	    //vector to store the output
	    Vector v = new Vector();
	 
	    // cover the base cases
	    if (arr[0]=='I'){
	        v.add(1);
	        v.add(2);
	        min_avail = 3;
	        pos_of_I = 1;
	    }
	    else{
	        v.add(2);
	        v.add(1);
	        min_avail = 3;
	        pos_of_I = 0;
	    }
	 
	    // Traverse rest of the input
	    for (int i=1; i<arr.length; i++){
	        if (arr[i]=='I'){
	            v.add(min_avail);
	            min_avail++;
	            pos_of_I = i+1;
	        }
	        else{
	            v.add(v.get(i));
	            for (int j=pos_of_I; j<=i; j++)
	                v.set(j, (int)v.get(j)+1);
	 
	            min_avail++;
	        }
	    }
	 
	    // print the number
	    for (int i=0; i<v.size(); i++)
	        System.out.print(v.get(i)+ " ");
	}
	public static void main(String[] args) {
		A147_FormMinimumNumberFromGivenSequence obj = new A147_FormMinimumNumberFromGivenSequence();
		obj.printLeast("IDID");
		System.out.println();
		obj.printLeast("I");
		System.out.println();
		obj.printLeast("DD");
		System.out.println();
		obj.printLeast("II");
		System.out.println();
		obj.printLeast("DIDI");
		System.out.println();
		obj.printLeast("IIDDD");
		System.out.println();
		obj.printLeast("DDIDDIID");
	}

}

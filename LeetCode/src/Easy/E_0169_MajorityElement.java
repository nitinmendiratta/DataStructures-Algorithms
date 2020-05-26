package Easy;
/*
 * A002: http://www.geeksforgeeks.org/majority-element/
 * E_169: https://leetcode.com/problems/majority-element/
 * Time Complexity: O(n)
 * Auxiliary Space : O(1)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a) If a[maj_index] == a[i]
          count++
    (b) Else
        count--;
    (c) If count == 0
          maj_index = i;
          count = 1
3.  Return a[maj_index]
 */
public class E_0169_MajorityElement {

	public int majority(int[] num){
		int count = 1, majindx = 0, n = num.length;

		for(int i = 1; i < n; i++){

			if(num[majindx] == num[i]){
				count++;
			}
			else{
				count--;
			}

			if(count == 0){
				count = 1;
				majindx = i;
			}
		}
		count = 0;
		for(int i = 0;i < n;i++){
			if(num[i] == num[majindx]) count++;
		}

		if(count > n/2) return num[majindx];
		else return -1;
	}

	public static void main(String[] args) {
		E_0169_MajorityElement obj = new E_0169_MajorityElement();
		int[] arr = {8,8,7,7,7};
		int indx = obj.majority(arr);
		if(indx == -1) System.out.println("No elem found");
		else{
			int result = arr[indx];
			System.out.println("majority elem is:"+result);
		}
	}
}

package Easy;
/*
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 */
public class E_0944_DeleteColumnsMakeSorted {

	public int minDeletionSize(String[] A) {
		int count = 0;  

		for(int i = 0; i < A[0].length(); i++){
			for(int j = 0; j < A.length-1; j++){
				
				char curr = A[j].charAt(i);
				char next = A[j+1].charAt(i);
				if(curr > next){
					count++;
					break;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		E_0944_DeleteColumnsMakeSorted obj = new E_0944_DeleteColumnsMakeSorted();
		System.out.println(obj.minDeletionSize(new String[] {"cba","daf","ghi"}));
		System.out.println(obj.minDeletionSize(new String[] {"a","b"}));
		System.out.println(obj.minDeletionSize(new String[] {"zyx","wvu","tsr"}));
	}
}

package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
 * Algorithm: segregateEvenOdd()
1) Initialize two index variables left and right:  
            left = 0,  right = size -1 
2) Keep incrementing left index until we see an odd number.
3) Keep decrementing right index until we see an even number.
4) If lef < right then swap arr[left] and arr[right]
 */
public class A027_SegregateEvenAndOddNumbers {

	public void segregateEvenOdd(int arr[]){
        /* Initialize left and right indexes */
        int left = 0, right = arr.length - 1;
        while (left < right){
            /* Increment left index while we see 0 at left */
            while (arr[left]%2 == 0 && left < right)
                left++;
 
            /* Decrement right index while we see 1 at right */
            while (arr[right]%2 == 1 && left < right)
                right--;
 
            if (left < right){
                /* Swap arr[left] and arr[right]*/
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
	public static void main(String[] args) {
		A027_SegregateEvenAndOddNumbers obj = new A027_SegregateEvenAndOddNumbers();
		int arr[] = {12, 34, 45, 9, 8, 90, 3};
		 
        obj.segregateEvenOdd(arr);
 
        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");

	}

}

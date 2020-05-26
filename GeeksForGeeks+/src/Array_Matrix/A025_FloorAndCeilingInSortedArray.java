package Array_Matrix;
// http://www.geeksforgeeks.org/search-floor-and-ceil-in-a-sorted-array/
//https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/FloorAndCeilingSortedArray.java

public class A025_FloorAndCeilingInSortedArray {
	
	public int floor(int input[], int x){
        int low = 0;
        int high = input.length-1;
        while(low <= high){
            int middle = (low + high)/2;
            if(input[middle] == x || (input[middle] < x && (middle == input.length-1 || input[middle+1] > x))){
                return middle;
            }else if(input[middle] < x){
                low = middle+1;
            }else{
                high = middle-1;
            }
        }
        return -1;
    }

    public int ceiling(int input[], int x){
        int low = 0;
        int high = input.length-1;
        while(low <= high){
            int middle = (low + high)/2;
            if(input[middle] == x || (input[middle] > x && (middle == 0 || input[middle-1] < x))){
                return middle;
            }else if(input[middle] < x){
                low = middle+1;
            }else{
                high = middle-1;
            }
        }
        return -1;
    }
	 
	public static void main(String[] args) {
		   A025_FloorAndCeilingInSortedArray obj = new A025_FloorAndCeilingInSortedArray();
		   int arr[] = {1, 2, 8, 10, 10, 12, 19};
		   int n = arr.length;;
		   int x = 13;
		   int index = obj.ceiling(arr,x);
		   if(index == -1)
		     System.out.println("Ceiling doesn't exist in array ");
		   else 
		     System.out.println("Ceiling is: "+arr[index]);
		   
		   index = obj.floor(arr,x);
		   if(index == -1)
		     System.out.println("Floor doesn't exist in array ");
		   else 
		     System.out.println("Floor is: "+arr[index]);
	}
}

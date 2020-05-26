package Sorting_Searching;

public class heapsort {
	
	
	public void arrayHeapSortArray(int arr[]) 
    { 
        int n = arr.length; 
 
        for (int i = n / 2 - 1; i >= 0; i--) 
        	heapifyMinimum(arr, n, i); 
        for (int i=n-1; i>=0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
 
            heapifyMinimum(arr, i, 0); 
        } 
    } 
 
    void heapifyMinimum(int arr[], int n, int i) 
    { 
        int largest = i; // smallest as root 
        int l = 2*i + 1; 
        int r = 2*i + 2; 
 
        if (l < n && arr[l] < arr[largest]) 
            largest = l; 
 
        if (r < n && arr[r] < arr[largest]) 
            largest = r; 
 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
 
            heapifyMinimum(arr, n, largest); 
        } 
    } 
 

}

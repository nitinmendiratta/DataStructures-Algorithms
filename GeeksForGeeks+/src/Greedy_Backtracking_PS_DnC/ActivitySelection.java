package Greedy_Backtracking_PS_DnC;

/*
 * http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/
 * 
 * You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, 
 * assuming that a person can only work on a single activity at a time.
	Example:

	Consider the following 6 activities. 
	     start[]  =  {1, 3, 0, 5, 8, 5};
	     finish[] =  {2, 4, 6, 7, 9, 9};
	The maximum set of activities that can be executed by a single person is {0, 1, 3, 4}
	The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than 
	or equal to the finish time of previously selected activity. We can sort the activities according to their finishing time so that we always 
	consider the next activity as minimum finishing time activity.
	
	1) Sort the activities according to their finishing time
	2) Select the first activity from the sorted array and print it.
	3) Do following for remaining activities in the sorted array.
	a) If the start time of this activity is greater than the finish time of previously selected activity then select this activity and print it.
 *
 */

public class ActivitySelection {

	public void printMaxActivities(int s[], int f[]){
		int n = s.length,i=0, j=0;
		
		System.out.println("Index of selected activities are:");
		// The first activity always gets selected
		i = 0;
		System.out.print(i+",");

		// Consider rest of the activities
		for (j = 1; j < n; j++){
			// If this activity has start time greater than or equal to the finish time of previously selected activity,then select it
			if (s[j] >= f[i]){
				System.out.print(j+",");
				i = j;
			}
		}
	}

	public static void main(String[] args) {
		ActivitySelection obj = new ActivitySelection();
		int s[] =  {1, 3, 0, 5, 8, 5};
		int f[] =  {2, 4, 6, 7, 9, 9};
		obj.printMaxActivities(s, f);
	}

}

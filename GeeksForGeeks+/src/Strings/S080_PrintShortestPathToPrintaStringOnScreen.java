package Strings;
/*
 * http://www.geeksforgeeks.org/print-shortest-path-print-string-screen/
 */
public class S080_PrintShortestPathToPrintaStringOnScreen {

	// Function to print shortest possible path to type all characters of given string using a remote
	/*If row difference is negative, we move up
	If row difference is positive, we move down
	If column difference is negative, we go left
	If column difference is positive, we go right*/
	public void printPath(String str){
	    int i = 0;
	    // start from charcater 'A' present at position (0, 0)
	    int curX = 0, curY = 0;
	    while (i < str.length()){
	        // find cordinates of next character
	        int nextX = (str.charAt(i) - 'A') / 5;
	        int nextY = (str.charAt(i) - 'B' + 1) % 5;
	 
	        // Move Up if destination is above
	        while (curX > nextX){
	            System.out.println("Move Up");
	            curX--;
	        }
	 
	        // Move Left if destination is to the left
	        while (curY > nextY){
	        	System.out.println("Move Left");
	            curY--;
	        }
	 
	        // Move down if destination is below
	        while (curX < nextX){
	        	System.out.println("Move Down");
	            curX++;
	        }
	 
	        // Move Right if destination is to the right
	        while (curY < nextY){
	        	System.out.println("Move Right");
	            curY++;
	        }
	 
	        // At this point, destination is reached
	        System.out.println("Press OK");
	        i++;
	    }
	}
	
	public static void main(String[] args) {
		S080_PrintShortestPathToPrintaStringOnScreen obj = new S080_PrintShortestPathToPrintaStringOnScreen();
		String str = "COZY";
		 
	    obj.printPath(str);
	}
}

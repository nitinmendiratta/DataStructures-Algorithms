package Strings;
/*
 * http://www.geeksforgeeks.org/check-if-a-given-sequence-of-moves-for-a-robot-is-circular-or-not/
 * Time Complexity: O(n) 
 */
public class S046_CheckIfaGivenSequenceOfMovesForRobotIsCircular {

	// This function returns true if the given path is circular, else false
	boolean isCircular(String path){
	  // Initialize starting point for robot as (0, 0) and starting
	  // direction as N North
	  int x = 0, y = 0;
	  int dir = 0;// North
	 
	  // Travers the path given for robot
	  for(int i=0; i<path.length(); i++){
	      // Find current move
	      char move = path.charAt(i);
	 
	      // If move is left or right, then change direction
	      if (move == 'R')
	        dir = (dir + 1)%4;
	      else if (move == 'L')
	        dir = (4 + dir - 1)%4;
	 
	      // If move is Go, then change  x or y according to
	      // current direction
	      else{ // if (move == 'G')
	         if (dir == 0) // North
	            y++;
	         else if (dir == 1)// East
	            x++;
	         else if (dir == 2)//South
	            y--;
	         else // dir == 3 //West
	            x--;
	      }
	  }
	 
	   // If robot comes back to (0, 0), then path is cyclic
	  return (x == 0 && y == 0);
	}
	
	public static void main(String[] args) {
		S046_CheckIfaGivenSequenceOfMovesForRobotIsCircular obj = new S046_CheckIfaGivenSequenceOfMovesForRobotIsCircular();
		String str = "GLGLGLG";
	    if (obj.isCircular(str))
	      System.out.println("Given sequence of moves is circular");
	    else
	      System.out.println("Given sequence of moves is NOT circular");
	}
}

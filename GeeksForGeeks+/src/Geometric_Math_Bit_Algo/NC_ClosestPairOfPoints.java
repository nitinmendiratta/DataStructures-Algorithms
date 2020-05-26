package Geometric_Math_Bit_Algo;

/*
 * http://www.geeksforgeeks.org/closest-pair-of-points-onlogn-implementation/
 * http://www.youtube.com/watch?v=frir6Sf7ft4
 * 
 * Step 1: Initialisation
 * 	Sort the points on X coordinate and on y coordinate
 * Step 2: Divide Step
 * 	-Let the value of the median ( when sorted on x coordinate be Xm)
 * 	-split X into Xl and Xr
 * 	-points in Xl have their x coordinate  <= Xm, Xr contains the other points
 * 	-split y into Yl and Yr, Yl contains the same points as Xl, Yr contains the same points as Xr
 * 	-Input is divided into Xl, Yl and Xr,Yr
 * Step 3:	Recurse step
 * 	dL : distance of the closest pair on input (Xl, Yl)
 * 	dR : ......................................(Xr,Yr)
 * 	d : min of dL and dR
 * Step: put all together
 */
public class NC_ClosestPairOfPoints {


	public static void main(String[] args) {
	
	}

}

package battleship;

import java.util.Arrays;

public class EmptySea extends Ship {
	
/*	This constructor sets the inherited length variable to 1.*/	
	EmptySea() {
		this.setLength(1);
		this.setHit(new boolean[1]);
		Arrays.fill(this.getHit(), false);
		
	}


	/*This method overrides shootAt(int row, int column) that is inherited from Ship, and always returns false to indicate that nothing was hit.*/
	@Override
	public
	boolean shootAt(int row, int column) {
		return false;
	}
	
	/*This method overrides isSunk() that is inherited from Ship, and always returns false to indicate that you didn’t sink anything.*/
	@Override
	public 
	boolean isSunk() {
		return false;
	}
	

	/*Returns a single-character String to use in the Ocean’s print method.
	Since this is the emptysea, you could choose to have an unoccupied sea in many ways*/
	@Override
	public String toString() {
		return "E";
	}
	
	@Override
	public
	String getShipType() {
		// TODO Auto-generated method stub
		return "empty";
	}
	
	
}

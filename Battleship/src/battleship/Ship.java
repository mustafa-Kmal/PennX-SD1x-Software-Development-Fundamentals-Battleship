package battleship;

public abstract class Ship {

	private int bowRow;						//– the row (0 to 19) which contains the bow (front) of the ship.


	private int bowColumn;					//- the column which contains the bow (front) of the ship.    

	private int length;						//– the number of squares occupied by the ship. An ”empty sea” location has length 1. 

	private boolean horizontal;				//– true if the ship occupies a single row, false otherwise. Ships will either be placed vertically or horizontally in the ocean.

	private boolean[] hit; 					// - this is a boolean array of size 8 that record hits. Only battleships use all the locations. The others will use fewer.




	Ship(){}


	Ship(int length) {
		this.length= getLength();
	}

	Ship(int length, boolean[] hit) {
		this.length= getLength();
		this.hit= getHit();
	}



	public int getBowRow() {
		return bowRow;
	}

	public int getBowColumn() {
		return bowColumn;
	}
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}


	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean[] getHit() {
		return hit;
	}
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}

	abstract String getShipType();





	/*Returns true if it is okay to put a ship of this length with its bow 
	 * in this location, with the given orientation, and returns false otherwise.
	 * The ship must not overlap another ship, or touch another ship (vertically,
	 * horizontally, or diagonally), and it must not ”stick out” beyond the array.
	 * Do not actually change either the ship or the Ocean, just says whether
	 * it is legal to do so.*/


	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		if(horizontal) {
			if (column + getLength() > 20)
				return false;
			else {
				for( int i = row-1 ; i< row +2 ; i++ ) {
					for(int j = column -1 ; j< column+ getLength()+1 ; j++ ) {
						try {
							if(!(ocean.getShipArray()[i][j].getShipType().equals("empty")))return false;
						}
						catch(Exception e) {
							continue;
						} 
					}
				}
			}
		}

		else {
			if(row + getLength() > 20) return false;
			else {
				for( int i = row - 1 ; i < row+getLength()+1 ; i++) {
					for(int j = column -1; j < column + 2; j++){
						try {
							if (!(ocean.getShipArray()[i][j].getShipType().equals("empty"))) {
								return false;
							}
						} catch (Exception e) {
							continue;
						}
					}
				}
			}
		}
		return true;

	}





	/*
	 * ”Puts” the ship in the ocean. This involves giving values to the bowRow,
	 *  bowColumn, and horizontal instance variables in the ship, and it also 
	 *  involves putting a reference to the ship in each of 1 or more locations (up to 8)
	 *  in the ships array in the Ocean object. (Note: This will be as many as 
	 *  eight identical references; you can’t refer to a ”part” of a ship, 
	 *  only to the whole ship.)*/
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		bowRow = row;
		bowColumn = column;
		this.horizontal = horizontal;
		if(okToPlaceShipAt(row, column, horizontal,ocean)) {
			if(horizontal) {
				for(int i = column ; i< column+getLength(); i++ ) {
					ocean.getShipArray()[row][i] = this;
				}
			}
			else {
				for(int i = row ; i< row+getLength(); i++ ) {
					ocean.getShipArray()[i][column]=this;
				}
			}}
		return;
	}

	/*
	 * If a part of the ship occupies the given row and column, and the ship hasn’t
	 *  been sunk, mark that part of the ship as ”hit” (in the hit array, 0 indicates the bow)
	 *   and return true, otherwise return false.*/
	boolean shootAt(int row, int column) {
		if (!isSunk()) {
			if(horizontal) {
				if(row == this.bowRow && column < this.bowColumn+length) {
				hit[column-this.bowColumn]=true;
				return true;
			}}
			else {				
				if(column == this.bowColumn && row < this.bowRow+length) {

				hit[row - this.bowRow ]=true;
				return true;
			}}
		}
		return false;
		
		
	
	}
	
	


	public boolean wasShootAt(int row, int column) {
		if (horizontal) {
			return (hit[column - this.bowColumn] == true);
		} else {
			return (hit[row - this.bowRow] == true);
		}
	}

	/*Return true if every part of the ship has been hit, false otherwise.
	 */
	
	/*boolean isSunk() {
		for(int i=0 ; i< hit.length; i++ ) {
			if (!(hit[i]==true)) 
					return false;
		}
			
		

		return true;
	}*/
	
	boolean isSunk() {
		for(int i=0 ; i< getLength(); i++ ) {
			try {
				if (!(this.getHit()[i]==true)) {
					return false;
				}
			} catch (Exception e) {
				continue ;
			}
		}

		return true;
	}




	/*
	 * This method should return ”x” if the ship has been sunk, ”S” if it has not been sunk
	 * . This method can be used to print out locations in the ocean that have been shot at;
	 *  it should not be used to print locations that have not been shot at.


       Since toString behaves exactly the same for all ship types, it can be moved 
       into the Ship class.

		Note that the toString method for the EmptySea class has to override the Ship 
		class's implementation. In order to figure out what needs to be done, please see the 
		description of the print method in the Ocean class.*/


	@Override
	//Returns a single-character String to use in the Ocean’s print method(see below).
	public String toString() {
		if(isSunk()) return "x";	

		return "S";
	}







}

package battleship;

import java.util.Arrays;

public class Destroyer extends Ship {

	
	Destroyer(){
		this.setLength(4);
		this.setHit(new boolean[4]);
		Arrays.fill(this.getHit(), false);
	}
	
	
	@Override
	public
	String getShipType() {
		// TODO Auto-generated method stub
		return "Destroyer";
	}

}

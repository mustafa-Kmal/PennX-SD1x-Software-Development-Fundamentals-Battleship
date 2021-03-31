package battleship;

import java.util.Arrays;

public class Cruiser extends Ship {

	Cruiser() {
		this.setLength(6);
		this.setHit(new boolean[6]);
		Arrays.fill(this.getHit(), false);
	}

	@Override
	public
	String getShipType() {
		// TODO Auto-generated method stub
		return "cruiser";
	}

}

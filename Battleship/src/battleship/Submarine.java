package battleship;

import java.util.Arrays;

public class Submarine extends Ship {
	
	Submarine(){
		this.setLength(3);
		this.setHit(new boolean[3]);
		Arrays.fill(this.getHit(), false);
		}

	@Override
	public
	String getShipType() {
		// TODO Auto-generated method stub
		return "Submarine";
	}

}

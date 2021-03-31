package battleship;

import java.util.Arrays;

public class LightCruiser extends Ship {

	LightCruiser(){
		this.setLength(5);
		this.setHit(new boolean[5]);
		Arrays.fill(this.getHit(), false);
	}
	
	@Override
	public
	String getShipType() {
		// TODO Auto-generated method stub
		return "LightCruiser";
	}

}

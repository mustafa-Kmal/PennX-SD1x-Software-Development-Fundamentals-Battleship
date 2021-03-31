package battleship;

import java.util.Arrays;

public class BattleCruiser extends Ship {

	BattleCruiser(){
		this.setLength(7);
		this.setHit(new boolean[7]);
		Arrays.fill(this.getHit(), false);
	}
	
	@Override
	public
	String getShipType() {
		// TODO Auto-generated method stub
		return "BattleCruiser";
	}

}

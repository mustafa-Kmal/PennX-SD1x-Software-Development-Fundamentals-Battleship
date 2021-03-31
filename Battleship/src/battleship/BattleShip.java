package battleship;

import java.util.Arrays;

public class BattleShip extends Ship {

	BattleShip(){
		this.setLength(8);
		this.setHit(new boolean[8]);
		Arrays.fill(this.getHit(), false);
	}
	
	
	
	@Override
	public
	String getShipType() {
		// TODO Auto-generated method stub
		return "BattleShip";
	}
	
	
	

}

package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class ShipTest {
	Ship battleShip1 = new BattleShip();
	Ship emptySea1 = new EmptySea();
	private Ship battleship1 = new BattleShip();
	private Ship cruiser1 = new Cruiser();
	private Ship cruiser2 = new Cruiser();
	private Ship destroyer1 = new Destroyer();
	private Ship destroyer2 = new Destroyer();
	private Ship destroyer3 = new Destroyer();
	private Ship submarine1 = new Submarine();
	private Ship submarine2 = new Submarine();
	private Ship submarine3 = new Submarine();
	private Ship submarine4 = new Submarine();
	private Ship emptySea = new EmptySea();
	private Ocean ocean = new Ocean();
	
	
	
	
	@Before
	public void setUp() throws Exception {
		//lay 1 battleship and 1 cruiser in the ocean
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				this.ocean.getShipArray()[i][j] = emptySea;
			}
		}
		cruiser1.setBowRow(2);
		cruiser1.setBowColumn(3);
		cruiser1.setHorizontal(true);
		this.ocean.getShipArray()[2][3]=cruiser1;
		this.ocean.getShipArray()[2][4]=cruiser1;
		this.ocean.getShipArray()[2][5]=cruiser1;

		battleship1.setBowColumn(0);
		battleship1.setBowRow(0);
		battleship1.setHorizontal(false);
		this.ocean.getShipArray()[0][0]=battleship1;
		this.ocean.getShipArray()[1][0]=battleship1;
		this.ocean.getShipArray()[2][0]=battleship1;
		this.ocean.getShipArray()[3][0]=battleship1;


	}


	@Test
	public void testOkToPlaceShipAt2() {
		Ship ship1 = new BattleShip();
		Ship ship2 = new BattleShip();
		Ocean ocean = new Ocean();
		assertTrue(ship1.okToPlaceShipAt(0, 10, true, ocean));
		ship1.placeShipAt(0, 10, true, ocean);
		assertTrue(ship2.okToPlaceShipAt(1, 0, false, ocean));
		assertTrue(ship2.okToPlaceShipAt(1, 0, true, ocean));
		assertFalse(ship2.okToPlaceShipAt(1, 4, true, ocean));
		assertFalse(ship2.okToPlaceShipAt(1, 13, false, ocean));
	}

	@Test
	public void testPlaceShipAt() {
		Ocean ocean = new Ocean();
		Ship submarine1 = new Submarine();
		Ship cruiser2 =new Cruiser();
		
		submarine1.placeShipAt(0, 2, true, ocean);
		//assertTrue(ocean.getShipArray()[0][2].getShipType().equals("submarine"));
		assertEquals("Submarine", ocean.getShipArray()[0][2].getShipType());
		
		cruiser2.placeShipAt(5, 1, true, ocean);
		assertEquals("cruiser", ocean.getShipArray()[5][1].getShipType());
		assertEquals("cruiser", ocean.getShipArray()[5][2].getShipType());
		assertEquals("cruiser", ocean.getShipArray()[5][3].getShipType());
		
	}


	@Test
	public void testShootAt() {
		Ocean ocean = new Ocean();
		BattleShip ship = new BattleShip();
		ship.placeShipAt(0, 0, true, ocean);

		assertTrue(ship.shootAt(0, 3));
		assertTrue(ship.shootAt(0, 4));
		assertFalse(ship.shootAt(1, 4));
		
	}
	
	@Test
	public void testShootAt2() {
		Ocean ocean = new Ocean();
		BattleShip ship = new BattleShip();
		ship.placeShipAt(0, 0, true, ocean);
		for (int j = 0; j < 8; j++) {
			ocean.shootAt(0, j);
		}
		
		assertFalse(ship.shootAt(0, 3));
		assertFalse(ship.shootAt(0, 4));
		assertFalse(ship.shootAt(1, 4));
		
	}


	
	
	@Test
	public void testIsSunk2() {
		Ocean ocean = new Ocean();
		BattleShip ship = new BattleShip();
		ship.placeShipAt(0, 0, true, ocean);
		for (int j = 0; j < 7; j++) {
			ocean.shootAt(0, j);
		}
		
		assertFalse(ship.isSunk());
		
	}

	@Test
	public void testToString() {
		Ocean ocean = new Ocean();
		BattleShip ship = new BattleShip();
		ship.placeShipAt(0, 0, true, ocean);
		for (int j = 0; j < 8; j++) {
			ocean.shootAt(0, j);
		}
		
		assertEquals("x", ship.toString());
		
	}
	
	@Test
	public void testToString2() {
		Ocean ocean = new Ocean();
		BattleShip ship = new BattleShip();
		ship.placeShipAt(0, 0, true, ocean);
		for (int j = 0; j < 7; j++) {
			ocean.shootAt(0, j);
		}
		
		assertEquals("S", ship.toString());
		
	}
	
	

}

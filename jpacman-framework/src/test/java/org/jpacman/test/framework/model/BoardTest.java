package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.IBoardInspector;
import org.jpacman.framework.model.Tile;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private int startx, starty;
	private Direction dir;
	private int nextx, nexty;
	private Board board;

	private static int WIDTH;
	private static int HEIGHT;

	@Before
	public void setUp() throws FactoryException, InterruptedException {
		WIDTH= 10;
		HEIGHT = 20;		
		board = new Board(WIDTH, HEIGHT);
	}

	/** 
	 * Test a sprite move without crossing boundaries.
	 */
	@Test
	public void test_S3_1_() {
		startx = 2;
		starty = 2;
		Tile source = board.tileAt(startx, starty);
		
		dir = Direction.UP;
		nextx = 2;
		nexty = 1;	
		Tile actual = board.tileAtDirection(source, dir);
		Tile desired = board.tileAt(nextx, nexty);
		assertEquals(desired, actual);
	}
	
	/** 
	 * Test a sprite move when crossing boundaries.
	 */
	@Test
	public void test_S3_1_boundaries() {
		startx = 0;
		starty = 2;
		Tile source = board.tileAt(startx, starty);
		
		dir = Direction.LEFT;
		nextx = WIDTH-1;
		nexty = 2;	
		Tile actual = board.tileAtDirection(source, dir);
		Tile desired = board.tileAt(nextx, nexty);
		assertEquals(desired, actual);
	}
	
}

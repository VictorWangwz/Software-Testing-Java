package org.jpacman.test.framework.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Sprite;
import org.jpacman.framework.model.Tile;
import org.jpacman.framework.model.Direction;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	private Board board;
	private final int height = 10;
	private final int width = 10;
	
	
	/**
	 * Initialize a board with default height and width
	 */
	@Before
	public void setUp(){
		this.board = new Board(this.width, this.height);
	}
	
	/**
	 * Test the getHeight() method
	 */
	@Test
	public void testHeight(){
		assertEquals(this.height, board.getHeight());
	}
	
	/**
	 * Test the getWidth() method
	 */
	@Test
	public void testWidth(){
		assertEquals(this.width, board.getWidth());
	}
	
	/**
	 * Test the put() method
	 */
	@Test
	public void testSpritePutOnTile(){
		Sprite sprite = new Sprite(){};
		this.board.put(sprite, 1, 1);
		assertEquals(this.board.tileAt(1, 1).topSprite(),sprite);
	}

	/**
	 * Test the spriteAt() method
	 */
	@Test
	public void testSpriteAt(){
		Sprite sprite = new Sprite(){};
		this.board.put(sprite, 1, 1);
		assertEquals(this.board.spriteAt(1, 1), sprite);
	}
	
	
	/**
	 * Test the spriteTypeAt() method
	 */
	@Test
	public void testSpriteTypeAt(){
		Sprite sprite = new Sprite(){};
		this.board.put(sprite, 1, 1);
		assertEquals(this.board.spriteTypeAt(1, 1), sprite.getSpriteType());
	}
	
	/**
	 * Test the tileAt() method
	 */
	@Test
	public void testTileAt(){
		Tile tile = this.board.tileAt(1,1);
		assertEquals(tile.getX(), 1);
		assertEquals(tile.getY(), 1);
	}
	
	/**
	 * Test the withinBoarders() method
	 */
	@Test
	public void testWithinBorders(){
		assertEquals(false, this.board.withinBorders(this.height, this.width));
	}
	
	/**
	 * Test the tileAtOffside() method
	 */
	@Test 
	public void testTileAtOffside(){
		Tile start= this.board.tileAt(1,1);
		Tile tile = this.board.tileAtOffset(start, 1, 1);
		assertEquals(tile, this.board.tileAt(2, 2));
	}
	
	
	/**
	 * Test the tileAtDirection() method
	 */
	@Test 
	public void testTileAtDirection(){
		Tile start= this.board.tileAt(1,1);
		Tile tileEnd = this.board.tileAtDirection(start, Direction.LEFT);
		Tile expectEnd = this.board.tileAt(0, 1);
		assertEquals(tileEnd, expectEnd);
	}
	
	
}

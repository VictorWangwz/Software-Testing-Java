package org.jpacman.test.framework.model;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Sprite;
import org.jpacman.framework.model.Tile;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.jpacman.framework.model.Direction;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	private Board board;
	private final int height = 10;
	private final int width = 10;
	private final Sprite sprite = new Sprite() { };
	private final int x = 0;
	private final int y = 0;
	
	/**
	 * Initialize a board with default height and width
	 */
	@Before
	public void setUp(){
		board = new Board(width, height);
		board.put(sprite, x, y);
	}
	
	/**
	 * Test initialization (the getHeight() method)
	 */
	@Test
	public void testHeight(){
		assertEquals(height, board.getHeight());
	}
	
	/**
	 * Test initialization (the getWidth() method)
	 */
	@Test
	public void testWidth(){
		assertEquals(width, board.getWidth());
	}
	
	/**
	 * Test initialization (the put() method)
	 */
	@Test
	public void testSpritePutOnTile(){
		assertEquals(board.tileAt(x, y).topSprite(),sprite);
		assertEquals(board.tileAt(x, y),sprite.getTile());
	}

	/**
	 * Test the spriteAt() method
	 */
	@Test
	public void testSpriteAt(){
		assertEquals(board.spriteAt(x, y), sprite);
	}
	
	
	/**
	 * Test the spriteTypeAt() with new sprite method
	 */
	@Test
	public void testSpriteTypeAt(){
		assertEquals(board.spriteTypeAt(x, y), sprite.getSpriteType());
	}
	@Test
	public void testNullSpriteTypeAt(){
		assertEquals(board.spriteTypeAt(x+1, y+1), SpriteType.EMPTY);
	}
	
	/**
	 * Test what happens if there are multiple sprites on one tile.
	 */
	@Test
	public void multipleSprites() {
		Sprite top = new Sprite() {};
		board.put(top, x, y);
		
		// now 'top' is the top most sprite.
		assertThat(board.spriteAt(0, 0), equalTo(top));

	}
	
	/**
	 * Test the tileAt() method
	 */
	@Test
	public void testTileAt(){
		Tile tile = board.tileAt(x, y);
		assertEquals(tile.getX(), x);
		assertEquals(tile.getY(), y);
	}
	
	/**
	 * Test that one out point is not on the board //withinBoarders() method
	 */
	@Test
	public void testWithinBorders(){
		assertEquals(false, board.withinBorders(height, width));
	}
	
	/**
	 * Test the tileAtOffside() method
	 */
	@Test 
	public void testTileAtOffside(){
		Tile start= board.tileAt(1,1);
		Tile tile = board.tileAtOffset(start, 1, 1);
		assertEquals(tile, board.tileAt(2, 2));
	}
	
	
	/**
	 * Test what happens if a tile moves across the boundary //tileAtDirection() method
	 */
	@Test 
	public void testTileAtDirection(){
		Tile start= board.tileAt(x, y);
		Tile actual = board.tileAtDirection(start, Direction.LEFT);
		Tile desired = board.tileAt(width-1, y);
		assertEquals(actual, desired);
	}
	
	
}

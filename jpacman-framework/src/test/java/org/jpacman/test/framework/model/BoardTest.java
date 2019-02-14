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
	}
	
	/**
	 * Test the constructor with negative width and height
	 */
	@Test
	public void testConstructor(){
		try{
			new Board(-1,10);
		}catch(AssertionError e){
		}
		try{
			new Board(10,-1);
		}catch(AssertionError e){
		}
	}
	
	
	/**
	 * Test the getHeight() method
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
	 * Test the put() method, put sprite on tile without any assertions
	 */
	@Test
	public void testSpritePutOnTile(){
		board.put(sprite, x, y);
		assertEquals(board.tileAt(x, y).topSprite(),sprite);
	}
	
	/**
	 * Test the put() method, put sprite on tile that is without board
	 */
	@Test
	public void testSpritePutOnTileOffBoard(){
		try{
			board.put(sprite, 11, 1);
		}catch(AssertionError e){
		}
		
	}
	
	/**
	 * Test the put() method, put sprite null on tile
	 */
	@Test
	public void testSpritePutNullOnTile(){
		Sprite sprite = null;
		try{
			board.put(sprite, x, y);
		}catch(AssertionError e){
		}
		
	}
	
	/**
	 * Test the put() method, put sprite that is already on tile onto tile
	 */
	@Test
	public void testExistSpritePutOnTile(){
		board.put(sprite, x, y);
		try{
			board.put(sprite, 2, 1);
		}catch(AssertionError e){
		}
		
	}

	/**
	 * Test the spriteAt() method
	 */
	@Test
	public void testSpriteAt(){
		board.put(sprite, x, y);
		assertEquals(board.spriteAt(x, y), sprite);
	}
	
	/**
	 * Test the spriteAt() method with withinboarders() false
	 */
	@Test
	public void testSpriteAtOutBoarders(){
		try{
			board.spriteAt(11, 1);
		}catch(AssertionError e){
		}
	}
	
	
	/**
	 * Test the spriteTypeAt() with new sprite method
	 */
	@Test
	public void testSpriteTypeAt(){
		board.put(sprite, x, y);
		assertEquals(board.spriteTypeAt(x, y), sprite.getSpriteType());
	}
	
	/**
	 * Test the spriteTypeAt() method with withinboarders() false
	 */
	@Test
	public void testSpriteTypeAtOutBoarders(){
		try{
			board.spriteTypeAt(11, 1);
		}catch(AssertionError e){
		}
		
	}
	
	@Test
	public void testNullSpriteTypeAt(){
		assertEquals(board.spriteTypeAt(x, y), SpriteType.EMPTY);
	}
	
	/**
	 * Test the tileAt() method
	 */
	@Test
	public void testTileAt(){
		Tile tile = board.tileAt(x,y);
		assertEquals(tile.getX(), x);
		assertEquals(tile.getY(), y);
	}
	
	/**
	 * Test the tileAt() method with withinboarders() false
	 */
	@Test
	public void testTileAtOutBoarder(){
		
		try{
			Tile tile = board.tileAt(11,11);
		}catch(AssertionError e){
		}
		
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
	 * Test the withinBoarders() method
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
		Tile start= board.tileAt(x,y);
		Tile tile = board.tileAtOffset(start, 1, 1);
		assertEquals(tile, board.tileAt(x+1, y+1));
	}
	
	/**
	 * Test the tileAtOffside() method with Start as null
	 */
	@Test 
	public void testTileAtOffsideStartNull(){
		try{
			Tile start= null;
			Tile tile = board.tileAtOffset(start, 1, 1);
		}catch(AssertionError e){
		}
		
	}
	
	
	/**
	 * Test tileAtDirection() method
	 */
	@Test 
	public void testTileAtDirection(){
		Tile start= board.tileAt(1,1);
		Tile tileEnd = board.tileAtDirection(start, Direction.LEFT);
		Tile expectEnd = board.tileAt(0, 1);
		assertEquals(tileEnd, expectEnd);
	}
	
	/**
	 * Test what happens if a tile moves across the boundary //tileAtDirection() method
	 */
	
	@Test 
	public void testTileAtDirectionAcrossBound(){
		Tile start= board.tileAt(x, y);
		Tile actual = board.tileAtDirection(start, Direction.LEFT);
		Tile desired = board.tileAt(width-1, y);
		assertEquals(actual, desired);
	}
	
	
	
}

package org.jpacman.test.framework.model;
import static org.junit.Assert.assertEquals;
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
	 * Test the getWidth() method
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
		Sprite sprite = new Sprite(){};
		board.put(sprite, 1, 1);
		assertEquals(board.tileAt(1, 1).topSprite(),sprite);
	}
	
	/**
	 * Test the put() method, put sprite on tile that is without board
	 */
	@Test
	public void testSpritePutOnTileOffBoard(){
		Sprite sprite = new Sprite(){};
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
			board.put(sprite, 1, 1);
		}catch(AssertionError e){
		}
		
	}
	
	/**
	 * Test the put() method, put sprite that is already on tile onto tile
	 */
	@Test
	public void testExistSpritePutOnTile(){
		Sprite sprite = new Sprite(){};
		board.put(sprite, 1, 1);
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
		Sprite sprite = new Sprite(){};
		board.put(sprite, 1, 1);
		assertEquals(board.spriteAt(1, 1), sprite);
	}
	
	/**
	 * Test the spriteAt() method with withinboarders() false
	 */
	@Test
	public void testSpriteAtOutBoarders(){
		Sprite sprite = new Sprite(){};
		board.put(sprite, 1, 1);
		try{
			assertEquals(board.spriteAt(11, 1), sprite);
		}catch(AssertionError e){
		}
		
	}
	
	
	/**
	 * Test the spriteTypeAt() with new sprite method
	 */
	@Test
	public void testSpriteTypeAt(){
		Sprite sprite = new Sprite(){};
		board.put(sprite, 1, 1);
		assertEquals(board.spriteTypeAt(1, 1), sprite.getSpriteType());
	}
	
	/**
	 * Test the spriteTypeAt() method with withinboarders() false
	 */
	@Test
	public void testSpriteTypeAtOutBoarders(){
		Sprite sprite = new Sprite(){};
		board.put(sprite, 1, 1);
		try{
			assertEquals(board.spriteTypeAt(11, 1), sprite.getSpriteType());
		}catch(AssertionError e){
		}
		
	}
	
	@Test
	public void testNullSpriteTypeAt(){
		assertEquals(board.spriteTypeAt(1, 1), SpriteType.EMPTY);
	}
	
	/**
	 * Test the tileAt() method
	 */
	@Test
	public void testTileAt(){
		Tile tile = board.tileAt(1,1);
		assertEquals(tile.getX(), 1);
		assertEquals(tile.getY(), 1);
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
	 * Test the withinBoarders() method
	 */
	@Test
	public void testWithinBorders(){
		assertEquals(false, board.withinBorders(this.height, this.width));
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
	 * Test the tileAtOffside() method with offset to negative
	 */
	@Test 
	public void testTileAtOffsideNegative(){
		try{
			Tile start= board.tileAt(1,1);
			Tile tile = board.tileAtOffset(start, 1, 1);
		}catch(AssertionError e){
		}
		
	}
	
	/**
	 * Test the tileAtDirection() method
	 */
	@Test 
	public void testTileAtDirection(){
		Tile start= board.tileAt(1,1);
		Tile tileEnd = board.tileAtDirection(start, Direction.LEFT);
		Tile expectEnd = board.tileAt(0, 1);
		assertEquals(tileEnd, expectEnd);
	}
	
	
	
}

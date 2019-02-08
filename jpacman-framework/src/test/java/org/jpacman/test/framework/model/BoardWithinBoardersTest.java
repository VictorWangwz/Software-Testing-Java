package org.jpacman.test.framework.model;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.jpacman.framework.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class BoardWithinBoardersTest {
	
	private Board board;
	private final int height = 10;
	private final int width = 10;
	private int x;
	private int y;
	private boolean flag;
	
	/**
	 * Initialize a board with default height and width,
	 * and create x, y, expected flag from parameters
	 */
	public BoardWithinBoardersTest(int x, int y, boolean flag){
		this.board = new Board(width, height);
		this.x = x;
		this.y = y;
		this.flag = flag;
	}
	
	
	/**
	 * Test WithinBoarders
	 */
	@Test
	public void testWithinBoarders(){
		assertEquals(this.board.withinBorders(this.x, this.y), this.flag);
	}
	
	
	/**
	 * Provide parameters to constructor of class
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] values = new Object[][] {
			{0, 1, true},
			{-1, 2, false},
			{10, 3, false},
			{9 ,4, true},
			{5, 0, true},
			{6, -1, false},
			{7, 10, false},
			{8, 9, true},
			{4, 100, false},
			{-1000, 6, false}
		};
		return Arrays.asList(values);
	}


}

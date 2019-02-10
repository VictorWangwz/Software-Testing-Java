package org.jpacman.test.framework.factory;

import org.jpacman.framework.factory.DefaultGameFactory;
import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.factory.IGameFactory;
import org.jpacman.framework.factory.MapParser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FactoryExceptionTest {
	
	private MapParser parser;
	private String[] map = {};
	
	/**
     * Initialization
     */
	@Before
	public void setUp() {
		IGameFactory factory = new DefaultGameFactory();
		parser = new MapParser(factory);
	}
	
	/**
     * Common FactoryException testing without cause
     */
	@Test(expected=FactoryException.class)
	public void testFactoryException() throws FactoryException{
		this.parser.parseMap(this.map);
	}
	
	/**
     * Common FactoryException testing with cause
     */
	@Test(expected=FactoryException.class)
	public void testFactoryExceptionWithCause() throws FactoryException{
		Throwable t = new Throwable();
		FactoryException f = new FactoryException("Problem reading file ", t);
	}
	
}

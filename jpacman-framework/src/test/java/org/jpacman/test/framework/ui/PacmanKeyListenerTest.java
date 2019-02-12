package org.jpacman.test.framework.ui;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.ui.IPacmanInteraction;
import org.jpacman.framework.ui.MainUI;
import org.jpacman.framework.ui.PacmanKeyListener;
import org.junit.Before;
import org.junit.Test;

public class PacmanKeyListenerTest {
	KeyEvent event;
	MainUI ui = new MainUI();
	@Before
	public void setUp(){
		this.event = new KeyEvent(this.ui, 0, 0, 0, KeyEvent.VK_UP, 'a');
		}
	@Test
	public void testUIActions() throws FactoryException, InterruptedException, AWTException {

		Robot robot = new Robot();
		ui.initialize();
		ui.start();
		robot.keyPress(KeyEvent.VK_K);
	}
}
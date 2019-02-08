package org.jpacman.test.framework.ui;

import java.awt.event.KeyEvent;

import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.ui.IPacmanInteraction;
import org.jpacman.framework.ui.MainUI;
import org.jpacman.framework.ui.PacmanKeyListener;
import org.junit.Test;

public class PacmanKeyListenerTest {
	/**
	 * Invoke series of actions on the real game, including the 
	 * real ghost mover.
	 * 
	 * @throws FactoryException If reading board fails.
	 * @throws InterruptedException Since we're timing.
	 */
	@Test
	public void testUIActions() throws FactoryException, InterruptedException {
		MainUI ui = new MainUI();
		ui.initialize();
		ui.start();
		IPacmanInteraction eventHandler = ui.eventHandler();
		PacmanKeyListener[] keyListener = ui.getListeners(PacmanKeyListener.class);
		System.out.print(keyListener);

		// now trigger interesting events.
		eventHandler.start();
	}
}
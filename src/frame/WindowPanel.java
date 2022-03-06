package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Actions.pressAKey;
import Actions.pressDKey;
import Actions.releaseAKey;
import Actions.releaseDKey;

public class WindowPanel extends JPanel {
	
	private final MazePanel mazePanel;
	private final ButtonsPanel buttonsPanel;
	
	public WindowPanel(MazeApp app) {
		
		add(mazePanel = new MazePanel(app), BorderLayout.NORTH);
		add(buttonsPanel = new ButtonsPanel(app), BorderLayout.SOUTH);
		
		
		getInputMap().put(KeyStroke.getKeyStroke("A"), "keyAPressed");
		getInputMap().put(KeyStroke.getKeyStroke("D"), "keyDPressed");
		getInputMap().put(KeyStroke.getKeyStroke("released A"), "keyAReleased");
		getInputMap().put(KeyStroke.getKeyStroke("released D"), "keyDReleased");
		getActionMap().put("keyAPressed", new pressAKey());
		getActionMap().put("keyDPressed", new pressDKey());
		getActionMap().put("keyAReleased", new releaseAKey());
		getActionMap().put("keyDReleased", new releaseDKey());
		
		
		setPreferredSize(new Dimension(500,600));
	}

	public void notifyForUpdate() {
		mazePanel.notifyForUpdate();
		
	}

}

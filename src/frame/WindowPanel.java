package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	
	private final MazePanel mazePanel;
	private final ButtonsPanel buttonsPanel;
	
	public WindowPanel(MazeApp app) {
		
		add(mazePanel = new MazePanel(app), BorderLayout.NORTH);
		add(buttonsPanel = new ButtonsPanel(app), BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(500,600));
	}

	public void notifyForUpdate() {
		mazePanel.notifyForUpdate();
		
	}

}

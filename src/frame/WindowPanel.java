package frame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	
	private final MazePanel mazePanel;
	private final ButtonsPanel buttonsPanel;
	
	public WindowPanel(MazeApp app) {
		
		add(mazePanel = new MazePanel(app), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(app), BorderLayout.SOUTH);
	}

	public void notifyForUpdate() {
		mazePanel.notifyForUpdate();
		
	}

}

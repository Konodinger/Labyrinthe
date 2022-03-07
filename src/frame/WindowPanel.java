package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class WindowPanel extends JPanel {
	
	private final MazePanel mazePanel;
	private final ButtonsPanel buttonsPanel;
	
	public WindowPanel(MazeApp app) {
		
		add(mazePanel = new MazePanel(app), BorderLayout.NORTH);
		add(buttonsPanel = new ButtonsPanel(app), BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(700,750));
	}

	public void notifyForUpdate() {
		mazePanel.notifyForUpdate();
		revalidate();
	}

}

package frame.MenuBar;

import javax.swing.JMenuItem;

import frame.MazeApp;

public class QuitMenuItem extends JMenuItem{

	private final MazeApp app;
	
	public QuitMenuItem(MazeApp app) {
		super("Quitter");
		this.app = app;
		
	}
}

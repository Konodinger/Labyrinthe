package frame.MenuBar;

import javax.swing.JMenuItem;

import frame.MazeApp;

public class LoadMenuItem extends JMenuItem {

	private final MazeApp app;
	
	public LoadMenuItem(MazeApp app) {
		super("Charger");
		this.app = app;
		
	}
}

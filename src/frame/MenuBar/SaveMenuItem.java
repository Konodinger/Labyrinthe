package frame.MenuBar;

import javax.swing.JMenuItem;

import frame.MazeApp;

public class SaveMenuItem extends JMenuItem {

	private final MazeApp app;
	
	public SaveMenuItem(MazeApp app) {
		super("Sauvegarder");
		this.app = app;
		
	}
}
